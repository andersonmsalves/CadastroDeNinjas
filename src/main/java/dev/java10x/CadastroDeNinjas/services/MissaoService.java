package dev.java10x.CadastroDeNinjas.services;

import dev.java10x.CadastroDeNinjas.dtos.MissaoDTO;
import dev.java10x.CadastroDeNinjas.entities.Missao;
import dev.java10x.CadastroDeNinjas.mappers.MissaoMapper;
import dev.java10x.CadastroDeNinjas.repositories.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

    @Autowired
    private MissaoMapper missaoMapper;

    // Buscar todas as missoes
    public List<Missao> findAll() {
        return missaoRepository.findAll();
    }

    // Buscar missao por id
    public Missao findById(Long id) {
        return missaoRepository.findById(id).get();
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
    public Missao atualizarMissao(Long id, Missao missao) {

        if(missaoRepository.existsById(id)) {
            missao.setId(id);
            return missaoRepository.save(missao);
        }
        return null;
    }
}
