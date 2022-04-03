package com.imbilalbutt.Spring.MVC;

import com.imbilalbutt.Spring.MVC.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class UserRestTest {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final String URL = "http://localhost:8080/api/users";

    @Test
    public void testUserCRUD(){

        final UserDTO dto = new UserDTO();
        dto.setUsername("Username_" + UUID.randomUUID());
        dto.setName("Name_" + UUID.randomUUID());

        // Check for Save
        final UserDTO saveDto = REST_TEMPLATE.postForObject(URL + "/save",dto, UserDTO.class);
        verifyDTO(dto, saveDto);

        // Check for Update
        saveDto.setName("Update Name");
        final UserDTO updatedDto = REST_TEMPLATE.postForObject(URL + "/save", saveDto, UserDTO.class);
        verifyDTO(saveDto, updatedDto);

        // Check for Get
        final UserDTO byId = REST_TEMPLATE.getForObject( URL+"/get/"+saveDto.getId(), UserDTO.class);
        verifyDTO(saveDto, byId);

        // Check for GetAll
        final List dtos = REST_TEMPLATE.getForObject(URL+"/list", List.class);
        assertThat(dtos).isNotEmpty();

        // Check for Delete
        REST_TEMPLATE.delete(URL+"/delete/"+saveDto.getId());
        final UserDTO deleted = REST_TEMPLATE.getForObject(URL+"/get/"+saveDto.getId(), UserDTO.class);
        assertThat(deleted).isNull();

    }

    private void verifyDTO(UserDTO expected, UserDTO actual) {
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getCreated()).isNotNull();
        assertThat(actual.getModified()).isNotNull();
        assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
        assertThat(actual.getName()).isEqualTo(expected.getName());
    }
}
