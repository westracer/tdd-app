package model;

public class ChordGroup {
    public Chord[] chords;
    public String sentence;

    public ChordGroup(Chord[] chords, String s) {
        this.chords = chords;
        this.sentence = s;
    }

    public static ChordGroup generate() {
        return null;
    }
}
