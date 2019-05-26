package admin;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;



public class FirstVBox extends Application{
	
    private Label studentLabel = new Label("Student Registration Details");
    private Button btnAddNew = new Button("Add New");
    private Button btnEdit = new Button("Edit");
    private Button btnDelete = new Button("Delete");
    private Button btnClear = new Button("Clear");
    private Button btnSave = new Button("Save");
	Label label_2 = new Label("Personal Information");
	private TextField firstName = new TextField();
    private TextField lastName = new TextField();
    private TextField id = new TextField();
    private TextField department = new TextField();
    private TextField email = new TextField();
    private TextField phone = new TextField();
    private TextField address = new TextField();
    private TextField dob = new TextField();
    
	private TextField GuardianfirstName = new TextField();
    private TextField GuardianlastName = new TextField();
    private TextField Guardianemail = new TextField();
    private TextField Guardianphone = new TextField();
	
	@Override
	public void start(Stage primaryStage)
	{
		VBox vboxMain = new VBox();
		
		BorderPane root = new BorderPane();
		
		MenuBar menuBar = new MenuBar();
		
		Menu file = new Menu("File");
		
		MenuItem itmClose = new MenuItem("Close");
		
		Menu edit = new Menu("Edit");
		
		MenuItem itmCourse = new MenuItem("Course Panel");
		MenuItem itmTeacher = new MenuItem("Teacher Panel");
		
		Menu help = new Menu("Help");
		
		MenuItem itmAbout = new MenuItem("About");
		
		file.getItems().addAll(itmClose);
		edit.getItems().addAll(itmCourse, itmTeacher);
		help.getItems().addAll(itmAbout);
		
		menuBar.getMenus().addAll(file,edit,help);
		
		root.setTop(menuBar);

		
		
		VBox vbox = new VBox();
		
		HBox hbox = new HBox();
		Button btnAddNew = new Button("AddNew");
		btnAddNew.setStyle("-fx-background-color:green;-fx-text-fill:white;");
		Button btnEdit = new Button("Edit");
		btnEdit.setStyle("-fx-background-color:green;-fx-text-fill:white;");
		Button btnDelete = new Button("Delete");
		btnDelete.setStyle("-fx-background-color:red;-fx-text-fill:white;");
		VBox vbox2 = new VBox();
		Label label_1 = new Label("Student Registration Details");
		label_1.setStyle("-fx-text-fill:#4682B4;-fx-font-weight:bold;-fx-font-size:14;");
		label_1.setPadding(new Insets(2, 18, 1, 25));
		hbox.getChildren().addAll(btnAddNew, btnEdit, btnDelete);
		hbox.setPadding(new Insets(10, 10 ,10 ,27));
		hbox.setSpacing(20);
		vbox2.getChildren().add(hbox);
		vbox2.getChildren().add(label_1);
		


		Label label_2 = new Label("Personal Information");
		label_2.setStyle("-fx-text-fill:#800080;-fx-font-weight:bold;-fx-font-size:14;");
		label_2.setPadding(new Insets(4,1,1,4));
		
		GridPane gridPane1 = new GridPane();
		gridPane1.addRow(0,new Label("First Name"));
		gridPane1.addRow(0, firstName);
		gridPane1.addRow(1, new Label("Last Name"));
		gridPane1.addRow(1, lastName);
		gridPane1.addRow(2, new Label("ID"));
		gridPane1.addRow(2, id);
		gridPane1.addRow(3, new Label("Department"));
		gridPane1.addRow(3, department);
		gridPane1.addRow(4, new Label("Email"));
		gridPane1.addRow(4, email);
		gridPane1.addRow(5, new Label("Phone"));
		gridPane1.addRow(5, phone);
		gridPane1.addRow(6, new Label("Address"));
		gridPane1.addRow(6, address);
		gridPane1.addRow(7, new Label("DOB"));
		gridPane1.addRow(7, dob);
		
		gridPane1.setPadding(new Insets(4,12,4,22));
		
		VBox vbox3 = new VBox();
		
		vbox3.getChildren().add(label_2);
		vbox3.getChildren().add(gridPane1);
		
		VBox vbox4 = new VBox();
		Label label_3 = new Label("Guardian Information");
		label_3.setStyle("-fx-text-fill:#800080;-fx-font-weight:bold;-fx-font-size:14;");
		label_3.setPadding(new Insets(4,1,1,4));
		GridPane gridPane2 = new GridPane();
		gridPane2.addRow(0,new Label("First Name"));
		gridPane2.addRow(0, GuardianfirstName);
		gridPane2.addRow(1,new Label("Last Name"));
		gridPane2.addRow(1, GuardianlastName);
		gridPane2.addRow(2,new Label("Email"));
		gridPane2.addRow(2, Guardianemail);
		gridPane2.addRow(3,new Label("Phone"));
		gridPane2.addRow(3, Guardianphone);
		
		gridPane2.setPadding(new Insets(4,12,4,22));

		vbox4.getChildren().add(label_3);
		vbox4.getChildren().add(gridPane2);
		

		HBox hbox5 = new HBox();
		Button btnClear = new Button("Clear");
		Button btnSace = new Button("Save");
		hbox5.getChildren().addAll(btnClear, btnSave);
		
		btnClear.setStyle("-fx-background-color:red;-fx-text-fill:white;");
		btnSave.setStyle("-fx-background-color:green;-fx-text-fill:white;");
		
		hbox5.setAlignment(Pos.BASELINE_RIGHT);
		hbox5.setSpacing(20);
		hbox5.setPadding(new Insets(7,17,10,1));
		
		vbox.getChildren().add(vbox2);
		vbox.getChildren().add(vbox3);
		vbox.getChildren().add(vbox4);
		vbox.getChildren().add(hbox5);		
		
		

		vboxMain.getChildren().add(root);
		vboxMain.getChildren().add(vbox);


		
		Scene scene = new Scene(vboxMain);
		primaryStage.setTitle("Admin Panel");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			launch(args);
	}

}
