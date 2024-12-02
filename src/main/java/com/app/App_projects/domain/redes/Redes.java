package com.app.App_projects.domain.redes;

import com.app.App_projects.domain.participantes.Participantes;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="redes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@EqualsAndHashCode(of = "id")// Provavelmente não precisa
public class Redes {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="nome")
    private String name;

    @Column(name="linkRedes")
    private String linkRedes;

    @ManyToOne
    @JoinColumn(name="participantes_id",nullable = false)
    private Participantes participantes;


}
