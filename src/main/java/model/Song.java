package model;

public class Song {
    public static final int MIN_PARTS = 2;
    public static final int MAX_PARTS = 3;

    public Chord[] mainChords;          // основные аккорды
    public Chord[] extraChords;         // доп. аккорды
    public int chordsPerGroup;          // аккордов в группе
    public SongPart[] verses;           // куплеты
    public boolean groupSizeChanges;    // меняется ли длина группы
    public SongPart chorus;             // припев

    public Song() {}

    public static Song generate() {
        return null;
    }
}
