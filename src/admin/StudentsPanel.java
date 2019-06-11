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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentsPanel {
	private static Label studentLabel = new Label("Student Registration Details");
	private static Button btnAddNew = new Button("Add New");
	private static Button btnEdit = new Button("Edit");
	private static Button btnDelete = new Button("Delete");
	private static Button btnClear = new Button("Clear");
	private static Button btnSave = new Button("Save");
	static Label label_2 = new Label("Personal Information");
	private static TextField studentID = new TextField();
	private static TextField studentName = new TextField();
	private static TextField studentSurname = new TextField();
	private static TextField gender = new TextField();
	private static TextField phoneNumber = new TextField();
	private static TextField email = new TextField();
	private static PasswordField password = new PasswordField();
	private static TextField classRoomNumber = new TextField();
	private static TextField addressID = new TextField();
	private static TextField birthDate = new TextField();
	private static TextField age = new TextField();

	private static TableView studentsTable = new TableView();

	public static void createStage() {

		BorderPane pane = new BorderPane();
		Stage stage = new Stage();

		VBox vboxMain = new VBox();

		BorderPane root = new BorderPane();

		MenuBar menuBar = new MenuBar();

		Menu file = new Menu("File");

		MenuItem itmClose = new MenuItem("Close");

		Menu edit = new Menu("Edit");

		MenuItem itmCourse = new MenuItem("Course Panel");
		MenuItem itmTeacher = new MenuItem("Teacher Panel");
		itmTeacher.setOnAction(e -> {
			TeachersPanel.createStage();
		});

		Menu help = new Menu("Help");

		MenuItem itmAbout = new MenuItem("About");

		file.getItems().addAll(itmClose);
		edit.getItems().addAll(itmCourse, itmTeacher);
		help.getItems().addAll(itmAbout);

		menuBar.getMenus().addAll(file, edit, help);

		root.setTop(menuBar);

		TableColumn<String, StudentsTable> column1 = new TableColumn<>("ID");
		column1.setCellValueFactory(new PropertyValueFactory("studentID"));
		column1.setPrefWidth(60);

		TableColumn<String, StudentsTable> column2 = new TableColumn<>("Name");
		column2.setCellValueFactory(new PropertyValueFactory("studentName"));
		column2.setPrefWidth(150);

		TableColumn<String, StudentsTable> column3 = new TableColumn<>("Surname");
		column3.setCellValueFactory(new PropertyValueFactory("studentSurname"));
		column3.setPrefWidth(150);

		TableColumn<String, StudentsTable> column4 = new TableColumn<>("Gender");
		column4.setCellValueFactory(new PropertyValueFactory("gender"));
		column4.setPrefWidth(120);

		TableColumn<String, StudentsTable> column5 = new TableColumn<>("Phone");
		column5.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
		column5.setPrefWidth(120);

		TableColumn<String, StudentsTable> column6 = new TableColumn<>("Email");
		column6.setCellValueFactory(new PropertyValueFactory("email"));
		column6.setPrefWidth(120);

		TableColumn<String, StudentsTable> column7 = new TableColumn<>("Password");
		column7.setCellValueFactory(new PropertyValueFactory("password"));
		column7.setPrefWidth(120);

		TableColumn<String, StudentsTable> column8 = new TableColumn<>("Class");
		column8.setCellValueFactory(new PropertyValueFactory("classRoomNumber"));
		column8.setPrefWidth(120);

		TableColumn<String, StudentsTable> column9 = new TableColumn<>("Address ID");
		column9.setCellValueFactory(new PropertyValueFactory("addressID"));
		column9.setPrefWidth(120);

		TableColumn<String, StudentsTable> column10 = new TableColumn<>("Birthday");
		column10.setCellValueFactory(new PropertyValueFactory("birthDate"));
		column10.setPrefWidth(120);

		TableColumn<Integer, StudentsTable> column11 = new TableColumn<>("Age");
		column11.setCellValueFactory(new PropertyValueFactory("age"));
		column1.setPrefWidth(120);

		studentsTable.getColumns().add(column1);
		studentsTable.getColumns().add(column2);
		studentsTable.getColumns().add(column3);
		studentsTable.getColumns().add(column4);
		studentsTable.getColumns().add(column5);
		studentsTable.getColumns().add(column6);
		studentsTable.getColumns().add(column7);
		studentsTable.getColumns().add(column8);
		studentsTable.getColumns().add(column9);
		studentsTable.getColumns().add(column10);
		studentsTable.getColumns().add(column11);

		studentsTable.setRowFactory(tv -> {
			TableRow<StudentsTable> row = new TableRow<>();

			row.setOnMouseClicked(e -> {
				studentID.setText(row.getItem().getStudentID());
				studentName.setText(row.getItem().getStudentName());
				studentSurname.setText(row.getItem().getStudentSurname());
				gender.setText(String.valueOf(row.getItem().getGender()));
				email.setText(String.valueOf(row.getItem().getEmail()));
				phoneNumber.setText(String.valueOf(row.getItem().getPhoneNumber()));
				classRoomNumber.setText(String.valueOf(row.getItem().getClassRoomNumber()));
				addressID.setText(String.valueOf(row.getItem().getAddressID()));
				birthDate.setText(String.valueOf(row.getItem().getBirthDate()));
				age.setText(String.valueOf(row.getItem().getAge()));
				password.setText(row.getItem().getPassword());
				adminSetAllEnable();
				studentID.setDisable(true);
				pane.setOnKeyPressed(ev -> {
					if(ev.getCode() == KeyCode.D)
					{
						deleteStudents();
					}
				});

			});
			return row;
		});
//		studentsTable.setPrefWidth(500);
//		studentsTable.setPrefHeight(200);
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
		label_1.setStyle("-fx-text-fill:#4682B4;-fx-font-weight:bold;-fx-font-size:22;");
		label_1.setPadding(new Insets(2, 18, 1, 25));
		hbox.getChildren().addAll(btnAddNew, btnEdit, btnDelete);
		hbox.setPadding(new Insets(10, 10, 10, 27));
		hbox.setSpacing(20);
		vbox2.getChildren().add(hbox);
		vbox2.getChildren().add(label_1);

		Label label_2 = new Label("Personal Information");
		label_2.setStyle("-fx-text-fill:#800080;-fx-font-weight:bold;-fx-font-size:18;");
		label_2.setPadding(new Insets(4, 1, 1, 4));

		GridPane gridPane1 = new GridPane();
		gridPane1.addRow(0, new Label("ID"));
		gridPane1.addRow(0, studentID);
		gridPane1.addRow(1, new Label("First Name"));
		gridPane1.addRow(1, studentName);
		gridPane1.addRow(2, new Label("Last Name"));
		gridPane1.addRow(2, studentSurname);
		gridPane1.addRow(3, new Label("Gender"));
		gridPane1.addRow(3, gender);
		gridPane1.addRow(4, new Label("Phone Number"));
		gridPane1.addRow(4, phoneNumber);
		gridPane1.addRow(5, new Label("Email"));
		gridPane1.addRow(5, email);
		gridPane1.addRow(6, new Label("Password"));
		gridPane1.addRow(6, password);
		gridPane1.addRow(7, new Label("Class Room"));
		gridPane1.addRow(7, classRoomNumber);
		gridPane1.addRow(8, new Label("Address ID"));
		gridPane1.addRow(8, addressID);
		gridPane1.addRow(9, new Label("BirthDate"));
		gridPane1.addRow(9, birthDate);
		gridPane1.addRow(10, new Label("Age"));
		gridPane1.addRow(10, age);

		gridPane1.setPadding(new Insets(4, 12, 4, 22));

		VBox vbox3 = new VBox();

		vbox3.getChildren().add(label_2);
		vbox3.getChildren().add(gridPane1);

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

		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.A) {
				adminSetAllEnable();
			}
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
		vbox.getChildren().add(hbox5);

		vboxMain.getChildren().add(root);
		vboxMain.getChildren().add(vbox);

		adminSetAllDisable();
		HBox mainPane = new HBox(50);
		mainPane.getChildren().addAll(vboxMain, studentsTable);
		pane.setTop(menuBar);
		pane.setBottom(mainPane);
		Scene scene = new Scene(pane);

		stage.setTitle("Students Panel");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public static void showStudents() {
		List<StudentsTable> students = StudentsTable.getStudents();

		ObservableList<StudentsTable> studentsList = FXCollections.observableArrayList();

		for (int i = 0; i < students.size(); i++) {
			studentsList.add(students.get(i));
		}

		studentsTable.setItems(studentsList);
	}

	public static void insertStudents() {

		if (StudentsTable.addStudents(studentID.getText(), studentName.getText(), studentSurname.getText(),
				gender.getText(), phoneNumber.getText(), email.getText(), password.getText(), classRoomNumber.getText(),
				addressID.getText(), birthDate.getText(), Integer.parseInt(age.getText()))) {
			showStudents();
			clearForm();
		}
	}

	private static void deleteStudents() {
		if (StudentsTable.deleteStudents(studentID.getText())) {
			showStudents();
			clearForm();
		}
	};

	private static void updateStudents() {
		if (StudentsTable.updateStudents(studentID.getText(), studentName.getText(), studentSurname.getText(),
				gender.getText(), phoneNumber.getText(), email.getText(), password.getText(), classRoomNumber.getText(),
				addressID.getText(), birthDate.getText(), Integer.parseInt(age.getText()))) {
			showStudents();
			clearForm();
		}
	};

	public static void clearForm() {
		studentID.setText("");
		studentName.setText("");
		studentSurname.setText("");
		gender.setText("");
		phoneNumber.setText("");
		email.setText("");
		classRoomNumber.setText("");
		addressID.setText("");
		birthDate.setText("");
		age.setText("");
		password.setText("");
	}

	private static void adminSetAllEnable() {
		studentID.setDisable(false);
		studentName.setDisable(false);
		studentSurname.setDisable(false);
		gender.setDisable(false);
		phoneNumber.setDisable(false);
		email.setDisable(false);
		password.setDisable(false);
		classRoomNumber.setDisable(false);
		addressID.setDisable(false);
		birthDate.setDisable(false);
		age.setDisable(false);
	}

	private static void adminSetAllDisable() {
		studentID.setDisable(true);
		studentName.setDisable(true);
		studentSurname.setDisable(true);
		gender.setDisable(true);
		phoneNumber.setDisable(true);
		email.setDisable(true);
		password.setDisable(true);
		classRoomNumber.setDisable(true);
		addressID.setDisable(true);
		birthDate.setDisable(true);
		age.setDisable(true);

	}

}
