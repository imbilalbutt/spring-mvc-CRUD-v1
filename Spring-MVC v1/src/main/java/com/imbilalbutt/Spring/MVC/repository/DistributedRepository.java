package com.imbilalbutt.Spring.MVC.repository;

import com.imbilalbutt.Spring.MVC.entity.DistributedEntity;
import org.springframework.data.repository.CrudRepository;

public interface DistributedRepository<ENTITY extends DistributedEntity> extends CrudRepository<ENTITY, Long> {
}
