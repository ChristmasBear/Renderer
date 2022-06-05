package dev.christmasbear.renderer;

import org.bukkit.plugin.java.JavaPlugin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class Renderer extends JavaPlugin {
    public static BufferedImage img = null;
    public static String path = null;

    @Override
    public void onEnable() {
        path = this.getDataFolder().getAbsolutePath();
        getCommand("renderimage").setExecutor(new CommandHandler());
        getCommand("startbadapple").setExecutor(new CommandHandler());
        new File(path).mkdirs();
        try {
            File in = new File(path + "\\image.png");
            img = ImageIO.read(in);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
