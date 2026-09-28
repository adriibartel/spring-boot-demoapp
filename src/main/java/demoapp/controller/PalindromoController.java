package demoapp.controller;

import demoapp.service.PalindromoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PalindromoController {

    private final PalindromoService service;

    public PalindromoController(PalindromoService service) {
        this.service = service;
    }

    @GetMapping("/palindromo")
    public String formulario(PalindromoForm palindromoForm) {
        return "palindromoForm";
    }

    @PostMapping("/palindromo")
    public String comprobar(@ModelAttribute @Valid PalindromoForm palindromoForm,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "palindromoForm";
        }

        model.addAttribute("esPalindromo", service.esPalindromo(palindromoForm.getTexto()));
        model.addAttribute("textoAnalizado", palindromoForm.getTexto());
        return "palindromoResultado";
    }
}
