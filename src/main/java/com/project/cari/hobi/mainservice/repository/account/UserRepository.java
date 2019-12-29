package com.project.cari.hobi.mainservice.repository.account;

import com.project.cari.hobi.mainservice.model.account.User;
import com.project.cari.hobi.mainservice.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<User> {
    Boolean existsUserByEmail(String email);
    Optional<User> findByEmail(String email);
}
