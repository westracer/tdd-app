import model.Chord;
import model.ChordGroup;
import model.ChordGroupType;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ChordGroupTest {
    final private static int GENERATE_ITER = 10;

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
