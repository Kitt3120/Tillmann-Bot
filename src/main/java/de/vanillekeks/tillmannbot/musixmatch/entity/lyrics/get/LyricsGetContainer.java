package de.vanillekeks.tillmannbot.musixmatch.entity.lyrics.get;

import com.google.gson.annotations.SerializedName;
import de.vanillekeks.tillmannbot.musixmatch.entity.Header;

public class LyricsGetContainer {
	
    @SerializedName("body")
    private LyricsGetBody body;
    
    @SerializedName("header")
    private Header header;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public LyricsGetBody getBody() {
        return body;
    }

    public void setBody(LyricsGetBody body) {
        this.body = body;
    }
}
