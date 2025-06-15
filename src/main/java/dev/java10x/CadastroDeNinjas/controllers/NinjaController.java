package dev.java10x.CadastroDeNinjas.controllers;

import dev.java10x.CadastroDeNinjas.entities.Ninja;
import dev.java10x.CadastroDeNinjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }

    // Adicionar ninja (Create)
    @PostMapping("/criar")
    public Ninja criarNinja(@RequestBody Ninja ninja) {
        return ninjaService.criarNinja(ninja);
    }

    // Procurar Ninja por Id (Read)
    @GetMapping("/listar/{id}")
    public Ninja mostrarNinjaPorId(@PathVariable  Long id) {
        System.out.println("ID: " + id);
        return ninjaService.findById(id);
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public List<Ninja> mostrarTodosOsNinjas() {
        return ninjaService.findAll();
    }

    // Alterar dados dos ninjas (Update)
    @PutMapping("/alterarId")
    public String alterarNinjaPorId() {
        return "Alterar Ninja por id";
    }

    // Deletar Ninja (Delete)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId() {
        return "Ninja deletado por Id";
    }
}
