package de.vanillekeks.tillmannbot.musixmatch.subtitle.get;

import com.google.gson.annotations.SerializedName;
import de.vanillekeks.tillmannbot.musixmatch.subtitle.Subtitle;

public class SubtitleGetBody {

    @SerializedName("subtitle")
    private Subtitle subtitle;

    public Subtitle getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(Subtitle subtitle) {
        this.subtitle = subtitle;
    }
}
