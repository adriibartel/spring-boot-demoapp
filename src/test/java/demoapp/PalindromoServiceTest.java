package demoapp;

import demoapp.service.PalindromoService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PalindromoServiceTest {

    private final PalindromoService service = new PalindromoService();

    @Test
    public void recognizesWordsIgnoringCase() {
        assertThat(service.esPalindromo("Neuquen")).isTrue();
    }

    @Test
    public void recognizesPhrasesIgnoringSpacesAndPunctuation() {
        assertThat(service.esPalindromo("Anita, lava la tina.")).isTrue();
    }

    @Test
    public void rejectsNonPalindromesAndTextWithoutLettersOrDigits() {
        assertThat(service.esPalindromo("Spring Boot")).isFalse();
        assertThat(service.esPalindromo(" !!! ")).isFalse();
    }
}
