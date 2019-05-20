import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

public class Login extends Application
{
	private Connection dbConnection;
	private TextField username = new TextField();
	private PasswordField password = new PasswordField();
	private Button btnDergo = new Button("KYÇU");
	private Stage mainStage;
	private Scene scene2 = new Scene(new Label("Mirdita"));

	public void start(Stage primaryStage)
	{
		setDBConnection();
		
		mainStage = primaryStage;
		HBox hbox = new HBox(30);
		VBox vbox = new VBox(20);
		StackPane photoPane = new StackPane();
		
		ImageView schoolImage = new ImageView("images/school.jpg");
		ImageView logoImage = new ImageView("images/logo.png");
		logoImage.setFitHeight(300);
		logoImage.setFitWidth(250);
		photoPane.getChildren().add(schoolImage);
		
		StackPane logoPane = new StackPane();
		logoPane.getChildren().add(logoImage);
		
		GridPane loginPane = new GridPane();
		loginPane.addRow(0, new Label("Perdoruesi: "));
		loginPane.addRow(0, username);
		loginPane.addRow(1, new Label("Fjalekalimi: "));
		loginPane.addRow(1, password);
	}
}