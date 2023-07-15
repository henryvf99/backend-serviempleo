package com.example.backendserviempleo.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 60, nullable = false)
    private String apellido;

    @Column(name = "telefono", length = 9, nullable = false)
    private String telefono;

    @Column(name = "direccion", length = 60, nullable = false)
    private String direccion;

    @Column(name = "mensaje", length = 500, nullable = false)
    private String mensaje;

    @Column(name = "servicio", length = 60, nullable = false)
    private String servicio;

    @Column(name = "costo", length = 60, nullable = false)
    private String costo;

    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;

    @Column(name = "iduserc", nullable = false)
    private Integer iduserc;


}
