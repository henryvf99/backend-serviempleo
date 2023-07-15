package com.example.backendserviempleo.models;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titulo", length = 60, nullable = false)
    private String titulo;

    @Column(name = "costo", nullable = false)
    private Integer costo;

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;

    @Column(name = "idusuario", nullable = false)
    private Integer idusuario;

}
