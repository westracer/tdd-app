package model;

import java.util.Random;

public class Chord {
    public ChordRoot root;
    public ChordType type;

    public Chord(ChordRoot root, ChordType type) {
        this.root = root;
        this.type = type;
    }

    public static Chord generate() {
        ChordRoot[] roots = ChordRoot.values();
        ChordType[] types = ChordType.values();
        Random r = new Random();

        return new Chord(roots[r.nextInt(roots.length)], types[r.nextInt(types.length)]);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == Chord.class) {
            Chord c2 = (Chord) obj;

            return this.root == c2.root && this.type == c2.type;
        } else {
            return super.equals(obj);
        }
    }
}
