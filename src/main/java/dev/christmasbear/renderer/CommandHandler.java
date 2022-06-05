package dev.christmasbear.renderer;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.image.BufferedImage;

public class CommandHandler implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("renderimage")) {
                BufferedImage img = Renderer.img;
                Location playerLoc = ((Player) sender).getLocation();
                ImageRenderer.renderImage(img, playerLoc);

            } else if (command.getName().equalsIgnoreCase("startbadapple")) {
                Location playerLoc = ((Player) sender).getLocation();
                VideoRenderer.renderVideo(playerLoc);
            }
        }

        return false;
    }
}
