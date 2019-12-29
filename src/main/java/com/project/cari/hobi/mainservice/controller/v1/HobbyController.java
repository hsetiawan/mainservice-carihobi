package com.project.cari.hobi.mainservice.controller.v1;

import com.project.cari.hobi.mainservice.controller.v1.request.HobbyRequest;
import com.project.cari.hobi.mainservice.service.product.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hobby")
public class HobbyController {

    @Autowired
    HobbyService hobbyService;

    @PostMapping("")
    private String create(@RequestBody HobbyRequest request){
        return null;
    }
}
