package retrofit;

import java.io.IOException;
import java.util.Objects;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class BuscaCepController {

	@FXML
	private TextField cepBusca;
	@FXML
	private Label cep;
	@FXML
	private Label logradouro;
	@FXML
	private Label bairro;
	@FXML
	private Label localidade;
	@FXML
	private Label uf;
	@FXML
	private Label error;


	public void OpenBuscaCep() throws IOException{

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(Objects.requireNonNull(BuscaCepController.class.getClassLoader().getResource("retrofit/BuscaCep.fxml")));

		primaryStage.setTitle("Minhas tarefas");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();

	}


	public void BuscaCep(Event BuscaCep){

		String cepp = cepBusca.getText();
		GetCep(cepp);

	}

	public void preencheTela(Cep cepp){

		cep.setText(cepp.getCep());
		logradouro.setText(cepp.getLogradouro());
		bairro.setText(cepp.getBairro());
		localidade.setText(cepp.getLocalidade());
		uf.setText(cepp.getUf());

	}

	public void GetCep(String cep){
		error.setText("");

		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("https://viacep.com.br/ws/")

			    .addConverterFactory(GsonConverterFactory.create())
			    .build();

			TesteApi api = retrofit.create(TesteApi.class);

			try {
				Call<Cep> call = api.getTime(cep);

				Response<Cep> r = call.execute();

				Cep t = r.body();

				preencheTela(t);


			}catch(Exception e) {
				Cep p = new Cep();
				preencheTela(p);
				error.setText("CEP INVÁLIDO!");
			}
	}


}
