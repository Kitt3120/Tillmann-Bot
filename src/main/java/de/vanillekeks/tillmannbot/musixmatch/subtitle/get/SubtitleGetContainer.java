package de.vanillekeks.tillmannbot.musixmatch.subtitle.get;

import com.google.gson.annotations.SerializedName;
import de.vanillekeks.tillmannbot.musixmatch.entity.Header;

public class SubtitleGetContainer {

    @SerializedName("body")
    private SubtitleGetBody body;

    @SerializedName("header")
    private Header header;

    public SubtitleGetBody getBody() {
        return body;
    }

    public void setBody(SubtitleGetBody body) {
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
