package br.com.br.processor;

import br.com.br.annotation.SerializerMethod;
import br.com.br.annotation.SerializerType;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SeralizerProcessor {

    public String serializer(final Object obj) throws IllegalAccessException, InvocationTargetException {
        Objects.requireNonNull(obj, "Enter with non null object");

        var clazz = obj.getClass();
        var typeAnnotation = Stream.of(clazz.getAnnotations())
                .flatMap(a -> (a instanceof SerializerType s) ? Stream.of(s) : Stream.empty())//Verifica se é na a classe é do tipo SerializeType
                /*.filter(SerializerType.class::isInstance)//Verifica se é uma instância de SerializeType
                .map(SerializerType.class::cast)*/
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("For serialize object annotate it with @SerializerType"));

        var fieldNameFormatter = typeAnnotation.fieldFormat().getFormat();
        var prettify = typeAnnotation.prettify();

        Map<String, Object> elements = new HashMap<>();
        for(var field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            elements.put(field.getName(), field.get(obj));
        }

        var annotatedMethods = Stream.of(obj.getClass().getMethods())
                .filter(m -> Stream.of(m.getAnnotations())
                .anyMatch(a -> a.annotationType().equals(SerializerMethod.class)))
                .toList();

        for (var method : annotatedMethods){
            method.setAccessible(true);
            var custoName = method.getAnnotation(SerializerMethod.class).value();
            elements.put(custoName.isBlank() ? method.getName() : custoName, method.invoke(obj));
        }

        var jsonFields = elements.entrySet().stream()
                .map(e -> String.format(
                        "    \"%s\": %s",fieldNameFormatter.
                                apply(e.getKey()),
                                formatValue(e.getValue())

                ))
                .collect(Collectors.joining(String.format(", %s", System.lineSeparator())));
        var json = String.format("{%s%s%s}",
                System.lineSeparator(),
                jsonFields,
                System.lineSeparator());

        return prettify ? json :
                json.replaceAll(System.lineSeparator(), "")
                        .replaceAll("  ", "");
    }

    private String formatValue(final Object value){

        return value instanceof String s ?
                String.format("\"%s\"", s) : value.toString();
    }
}
