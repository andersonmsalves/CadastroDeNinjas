package dev.java10x.CadastroDeNinjas.controllers.ui;

import dev.java10x.CadastroDeNinjas.dtos.NinjaDTO;
import dev.java10x.CadastroDeNinjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ninjas/ui")
public class NinjaControllerUi {

    @Autowired
    private NinjaService ninjaService;

    // Mostrar todos os ninjas (Read)
    // http://localhost:8080/ninjas/ui/listar
    @GetMapping("/listar")
    public String findAllNinjas(Model model) {
        List<NinjaDTO> ninjasDTO = ninjaService.findAll();
        model.addAttribute("ninjas", ninjasDTO);
        return "listarNinjas";
    }

    @GetMapping("/excluir/{id}")
    public String deletarNinjaPorId(@PathVariable Long id) {

        ninjaService.excluirNinja(id);
        return "redirect:/ninjas/ui/listar";
    }
}
