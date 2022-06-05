package dev.christmasbear.renderer;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class VideoRenderer {
    public static void renderVideo(Location loc) {
        final int[] counter = {1};
        new BukkitRunnable() {
            @Override
            public void run() {
                if (counter[0] <= 5258) {
                    File in = new File(Renderer.path + "\\frames\\frame" + counter[0] + ".png");
                    try {
                        BufferedImage bimg = ImageIO.read(in);
                        Image img = bimg.getScaledInstance(60, 45, Image.SCALE_FAST);
                        BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
                        Graphics2D bGr = bi.createGraphics();
                        bGr.drawImage(img, 0, 0, null);
                        bGr.dispose();

                        for (int i = 0; i < bi.getWidth(); i++) {
                            for (int j = 0; j < bi.getHeight(); j++) {
                                int rgb = bi.getRGB(i, j);
                                java.awt.Color color1 = new java.awt.Color(rgb);
                                Location newLoc = loc.clone().add(i / 6f, 0, j / 6f);
                                org.bukkit.Color color2 = org.bukkit.Color.fromRGB(color1.getRed(), color1.getGreen(), color1.getBlue());
                                if (!color2.equals(org.bukkit.Color.WHITE)) {
                                    newLoc.getWorld().spawnParticle(Particle.REDSTONE, newLoc, 0, 0, 0, 0, 0, new Particle.DustOptions(color2, 1.25f));

                                }

                            }
                        }
                        counter[0]++;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    this.cancel();
                }

            }
        }.runTaskTimer(Renderer.getPlugin(Renderer.class), 0, 2L);
    }
}
