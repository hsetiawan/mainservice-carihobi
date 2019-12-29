package com.project.cari.hobi.mainservice.model.product;


import com.project.cari.hobi.mainservice.model.Base;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "HOBBIES")
@Where(clause = "IS_DELETED=false")
@Data
public class Hobby extends Base {

    private static final int MIN_NAME = 2;

    @NotNull
    @Size(min = MIN_NAME)
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String image;

    private String videoUrl;

    @OneToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;
}
