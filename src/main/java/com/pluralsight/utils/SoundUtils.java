package com.pluralsight.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class SoundUtils {

    public static void playMenuClick() {
        playSound("sounds/menu-click.wav");
    }

    public static void playSuccessChime() {
        playSound("sounds/success-chime.wav");
    }

    public static void playExitSound() {
        playSound("sounds/exit-sound.wav");
    }

    private static void playSound(String resourcePath) {
        try (InputStream rawStream = SoundUtils.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (rawStream == null) {
                System.out.println("Sound file not found: " + resourcePath);
                return;
            }
            // AudioSystem needs a stream that supports mark/reset to read the wav header
            try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(rawStream))) {
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
                // exit sound plays on program shutdown, so block until playback finishes
                // instead of letting the JVM exit and cut the clip off early
                while (!clip.isRunning()) Thread.sleep(10);
                while (clip.isRunning()) Thread.sleep(10);
                clip.close();
            }
        } catch (Exception e) {
            System.out.println("Unable to play sound: " + e.getMessage());
        }
    }
}
