package br.com.br.model;

import br.com.br.annotation.FieldFormatEnum;
import br.com.br.annotation.SerializerMethod;
import br.com.br.annotation.SerializerType;
import lombok.Data;

@Data
@SerializerType(fieldFormat = FieldFormatEnum.PASCAL_CASE, prettify = false)
public class Person {

    private long id;

    private String name;

    private int age;

    public Person(long id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @SerializerMethod("firstNamePerson")
    public String firstName(){
        return name.split(" ")[0];
    }
}
