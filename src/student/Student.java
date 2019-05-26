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
		

}
