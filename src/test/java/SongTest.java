import model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    final private static int GENERATE_ITER = 10;
    final private static String TEST_PART_NAME = "Test part";

    @Test
    void generateSongPart() {
        ChordGroup[] mainChords = new ChordGroup[]{
                ChordGroup.generate(ChordGroupType.MAIN),
                ChordGroup.generate(ChordGroupType.MAIN)
        };

        SongPart pOld = new SongPart(TEST_PART_NAME, mainChords);

        for (int i = 0; i < GENERATE_ITER; i++) {
            SongPart pNew = new SongPart(TEST_PART_NAME, mainChords);

            assertSame(pNew.chordGroups, pOld.chordGroups, "У части песни разные аккорды");
            assertSame(pNew.name, TEST_PART_NAME, "Название части песни неверное");
        }
    }
}
