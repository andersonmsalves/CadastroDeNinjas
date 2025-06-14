package dev.java10x.CadastroDeNinjas.repositories;

import dev.java10x.CadastroDeNinjas.entities.Missao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<Missao, Long> {
}
