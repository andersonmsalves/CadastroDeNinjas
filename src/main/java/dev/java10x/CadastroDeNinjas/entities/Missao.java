package dev.java10x.CadastroDeNinjas.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.CadastroDeNinjas.enums.NivelMissao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor
@AllArgsConstructor
@Data
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

    /*public Missao(){

    }

    public Missao(String nome, NivelMissao dificuldade){
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.ninjas = new ArrayList<>();
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

    public void adicionarNinja(Ninja ninja) {
        this.ninjas.add(ninja);
    }

    public List<Ninja> getNinjas(){
        return ninjas;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
