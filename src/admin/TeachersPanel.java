package admin;

import java.util.List;

import Help.About;
import Help.AdminHelp;
import database.Hash;
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

public class TeachersPanel {
	private Label teachersLabel = new Label("Teachers Registration Details");
	private Button btnAddNew = new Button("Add New");
	private Button btnEdit = new Button("Edit");
	private Button btnDelete = new Button("Delete");
	private Button btnClear = new Button("Clear");
	private Button btnSave = new Button("Save");
	static Label label_2 = new Label("Personal Information");

	private TextField teacherID = new TextField();
	private TextField teacherName = new TextField();
	private TextField teacherSurname = new TextField();
	private TextField phoneNumber = new TextField();
	private TextField email = new TextField();
	private PasswordField password = new PasswordField();
	private TextField addressID = new TextField();
	private TextField subjectID = new TextField();
	private TableView teachersTable = new TableView();

	public void createStage() {

		Stage stage = new Stage();

		BorderPane pane = new BorderPane();
		VBox vboxMain = new VBox();

		BorderPane root = new BorderPane();

		MenuBar menuBar = new MenuBar();

		Menu file = new Menu("File");

		MenuItem itmClose = new MenuItem("Close");
		itmClose.setOnAction(e -> {
			stage.hide();
		});

		Menu edit = new Menu("Edit");

		MenuItem itmStudents = new MenuItem("Students Panel");
		itmStudents.setOnAction(e -> {
			new StudentsPanel().createStage();
		});

		Menu help = new Menu("Help");

		MenuItem itmAbout = new MenuItem("About");
		MenuItem itmHelp = new MenuItem("Help");
		itmHelp.setOnAction(e -> {
			AdminHelp.about();

		});

		itmAbout.setOnAction(e -> {
			About.about();

		});
		pane.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.F1) {
				AdminHelp.about();

			}
			if (e.isAltDown() && e.getCode() == KeyCode.F4) {
				stage.hide();
			}
		});

		file.getItems().addAll(itmClose);
		edit.getItems().addAll(itmStudents);
		help.getItems().addAll(itmAbout);
		help.getItems().addAll(itmHelp);

		menuBar.getMenus().addAll(file, edit, help);

		root.setTop(menuBar);

		TableColumn<String, TeachersTable> column1 = new TableColumn<>("ID");
		column1.setCellValueFactory(new PropertyValueFactory("teacherID"));
		column1.setPrefWidth(60);

		TableColumn<String, TeachersTable> column2 = new TableColumn<>("Name");
		column2.setCellValueFactory(new PropertyValueFactory("teacherName"));
		column2.setPrefWidth(150);

		TableColumn<String, TeachersTable> column3 = new TableColumn<>("Surname");
		column3.setCellValueFactory(new PropertyValueFactory("teacherSurname"));
		column3.setPrefWidth(150);

		TableColumn<String, TeachersTable> column4 = new TableColumn<>("Phone No");
		column4.setCellValueFactory(new PropertyValueFactory("phoneNumber"));
		column4.setPrefWidth(120);

		TableColumn<String, TeachersTable> column5 = new TableColumn<>("Email");
		column5.setCellValueFactory(new PropertyValueFactory("email"));
		column5.setPrefWidth(120);

		TableColumn<String, TeachersTable> column6 = new TableColumn<>("Password");
		column6.setCellValueFactory(new PropertyValueFactory("password"));
		column6.setPrefWidth(120);

		TableColumn<String, TeachersTable> column7 = new TableColumn<>("Address ID");
		column7.setCellValueFactory(new PropertyValueFactory("addressID"));
		column7.setPrefWidth(120);

		TableColumn<String, TeachersTable> column8 = new TableColumn<>("Subject ID");
		column8.setCellValueFactory(new PropertyValueFactory("subjectID"));
		column8.setPrefWidth(120);

		teachersTable.getColumns().add(column1);
		teachersTable.getColumns().add(column2);
		teachersTable.getColumns().add(column3);
		teachersTable.getColumns().add(column4);
		teachersTable.getColumns().add(column5);
		teachersTable.getColumns().add(column6);
		teachersTable.getColumns().add(column7);
		teachersTable.getColumns().add(column8);

		teachersTable.setRowFactory(tv -> {
			TableRow<TeachersTable> row = new TableRow<>();

			row.setOnMouseClicked(e -> {
				teacherID.setText(row.getItem().getTeacherID());
				teacherName.setText(row.getItem().getTeacherName());
				teacherSurname.setText(row.getItem().getTeacherSurname());
				phoneNumber.setText(String.valueOf(row.getItem().getPhoneNumber()));
				email.setText(String.valueOf(row.getItem().getEmail()));
				password.setText(String.valueOf(row.getItem().getPassword()));
				addressID.setText(String.valueOf(row.getItem().getAddressID()));
				subjectID.setText(String.valueOf(row.getItem().getSubjectID()));
				adminSetAllEnable();
				teacherID.setDisable(true);
				pane.setOnKeyPressed(ev -> {
					if (ev.isControlDown() && ev.getCode() == KeyCode.D) {
						deleteTeachers();
					}
				});

			});
			return row;
		});
