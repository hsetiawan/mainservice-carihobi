package com.project.cari.hobi.mainservice.model.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.cari.hobi.mainservice.model.Base;
import com.project.cari.hobi.mainservice.model.account.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")
@Where(clause = "IS_DELETED=false")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends Base {

    @NotNull
    @Email(message = "enter.valid.email")
    @Column(nullable = false)
    private String email;

    @NotNull
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.status = UserStatus.NEW;
    }
}
