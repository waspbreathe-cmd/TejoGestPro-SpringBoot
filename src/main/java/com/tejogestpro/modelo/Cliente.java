package com.tejogestpro.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

/**
 * Entidad JPA que representa la tabla 'cliente' en la base de datos tejo_gest_pro.
 * Incluye anotaciones de validacion para garantizar integridad de datos en formularios.
 */
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    @NotBlank(message = "El numero de documento es obligatorio")
    @Pattern(regexp = "^[0-9]{6,15}$", message = "El documento debe contener entre 6 y 15 digitos numericos")
    @Column(name = "documento", nullable = false, length = 20)
    private String documento;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 60, message = "El apellido debe tener entre 2 y 60 caracteres")
    @Column(name = "apellido", nullable = false, length = 60)
    private String apellido;

    @NotBlank(message = "El telefono es obligatorio")
    @Pattern(regexp = "^[0-9]{7,10}$", message = "El telefono debe tener entre 7 y 10 digitos")
    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @NotBlank(message = "El correo electronico es obligatorio")
    @Email(message = "Ingrese un formato de correo electronico valido")
    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "fecha_registro", insertable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    // Constructor vacio requerido por JPA
    public Cliente() {
    }

    // Getters y Setters siguiendo estandar camelCase
    public Integer getIdCliente() { return idCliente; }
    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}