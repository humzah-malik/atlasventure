/**
 * Class responsible for loading music and sounds and providing methods for playback, stopping, and changing.
 * @version 0.1
 * @author Prabnoor Multani
 */

 import javax.sound.sampled.*;
 import java.io.IOException;
 import java.util.Objects;
 import java.util.Scanner;
 
 public class AudioManager {
     private AudioInputStream menuMusic;
     private Clip menuMusicClip;
     private AudioInputStream gamePlayMusic;
     private Clip gameplayMusicClip;
     private AudioInputStream buttonClickSound;
     private Clip buttonClickSoundClip;
     private AudioInputStream correctAnswerSound;
     private Clip correctAnswerSoundClip;
    
     private static AudioManager audioManager;

     /**
      * AudioManager constructor. Loads all music and sound files and initializes and opens their corresponding clips.
      * @throws UnsupportedAudioFileException
      * @throws IOException
      * @throws LineUnavailableException
      */
     private AudioManager() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
         menuMusic = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("resources/menu_music.wav")));
         gamePlayMusic = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("resources/gameplay_music.wav")));
         buttonClickSound = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("resources/button_sound.wav")));
         correctAnswerSound = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("resources/correct_answer.wav")));

         menuMusicClip = AudioSystem.getClip();
         menuMusicClip.open(menuMusic);
         gameplayMusicClip = AudioSystem.getClip();
         gameplayMusicClip.open(gamePlayMusic);
         buttonClickSoundClip = AudioSystem.getClip();
         buttonClickSoundClip.open(buttonClickSound);
         correctAnswerSoundClip = AudioSystem.getClip();
         correctAnswerSoundClip.open(correctAnswerSound);
     }
 
     public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
         AudioManager man = new AudioManager();
 
         Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();
         while (!input.equalsIgnoreCase("exit")) {
             if (input.equalsIgnoreCase("mp")) man.playMenuMusic();
             if (input.equalsIgnoreCase("ms")) man.stopMenuMusic();
             if (input.equalsIgnoreCase("gp")) man.playGameplayMusic();
             if (input.equalsIgnoreCase("gs")) man.stopGameplayMusic();
             if (input.equalsIgnoreCase("bp")) man.playButtonClickSound();
             if (input.equalsIgnoreCase("cap")) man.playCorrectAnswerSound();
             input = sc.nextLine();
         }
     }
 
     /**
      * Plays menu music.
      */
     public void playMenuMusic() {
         if (menuMusicClip.isRunning()) menuMusicClip.stop();
         menuMusicClip.setFramePosition(0);
         menuMusicClip.start();
     }
 
     /**
      * Stops the menu music.
      */
     public void stopMenuMusic() {
         menuMusicClip.stop();
     }
 
     /**
      * Plays the gameplay music.
      */
     public void playGameplayMusic() {
         if (gameplayMusicClip.isRunning()) gameplayMusicClip.stop();
         gameplayMusicClip.setFramePosition(0);
         gameplayMusicClip.start();
     }
 
     /**
      * Stops the gameplay music.
      */
     public void stopGameplayMusic() {
         gameplayMusicClip.stop();
     }
 
     /**
      * Plays the button click sound.
      */
     public void playButtonClickSound() {
         buttonClickSoundClip.setFramePosition(0);
         buttonClickSoundClip.start();
     }
 
     /**
      * Plays the correct answer sound.
      */
     public void playCorrectAnswerSound() {
         correctAnswerSoundClip.setFramePosition(0);
         correctAnswerSoundClip.start();
     }
 
     /**
      * Changes the audio input stream for the menu music.
      * @param music path to the music file.
      * @throws UnsupportedAudioFileException
      * @throws IOException
      */
     public void changeMenuMusic(String music) throws UnsupportedAudioFileException, IOException {
         menuMusic = AudioSystem.getAudioInputStream(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(music)));
     }

     public static AudioManager getInstance() {
        if (audioManager == null) {
            synchronized (AudioManager.class) {
                if (audioManager == null) {
                    try {
                        audioManager = new AudioManager();
                    } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                        e.printStackTrace(); // Consider a better exception handling
                    }
                }
            }
        }
        return audioManager;
    }
 }
