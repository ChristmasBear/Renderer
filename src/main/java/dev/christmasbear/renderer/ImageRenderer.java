package dev.christmasbear.renderer;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

import java.awt.image.BufferedImage;

public class ImageRenderer {
    public static void renderImage(BufferedImage img, Location loc) {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (int i = 0; i < img.getWidth(); i++) {
                    for (int j = 0; j < img.getHeight(); j++) {
                        int rgb = img.getRGB(i, j);
                        java.awt.Color color1 = new java.awt.Color(rgb);
                        Location newLoc = loc.clone().add(i / 5f, 0, j / 5f);
                        Color color2 = Color.fromRGB(color1.getRed(), color1.getGreen(), color1.getBlue());
                        newLoc.getWorld().spawnParticle(Particle.REDSTONE, newLoc, 0, 0, 0, 0, 0, new Particle.DustOptions(color2, 1.25f));

                    }
                }
            }
        }.runTaskTimer(Renderer.getPlugin(Renderer.class), 0, 5L);
    }
}
