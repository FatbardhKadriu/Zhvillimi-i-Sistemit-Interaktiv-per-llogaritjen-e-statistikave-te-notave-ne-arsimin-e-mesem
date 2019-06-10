package admin;

import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminPanel {
	private static Label studentLabel = new Label("Student Registration Details");
	private static Button btnAddNew = new Button("Add New");
	private static Button btnEdit = new Button("Edit");
	private static Button btnDelete = new Button("Delete");
	private static Button btnClear = new Button("Clear");
	private static Button btnSave = new Button("Save");
	static Label label_2 = new Label("Personal Information");
	private static TextField firstName = new TextField();
	private static TextField lastName = new TextField();
	private static TextField id = new TextField();
//    private static TextField department = new TextField();
//    private static TextField email = new TextField();
	private static TextField phone = new TextField();
//    private static TextField address = new TextField();
//    private static TextField dob = new TextField();

	private static TextField GuardianfirstName = new TextField();
	private static TextField GuardianlastName = new TextField();
	private static TextField Guardianemail = new TextField();
	private static TextField Guardianphone = new TextField();
	private static TableView studentsTable = new TableView();

	public static void createStage() {

		Stage stage = new Stage();

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

		menuBar.getMenus().addAll(file, edit, help);

		root.setTop(menuBar);

		TableColumn<Integer, AdminTable> column1 = new TableColumn<>("ID");
		column1.setCellValueFactory(new PropertyValueFactory("id"));
		column1.setPrefWidth(60);

		TableColumn<String, AdminTable> column2 = new TableColumn<>("Name");
		column2.setCellValueFactory(new PropertyValueFactory("name"));
		column2.setPrefWidth(150);

		TableColumn<String, AdminTable> column3 = new TableColumn<>("Surname");
		column3.setCellValueFactory(new PropertyValueFactory("surname"));
		column3.setPrefWidth(150);

		TableColumn<String, AdminTable> column4 = new TableColumn<>("Phone");
		column4.setCellValueFactory(new PropertyValueFactory("phone"));
		column4.setPrefWidth(120);

		studentsTable.getColumns().add(column1);
		studentsTable.getColumns().add(column2);
		studentsTable.getColumns().add(column3);
		studentsTable.getColumns().add(column4);

		studentsTable.setRowFactory(tv -> {
			TableRow<AdminTable> row = new TableRow<>();

			row.setOnMouseClicked(e -> {
				id.setText(String.valueOf(row.getItem().getId()));
				firstName.setText(row.getItem().getName());
				lastName.setText(row.getItem().getSurname());
				phone.setText(String.valueOf(row.getItem().getPhone()));
				adminSetAllEnable();
				id.setDisable(true);
			});

			return row;
		});
		studentsTable.setPrefWidth(500);
		studentsTable.setPrefHeight(200);
		showStudents();

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
		hbox.setPadding(new Insets(10, 10, 10, 27));
		hbox.setSpacing(20);
		vbox2.getChildren().add(hbox);
		vbox2.getChildren().add(label_1);

		Label label_2 = new Label("Personal Information");
		label_2.setStyle("-fx-text-fill:#800080;-fx-font-weight:bold;-fx-font-size:14;");
		label_2.setPadding(new Insets(4, 1, 1, 4));

		GridPane gridPane1 = new GridPane();
		gridPane1.addRow(0, new Label("ID"));
		gridPane1.addRow(0, id);
		gridPane1.addRow(1, new Label("First Name"));
		gridPane1.addRow(1, firstName);
		gridPane1.addRow(2, new Label("Last Name"));
		gridPane1.addRow(2, lastName);

//		gridPane1.addRow(3, new Label("Department"));
//		gridPane1.addRow(3, department);
//		gridPane1.addRow(4, new Label("Email"));
//		gridPane1.addRow(4, email);
		gridPane1.addRow(3, new Label("Phone"));
		gridPane1.addRow(3, phone);
//		gridPane1.addRow(6, new Label("Address"));
//		gridPane1.addRow(6, address);
//		gridPane1.addRow(7, new Label("DOB"));
//		gridPane1.addRow(7, dob);
//		
		gridPane1.setPadding(new Insets(4, 12, 4, 22));

		VBox vbox3 = new VBox();

		vbox3.getChildren().add(label_2);
		vbox3.getChildren().add(gridPane1);

		VBox vbox4 = new VBox();
		Label label_3 = new Label("Guardian Information");
		label_3.setStyle("-fx-text-fill:#800080;-fx-font-weight:bold;-fx-font-size:14;");
		label_3.setPadding(new Insets(4, 1, 1, 4));
		GridPane gridPane2 = new GridPane();
		gridPane2.addRow(0, new Label("First Name"));
		gridPane2.addRow(0, GuardianfirstName);
		gridPane2.addRow(1, new Label("Last Name"));
		gridPane2.addRow(1, GuardianlastName);
		gridPane2.addRow(2, new Label("Email"));
		gridPane2.addRow(2, Guardianemail);
		gridPane2.addRow(3, new Label("Phone"));
		gridPane2.addRow(3, Guardianphone);

		gridPane2.setPadding(new Insets(4, 12, 4, 22));

//		vbox4.getChildren().add(label_3);
//		vbox4.getChildren().add(gridPane2);
		btnSave.setOnAction(e -> {
			insertStudents();
		});

		btnClear.setOnAction(e -> {
			clearForm();
			adminSetAllDisable();
		});
		btnEdit.setOnAction(e -> {
			updateStudents();
		});
		btnDelete.setOnAction(e -> {
			deleteStudents();
		});
		btnAddNew.setOnAction(e -> {
			adminSetAllEnable();
		});
		HBox hbox5 = new HBox();

		hbox5.getChildren().addAll(btnClear, btnSave);

		btnClear.setStyle("-fx-background-color:red;-fx-text-fill:white;");
		btnSave.setStyle("-fx-background-color:green;-fx-text-fill:white;");

		hbox5.setAlignment(Pos.BASELINE_RIGHT);
		hbox5.setSpacing(20);
		hbox5.setPadding(new Insets(7, 17, 10, 1));

		vbox.getChildren().add(vbox2);
		vbox.getChildren().add(vbox3);
		vbox.getChildren().add(vbox4);
		vbox.getChildren().add(hbox5);

		vboxMain.getChildren().add(root);
		vboxMain.getChildren().add(vbox);

		adminSetAllDisable();
		HBox mainPane = new HBox(50);
		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(new Label("Ketu vjen tabela"));
		mainPane.getChildren().addAll(vboxMain, studentsTable);
		Scene scene = new Scene(mainPane);

		stage.setTitle("Admin Panel");
		stage.setScene(scene);
		stage.show();
	}

	public static void showStudents() {
		List<AdminTable> students = AdminTable.getStudents();

		ObservableList<AdminTable> studentsList = FXCollections.observableArrayList();

		for (int i = 0; i < students.size(); i++) {
			studentsList.add(students.get(i));
		}

		studentsTable.setItems(studentsList);
	}

	public static void insertStudents() {

		if (AdminTable.addStudents(Integer.parseInt(id.getText()), firstName.getText(), lastName.getText(),
				phone.getText())) {
			showStudents();
			clearForm();
		}
	}

	private static void deleteStudents() {
		if (AdminTable.deleteStudents(Integer.parseInt(id.getText()))) {
			showStudents();
			clearForm();
		}
	};

	private static void updateStudents() {
		if (AdminTable.updateStudents(Integer.parseInt(id.getText()), firstName.getText(), lastName.getText(),
				phone.getText())) {
			showStudents();
			clearForm();
		}
	};

	public static void clearForm() {
		id.setText("");
		firstName.setText("");
		lastName.setText("");
		phone.setText("");
	}

	private static void adminSetAllEnable() {
		id.setDisable(false);
		firstName.setDisable(false);
		lastName.setDisable(false);
		phone.setDisable(false);
		btnSave.setDisable(false);
		btnClear.setDisable(false);
	}

	private static void adminSetAllDisable() {
		id.setDisable(true);
		firstName.setDisable(true);
		lastName.setDisable(true);
		phone.setDisable(true);
		btnSave.setDisable(true);
		btnClear.setDisable(true);

	}

}
