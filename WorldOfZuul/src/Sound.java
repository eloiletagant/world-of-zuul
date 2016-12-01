import java.io.File;
import javax.sound.sampled.*;
/*
 * 
 * Group 4
 * 01/12/2016
 */

public class Sound {
	public synchronized void playSound(String url) {
		  File f = new File(url);
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(f);
		        clip.open(inputStream);
		        clip.loop(Clip.LOOP_CONTINUOUSLY);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
}