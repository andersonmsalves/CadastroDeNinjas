package dev.java10x.CadastroDeNinjas.entities;

// Jpa = Java Persistence API
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ninjas")
/*@NoArgsConstructor
@AllArgsConstructor
@Data // Criar os Getters and Setters*/
@ToString(exclude = "missao")
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nome")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name="rank")
    private String rank;

    @Column(name = "idade")
    private int idade;

    // Um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missao_id") // Foreing Key ou chave estrangeira
    private Missao missao;

    public Ninja() {
    }

    public Ninja(Long id, String nome, String email, String imgUrl, int idade, String rank, Missao missao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.imgUrl = imgUrl;
        this.idade = idade;
        this.rank = rank;
        this.missao = missao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Missao getMissao() {
        return missao;
    }

    public void setMissao(Missao missao) {
        this.missao = missao;
    }
}
