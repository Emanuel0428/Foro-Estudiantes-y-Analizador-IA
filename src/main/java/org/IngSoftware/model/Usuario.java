package org.IngSoftware.model;

import jakarta.persistence.*;

import java.util.Date;

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
    private String Contraseña;

    @Column(name = "fecha_registro", nullable = false)
    private Date Fecha_Registro;


    // Getters y Setters

    public int getId() {
        return DocId;
    }

    public String getNombre(){
        return Nombre;
    }

    public String getCorreo(){
        return Correo;
    }

    public String getContraseña(){
        return Contraseña;
    }

    public Date getFecha_Registro(){
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

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public void setFecha_Registro(Date Fecha_Registro) {
        this.Fecha_Registro = Fecha_Registro;
    }


}

