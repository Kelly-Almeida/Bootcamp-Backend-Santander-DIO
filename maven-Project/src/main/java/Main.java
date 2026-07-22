import br.com.dio.dto.UserDTO;
import br.com.dio.mapper.UserMapper;
import br.com.dio.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class Main {

    private static UserMapper mapper = Mappers.getMapper(UserMapper.class);
    public static void main(String[] args){
        UserDTO dto = new UserDTO();
        UserModel model = new UserModel();

        model.setCode(1);
        model.setUserName("Levy");
        model.setBirthday(LocalDate.now().minusYears(23));
        System.out.println(mapper.toDTO(model));

        dto.setId(2);
        dto.setName("Karoline");
        dto.setBirthday(LocalDate.now().minusYears(20));
        System.out.println(mapper.toModel(dto));


    }
}
