package com.project.cari.hobi.mainservice.controller.v1;

import com.project.cari.hobi.mainservice.controller.v1.request.VendorRequest;
import com.project.cari.hobi.mainservice.exception.ConflictException;
import com.project.cari.hobi.mainservice.model.account.Vendor;
import com.project.cari.hobi.mainservice.service.account.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/vendor/{email}")
    public Vendor getByEmail(@PathVariable("email") String email){
        return userService.getVendorByEmail(email);
    }

    @PostMapping(value = "/vendor/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> vendorRegister(@RequestBody VendorRequest request){
        if(userService.isExists(request.getEmail()))
            throw new ConflictException("Email Already Exists!");

        return ResponseEntity.ok(userService.createVendor(request));
    }

}
