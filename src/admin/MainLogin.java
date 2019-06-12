package admin;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainLogin {

	private TextField email = new TextField();
	private PasswordField password = new PasswordField();
	private Label ErrorResult = new Label();
	private Button btnLogin = new Button("Login");
	private Label title = new Label("Login as Administrator");
	private Stage mainStage;

	public void createStage() {
		Stage primaryStage = new Stage();
		VBox pane = new VBox(60);
		mainStage = primaryStage;
		GridPane loginPane = new GridPane();
		loginPane.addRow(0, new Label("Email"), email);
		loginPane.addRow(1, new Label("Password"), password);
		loginPane.add(btnLogin, 1, 3);
		loginPane.add(ErrorResult, 1, 4);
		loginPane.setHgap(35);
		loginPane.setVgap(10);
		loginPane.setHalignment(btnLogin, HPos.RIGHT);
		loginPane.setAlignment(Pos.CENTER);
		btnLogin.setOnAction(e -> {
			loginAdmin();
		});
		pane.getChildren().addAll(title, loginPane);
		title.getStyleClass().add("title");
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 500, 330);
		primaryStage.setScene(scene);
		primaryStage.show();
		ErrorResult.getStyleClass().add("error");
		btnLogin.getStyleClass().add("button-blue");
		scene.getStylesheets().add("style.css");

		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.ENTER) {
				loginAdmin();
			}
		});
	}

	public void loginAdmin() {
		String query = "Select * from Administrator where email = ? AND password = ?";
		try {

			PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
			preparedStatement.setString(1, email.getText());
			preparedStatement.setString(2, password.getText());

			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Logged in");
				alert.setHeaderText(null);
				alert.setContentText("You are log in!");

				alert.showAndWait();

//				mainStage.show();
				mainStage.hide();
				new StudentsPanel().createStage();

//				System.exit(1);
			} else {
				ErrorResult.setText("Email or Password Incorrect");
			}

		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Database problem!");
			alert.setHeaderText(null);
			alert.setContentText("Cannot connect to database!");

			alert.showAndWait();

			System.exit(1);
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
