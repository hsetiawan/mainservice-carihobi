package com.project.cari.hobi.mainservice.model.account;

import com.project.cari.hobi.mainservice.model.Base;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "ADDRESSES")
@Where(clause = "IS_DELETED=false")
@DynamicUpdate
public class Address extends Base {

    @NotNull
    private String name;

    @NotNull
    private String street;

    private String subDistrictId;

    private String subDistrict;

    private String districtId;

    private String district;

    private String cityId;

    private String city;

    private String provinceId;

    private String province;

    private String postalCode;

    public Address(String name, String street, String subDistrictId, String subDistrict, String districtId, String district, String cityId, String city, String provinceId, String province, String postalCode) {
        this.name = name;
        this.street = street;
        this.subDistrictId = subDistrictId;
        this.subDistrict = subDistrict;
        this.districtId = districtId;
        this.district = district;
        this.cityId = cityId;
        this.city = city;
        this.provinceId = provinceId;
        this.province = province;
        this.postalCode = postalCode;
    }
}
