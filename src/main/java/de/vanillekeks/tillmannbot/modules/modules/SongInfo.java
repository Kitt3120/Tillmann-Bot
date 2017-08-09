package de.vanillekeks.tillmannbot.modules.modules;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventListener;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import de.vanillekeks.tillmannbot.Core;
import de.vanillekeks.tillmannbot.misc.Authentication;
import de.vanillekeks.tillmannbot.modules.Command;
import de.vanillekeks.tillmannbot.modules.IModule;
import de.vanillekeks.tillmannbot.musixmatch.MusixMatch;
import de.vanillekeks.tillmannbot.musixmatch.MusixMatchException;
import de.vanillekeks.tillmannbot.musixmatch.entity.lyrics.Lyrics;
import de.vanillekeks.tillmannbot.musixmatch.entity.track.Track;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import java.util.List;

/**
 * Created by kitt3120 on 09.08.2017 at 00:47.
 */
public class SongInfo extends AudioEventAdapter implements IModule, AudioEventListener {

    private MusixMatch musixMatch;

    @Override
    public void onRegister() {
        Core.getAudioSystem().getAudioPlayer().addListener(this);
        musixMatch = new MusixMatch(Authentication.MUSIXMATCH_API_KEY);
    }

    @Override
    public void onTrackStart(AudioPlayer player, AudioTrack track) {
        Message message = null;
        try {
            message = Core.getSongInfoTextChannel().sendMessage("Now playing " + track.getInfo().title).complete(true);
            String lyrics = getLyrics(track.getInfo().title);
            message.editMessage(message.getContent() + "\n```" + lyrics + "```").queue();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        } catch (MusixMatchException e) {
            e.printStackTrace();
            if(message != null) message.editMessage(message.getContent() + "\n```Ein Fehler ist aufgetreten```").queue();
        }
    }

    @Override
    public List<Command> getCommands() {
        return null;
    }

    @Override
    public boolean hasCommands() {
        return false;
    }

    @Override
    public void onCommand(Command command, List<String> args, User author, MessageChannel channel, Message message) {}

    @Override
    public String getName() {
        return "SongInfo";
    }

    @Override
    public void unload() {}

    @Override
    public boolean isVisible() {
        return false;
    }

    @Override
    public void onEvent(Event event) {}

    @Override
    public void onShutdown() {}

    private String getLyrics(String songInfo) throws MusixMatchException {
        List<Track> tracks = musixMatch.searchTracks(songInfo, null, null, 1, 1, true);
        if(!tracks.isEmpty()) {
            Track foundTrack = tracks.get(0);
            if(foundTrack.getTrack().getHasLyrics() == 1) {
                Lyrics lyrics = musixMatch.getLyrics(foundTrack.getTrack().getTrackId());
                return lyrics.getLyricsBody();
            }
        }
        return "Kein Liedtext gefunden";
    }
}
