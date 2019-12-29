package com.project.cari.hobi.mainservice.controller.v1.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorRequest {

    private String email;
    private String password;
    private String name;
    private String phone;
    private String photo;
    private AddressRequest address;
    private String gender;

}
