package dev.java10x.CadastroDeNinjas.entities;

// Jpa = Java Persistence API
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ninjas")
@NoArgsConstructor
@AllArgsConstructor
@Data // Criar os Getters and Setters
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    // Um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missao_id") // Foreing Key ou chave estrangeira
    private Missao missao;
}
