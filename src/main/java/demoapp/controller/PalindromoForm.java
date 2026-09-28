package demoapp.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PalindromoForm {

    @NotBlank(message = "Escribe una palabra o frase.")
    @Size(max = 100, message = "El texto no puede superar los 100 caracteres.")
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
