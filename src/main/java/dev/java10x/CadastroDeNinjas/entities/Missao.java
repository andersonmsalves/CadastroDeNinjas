package dev.java10x.CadastroDeNinjas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.enums.NivelMissao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_missoes")
/*@NoArgsConstructor
@AllArgsConstructor
@Data*/
@ToString
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private NivelMissao dificuldade;

    // Uma missao pode ter vários ninjas
    @OneToMany(mappedBy = "missao")
    @JsonIgnore
    private List<Ninja> ninjas;

    public Missao() {
    }

    public Missao(Long id, String nome, NivelMissao dificuldade, List<Ninja> ninjas) {
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
