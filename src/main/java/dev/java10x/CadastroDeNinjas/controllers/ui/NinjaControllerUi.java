package dev.java10x.CadastroDeNinjas.controllers.ui;

import com.google.gson.Gson;
import dev.java10x.CadastroDeNinjas.dtos.NinjaDTO;
import dev.java10x.CadastroDeNinjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/listar/{id}")
    public String mostrarNinjaPorId(@PathVariable  Long id, Model model) {

        NinjaDTO ninjaDTO = ninjaService.findById(id);
        model.addAttribute("ninja", ninjaDTO);
        model.addAttribute("id", id);

        if(ninjaDTO != null) {
            return "ninjaDetalhes";
        }
        return "notFoundPage";
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarNinja(Model model) {
        model.addAttribute("ninja", new NinjaDTO());
        return "formularioNinja";
    }

    @PostMapping("/salvar")
    public String salvarNinja(@ModelAttribute NinjaDTO ninja, RedirectAttributes redirectAttributes) {
        ninjaService.criarNinja(ninja);
        redirectAttributes.addFlashAttribute("mensagem", "Ninja cadastrado com sucesso!");
        return "redirect:/ninjas/ui/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarNinja(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.findById(id);
        model.addAttribute("id", id);

        if(ninja != null){
            model.addAttribute("ninja", ninja);
            return "formularioNinja";
        }
        return "notFoundPage";
    }
}
