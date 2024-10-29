package org.IngSoftware.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int DocId;

    @Column(nullable = false, length = 100)
    private String Nombre;

    @Column(nullable = false, unique = true)
    private String Correo;

    @Column(nullable = false)
    private String Contrasena;

    @Column(name = "fecha_registro", nullable = false)
    private Date Fecha_Registro;


    // Getters y Setters

    public int getId() {
        return DocId;
    }

    public String Nombre(){
        return Nombre;
    }



}

