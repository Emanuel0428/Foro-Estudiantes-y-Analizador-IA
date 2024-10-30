package org.IngSoftware.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdRol;

    @Column(nullable = false, length = 50)
    private String DescripRol;


    // Getters y Setters

    public Long getIdRol() {
        return IdRol;
    }

    public String getDescripRol() {
        return DescripRol;
    }

    public void setIdRol(Long IdRol) {
        this.IdRol = IdRol;
    }

    public void setDescripRol(String DescripRol) {
        this.DescripRol = DescripRol;
    }
}

