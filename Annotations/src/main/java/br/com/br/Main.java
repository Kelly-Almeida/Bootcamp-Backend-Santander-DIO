package br.com.br;

import br.com.br.model.Person;
import br.com.br.model.User;
import br.com.br.processor.SeralizerProcessor;

import java.lang.reflect.InvocationTargetException;

public class Main {
    static void main() throws InvocationTargetException, IllegalAccessException {
        var processor = new SeralizerProcessor();
        System.out.println(processor.serializer(new User(1, "Karoline Santiago", 21, 19000)));
        System.out.println(processor.serializer(new Person(2, "Levy Athan", 18)));
    }
}