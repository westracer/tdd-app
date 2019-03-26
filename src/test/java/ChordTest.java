import model.ChordRoot;
import model.ChordType;
import model.Chord;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

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
    void rootEnumNotNullCheck() {
        assertNotNull(ChordRoot.class, "Enum ChordRoot не существует");
    }

    @Test
    void rootEnumCheck() {
        assertArrayEquals(ChordRoot.values(), CHORD_ROOTS, "Значения ChordRoot не совпадают");
    }

    @Test
    void typeEnumNotNullCheck() {
        assertNotNull(ChordRoot.class, "Enum ChordType не существует");
        assertArrayEquals(ChordType.values(), CHORD_TYPES, "Значения ChordType не совпадают");
    }

    @Test
    void typeEnumCheck() {
        assertArrayEquals(ChordType.values(), CHORD_TYPES, "Значения ChordType не совпадают");
    }

    @Test
    void checkFields() {
        boolean root = false, type = false;
        for (Field f : Chord.class.getFields()) {
            if (f.getName().equals("root") && f.getType() == ChordRoot.class) {
                root = true;

                if (type) break;
            } else if (f.getName().equals("type")) {
                type = true;

                if (root) break;
            }
        }

        assertTrue(root, "Поле root у класса Chord неверное");
        assertTrue(type, "Поле type у класса Chord неверное");
    }

    @Test
    void checkConstructor() {
        for (ChordType t : ChordType.values()) {
            for (ChordRoot r : ChordRoot.values()) {

                Chord c = new Chord(r, t);

                assertEquals(c.root, r, "Создан объект класса Chord с неверным значением root");
                assertEquals(c.type, t, "Создан объект класса Chord с неверным значением type");
            }
        }
    }

    @Test
    void equalsCheck() {
        for (ChordType t : ChordType.values()) {
            for (ChordRoot r : ChordRoot.values()) {

                Chord c1 = new Chord(r, t);
                Chord c2 = new Chord(r, t);

                assertEquals(c1, c2, "Объекты не равны");
            }
        }
    }

    @Test
    void randomChordGenerator() {
        boolean different = false;
        Chord c = Chord.generate();

        for (int i = 0; i < 10; i++) {
            if (!c.equals(Chord.generate())) {
                different = true;
                break;
            }
        }

        assertTrue(different, "Генерируются одинаковые объекты Chord");
    }
}
