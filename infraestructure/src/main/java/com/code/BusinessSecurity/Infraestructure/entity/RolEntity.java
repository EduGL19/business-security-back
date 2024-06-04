package com.code.BusinessSecurity.Infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles")
@Getter
@Setter
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private Long idRol;

    @Column(name = "name", nullable = false,length = 50)
    private String name;

    @Column(name = "slug", nullable = false,length = 50)
    private String slug;

    @Column(name = "menus", nullable = false,length = 250)
    private String menus;

}
