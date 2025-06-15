package dev.java10x.CadastroDeNinjas.dtos;

import dev.java10x.CadastroDeNinjas.entities.Missao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class NinjaDTO {

    private Long id;

    private String nome;

    private String email;

    private String imgUrl;

    private String rank;

    private int idade;

    private Missao missao;

    public NinjaDTO() {
    }

    public NinjaDTO(Long id, String nome, String email, String imgUrl, String rank, int idade, Missao missao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.imgUrl = imgUrl;
        this.rank = rank;
        this.idade = idade;
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
