package com.padelapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.*;




@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "USER")
@DiscriminatorColumn(name = "user_Type")
public class User implements UserDetails {
    private static final Logger logger = LoggerFactory.getLogger(UserDetails.class);

    @Id
    @Column(name = "iduser")
    @GeneratedValue
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "create_time", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "GENDER")
    private Integer gender;

    @Column(name = "LEVEL")
    private String level;

    @Column(name = "username")
    private String telegramUsername;

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL)
    private List<BookingUser> bookingUsers = new ArrayList<>();

    @Transient
    private List<UserRole> roles=new ArrayList<>();



    public User() {
        this.getRoles().add(UserRole.USER);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole role : roles) authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        logger.info("authorities: " + authorities);
        return authorities;

    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
