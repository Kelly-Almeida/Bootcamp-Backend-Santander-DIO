package br.com.dio.dto;

import lombok.Data;

import java.time.LocalDate;

@Data //Gera os get e set

public class UserDTO {


    private int id;
    private String name;
    private LocalDate birthday;


}
