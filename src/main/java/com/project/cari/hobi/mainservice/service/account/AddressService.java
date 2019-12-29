package com.project.cari.hobi.mainservice.service.account;

import com.project.cari.hobi.mainservice.controller.v1.request.AddressRequest;
import com.project.cari.hobi.mainservice.model.account.Address;
import org.springframework.stereotype.Service;

public interface AddressService {

    Address create(AddressRequest request);


}
