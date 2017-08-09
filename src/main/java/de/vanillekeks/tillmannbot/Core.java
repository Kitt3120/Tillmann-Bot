package de.vanillekeks.tillmannbot;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.sedmelluq.discord.lavaplayer.player.AudioConfiguration;
import de.vanillekeks.tillmannbot.audio.AudioSystem;
import de.vanillekeks.tillmannbot.frames.GUIFrame;
import de.vanillekeks.tillmannbot.misc.Authentication;
import de.vanillekeks.tillmannbot.modules.modulemanager.ModuleManager;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Core {

    private static Core instance;

    private static JDA bot;
    
    private static AudioSystem audioSystem;

    private static ModuleManager moduleManager;
    
    //Youtube API
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport HTTP_TRANSPORT;
    private static YouTube youtube;

    public static void main(String[] args) {
    	try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        } catch (Throwable t) {
            t.printStackTrace();
            System.err.println("Google HTTP_TRANSPORT could not be created. (Audio Module) - Exiting...");
            System.exit(1);
        }

        System.out.println("Setting up Youtube-API");
        try {
    		youtube = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
                @Override
                public void initialize(HttpRequest httpRequest) throws IOException {
                }
            }).setApplicationName("Tillmann-Bot").build();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("There was an error setting up the Youtube-API - " + e.getMessage() + "\nExiting...");
			System.exit(1);
		}
        System.out.println("Youtube-API set up. Starting Bot...");

        instance = new Core();
        System.out.println("Started");
    }

    public Core() {
        try {
            bot = new JDABuilder(AccountType.BOT).setToken(Authentication.DISCORD_TOKEN).setAutoReconnect(true).buildBlocking();
        } catch (LoginException | IllegalArgumentException | InterruptedException | RateLimitedException e) {
            e.printStackTrace();
            System.err.println("Could not start the bot: " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Setting up AudioSystem");
        audioSystem = new AudioSystem();
        audioSystem.getAudioPlayer().setVolume(15);
        audioSystem.getAudioPlayerManager().getConfiguration().setOpusEncodingQuality(10); //10 = max
        audioSystem.getAudioPlayerManager().getConfiguration().setResamplingQuality(AudioConfiguration.ResamplingQuality.HIGH);
        System.out.println("AudioSystem set up. Starting bot...");

        moduleManager = new ModuleManager();

        try {
            new GUIFrame();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Could not start the GUI: " + e.getMessage());
        }
    }

    public static Core getInstance() {
        return instance;
    }

    public static JDA getBot() {
        return bot;
    }

    public static ModuleManager getModuleManager() {
        return moduleManager;
    }
    
    public static YouTube getYoutube() {
		return youtube;
	}
    
    public static AudioSystem getAudioSystem() {
		return audioSystem;
	}

    public static void shutdown() {
        moduleManager.shutdown();
        System.exit(0);
    }

    public static Guild getMainGuild() {
        return bot.getGuildById("321288450299133973");
    }

    public static TextChannel getMainTextChannel() {
        return getMainGuild().getTextChannelById("344474459467677697");
    }

    public static TextChannel getSongInfoTextChannel() { return getMainGuild().getTextChannelById("344610155939364874"); }
}
