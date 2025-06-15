package dev.java10x.CadastroDeNinjas.services;

import dev.java10x.CadastroDeNinjas.dtos.NinjaDTO;
import dev.java10x.CadastroDeNinjas.entities.Ninja;
import dev.java10x.CadastroDeNinjas.mappers.NinjaMapper;
import dev.java10x.CadastroDeNinjas.repositories.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository; // Injeção de dependência

    @Autowired
    private NinjaMapper ninjaMapper;

    // Listar todos os meus ninjas
    public List<NinjaDTO> findAll() {
        List<Ninja> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)          // callback do metodo map
                .collect(Collectors.toList());  // converter para lista
    }

    // Buscar ninja por Id.
    public NinjaDTO findById(Long id){
        Optional<Ninja> ninja = ninjaRepository.findById(id);
        return ninja.map(ninjaMapper::map).orElse(null);
    }

    // Criar um ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDto){
        Ninja ninja = ninjaMapper.map(ninjaDto);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    // Excluir um ninja por Id
    public void excluirNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    // Atualizar ninja por Id
    public NinjaDTO atualizarNinjaPorId(Long id, NinjaDTO ninjaDTO) {
        Optional<Ninja> ninjaExiste = ninjaRepository.findById(id);

        if( ninjaExiste.isPresent() ) {
            ninjaDTO.setId(id);
            Ninja ninja = ninjaMapper.map(ninjaDTO);
            ninja = ninjaRepository.save(ninja);
            return ninjaMapper.map(ninja);
        }
        return null;
    }
}
