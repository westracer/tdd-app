package model;

import java.util.Arrays;
import java.util.Random;

public class ChordGroup {
    public static final int MIN_MAIN_CHORDS = 1;
    public static final int MAX_MAIN_CHORDS = 4;
    public static final int MIN_EXTRA_CHORDS = 0;
    public static final int MAX_EXTRA_CHORDS = 3;

    public Chord[] chords;
    public ChordGroupType type;

    public ChordGroup(Chord[] chords, ChordGroupType t) {
        this.chords = chords;
        this.type = t;
    }

    public static ChordGroup generate(ChordGroupType t) {
        Random r = new Random();

        int min = t == ChordGroupType.MAIN ? MIN_MAIN_CHORDS : MIN_EXTRA_CHORDS;
        int max = t == ChordGroupType.MAIN ? MAX_MAIN_CHORDS : MAX_EXTRA_CHORDS;

        int size = r.nextInt(max - min) + min;
        Chord[] chords = new Chord[size];

        for (int i = 0; i < size; i++) {
            chords[i] = Chord.generate();
        }

        return new ChordGroup(chords, t);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == ChordGroup.class) {
            ChordGroup g2 = (ChordGroup) obj;

            return Arrays.equals(chords, g2.chords) && type == g2.type;
        } else {
            return super.equals(obj);
        }
    }
}
