package org.zuo.ftpapi.dao.config;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private String id;
}
