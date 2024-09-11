package ru.zubtsov.marketplace.user;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

   /* UserDto toUserDto(User user);

    User mapToUser(SignUpRequest request);*/
}
