package com.code.BusinessSecurity.Infraestructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="users")
@Getter
@Setter
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long idUser;

    @Column(name = "firstname", nullable = false,length = 100)
    private String firstName;

    @Column(name = "lastname", nullable = false,length = 100)
    private String lastName;

    @Column(name = "email", nullable = false,length = 100)
    private String email;

    @Column(name = "password", nullable = false,length = 300)
    private String password;

    @Column(name = "image", nullable = false,length = 500)
    private String image;

    @Column(name="isactive", nullable = false,length = 1)
    private Boolean isActive;

    @Column(name="createdat",nullable = false)
    private Timestamp createdAt;

    @Column(name="updatedby",nullable = true)
    private Integer updatedBy;

    @Column(name="updatedat",nullable = true)
    private Timestamp updatedAt;

    @Column(name="rejectby",nullable = true)
    private Integer rejectBy;

    @Column(name="rejectat",nullable = true)
    private Timestamp rejectAt;
    /*
    @Column(name = "idrol", nullable = false)
    private Long idRol;
    */
    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "idrol")
    //private RolEntity rol;
    @JoinTable(name = "roles",
            joinColumns = @JoinColumn(name = "idrol"),
            inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<RolEntity> rol = new HashSet<>();




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rol.stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getName()))
                .collect(Collectors.toList());
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
