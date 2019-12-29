package com.project.cari.hobi.mainservice.model.account;

import com.project.cari.hobi.mainservice.model.Base;
import com.project.cari.hobi.mainservice.model.product.Hobby;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "VENDORS")
@Where(clause = "IS_DELETED=false")
@DynamicUpdate
@Getter @Setter
@NoArgsConstructor
public class Vendor extends Base {

    private final static int MAX_VENDOR_NAME = 24;

    @NotEmpty
    @Size(max = MAX_VENDOR_NAME)
    private String name;

    @NotEmpty
    private  String phone;

    @NotEmpty
    private String photo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @NotEmpty
    @Size(max=1)
    private String gender;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Hobby> hobbies;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Vendor( String name, String phone, String photo, String gender, Address address,  User user) {
        this.name = name;
        this.phone = phone;
        this.photo = photo;
        this.address = address;
        this.gender = gender;
        this.user = user;
    }

    public Vendor(List<Hobby> hobbies){
        this.hobbies = hobbies;
    }
}
