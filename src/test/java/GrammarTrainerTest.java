import Model.GrammarTrainer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrammarTrainerTest {

    @DisplayName("Testen ob man Wordpair hinufügen kann")
    @Test
    public void testAddPair()   {
        GrammarTrainer g = new GrammarTrainer();
        assertThrows(IllegalArgumentException.class, () -> {g.addWordpair(null);});
    }
}
