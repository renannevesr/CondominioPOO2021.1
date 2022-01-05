package br.upe.controllersJavaFX;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Alerts {
	
	static int aux;
	
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
	
	public static boolean alertConfirmation(String operation, String prosseguir) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setHeaderText(operation);
		alert.setContentText(prosseguir);
		ButtonType btnSim = new ButtonType ("Sim");
		ButtonType btnNao = new ButtonType ("Não");

		alert.getButtonTypes().setAll(btnSim, btnNao);
		
		alert.showAndWait().ifPresent(b -> {
		
			if (b == btnSim){
				aux = 1;
			} else {
				aux = 0;
			}
        });
		
		if (aux == 1) {
			return true;
		}
		return false;
	}
	
}


