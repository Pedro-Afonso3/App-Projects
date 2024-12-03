package com.app.App_projects.domain.participantes;

import com.app.App_projects.domain.projetos.Projetos;
import com.app.App_projects.domain.redes.Redes;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="participantes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Participantes {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="participantes_id")
    private String id;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @OneToMany(mappedBy = "participantes",cascade = CascadeType.ALL)
    private List<Redes> redesList;

    @OneToMany(mappedBy = "participantes",cascade = CascadeType.ALL)
    private List<Projetos> projetosList;
}
