package com.imbilalbutt.Spring.MVC.dto;

import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseDTO implements Serializable {

    private Long id;
    private LocalDateTime created;
    private LocalDateTime modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @JsonIgnore
    public Boolean isNew(){
        return id == null;
    }
}
