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
@Builder
@Setter
@EqualsAndHashCode(of = "id")// Provavelmente não precisa
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
    @Column(name="redesList")
    private List<Redes> redesList;

    @OneToMany(mappedBy = "participantes",cascade = CascadeType.ALL)
    @Column(name="projetosList")
    private List<Projetos> projetosList;
}
