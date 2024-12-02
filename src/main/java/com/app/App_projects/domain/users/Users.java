package com.app.App_projects.domain.users;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@EqualsAndHashCode(of = "id")// Provavelmente não precisa
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;
}
