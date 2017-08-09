package de.vanillekeks.tillmannbot.modules;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.Event;

import java.util.List;

public interface IModule {

    //Main
    public void onRegister();

    //Commands
    public List<Command> getCommands();

    public boolean hasCommands();

    public void onCommand(Command command, List<String> args, User author, MessageChannel channel, Message message);

    //Info
    public String getName();

    //Misc

    public void unload();

    public boolean isVisible();

    public void onEvent(Event event);

    void onShutdown();
}
