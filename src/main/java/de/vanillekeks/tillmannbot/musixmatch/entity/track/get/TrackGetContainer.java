package de.vanillekeks.tillmannbot.musixmatch.entity.track.get;

import com.google.gson.annotations.SerializedName;
import de.vanillekeks.tillmannbot.musixmatch.entity.Header;

public class TrackGetContainer {

    @SerializedName("header")
    private Header header;


    @SerializedName("body")
    private TrackGetBody body;


    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public TrackGetBody getBody() {
        return body;
    }

    public void setBody(TrackGetBody body) {
        this.body = body;
    }
}
