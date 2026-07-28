package br.com.dio.model;

import java.lang.String;

public class PersonBuilder {
    private String name;

    private int id;

    public PersonBuilder name(final String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder id(final int id) {
        this.id = id;
        return this;
    }

    public Person build() {
        var target = new Person();
        target.setName(name);
        target.setId(id);
        return target;
    }
}
