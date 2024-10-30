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
    @Column(nullable = false, length = 12)
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

    public String Correo(){
        return Correo;
    }

    public String Contrasena(){
        return Contrasena;
    }

    public Date Fecha_Registro(){
        return Fecha_Registro;
    }

    public void setId(int DocId) {
        this.DocId = DocId;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public void setFecha_Registro(Date Fecha_Registro) {
        this.Fecha_Registro = Fecha_Registro;
    }


    public Object getContrasena() {
        return Contrasena;
    }
}

