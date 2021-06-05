package com.natal.catalogservice.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class EntityClass implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date registryDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public Long getId() {
        return id;
    }

    public Date getRegistryDate() {
        return registryDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

}
