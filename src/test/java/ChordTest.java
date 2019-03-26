import model.ChordRoot;
import model.ChordType;
import model.Chord;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChordTest {
    @Test
    void classExists() {
        assertNotNull(Chord.class, "Класс Chord не существует");
    }

    @Test
    void rootEnumCheck() {
        assertNotNull(ChordRoot.class, "Enum ChordRoot не существует");
        assertArrayEquals(ChordRoot.values(), CHORD_ROOTS, "Значения ChordRoot не совпадают");
    }

    @Test
    void typeEnumCheck() {
        assertNotNull(ChordRoot.class, "Enum ChordType не существует");
        assertArrayEquals(ChordType.values(), CHORD_TYPES, "Значения ChordType не совпадают");
    }
}
