package model;

import java.util.Random;

public class Song {
    public static final int MIN_VERSES = 1;
    public static final int MAX_VERSES = 3;

    public ChordGroup[] mainChords;     // основные аккорды
    public ChordGroup[] extraChords;    // доп. аккорды
    public SongPart[] verses;           // куплеты
    public SongPart chorus;             // припев
    public boolean hasChorus;           // есть ли припев

    public Song() {}

    public static Song generate() {
        Random r = new Random();
        Song song = new Song();

        song.mainChords = new ChordGroup[]{ ChordGroup.generate(ChordGroupType.MAIN), ChordGroup.generate(ChordGroupType.MAIN) };
        song.extraChords = new ChordGroup[]{ ChordGroup.generate(ChordGroupType.EXTRA), ChordGroup.generate(ChordGroupType.EXTRA) };

        song.chorus = new SongPart("Chorus", song.extraChords);
        song.hasChorus = song.chorus.chordGroups[0].chords.length > 0 || song.chorus.chordGroups[1].chords.length > 0;

        song.verses = new SongPart[r.nextInt(MAX_VERSES - MIN_VERSES) + MIN_VERSES];
        for (int i = 0; i < song.verses.length; i++) {
            song.verses[i] = new SongPart("Verse " + (i + 1), song.mainChords);
        }

        return song;
    }
}
