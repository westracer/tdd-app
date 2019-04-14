import model.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ChordGroupTest {
    final private static int GENERATE_ITER = 10;

    @Test
    void equalsCheck() {
        Chord[] chords = new Chord[]{ Chord.generate(), Chord.generate() };
        for (ChordGroupType t : ChordGroupType.values()) {
            ChordGroup c1 = new ChordGroup(chords, t);
            ChordGroup c2 = new ChordGroup(chords, t);

            assertEquals(c1, c2, "Объекты не равны");
        }
    }

    @Test
    void generateOneGroup() {
        Random r = new Random();
        ChordGroup gOld = ChordGroup.generate(ChordGroupType.MAIN);
        boolean different = false;

        for (int i = 0; i < GENERATE_ITER; i++) {
            ChordGroupType t = r.nextBoolean() ? ChordGroupType.MAIN : ChordGroupType.EXTRA;
            ChordGroup gNew = ChordGroup.generate(t);

            assertTrue(gNew.chords.length > 0, "Группа аккордов пустая");
            assertSame(gNew.type, t, "Группа аккордов имеет неверный тип");

            if (!gOld.equals(ChordGroup.generate(t))) {
                different = true;
                break;
            }
        }

        assertTrue(different, "Генерируются одинаковые объекты ChordGroup");
    }
}
