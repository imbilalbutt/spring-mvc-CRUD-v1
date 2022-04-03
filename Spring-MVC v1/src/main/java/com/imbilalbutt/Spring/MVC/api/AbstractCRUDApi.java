package com.imbilalbutt.Spring.MVC.api;

import com.imbilalbutt.Spring.MVC.dto.BaseDTO;
import com.imbilalbutt.Spring.MVC.entity.DistributedEntity;

import java.util.List;

public interface AbstractCRUDApi<ENTITY extends DistributedEntity, DTO extends BaseDTO> {

    DTO save(DTO dto);

    DTO getById(Long id);

    List<DTO> list();

    Boolean delete(Long id);

}
