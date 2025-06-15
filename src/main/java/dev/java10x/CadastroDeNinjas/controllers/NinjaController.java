package dev.java10x.CadastroDeNinjas.controllers;

import dev.java10x.CadastroDeNinjas.dtos.NinjaDTO;
import dev.java10x.CadastroDeNinjas.entities.Ninja;
import dev.java10x.CadastroDeNinjas.mappers.NinjaMapper;
import dev.java10x.CadastroDeNinjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @Autowired
    private NinjaMapper ninjaMapper;

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (Create)
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Procurar Ninja por Id (Read)
    @GetMapping("/listar/{id}")
    public NinjaDTO mostrarNinjaPorId(@PathVariable  Long id) {
        System.out.println("ID: " + id);
        return ninjaService.findById(id);
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public List<NinjaDTO> mostrarTodosOsNinjas() {
        return ninjaService.findAll();
    }

    // Deletar Ninja (Delete)
    @DeleteMapping("/excluir/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.excluirNinja(id);
    }

    // Alterar dados dos ninjas (Update)
    @PatchMapping("/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return ninjaService.atualizarNinjaPorId(id, ninja);
    }
}
