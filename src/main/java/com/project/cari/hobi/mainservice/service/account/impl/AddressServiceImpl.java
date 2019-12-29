package com.project.cari.hobi.mainservice.service.account.impl;

import com.project.cari.hobi.mainservice.controller.v1.request.AddressRequest;
import com.project.cari.hobi.mainservice.model.account.Address;
import com.project.cari.hobi.mainservice.repository.account.AddressRepository;
import com.project.cari.hobi.mainservice.service.account.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address create(AddressRequest request){
        Address address = new Address(request.getName(), request.getStreet(), request.getSubDistrictId(), request.getSubDistrict(), request.getDistrictId(), request.getDistrict(), request.getCityId(), request.getCity(), request.getProvinceId(), request.getProvince(), request.getPostalCode());
        return addressRepository.save(address);
    }
}
