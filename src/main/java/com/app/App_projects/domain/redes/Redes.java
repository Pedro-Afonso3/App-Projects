package com.app.App_projects.domain.redes;

import com.app.App_projects.domain.participantes.Participantes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="redes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Redes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="redes_id")
    private String id;

    @Column(name="CodRedes", unique = true, nullable = false)
    private Long codRedes;

    @Column(name="nome")
    private String nome;

    @Column(name="linkRedes")
    private String linkRedes;

    @ManyToOne
    @JoinColumn(name="participantes_id",nullable = false)
    private Participantes participantes;

    @PrePersist
    private void gerarDados() {
        if (id == null) {
            this.id = java.util.UUID.randomUUID().toString();
        }
        if (codRedes == null) {
            this.codRedes = (long) (Math.random() * 1_000_000);
        }
    }

}
