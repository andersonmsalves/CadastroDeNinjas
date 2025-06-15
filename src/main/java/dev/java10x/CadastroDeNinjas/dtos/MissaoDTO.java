package dev.java10x.CadastroDeNinjas.dtos;

import dev.java10x.CadastroDeNinjas.entities.Ninja;
import dev.java10x.CadastroDeNinjas.enums.NivelMissao;

import java.util.List;

public class MissaoDTO {

    private Long id;

    private String nome;

    private NivelMissao dificuldade;

    private List<Ninja> ninjas;

    public MissaoDTO() {
    }

    public MissaoDTO(Long id, String nome, NivelMissao dificuldade, List<Ninja> ninjas) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.ninjas = ninjas;
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

    public NivelMissao getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(NivelMissao dificuldade) {
        this.dificuldade = dificuldade;
    }

    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }
}
