package com.project.cari.hobi.mainservice.repository;

import com.project.cari.hobi.mainservice.model.Base;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends Base> extends JpaRepository<T,Long>, JpaSpecificationExecutor<T> {
    Optional<T> findBySecureId(String secureId);
}
