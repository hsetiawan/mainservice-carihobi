package com.project.cari.hobi.mainservice.controller.v1.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private String name;
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
}
