package model;

public class SongPart {
    public static final int MIN_SENTENCES = 6;
    public static final int MAX_SENTENCES = 15;
    static final double SKIP_CHORD_SENTENCE = .15;

    public String name;
    public ChordGroup[] chordGroups;
    public String[] sentences;

    public SongPart(String n, ChordGroup[] chordGroups) {
        this.name = n;
        this.chordGroups = chordGroups;

        Random r = new Random();
        sentences = new String[r.nextInt(MAX_SENTENCES - MIN_SENTENCES) + MIN_SENTENCES];
        RandomSentences.Length l = r.nextBoolean() ?
                RandomSentences.Length.MEDIUM :
                r.nextBoolean() ?
                        RandomSentences.Length.MEDIUM :
                        RandomSentences.Length.SHORT;

        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = RandomSentences.generateRandomSentence(l);
        }
    }
}
