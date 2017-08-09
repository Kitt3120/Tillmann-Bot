package de.vanillekeks.tillmannbot.musixmatch.entity.lyrics.get;

import com.google.gson.annotations.SerializedName;
import de.vanillekeks.tillmannbot.musixmatch.entity.lyrics.Lyrics;

public class LyricsGetBody {
	
    @SerializedName("lyrics")
    private Lyrics lyrics;

    public void setLyrics(Lyrics lyrics) {
        this.lyrics = lyrics;
    }

    public Lyrics getLyrics() {
        return lyrics;
    }
}
