package com.imbilalbutt.Spring.MVC.service;

import com.imbilalbutt.Spring.MVC.api.UserApi;
import com.imbilalbutt.Spring.MVC.converter.UserDTOConverter;
import com.imbilalbutt.Spring.MVC.dto.UserDTO;
import com.imbilalbutt.Spring.MVC.entity.User;
import com.imbilalbutt.Spring.MVC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractCRUDService<User, UserDTO> implements UserApi {

    private UserRepository userRepository;
    private UserDTOConverter userDTOConverter;

    @Autowired
    public UserService(final UserRepository userRepository, final UserDTOConverter userDTOConverter) {
        super(userRepository, userDTOConverter);
        this.userRepository = userRepository;
        this.userDTOConverter = userDTOConverter;
    }

    @Override
    protected void updateEntity(User entity, UserDTO dto) {

//        entity = userDTOConverter.convertToEntity(entity, dto);
//
//        entity = userDTOConverter.convert(dto);

        entity.setUsername(dto.getUsername());
        entity.setName(dto.getName());

    }
}
