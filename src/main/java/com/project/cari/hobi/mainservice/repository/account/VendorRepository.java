package com.project.cari.hobi.mainservice.repository.account;

import com.project.cari.hobi.mainservice.model.account.User;
import com.project.cari.hobi.mainservice.model.account.Vendor;
import com.project.cari.hobi.mainservice.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends BaseRepository<Vendor> {
    Boolean existsVendorByName(String name);
    Optional<Vendor> findByUser(User user);


}
