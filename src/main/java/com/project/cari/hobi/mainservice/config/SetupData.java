package com.project.cari.hobi.mainservice.config;


import com.project.cari.hobi.mainservice.model.account.Address;
import com.project.cari.hobi.mainservice.model.account.User;
import com.project.cari.hobi.mainservice.model.account.Vendor;
import com.project.cari.hobi.mainservice.repository.account.AddressRepository;
import com.project.cari.hobi.mainservice.repository.account.UserRepository;
import com.project.cari.hobi.mainservice.repository.account.VendorRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class SetupData implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetupData = false;

    private UserRepository userRepository;
    private VendorRepository vendorRepository;
    private AddressRepository addressRepository;


    public SetupData(UserRepository userRepository, VendorRepository vendorRepository, AddressRepository addressRepository){
        this.userRepository = userRepository;
        this.vendorRepository = vendorRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        if(alreadySetupData) return;
        createUser("geraldo@haqpan.com", "123456");

        createAddress("Home", "jl. ini dan itu", "1","Babakan", "2", "", "", "", "", "", "");
        createVendor("Vendor Name - 2 ", "123456", "http://google.com/photo",  "M", "Home", "jl. ini dan itu", "1","Babakan", "2", "", "", "", "", "", "16680","vendor@haqpan.com", "123456" );
        alreadySetupData = true;

    }


    //List of Save Functions

    @Transactional
    User createUser(String email, String password){
        Optional<User> existsUser = userRepository.findByEmail(email);
        if(!existsUser.isPresent()){
            User user = new User(email, password);
            return userRepository.save(user);
        }else{
            return existsUser.get();
        }
    }

    @Transactional
    Address createAddress(String name, String street, String subDistrictId, String subdistrict, String districtId, String district, String cityId, String city, String provinceId, String province, String postalCode ){
        Address address = new Address(name, street, subDistrictId, subdistrict, districtId, district, cityId, city, provinceId, province, postalCode);
        return addressRepository.save(address);
    }


    @Transactional
    Vendor createVendor(String name, String phone, String photo,  String gender, String nameAddress, String street, String subDistrictId, String subdistrict, String districtId, String district, String cityId, String city, String provinceId, String province, String postalCode ,String email, String password ){
        boolean isExistsVendor = vendorRepository.existsVendorByName(name);
        if(!isExistsVendor){
            User user = createUser(email, password);
            Address address = createAddress(nameAddress, street, subDistrictId, subdistrict, districtId, district, cityId, city, provinceId, province, postalCode);
            Vendor vendor = new Vendor(name, phone, photo,  gender, address, user);
            return vendorRepository.save(vendor);
        }

        return  null;
    }


}
