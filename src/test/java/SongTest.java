import model.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

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

    @Test
    void generateSong() {
        Song song = Song.generate();

        assertTrue(
                song.verses.length >= Song.MIN_VERSES && song.verses.length <= Song.MAX_VERSES,
                "Сгенерировано неверное число куплетов"
        );
    }

    @Test
    void printSongPart() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Song song = Song.generate();
        SongPart verse = song.verses[0];

        verse.print();

        System.out.flush();
        System.setOut(old);

        assertEquals(
                verse.sentences.length * 2 + 2, // 2 = название куплета + первая строка
                baos.toString().split("\n").length,
                "Выведено неверное количество строк"
        );
    }

    @Test
    void printSong() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Song song = Song.generate();
        song.print();

        System.out.flush();
        System.setOut(old);

        int expected = song.hasChorus ? song.verses.length - 1 : 0;
        expected += song.verses.length;

        Pattern p = Pattern.compile("[.*]:");
        int actual = p.split(baos.toString()).length;

        assertEquals(expected, actual,"Выведено неверное количество частей песен");
    }

    @Test
    void mainPrint() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        Main.main(new String[] {});
        System.out.flush();
        System.setOut(old);

        int actual = baos.toString().split("\n").length;

        assertTrue(actual >= SongPart.MIN_SENTENCES + 1,"Выведено неверное количество частей песен");
    }
}
