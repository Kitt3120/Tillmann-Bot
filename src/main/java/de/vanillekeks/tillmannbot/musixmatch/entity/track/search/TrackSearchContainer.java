package de.vanillekeks.tillmannbot.musixmatch.entity.track.search;

import com.google.gson.annotations.SerializedName;
import de.vanillekeks.tillmannbot.musixmatch.entity.Header;

public class TrackSearchContainer {

	@SerializedName("body")
	private TrackSearchBody body;

	@SerializedName("header")
	private Header header;

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public TrackSearchBody getBody() {
		return body;
	}

	public void setBody(TrackSearchBody body) {
		this.body = body;
	}
}
