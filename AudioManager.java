/**
 * Class responsible for loading music and sounds and providing methods for playback, stopping, and changing.
 * @version 0.1
 * @author 
 */

 import javax.sound.sampled.*;
 import java.io.IOException;
 import java.util.Objects;
 import java.util.Scanner;
 import java.io.BufferedInputStream;
 
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
      * Primary constructor: Loads all audio files and initializes their clips.
      * @throws UnsupportedAudioFileException 
      * @throws IOException 
      * @throws LineUnavailableException 
      */
     private AudioManager() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
         menuMusic = AudioSystem.getAudioInputStream(
             new BufferedInputStream(
                 Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("resources/menu_music.wav"))
             )
         );
         gamePlayMusic = AudioSystem.getAudioInputStream(
             new BufferedInputStream(
                 Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("resources/gameplay_music.wav"))
             )
         );
         buttonClickSound = AudioSystem.getAudioInputStream(
             new BufferedInputStream(
                 Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("resources/button_sound.wav"))
             )
         );
         correctAnswerSound = AudioSystem.getAudioInputStream(
             new BufferedInputStream(
                 Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("resources/correct_answer.wav"))
             )
         );
 
         menuMusicClip = AudioSystem.getClip();
         menuMusicClip.open(menuMusic);
         gameplayMusicClip = AudioSystem.getClip();
         gameplayMusicClip.open(gamePlayMusic);
         buttonClickSoundClip = AudioSystem.getClip();
         buttonClickSoundClip.open(buttonClickSound);
         correctAnswerSoundClip = AudioSystem.getClip();
         correctAnswerSoundClip.open(correctAnswerSound);
     }
     
     /**
      * No-op constructor used for the SilentAudioManager.
      * It doesn't load any audio and thus doesn't throw any exceptions.
      * @param skip a dummy parameter to differentiate from the primary constructor.
      */
     private AudioManager(boolean skip) {
         // No audio loading. This constructor purposely does nothing.
     }
     
     /**
      * Main method to run the AudioManager.
      * @param args
      * @throws UnsupportedAudioFileException
      * @throws LineUnavailableException
      * @throws IOException
      */
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
         sc.close();
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
         menuMusic = AudioSystem.getAudioInputStream(
             Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(music))
         );
     }
     
     /**
      * Returns the singleton instance of AudioManager.
      */
     public static AudioManager getInstance() {
         if (audioManager == null) {
             synchronized (AudioManager.class) {
                 if (audioManager == null) {
                     try {
                         audioManager = new AudioManager();
                     } catch (Exception e) {
                         System.out.println("⚠️ Audio failed to initialize. Skipping sound.");
                         audioManager = new SilentAudioManager(true); // Use the no-op version
                     }
                 }
             }
         }
         return audioManager;
     }
     
     /**
      * Silent version of AudioManager that does nothing.
      */
     private static class SilentAudioManager extends AudioManager {
         private SilentAudioManager(boolean dummy) {
             super(true); // Calls the no-op constructor in AudioManager
         }
     
         @Override public void playMenuMusic() {}
         @Override public void stopMenuMusic() {}
         @Override public void playGameplayMusic() {}
         @Override public void stopGameplayMusic() {}
         @Override public void playButtonClickSound() {}
         @Override public void playCorrectAnswerSound() {}
     }
 } 