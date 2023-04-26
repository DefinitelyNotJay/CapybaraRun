package main;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
    private Clip clip;
    private URL soundURL[] = new URL[30];
    
    public Sound(){
        soundURL[0] = getClass().getResource("/res/sound/capybara_main.wav");
    }

    public void setFiles(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void playsound(){
        clip.start();
    }

    public void loopsound(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopsound(){
        clip.stop();
    }
}
