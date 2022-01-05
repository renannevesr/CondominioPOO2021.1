package br.upe.controllersJavaFX;

import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music {

	static MediaPlayer mediaPlayer;
	
	public static void playMusic(String s) {
		try{
			Media h = new Media(Paths.get(s).toUri().toString());
			mediaPlayer = new MediaPlayer(h);
			if (s.equals("./mp3/login_music.mp3")) {
				mediaPlayer.setVolume(0.045);				
			}else {
				mediaPlayer.setVolume(0.09);	
			}
			mediaPlayer.play();
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public static void stopMusic(){
		mediaPlayer.stop();
	}
	
	public static void pauseMusic() {
		mediaPlayer.pause();
	}
}
