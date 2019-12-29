package com.project.cari.hobi.mainservice.service.account.impl;

import com.project.cari.hobi.mainservice.controller.v1.request.VendorRequest;
import com.project.cari.hobi.mainservice.exception.ResourceNotFoundException;
import com.project.cari.hobi.mainservice.model.account.Address;
import com.project.cari.hobi.mainservice.model.account.User;
import com.project.cari.hobi.mainservice.model.account.Vendor;
import com.project.cari.hobi.mainservice.repository.account.UserRepository;
import com.project.cari.hobi.mainservice.repository.account.VendorRepository;
import com.project.cari.hobi.mainservice.service.account.AddressService;
import com.project.cari.hobi.mainservice.service.account.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private AddressService addressService;

    @Override
    public String createVendor(VendorRequest request){
        User user = saveUser(request.getEmail(), request.getPassword());
        Address address = addressService.create(request.getAddress());
        Vendor vendor = new Vendor(request.getName(), request.getPhone(), request.getPhoto(), request.getGender(), address, user);
        vendorRepository.save(vendor);
        return "ok";
    }

    @Override
    public User saveUser(String email, String password){
        User user = new User(email, password);
        return userRepository.save(user);
    }

    @Override
    public Boolean isExists(String email){
        return userRepository.existsUserByEmail(email);
    }


    @Override
    public Vendor getVendorByEmail(String email){
        return vendorRepository.findByUser(getByEmail(email))
                .orElseThrow(() -> new ResourceNotFoundException("Vendor with  email:"+email+" is not found!"));
    }

    private User getByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Email is Not Found!"));
    }
}
