package com.project.cari.hobi.mainservice.model.product;


import com.project.cari.hobi.mainservice.model.Base;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "CATEGORY")
@Where(clause = "IS_DELETED=false")
public class Category extends Base {

    @NotNull
    private String name;

    @NotNull
    private String code;

    private String description;
    private String image;
}
