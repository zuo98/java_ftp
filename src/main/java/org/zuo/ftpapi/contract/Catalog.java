package org.zuo.ftpapi.contract;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.UUID;

public class Catalog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    protected Catalog() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public String getclazz() {
        Class<?> cls = this.getClass();
        String name = cls.getName();
        String[] names = name.split("\\.");
        name = names[names.length - 1];
        return name;
    }


}
