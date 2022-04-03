package com.imbilalbutt.Spring.MVC.converter;

import com.imbilalbutt.Spring.MVC.dto.BaseDTO;
import com.imbilalbutt.Spring.MVC.entity.DistributedEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDTOConverter<ENTITY extends DistributedEntity, DTO extends BaseDTO> {

    public abstract DTO convert(final ENTITY entity);

    public abstract ENTITY convert(final DTO dto);

    public void convert(final @NotNull ENTITY entity, final DTO dto){
        dto.setId(entity.getId());
        dto.setCreated(entity.getCreated());
        dto.setModified(entity.getModified());
    }

    public AbstractDTOConverter setId(final @NotNull ENTITY entity, final DTO dto){
        dto.setId(entity.getId());
        return this;
    }

    public AbstractDTOConverter setCreated(final @NotNull ENTITY entity, final DTO dto){
        dto.setCreated(entity.getCreated());
        return this;
    }

    public AbstractDTOConverter setModified(final @NotNull ENTITY entity, final DTO dto){
        dto.setModified(entity.getModified());
        return this;
    }

    public DTO convertToDTO(final @NotNull ENTITY entity, final DTO dto){
        dto.setId(entity.getId());
        dto.setCreated(entity.getCreated());
        dto.setModified(entity.getModified());
        return dto;
    }

    public ENTITY convertToEntity(final ENTITY entity, final @NotNull DTO dto){
        entity.setId(dto.getId());
        entity.setCreated(dto.getCreated());
        entity.setModified(dto.getModified());

        return entity;
    }

    public List<DTO> convertList(final List<ENTITY> entities){

        if(CollectionUtils.isEmpty(entities)){
            return Collections.emptyList();
        }

        return entities.stream()
                .sequential()
                .map(entity -> convert(entity))
                .collect(Collectors.toList());
    }
}
