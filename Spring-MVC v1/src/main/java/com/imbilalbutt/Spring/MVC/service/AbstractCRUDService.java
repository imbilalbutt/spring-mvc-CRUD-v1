package com.imbilalbutt.Spring.MVC.service;

import com.google.common.collect.Lists;
import com.imbilalbutt.Spring.MVC.api.AbstractCRUDApi;
import com.imbilalbutt.Spring.MVC.converter.AbstractDTOConverter;
import com.imbilalbutt.Spring.MVC.dto.BaseDTO;
import com.imbilalbutt.Spring.MVC.entity.DistributedEntity;
import com.imbilalbutt.Spring.MVC.repository.DistributedRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.GenericTypeResolver;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public abstract class AbstractCRUDService<ENTITY extends DistributedEntity, DTO extends BaseDTO> implements AbstractCRUDApi<ENTITY, DTO> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractCRUDService.class);

    private DistributedRepository<ENTITY> repository;
    private AbstractDTOConverter<ENTITY, DTO> converter;
    private Class<ENTITY> entityClass;

    private Class<DTO> dtoClass;

    public AbstractCRUDService(final DistributedRepository<ENTITY> repository, final AbstractDTOConverter<ENTITY,DTO> converter) {
        this.repository = repository;
        this.converter = converter;

        final Class<?>[] params = GenericTypeResolver.resolveTypeArguments(getClass(), AbstractCRUDService.class);

        entityClass = (Class<ENTITY>) params[0];
        dtoClass = (Class<DTO>) params[1];
    }

    @Override
    public DTO save(DTO dto) {

        final ENTITY entity;

       if(dto.isNew()){ // save()
           entity = initEntity();
       } else { // update()
           entity = repository.findById(dto.getId()).orElse(null);
       }

        if(ObjectUtils.isEmpty(entity)) {
            LOG.error("Failed to save the entity '{}'" , entityClass.getSimpleName());
            return null;
        }

        entity.setModified(LocalDateTime.now());

        // Map DTO to entity
        updateEntity(entity, dto);

       final ENTITY savedEntity = repository.save(entity);

       return converter.convert(savedEntity);
    }

    protected abstract void updateEntity(final ENTITY entity, final  DTO dto);

    @Override
    public DTO getById(Long id) {

        final ENTITY entity = repository.findById(id).orElse(null);
        if(ObjectUtils.isEmpty(entity)){
            LOG.error("Failed to find entity with ID : '{}' ", id);
            return null;
        }
        return converter.convert(entity);
    }

    private ENTITY initEntity() {
        try {
            ENTITY entity = entityClass.newInstance();
            entity.setCreated(LocalDateTime.now());

            return entity;
        } catch (InstantiationException | IllegalAccessException e){
            LOG.error(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<DTO> list() {

         final List<ENTITY> entities = Lists.newArrayList(repository.findAll());
         if(CollectionUtils.isEmpty(entities)){
             return Collections.emptyList();
         }
        return converter.convertList(entities);

    }

    @Override
    public Boolean delete(Long id) {

        final ENTITY entity = repository.findById(id).orElse(null);

        if(ObjectUtils.isEmpty(entity)){
           LOG.error("Failed to delete the entity with ID '{}'. It does not exist. ", entity.getId());
           return Boolean.FALSE;
        }

        try {
            repository.delete(entity);
            return Boolean.TRUE;
        } catch (Exception e){
            LOG.error(e.getMessage(), e);
            return Boolean.FALSE;
        }

    }
}
