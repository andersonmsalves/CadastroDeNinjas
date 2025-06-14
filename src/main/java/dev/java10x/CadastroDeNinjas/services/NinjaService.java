package dev.java10x.CadastroDeNinjas.services;

import dev.java10x.CadastroDeNinjas.entities.Ninja;
import dev.java10x.CadastroDeNinjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository; // Injeção de dependência

    // Listar todos os meus ninjas
    public List<Ninja> findAll() {
        return ninjaRepository.findAll();
    }

    // Buscar ninja por Id.
    public Ninja findById(Long id){
        return ninjaRepository.findById(id).get();
    }

    // Criar um ninja
    public Ninja criarNinja(Ninja ninja){
        return ninjaRepository.save(ninja);
    }
}
