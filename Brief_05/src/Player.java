import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Player {
    public Player(){

    }
    //
    public void playSound(boolean type){
        String soundName = "correct-sound-effect";
        if (!type)
            soundName = "MetalGearAlert_SoundEffect";
        String absPath = String.format("/%s.wav", soundName);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource(absPath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
