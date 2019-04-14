import model.Chord;
import model.ChordGroup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChordGroupTest {
    final private static int GENERATE_ITER = 10;

    @Test
    void generateOneGroup() {
        for (int i = 0; i < GENERATE_ITER; i++) {
            ChordGroup g = ChordGroup.generate();
            assertTrue(g != null && g.chords.length > 0, "Группа аккордов пустая");
            assertTrue(g.sentence != null && g.sentence.length() > 0, "Группа аккордов пустая");
        }
        assertNotNull(Chord.class, "Класс Chord не существует");
    }
}
