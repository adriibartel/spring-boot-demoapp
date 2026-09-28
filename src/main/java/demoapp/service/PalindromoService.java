package demoapp.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromoService {

    public boolean esPalindromo(String texto) {
        int[] caracteres = texto.codePoints()
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .toArray();

        if (caracteres.length == 0) {
            return false;
        }

        for (int izquierda = 0, derecha = caracteres.length - 1; izquierda < derecha; izquierda++, derecha--) {
            if (caracteres[izquierda] != caracteres[derecha]) {
                return false;
            }
        }
        return true;
    }
}
