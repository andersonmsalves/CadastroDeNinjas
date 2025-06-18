package dev.java10x.CadastroDeNinjas.controllers;

import dev.java10x.CadastroDeNinjas.dtos.MissaoDTO;
import dev.java10x.CadastroDeNinjas.entities.Missao;
import dev.java10x.CadastroDeNinjas.services.MissaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/missoes")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;


    @GetMapping("/boasVindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    @GetMapping()
    public List<MissaoDTO> findAllMissoes(){
        return missaoService.findAll();
    }

    @GetMapping("/{id}")
    public MissaoDTO findMissaoById(@PathVariable Long id){
        return missaoService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteMissaoById(Long id){
        missaoService.deleteMissaoById(id);
    }

    @PostMapping
    public MissaoDTO criarMissao(@RequestBody MissaoDTO missaoDTO) {
        return missaoService.criarMissao(missaoDTO);
    }

    @PatchMapping("/{id}")
    public MissaoDTO atualizarMissao(@PathVariable Long id, @RequestBody MissaoDTO missaoDTO) {
        return missaoService.atualizarMissao(id, missaoDTO);
    }
}
