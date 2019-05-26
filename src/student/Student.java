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

	private TextField firstName = new TextField();
	private TextField lastName = new TextField();
	private TextField id = new TextField();
	private TextField email = new TextField();
	private TextField password = new TextField();
	private TextField address = new TextField();
	private TextField phone = new TextField();
	
	private Button btnEdit = new Button("Edit profile");
	private Button btnView = new Button("View");
	private Button btnCancel = new Button("Cancel");
	private Button btnSave = new Button("Save");
	private Label profInfo = new Label("Profile information : ");
	
	
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
		btnPane.getChildren().addAll(btnEdit,btnView);
		StackPane stackBtn = new StackPane();
		
		stackBtn.getChildren().add(btnPane);
		
		file.getItems().addAll(itmNew , itmSave , itmClose);
		edit.getItems().addAll(itmCut, itmCopy, itmPaste);
		subSearch.getItems().addAll(itmFind, itmReplace);
		
		
		menuBar.getMenus().addAll(file,edit,help);
		edit.getItems().add(subSearch);
		
		
		
		
		
		GridPane ProfilePane = new GridPane();
		
		
		ProfilePane.addRow(0,new Label("First Name : "));
		ProfilePane.addRow(0, firstName);
		ProfilePane.addRow(1,new Label("Last Name : "));
		ProfilePane.addRow(1, lastName);
		ProfilePane.addRow(2,new Label(" ID : "));
		ProfilePane.addRow(2, id);
		ProfilePane.addRow(3,new Label(" Email : "));
		ProfilePane.addRow(3, email);
		ProfilePane.addRow(4,new Label("Password : "));
		ProfilePane.addRow(4, password);
		ProfilePane.addRow(5,new Label(" Address : "));
		ProfilePane.addRow(5, address);
		ProfilePane.addRow(6,new Label("Phone : "));
		ProfilePane.addRow(6, phone);
		ProfilePane.setPadding(new Insets(10,10,10,20));
		
		VBox pane1 = new VBox(20);
		profInfo.setStyle("-fx-text-fill: blue;");
		pane1.getChildren().addAll(profInfo, ProfilePane);
		HBox btn2Pane = new HBox(20);
		
		VBox main = new VBox(30);
		main.getChildren().addAll(stackBtn,pane1);
		btn2Pane.getChildren().addAll(btnCancel,btnSave);
		ProfilePane.add(btn2Pane, 1, 7);


		ProfilePane.setVgap(15);
		ProfilePane.setHgap(15);
		
		
		root.setTop(menuBar);
		root.setCenter(main);
		Scene scene = new Scene(root,600,600);

		primaryStage.setTitle("Student");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}


		

}
