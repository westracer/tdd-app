package model;

import java.util.Arrays;
import java.util.Random;

public class ChordGroup {
    public static final int MIN_MAIN_CHORDS = 1;
    public static final int MAX_MAIN_CHORDS = 4;
    public static final int MIN_EXTRA_CHORDS = 0;
    public static final int MAX_EXTRA_CHORDS = 3;

    public Chord[] chords;
    public double[] pos;
    public ChordGroupType type;

    public ChordGroup(Chord[] chords, ChordGroupType t, double[] p) {
        this.chords = chords;
        this.type = t;
        this.pos = p;
    }

    public ChordGroup(Chord[] chords, ChordGroupType t) {
        this.chords = chords;
        this.type = t;

        Random r = new Random();
        double[] pos = new double[chords.length];

        for (int i = 0; i < chords.length; i++) {
            chords[i] = Chord.generate();

            double orPos = 1. * chords.length / i;
            int sign = r.nextBoolean() ? 1 : -1;
            double shift = r.nextDouble() / 5;

            pos[i] = orPos + shift * sign * orPos;
        }

        this.pos = pos;
    }

    public static ChordGroup generate(ChordGroupType t) {
        Random r = new Random();

        int min = t == ChordGroupType.MAIN ? MIN_MAIN_CHORDS : MIN_EXTRA_CHORDS;
        int max = t == ChordGroupType.MAIN ? MAX_MAIN_CHORDS : MAX_EXTRA_CHORDS;

        int size = r.nextInt(max - min) + min;
        Chord[] chords = new Chord[size];
        double[] pos = new double[size];

        for (int i = 0; i < size; i++) {
            chords[i] = Chord.generate();

            double orPos = (1. + i) / size;
            double shift = r.nextDouble() / 5 + .1;

            pos[i] = orPos - .6 * shift;
        }

        return new ChordGroup(chords, t, pos);
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

    public void print(String sentence) {
        int strLen = sentence.length();
        StringBuilder sb = new StringBuilder();

        int prevPos = 0;

        for (int i = 0; i < chords.length; i++) {
            Chord c = chords[i];
            String chordStr = c.toString();
            int currPos = (int) (strLen * pos[i]) - 2 * chordStr.length();

            for (int j = prevPos; j < currPos; j++) {
                sb.append(" ");
            }

            sb.append(chordStr);

            prevPos = currPos;
        }

        System.out.println(sb.toString());
    }
}
