package com.project.cari.hobi.mainservice.service.account;

import com.project.cari.hobi.mainservice.controller.v1.request.VendorRequest;
import com.project.cari.hobi.mainservice.model.account.User;
import com.project.cari.hobi.mainservice.model.account.Vendor;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional
    String createVendor(VendorRequest request);

    @Transactional
    User saveUser(String email, String password);

    Boolean isExists(String email);

    Vendor getVendorByEmail(String email);
}
