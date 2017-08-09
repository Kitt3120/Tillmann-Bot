package de.vanillekeks.tillmannbot.musixmatch.snippet.get;

import com.google.gson.annotations.SerializedName;
import de.vanillekeks.tillmannbot.musixmatch.entity.Header;

public class SnippetGetContainer {

    @SerializedName("body")
    private SnippetGetBody body;

    @SerializedName("header")
    private Header header;

    public SnippetGetBody getBody() {
        return body;
    }

    public void setBody(SnippetGetBody body) {
        this.body = body;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
