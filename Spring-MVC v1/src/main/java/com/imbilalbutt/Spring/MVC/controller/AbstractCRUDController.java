package com.imbilalbutt.Spring.MVC.controller;

import com.imbilalbutt.Spring.MVC.api.AbstractCRUDApi;
import com.imbilalbutt.Spring.MVC.dto.BaseDTO;
import com.imbilalbutt.Spring.MVC.entity.DistributedEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AbstractCRUDController<ENTITY extends DistributedEntity, DTO extends BaseDTO> {

    private AbstractCRUDApi<ENTITY, DTO> service;

    public AbstractCRUDController(AbstractCRUDApi<ENTITY, DTO> service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    public DTO getById(@PathVariable("id") Long id) { return service.getById(id); }

    @PostMapping ("/save")
    public DTO save(@RequestBody DTO dto) { return service.save(dto); }

    @GetMapping("/list")
    public List<DTO> list(){return service.list();}

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable("id") Long id){
        return service.delete(id);
    }
}
