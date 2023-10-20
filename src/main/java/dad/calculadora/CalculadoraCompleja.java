package dad.calculadora;

import javafx.application.Application;
import javafx.beans.binding.DoubleBinding;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class CalculadoraCompleja extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TextField realText1 = new TextField("0");
		realText1.setPrefSize(50, 20);
		
		TextField imaginarioText1 = new TextField("0");
		imaginarioText1.setPrefSize(50, 20);

		
		TextField realText2 = new TextField("0");
		realText2.setPrefSize(50, 20);

		
		TextField imaginarioText2 = new TextField("0");
		imaginarioText2.setPrefSize(50, 20);

		
		TextField resultText = new TextField("0");
		resultText.setPrefSize(50, 20);

		
		TextField rImaText = new TextField("0");
		rImaText.setPrefSize(50, 20);


		ComboBox<String> operadorCombo = new ComboBox<>();
		operadorCombo.getItems().addAll("+", "-", "*", "/");
		
		Separator separador = new Separator();
		
		HBox barraHBox1 = new HBox(5, realText1, new Label("+"), imaginarioText1, new Label("i"));
		HBox barraHBox2 = new HBox(5, realText2, new Label("+"), imaginarioText2, new Label("i"));
		HBox barraHBox3 = new HBox(5, resultText, new Label("+"), rImaText, new Label("i"));
		
		VBox contenedorVBox = new VBox(5, barraHBox1, barraHBox2, separador, barraHBox3);
		contenedorVBox.setPadding(new Insets(40, 10, 10, 10));

		contenedorVBox.setAlignment(Pos.CENTER);
		
		VBox comboVBox = new VBox(operadorCombo);
		comboVBox.setAlignment(Pos.CENTER);
		
		HBox root = new HBox(5, comboVBox, contenedorVBox);
		root.setAlignment(Pos.CENTER);
				
		Scene scene = new Scene(root, 500, 350);
		
		primaryStage.setTitle("CalculadoraView.fxml");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		Complejo complejo1 = new Complejo();
		Complejo complejo2 = new Complejo();
		Complejo resultado = new  Complejo();
		
		realText1.textProperty().bindBidirectional(complejo1.realProperty(), new NumberStringConverter());
		imaginarioText1.textProperty().bindBidirectional(complejo1.imaginarioProperty(), new NumberStringConverter());
		realText2.textProperty().bindBidirectional(complejo2.realProperty(), new NumberStringConverter());
		imaginarioText2.textProperty().bindBidirectional(complejo2.imaginarioProperty(), new NumberStringConverter());

		resultText.textProperty().bindBidirectional(resultado.realProperty(), new NumberStringConverter());
		rImaText.textProperty().bindBidirectional(resultado.imaginarioProperty(), new NumberStringConverter());

		operadorCombo.getSelectionModel().selectedItemProperty().addListener((o, ov, nv) -> {
			if(nv == "+") {
				resultado.realProperty().bind(complejo1.realProperty().add(complejo2.realProperty()));
				resultado.imaginarioProperty().bind(complejo1.imaginarioProperty().add(complejo2.imaginarioProperty()));
			}else if(nv == "-") {
				resultado.realProperty().bind(complejo1.realProperty().subtract(complejo2.realProperty()));
				resultado.imaginarioProperty().bind(complejo1.imaginarioProperty().subtract(complejo2.imaginarioProperty()));
			}else if(nv == "*") {
				resultado.realProperty().bind((complejo1.realProperty().multiply(complejo2.realProperty())).subtract((complejo1.imaginarioProperty()).multiply(complejo2.imaginarioProperty())));
				resultado.imaginarioProperty().bind((complejo1.realProperty().multiply(complejo2.imaginarioProperty())).add((complejo1.imaginarioProperty()).multiply(complejo2.realProperty())));
			}else {
				DoubleBinding denominador = complejo2.realProperty().multiply(complejo2.realProperty())
						.add(complejo2.imaginarioProperty()).multiply(complejo2.imaginarioProperty());

				resultado.realProperty().bind((complejo1.realProperty().multiply(complejo2.realProperty())
						.add(complejo1.imaginarioProperty()).multiply(complejo2.imaginarioProperty())).divide(denominador));
				
				resultado.imaginarioProperty().bind((complejo1.imaginarioProperty().multiply(complejo2.realProperty())
						.subtract(complejo1.realProperty()).multiply(complejo2.imaginarioProperty())).divide(denominador));
			}
				
		});
		
	}
}
