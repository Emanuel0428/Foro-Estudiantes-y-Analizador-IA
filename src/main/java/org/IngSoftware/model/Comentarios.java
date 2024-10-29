package org.IngSoftware.model;

import jakarta.persistence.*;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Comentarios")
public class Comentarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdComentario;

    @JoinColumn(name = "IdPublicaciones", nullable = false)
    private Publicaciones publicaciones;

    @JoinColumn(name = "DocId", nullable = false)
    private int docId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String Contenido;

    @Column(name = "Fecha_Creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "Fecha_Ultima_Edicion", nullable = false)
    private LocalDateTime fechaUltimaEdicion;


    public int getIdComentario() {
        return IdComentario;
    }

    public void setIdComentario(int idComentario) {
        IdComentario = idComentario;
    }

    public Publicaciones getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(Publicaciones publicaciones) {
        this.publicaciones = publicaciones;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public String getContenido() {
        return Contenido;
    }

    public void setContenido(String contenido) {
        Contenido = contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaUltimaEdicion() {
        return fechaUltimaEdicion;
    }

    public void setFechaUltimaEdicion(LocalDateTime fechaUltimaEdicion) {
        this.fechaUltimaEdicion = fechaUltimaEdicion;
    }
}

