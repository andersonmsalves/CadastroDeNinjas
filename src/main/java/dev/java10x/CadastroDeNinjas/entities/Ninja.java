package dev.java10x.CadastroDeNinjas.entities;

// Jpa = Java Persistence API
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ninjas")
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private int idade;

    // Um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missao_id") // Foreing Key ou chave estrangeira
    private Missao missao;

    public Ninja(){

    }

    public Ninja(String nome, String email, int idade){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public Ninja(String nome, String email, int idade, Missao missao){
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.missao = missao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Missao getMissao() {
        return missao;
    }

    public void setMissao(Missao missao) {
        this.missao = missao;
    }
}
