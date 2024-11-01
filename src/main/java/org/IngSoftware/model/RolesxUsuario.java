package org.IngSoftware.model;
import jakarta.persistence.*;

@Entity
@Table(name = "RolesxUsuario")
public class RolesxUsuario {


    @ManyToOne
    @JoinColumn(name = "IdRol")
    private Roles IdRol;

    @ManyToOne
    @JoinColumn(name = "DocId")
    private Usuario DocId;

    // Getters y Setters

    public Roles getIdRol() {
        return IdRol;
    }

    public Usuario getDocId() {
        return DocId;
    }

    public void setIdRol(Roles IdRol) {
        this.IdRol = IdRol;
    }

    public void setDocId(Usuario DocId) {
        this.DocId = DocId;
    }
}
