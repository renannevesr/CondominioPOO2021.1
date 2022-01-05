package br.upe;

import java.io.IOException;

import br.upe.controllersJavaFX.Music;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;
  
    @Override
    public void start(Stage stage) throws IOException {
    	Music.playMusic("./mp3/login_music.mp3");
    	scene = new Scene(loadFXML("login"), 700, 500);
    	stage.setScene(scene);
    	stage.setResizable(false);
    	stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
	
    public static void main(String[] args) throws Exception {
    	launch();
    }
    
}