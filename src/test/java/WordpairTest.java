import Model.Wordpair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordpairTest {

    @DisplayName("Testen ob das Wort gültig ist")
    @Test
    public void testWord()  {
        Wordpair pair = new Wordpair("test","https://elearning.tgm.ac.at/course/view.php?id=1562");
        assertThrows(IllegalArgumentException.class, () -> {pair.setWord(null);});
        assertThrows(IllegalArgumentException.class, () -> {pair.setWord("");});
    }

    @DisplayName("Testen ob die URL gültig ist")
    @Test
    public void testURL()   {
        Wordpair pair = new Wordpair("test","https://elearning.tgm.ac.at/course/view.php?id=1562");
        assertThrows(IllegalArgumentException.class, () -> {pair.setURL(null);});
        assertThrows(IllegalArgumentException.class, () -> {pair.setURL("");});
        assertThrows(IllegalArgumentException.class, () -> {pair.setURL("test");});
    }
}
