package dev.java10x.CadastroDeNinjas.repositories;

import dev.java10x.CadastroDeNinjas.entities.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<Ninja, Long> {
}
