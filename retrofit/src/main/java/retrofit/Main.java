package retrofit;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application{

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass()
				.getClassLoader()
				.getResource("retrofit/BuscaCep.fxml"));

		primaryStage.setTitle("Busca Cep");

		primaryStage.setScene(new Scene(root));

		primaryStage.show();

	}

}
