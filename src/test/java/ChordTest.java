import model.ChordRoot;
import model.ChordType;
import model.Chord;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChordTest {
    final private static ChordRoot[] CHORD_ROOTS = new ChordRoot[] {
            ChordRoot.C, ChordRoot.Cs, ChordRoot.Db,
            ChordRoot.D, ChordRoot.Ds, ChordRoot.Eb,
            ChordRoot.E, ChordRoot.F, ChordRoot.Fs, ChordRoot.Gb,
            ChordRoot.G, ChordRoot.Gs, ChordRoot.Ab,
            ChordRoot.A, ChordRoot.As, ChordRoot.Bb,
            ChordRoot.B
    };

    final private static ChordType[] CHORD_TYPES = new ChordType[] {
            ChordType.major, ChordType.minor, ChordType.five, ChordType.seven
    };

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
