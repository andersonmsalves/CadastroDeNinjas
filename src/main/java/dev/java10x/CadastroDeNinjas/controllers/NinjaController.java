package dev.java10x.CadastroDeNinjas.controllers;

import dev.java10x.CadastroDeNinjas.dtos.NinjaDTO;
import dev.java10x.CadastroDeNinjas.entities.Ninja;
import dev.java10x.CadastroDeNinjas.mappers.NinjaMapper;
import dev.java10x.CadastroDeNinjas.services.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import java.util.List;

@RestController
@RequestMapping(value = "/ninjas")
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    @Autowired
    private NinjaMapper ninjaMapper;

    // Adicionar ninja (Create)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + ninjaDTO.getNome() +
                        "(ID): " + ninjaDTO.getId() );
    }

    // Procurar Ninja por Id (Read)
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarNinjaPorId(@PathVariable  Long id) {

        NinjaDTO ninjaDTO = ninjaService.findById(id);

        if(ninjaDTO != null) {
            Gson gson = new Gson();
            // return ResponseEntity.ok().body( gson.toJson(ninjaDTO) );
            return ResponseEntity
                    .ok()
                    .body( ninjaDTO );
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ninja não encontrado");
    }

    // Mostrar todos os ninjas (Read)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> mostrarTodosOsNinjas() {
        List<NinjaDTO> ninjasDTO = ninjaService.findAll();
        return ResponseEntity.ok().body(ninjasDTO);
    }

    // Deletar Ninja (Delete)
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {

        if(ninjaService.findById(id) != null) {
            ninjaService.excluirNinja(id);
            return ResponseEntity.ok("Ninja deletado com sucesso");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("O ninja com id: " + id + " não encontrado");
    }

    // Alterar dados dos ninjas (Update)
    @PatchMapping("/{id}")
    public ResponseEntity<String> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){

        if( ninjaService.findById(id) != null ){
            ninjaService.atualizarNinjaPorId(id, ninja);
            return ResponseEntity.ok().body("Ninja com id: " + id + " atualizado com sucesso");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Ninja não encontrado para atualizar");

    }
}
