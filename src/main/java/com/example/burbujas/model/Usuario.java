package com.example.burbujas.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "cuit")
    private String cuit;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @ManyToOne()
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "direccion_comercial")
    private String direccionComercial;

    @Column(name = "email")
    private String email;

    @ManyToOne()
    @JoinColumn(name = "pais_id")
    private Pais pais;

    @ManyToOne()
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    @ManyToOne()
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    public Usuario() {
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccionComercial() {
        return direccionComercial;
    }

    public void setDireccionComercial(String direccionComercial) {
        this.direccionComercial = direccionComercial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(usuarioId, usuario.usuarioId) && Objects.equals(nombre, usuario.nombre) && Objects.equals(apellido, usuario.apellido) && Objects.equals(cuit, usuario.cuit) && Objects.equals(fechaCreacion, usuario.fechaCreacion) && Objects.equals(fechaModificacion, usuario.fechaModificacion) && Objects.equals(rol, usuario.rol) && Objects.equals(direccion, usuario.direccion) && Objects.equals(direccionComercial, usuario.direccionComercial) && Objects.equals(email, usuario.email) && Objects.equals(pais, usuario.pais) && Objects.equals(provincia, usuario.provincia) && Objects.equals(localidad, usuario.localidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, nombre, apellido, cuit, fechaCreacion, fechaModificacion, rol, direccion, direccionComercial, email, pais, provincia, localidad);
    }
}
