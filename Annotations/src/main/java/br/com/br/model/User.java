package br.com.br.model;

import br.com.br.annotation.FieldFormatEnum;
import br.com.br.annotation.SerializerType;

@SerializerType(fieldFormat = FieldFormatEnum.SNAKE_CASE)
public record User(
        long id,
        String fullName,
        int age,
        double salary
) {

}
