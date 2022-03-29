package co.edu.udea.gradesapi.model.mapper;

import co.edu.udea.gradesapi.model.User;
import co.edu.udea.gradesapi.model.dto.UserDto;
import org.mapstruct.*;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);

    @Mapping(source = "subjectTutorId", target = "subjectTutor.id")
    User userDtoToUser(UserDto userDto);

    @Mapping(source = "subjectTutor.id", target = "subjectTutorId")
    UserDto userToUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserDto(UserDto userDto, @MappingTarget User user);
}