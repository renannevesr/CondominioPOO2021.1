package br.upe;

import java.io.IOException;

import javafx.fxml.FXML;

public class Login {
	
	@FXML
    private void switchToHome() throws IOException {
        App.setRoot("home");
    }

}
