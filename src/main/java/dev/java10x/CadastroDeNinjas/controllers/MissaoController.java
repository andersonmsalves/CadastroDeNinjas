package dev.java10x.CadastroDeNinjas.controllers;

import dev.java10x.CadastroDeNinjas.entities.Missao;
import dev.java10x.CadastroDeNinjas.services.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/missoes")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    @GetMapping()
    public List<Missao> findAllMissoes(){
        return missaoService.findAll();
    }

    @GetMapping("/{id}")
    public Missao findMissaoById(@PathVariable Long id){
        return missaoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMissaoById(Long id){
        missaoService.deleteMissaoById(id);
    }

    @PostMapping
    public Missao criarMissao(@RequestBody Missao missao) {
        return missaoService.criarMissao(missao);
    }

    @PatchMapping("/{id}")
    public Missao atualizarMissao(@PathVariable Long id, @RequestBody Missao missao) {
        return missaoService.atualizarMissao(id, missao);
    }
}
