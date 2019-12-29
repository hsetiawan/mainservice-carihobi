package com.project.cari.hobi.mainservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Data
public class Base implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue()
    @JsonIgnore
    private Long id;

    @Column(length = 36)
    @JsonIgnore
    private String secureId;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_CREATED")
    @JsonIgnore
    private Date creationDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_MODIFIED")
    @JsonIgnore
    private Date modificationDate;

    @CreatedBy
    @Column(updatable = false)
    @JsonIgnore
    private String createdBy;

    @LastModifiedBy
    @Column()
    @JsonIgnore
    private String modifiedBy;

    @Column
    @JsonIgnore
    private Boolean isDeleted;

    @PrePersist
    public void prePersist() {
        this.secureId = UUID.randomUUID().toString();
        this.creationDate = new Date();
        this.isDeleted = false;
    }

    @PreUpdate
    public void preUpdate() {
        this.modificationDate = new Date();
    }

}