//		studentsTable.setPrefWidth(500);
//		studentsTable.setPrefHeight(200);
		showTeachers();

		VBox vbox = new VBox();

		HBox hbox = new HBox();
		Button btnAddNew = new Button("AddNew");
		btnAddNew.setStyle("-fx-background-color:green;-fx-text-fill:white;");
		Button btnEdit = new Button("Edit");
		btnEdit.setStyle("-fx-background-color:green;-fx-text-fill:white;");
		Button btnDelete = new Button("Delete");
		btnDelete.setStyle("-fx-background-color:red;-fx-text-fill:white;");
		VBox vbox2 = new VBox();
		Label label_1 = new Label("Teachers Details");
		label_1.setStyle("-fx-font-weight:bold;-fx-font-size:25;");
		label_1.setPadding(new Insets(2, 18, 1, 25));
		hbox.getChildren().addAll(btnAddNew, btnEdit, btnDelete);
		hbox.setPadding(new Insets(10, 10, 10, 27));
		hbox.setSpacing(20);
		vbox2.getChildren().add(hbox);
		vbox2.getChildren().add(label_1);

		Label label_2 = new Label("Teacher Information");
		label_2.setStyle("-fx-font-weight:bold;-fx-font-size:22;");
		label_2.setPadding(new Insets(4, 1, 1, 4));

		GridPane gridPane1 = new GridPane();
		gridPane1.addRow(0, new Label("ID"));
		gridPane1.addRow(0, teacherID);
		gridPane1.addRow(1, new Label("First Name"));
		gridPane1.addRow(1, teacherName);
		gridPane1.addRow(2, new Label("Last Name"));
		gridPane1.addRow(2, teacherSurname);
		gridPane1.addRow(3, new Label("Phone Number"));
		gridPane1.addRow(3, phoneNumber);
		gridPane1.addRow(4, new Label("Email"));
		gridPane1.addRow(4, email);
		gridPane1.addRow(5, new Label("Password"));
		gridPane1.addRow(5, password);
		gridPane1.addRow(6, new Label("Address ID"));
		gridPane1.addRow(6, addressID);
		gridPane1.addRow(7, new Label("Subject ID"));
		gridPane1.addRow(7, subjectID);

		gridPane1.setPadding(new Insets(4, 12, 4, 22));

		gridPane1.setVgap(10);
		gridPane1.setHgap(15);

		VBox vbox3 = new VBox();

		vbox3.getChildren().add(label_2);
		vbox3.getChildren().add(gridPane1);

		btnSave.setOnAction(e -> {
			insertTeachers();
		});

		btnClear.setOnAction(e -> {
			clearForm();
			adminSetAllDisable();
		});
		btnEdit.setOnAction(e -> {
			updateTeachers();
		});
		btnDelete.setOnAction(e -> {
			deleteTeachers();
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
		vbox.getChildren().add(hbox5);

		vboxMain.getChildren().add(root);
		vboxMain.getChildren().add(vbox);

		adminSetAllDisable();
		HBox mainPane = new HBox(50);
		mainPane.getChildren().addAll(vboxMain, teachersTable);
		pane.setTop(menuBar);
		pane.setBottom(mainPane);
		Scene scene = new Scene(pane);

		stage.setTitle("Teachers Panel");
		stage.setScene(scene);
		stage.show();
	}

	public void showTeachers() {
		List<TeachersTable> teachers = TeachersTable.getTeachers();

		ObservableList<TeachersTable> teachersList = FXCollections.observableArrayList();

		for (int i = 0; i < teachers.size(); i++) {
			teachersList.add(teachers.get(i));
		}

		teachersTable.setItems(teachersList);
	}

	public void insertTeachers() {

		if (TeachersTable.addTeachers(teacherID.getText(), teacherName.getText(), teacherSurname.getText(),
				phoneNumber.getText(), email.getText(), password.getText(), addressID.getText(), subjectID.getText())) {
			showTeachers();
			clearForm();
		}
	}

	private void deleteTeachers() {
		if (TeachersTable.deleteTeachers(teacherID.getText())) {
			showTeachers();
			clearForm();
		}
	};

	private void updateTeachers() {
		if (TeachersTable.updateTeachers(teacherID.getText(), teacherName.getText(), teacherSurname.getText(),
				phoneNumber.getText(), email.getText(), password.getText(), addressID.getText(), subjectID.getText())) {
			showTeachers();
			clearForm();
		}
	};

	public void clearForm() {
		teacherID.setText("");
		teacherName.setText("");
		teacherSurname.setText("");
		phoneNumber.setText("");
		email.setText("");
		password.setText("");
		addressID.setText("");
		subjectID.setText("");
	}

	private void adminSetAllEnable() {
		teacherID.setDisable(false);
		teacherName.setDisable(false);
		teacherSurname.setDisable(false);
		phoneNumber.setDisable(false);
		email.setDisable(false);
		password.setDisable(false);
		addressID.setDisable(false);
		subjectID.setDisable(false);

	}

	private void adminSetAllDisable() {
		teacherID.setDisable(true);
		teacherName.setDisable(true);
		teacherSurname.setDisable(true);
		phoneNumber.setDisable(true);
		email.setDisable(true);
		password.setDisable(true);
		addressID.setDisable(true);
		subjectID.setDisable(true);
	}

}
