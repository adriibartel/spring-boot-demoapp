package demoapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PalindromoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void displaysThePalindromeForm() throws Exception {
        mockMvc.perform(get("/palindromo"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Comprobar si es un palíndromo")));
    }

    @Test
    public void postsTextAndDisplaysTheServiceResult() throws Exception {
        mockMvc.perform(post("/palindromo").param("texto", "Anita, lava la tina."))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("es un palíndromo.")));
    }

    @Test
    public void rejectsBlankAndOverlongText() throws Exception {
        String tooLong = String.format("%101s", "").replace(' ', 'a');

        mockMvc.perform(post("/palindromo").param("texto", "   "))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Escribe una palabra o frase.")));

        mockMvc.perform(post("/palindromo").param("texto", tooLong))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("El texto no puede superar los 100 caracteres.")));
    }
}
