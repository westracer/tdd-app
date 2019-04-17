import model.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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

            assertSame(gNew.type, t, "Группа аккордов имеет неверный тип");

            if (!gOld.equals(ChordGroup.generate(t))) {
                different = true;
                break;
            }
        }

        assertTrue(different, "Генерируются одинаковые объекты ChordGroup");
    }

    @Test
    void printGroup() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        ChordGroup group = ChordGroup.generate(ChordGroupType.MAIN);
        group.print("Test sentence test sentence test sentence test sentence");

        StringBuilder str = new StringBuilder();
        for (Chord c : group.chords) {
            str.append(c.toString());
        }

        System.out.flush();
        System.setOut(old);

        assertEquals(
                str.toString(),
                baos.toString().trim().replace(" ", ""),
                "Выведены неверные аккорды"
        );
    }
}
