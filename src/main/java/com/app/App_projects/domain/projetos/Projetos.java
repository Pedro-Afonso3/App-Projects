package com.app.App_projects.domain.projetos;

import com.app.App_projects.domain.participantes.Participantes;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="projetos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Projetos {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="projetos_id")
    private UUID id;

    @Column(name="CodProjeto", unique = true, nullable = false)
    private Long codProjeto;

    @Column(name="titulo")
    private String titulo;

    @Column(name="descricao")
    private String descricao;

    @Column(name="tecnologias")
    private String tecnologias;//Achei melhor colocar assim, porque nem smp será uma linguagem pode ser um framework

    @ManyToOne
    @JoinColumn(name="participantes_id")
    private Participantes participantes;

    @PrePersist
    private void gerarDados() {
        if (id == null) {
            this.id = java.util.UUID.randomUUID();
        }
        if (codProjeto == null) {
            this.codProjeto = (long) (Math.random() * 1_000_000);
        }
    }
}
