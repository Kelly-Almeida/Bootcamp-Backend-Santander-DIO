import br.com.dio.dto.UserDTO;
import br.com.dio.mapper.UserMapper;
import br.com.dio.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class Main {

    private static UserMapper mapper = Mappers.getMapper(UserMapper.class);

    static void main() {
        UserModel model = new UserModel();
        UserDTO dto =  new UserDTO();

        model.setCode(1);
        model.setUserName("Karoline");
        model.setBirthday(LocalDate.now());

        System.out.println(model);

        dto.setId(2);
        dto.setName("Levy");
        dto.setBirthday(LocalDate.now());

        System.out.println(dto);

        System.out.println(mapper.toModel(dto));
        System.out.println(mapper.toDTO(model));

    }
}