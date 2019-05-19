package p1;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class llogaritKredine extends Application
{
	private TextField tfShkallaEinteresitVjetor = new TextField();
	private TextField tfNumriIviteve = new TextField();
	private TextField tfShumaKredise = new TextField();
	private TextField tfPagesaMujore = new TextField();
	private TextField tfPagesaTotale = new TextField();
	private Button btnKalkulo = new Button("Kalkulo");

	@Override
	public void start(Stage primaryStage)
	{

		GridPane pane = new GridPane();
		pane.setStyle("-fx-background-color:#006666");
		pane.setPadding(new Insets(15, 15, 15, 15));
		pane.setHgap(7);
		pane.setVgap(7);
		Label l1 = new Label("Shkalla e interesit vjetor: ");
		Label l2 = new Label("Numri i viteve: ");
		Label l3 = new Label("Shuma e kredise: ");
		Label l4 = new Label("Pagesa mujore: ");
		Label l5 = new Label("Pagesa totale: ");
		l1.setFont(new Font(20));
		l1.setTextFill(Color.WHITE);
		l2.setFont(new Font(20));
		l3.setFont(new Font(20));
		l4.setFont(new Font(20));
		l5.setFont(new Font(20));
		pane.add(l1, 0, 0);
		pane.add(tfShkallaEinteresitVjetor, 1, 0);
		pane.add(l2, 0, 1);
		pane.add(tfNumriIviteve, 1, 1);
		pane.add(l3, 0, 2);
		pane.add(tfShumaKredise, 1, 2);
		pane.add(l4, 0, 3);
		pane.add(tfPagesaMujore, 1, 3);
		pane.add(l5, 0, 4);
		pane.add(tfPagesaTotale, 1, 4);
		pane.add(btnKalkulo, 1, 5);
		pane.setAlignment(Pos.CENTER);
		tfShkallaEinteresitVjetor.setAlignment(Pos.BOTTOM_RIGHT);
		tfNumriIviteve.setAlignment(Pos.BOTTOM_RIGHT);
		tfShumaKredise.setAlignment(Pos.BOTTOM_RIGHT);
		tfPagesaMujore.setAlignment(Pos.BOTTOM_RIGHT);
		tfPagesaTotale.setAlignment(Pos.BOTTOM_RIGHT);
		tfPagesaMujore.setEditable(false);
		tfPagesaTotale.setEditable(false);
		btnKalkulo.setOnAction(e -> {
			kalkuloPagesenEkredise();
		});
		pane.setHalignment(btnKalkulo, HPos.RIGHT);
		Scene scene = new Scene(pane, 450, 250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Kalkulimi i kredise");
		primaryStage.show();
	}

	private void kalkuloPagesenEkredise()
	{
		Double interesi = Double.parseDouble(tfShkallaEinteresitVjetor.getText());
		int vitet = Integer.parseInt(tfNumriIviteve.getText());
		Double shumaKredise = Double.parseDouble(tfShumaKredise.getText());
		Kredia kredi = new Kredia(interesi, vitet, shumaKredise);
		tfPagesaMujore.setText(String.format("%.2f", kredi.getPagesaMujore()));
		tfPagesaTotale.setText(String.format("%.2f", kredi.getPagesaTotale()));
	}

	public static void main(String[] args)
	{
		Application.launch(args);
	}
}