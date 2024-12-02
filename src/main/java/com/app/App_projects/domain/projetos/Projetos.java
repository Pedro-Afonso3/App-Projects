package com.app.App_projects.domain.projetos;

import com.app.App_projects.domain.participantes.Participantes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="projetos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@EqualsAndHashCode(of = "id")// Provavelmente não precisa
public class Projetos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="descricao")
    private String descricao;

    @Column(name="tecnologias")
    private String tecnologias;//Achei melhor colocar assim, porque nem smp será uma linguagem pode ser um framework

    @ManyToOne
    @JoinColumn(name="participantes_id")
    private Participantes participantes;
}
