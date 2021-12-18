package br.upe.controllersJavaFX;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	
	public static void alertSuccess(String txt) {
		Alert alert = new Alert (AlertType.INFORMATION);
		alert.setTitle("Sucesso");
		alert.setHeaderText("Operação realizada com sucesso!");
		alert.setContentText(txt);
		alert.showAndWait();
	}
	
	
	public static void alertError(String txt) {
		Alert alert = new Alert (AlertType.ERROR);
		alert.setTitle("Erro");
		alert.setHeaderText("Algo de errado aconteceu com essa operação");
		alert.setContentText(txt);
		alert.showAndWait();
	}
	
}


