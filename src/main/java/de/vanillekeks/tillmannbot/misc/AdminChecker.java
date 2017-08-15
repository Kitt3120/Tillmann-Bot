package de.vanillekeks.tillmannbot.misc;

import net.dv8tion.jda.core.entities.User;

import java.util.ArrayList;

public class AdminChecker {

    public static boolean isAdmin(User user) {
        ArrayList<String> adminIds = new ArrayList<>();
        adminIds.add("256510610165071873"); //Papst
        adminIds.add("186105158076203011"); //Van <3
        adminIds.add("238645059329720330"); //Kitt3120
        adminIds.add("292269732873240597"); //Semih
        adminIds.add("325752779106811904"); //Luca
        return (adminIds.contains(user.getId()));
    }

}
