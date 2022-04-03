package com.imbilalbutt.Spring.MVC.converter;

import com.imbilalbutt.Spring.MVC.dto.UserDTO;
import com.imbilalbutt.Spring.MVC.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter extends AbstractDTOConverter<User, UserDTO> {

    @Override
    public UserDTO convert(final User entity) {
         UserDTO userDto = new UserDTO();

//         super.convert(entity, userDto);
//         super.setId(entity, userDto).setCreated(entity, userDto).setModified(entity, userDto);

        super.convertToDTO(entity, userDto);
        userDto.setUsername(entity.getUsername());
        userDto.setName(entity.getName());

        return userDto;
    }

    @Override
    public User convert(UserDTO dto) {

        User entity = new User();

//        super.convert(entity, dto);
//        super.setId(entity, userDto).setCreated(entity, userDto).setModified(entity, userDto);

        super.convertToEntity(entity, dto);
        entity.setUsername(entity.getUsername());
        entity.setName(entity.getName());

        return entity;
    }


}
