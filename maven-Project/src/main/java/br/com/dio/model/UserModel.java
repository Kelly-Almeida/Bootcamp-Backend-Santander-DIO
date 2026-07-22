package br.com.dio.model;

import lombok.Data;

import java.time.LocalDate;

@Data /*Resummo de..
*@Getter
*@Setter
*@EqualsAndHashCode
*@toArgsConstructor
*@toString
*/

public class UserModel {
    private int code;
    private String userName;
    private LocalDate birthday;
}
