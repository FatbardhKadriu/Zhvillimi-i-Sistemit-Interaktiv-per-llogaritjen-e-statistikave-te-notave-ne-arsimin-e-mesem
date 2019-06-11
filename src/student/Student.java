package student;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Student extends Application{

	private static Label studentLabel = new Label("Your details:");
	
	@Override
	public  void start(Stage primaryStage)
	{
		//root node
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		
		Menu file = new Menu("File");
		
		MenuItem itmNew = new MenuItem("New");
		MenuItem itmSave = new MenuItem("Save");
		MenuItem itmClose = new MenuItem("Close");
		
		
		Menu edit = new Menu("Edit");
		
		MenuItem itmCut = new MenuItem("Cut");
		MenuItem itmCopy = new MenuItem("Copy");
		MenuItem itmPaste = new MenuItem("Paste");
		
		
		Menu help = new Menu("Help");
		
		
		Menu subSearch = new Menu("Search");
		
		MenuItem itmFind = new MenuItem("Find");
		MenuItem itmReplace = new MenuItem("Replace");
		
		HBox btnPane = new HBox(20);
		btnPane.setPadding(new Insets(10,10,10,10));
		btnPane.getChildren().addAll();
		StackPane stackBtn = new StackPane();
		
		stackBtn.getChildren().add(btnPane);
		
		file.getItems().addAll(itmNew , itmSave , itmClose);
		edit.getItems().addAll(itmCut, itmCopy, itmPaste);
		subSearch.getItems().addAll(itmFind, itmReplace);
		
		
		menuBar.getMenus().addAll(file,edit,help);
		edit.getItems().add(subSearch);
		
		

		
		root.setTop(menuBar);
		root.setCenter(btnPane);
		Scene scene = new Scene(root,600,600);

		primaryStage.setTitle("Students details");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}


		

}
