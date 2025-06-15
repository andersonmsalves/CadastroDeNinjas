package dev.java10x.CadastroDeNinjas.services;

import dev.java10x.CadastroDeNinjas.dtos.MissaoDTO;
import dev.java10x.CadastroDeNinjas.entities.Missao;
import dev.java10x.CadastroDeNinjas.mappers.MissaoMapper;
import dev.java10x.CadastroDeNinjas.repositories.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

    @Autowired
    private MissaoMapper missaoMapper;

    // Buscar todas as missoes
    public List<MissaoDTO> findAll() {
        List<Missao> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map) // Iterar sobre cada Missao fazendo o mapeamento
                .collect(Collectors.toList()); // Converter para lista
    }

    // Buscar missao por id
    public MissaoDTO findById(Long id) {
        Optional<Missao> missao = missaoRepository.findById(id);
        return missao.map(missaoMapper::map).orElse(null);
    }

    // Deletar missao por id
    public void deleteMissaoById(Long id) {
        missaoRepository.deleteById(id);
    }

    // Criar missao
    public MissaoDTO criarMissao(MissaoDTO missaoDTO){
        Missao missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    // Atualizar Missao por is
    public MissaoDTO atualizarMissao(Long id, MissaoDTO missaoDTO) {

        Optional<Missao> missaoExistente = missaoRepository.findById(id);

        if( missaoExistente.isPresent() ) {
            missaoDTO.setId(id);
            Missao missao = missaoMapper.map(missaoDTO);
            missao = missaoRepository.save(missao);
            return missaoMapper.map(missao);
        }
        return null;
    }
}
