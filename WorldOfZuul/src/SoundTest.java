import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundTest {
	public static void main(String[] args) throws Exception {

		System.out.println("1");
		URL url = new URL("https://r9---sn-hgn7zn7l.googlevideo.com/videoplayback?id=a282d12539ee9094&itag=251&source=youtube&requiressl=yes&pl=24&ratebypass=yes&mime=audio/webm&gir=yes&clen=3710220&lmt=1442163962886924&dur=223.961&key=cms1&signature=776AA44B9B57F97EE856FABCBC058451AA7EDD8A.0B74C16549A12885A07ECF35661136B60F673FB8&upn=GBoxYnpAdOs&ip=195.220.223.18&ipbits=0&expire=1480092759&sparams=clen,dur,expire,gir,id,initcwndbps,ip,ipbits,ipbypass,itag,lmt,mime,mm,mn,ms,mv,nh,pl,ratebypass,requiressl,source&redirect_counter=1&req_id=5aaa9cb78b60a3ee&cms_redirect=yes&ipbypass=yes&mm=31&mn=sn-hgn7zn7l&ms=au&mt=1480070952&mv=m");
		System.out.println("2");
		AudioClip clip = Applet.newAudioClip(url);
		System.out.println("3");
		clip.play();
		System.out.println("4");
		Thread.sleep(1000);

//		URL url = new URL(
//			"file:/C:/Users/Eli/workspace/minitennis/src/com/edu4java/minitennis7/back.wav");

//		URL url = SoundTest.class.getResource("back.wav");
//		AudioClip clip = Applet.newAudioClip(url);
//		AudioClip clip2 = Applet.newAudioClip(url);
//		clip.play();
//		Thread.sleep(1000);
//		clip2.loop();
//		Thread.sleep(20000);
//		clip2.stop();
		
		System.out.println("end");
	}
}