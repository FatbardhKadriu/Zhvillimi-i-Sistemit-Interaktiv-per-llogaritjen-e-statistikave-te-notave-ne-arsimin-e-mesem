package teacher;

import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
	// Text fields
	private TextField periodIDTxt = new TextField();
	private TextField studentIDTxt = new TextField();
	private TextField subjectIDTxt = new TextField();
	private TextField commitmentTxt = new TextField();
	private TextField tasksTxt = new TextField();
	private TextField essayTxt = new TextField();
	private TextField debatesTxt = new TextField();
	private TextField projectsTxt = new TextField();
	private TextField testsTxt = new TextField();
	private TextField quizzessTxt = new TextField();
	private TextField portfolioTxt = new TextField();
	private TextField markPart1Txt = new TextField();
	private TextField finalTestTxt = new TextField();
	private TextField markPart2Txt = new TextField();
	private TextField finalPeriodMarkTxt = new TextField();

	// Buttons
	private Button insertBtn = new Button("Insert");
	private Button updateBtn = new Button("Update");
	private Button deleteBtn = new Button("Delete");
	private Button clearBtn = new Button("Clear");

	// Table views
	private TableView gradesTable = new TableView();

	@Override
	public void start(Stage primaryStage)
	{
		// Form pane
		GridPane formPane = new GridPane();

		formPane.addRow(0, new Label("PeriodID: "), periodIDTxt);
		formPane.addRow(1, new Label("StudentID: "), studentIDTxt);
		formPane.addRow(2, new Label("SubjectID: "), subjectIDTxt);
		formPane.addRow(3, new Label("Commitment: "), commitmentTxt);
		formPane.addRow(4, new Label("Tasks: "), tasksTxt);
		formPane.addRow(5, new Label("Essay: "), essayTxt);
		formPane.addRow(6, new Label("Debates: "), debatesTxt);
		formPane.addRow(7, new Label("Projects: "), projectsTxt);
		formPane.addRow(8, new Label("Tests: "), testsTxt);
		formPane.addRow(9, new Label("Quizzess: "), quizzessTxt);
		formPane.addRow(10, new Label("Portfolio: "), portfolioTxt);
		formPane.addRow(11, new Label("MarkPart1: "), markPart1Txt);
		formPane.addRow(12, new Label("FinalTest: "), finalTestTxt);
		formPane.addRow(13, new Label("MarkPart2: "), markPart2Txt);
		formPane.addRow(14, new Label("FinalPeriodMark: "), finalPeriodMarkTxt);

		formPane.setHgap(10);
		formPane.setVgap(10);

//		markPart1Txt.setDisable(true);
//		markPart2Txt.setDisable(true);
//		finalPeriodMarkTxt.setDisable(true);

		// Buttons pane
		HBox buttonsPane = new HBox(10);

		buttonsPane.getChildren().addAll(insertBtn, updateBtn, deleteBtn, clearBtn);

		insertBtn.setOnAction(e -> {
			insertGrade();
		});

		clearBtn.setOnAction(e -> {
			clearForm();
		});

		deleteBtn.setOnAction(e -> {
			deleteGrade();
		});

		updateBtn.setOnAction(e -> {
			updateGrade();
		});

		// Left Pane

		VBox leftPane = new VBox(50);

		leftPane.getChildren().addAll(formPane, buttonsPane);

		// Grades table

		TableColumn<String, Grades> column1 = new TableColumn<>("periodID");
		column1.setCellValueFactory(new PropertyValueFactory("periodID"));
		column1.setPrefWidth(80);

		TableColumn<String, Grades> column2 = new TableColumn<>("studentID");
		column2.setCellValueFactory(new PropertyValueFactory("studentID"));
		column2.setPrefWidth(120);

		TableColumn<String, Grades> column3 = new TableColumn<>("subjectID");
		column3.setCellValueFactory(new PropertyValueFactory("subjectID"));
		column3.setPrefWidth(80);

		TableColumn<String, Grades> column4 = new TableColumn<>("commitment");
		column4.setCellValueFactory(new PropertyValueFactory("commitment"));
		column4.setPrefWidth(120);

		TableColumn<String, Grades> column5 = new TableColumn<>("tasks");
		column5.setCellValueFactory(new PropertyValueFactory("tasks"));
		column5.setPrefWidth(60);

		TableColumn<String, Grades> column6 = new TableColumn<>("essay");
		column6.setCellValueFactory(new PropertyValueFactory("essay"));
		column6.setPrefWidth(60);

		TableColumn<String, Grades> column7 = new TableColumn<>("debates");
		column7.setCellValueFactory(new PropertyValueFactory("debates"));
		column7.setPrefWidth(80);

		TableColumn<String, Grades> column8 = new TableColumn<>("projects");
		column8.setCellValueFactory(new PropertyValueFactory("projects"));
		column8.setPrefWidth(80);

		TableColumn<String, Grades> column9 = new TableColumn<>("tests");
		column9.setCellValueFactory(new PropertyValueFactory("tests"));
		column9.setPrefWidth(60);

		TableColumn<String, Grades> column10 = new TableColumn<>("quizzess");
		column10.setCellValueFactory(new PropertyValueFactory("quizzess"));
		column10.setPrefWidth(80);

		TableColumn<String, Grades> column11 = new TableColumn<>("portfolio");
		column11.setCellValueFactory(new PropertyValueFactory("portfolio"));
		column11.setPrefWidth(100);

		TableColumn<String, Grades> column12 = new TableColumn<>("markPart1");
		column12.setCellValueFactory(new PropertyValueFactory("markPart1"));
		column12.setPrefWidth(100);

		TableColumn<String, Grades> column13 = new TableColumn<>("finalTest");
		column13.setCellValueFactory(new PropertyValueFactory("finalTest"));
		column13.setPrefWidth(100);

		TableColumn<String, Grades> column14 = new TableColumn<>("markPart2");
		column14.setCellValueFactory(new PropertyValueFactory("markPart2"));
		column14.setPrefWidth(100);

		TableColumn<String, Grades> column15 = new TableColumn<>("finalPeriodMark");
		column15.setCellValueFactory(new PropertyValueFactory("finalPeriodMark"));
		column15.setPrefWidth(140);

		gradesTable.getColumns().add(column1);
		gradesTable.getColumns().add(column2);
		gradesTable.getColumns().add(column3);
		gradesTable.getColumns().add(column4);
		gradesTable.getColumns().add(column5);
		gradesTable.getColumns().add(column6);
		gradesTable.getColumns().add(column7);
		gradesTable.getColumns().add(column8);
		gradesTable.getColumns().add(column9);
		gradesTable.getColumns().add(column10);
		gradesTable.getColumns().add(column11);
		gradesTable.getColumns().add(column12);
		gradesTable.getColumns().add(column13);
		gradesTable.getColumns().add(column14);
		gradesTable.getColumns().add(column15);

		gradesTable.setPrefWidth(1360);
		gradesTable.setPrefHeight(200);

		// Main Pane
		HBox mainPane = new HBox(10);

		mainPane.getChildren().addAll(leftPane, gradesTable);

		mainPane.setPadding(new Insets(15, 15, 15, 15));

		Scene scene = new Scene(mainPane, 1700, 800);

		primaryStage.setTitle("School");
		primaryStage.setScene(scene);

		showGrades();

		primaryStage.show();
	}

	public void showGrades()
	{
		List<Grades> grades = Grades.getGrades();

		ObservableList<Grades> gradesList = FXCollections.observableArrayList();

		for (int i = 0; i < grades.size(); i++)
		{
			gradesList.add(grades.get(i));
		}

		gradesTable.setItems(gradesList);
	}

	public void clearForm()
	{
		periodIDTxt.setText("");
		studentIDTxt.setText("");
		subjectIDTxt.setText("");
		commitmentTxt.setText("");
		tasksTxt.setText("");
		essayTxt.setText("");
		debatesTxt.setText("");
		projectsTxt.setText("");
		testsTxt.setText("");
		quizzessTxt.setText("");
		portfolioTxt.setText("");
		markPart1Txt.setText("");
		finalTestTxt.setText("");
		markPart2Txt.setText("");
		finalPeriodMarkTxt.setText("");
	}

	public void insertGrade()
	{

		if (Grades.addGrade(periodIDTxt.getText(), studentIDTxt.getText(), subjectIDTxt.getText(),
				Double.parseDouble(commitmentTxt.getText()), Double.parseDouble(tasksTxt.getText()),
				Double.parseDouble(essayTxt.getText()), Double.parseDouble(debatesTxt.getText()),
				Double.parseDouble(projectsTxt.getText()), Double.parseDouble(testsTxt.getText()),
				Double.parseDouble(quizzessTxt.getText()), Double.parseDouble(portfolioTxt.getText()),
				Double.parseDouble(markPart1Txt.getText()), Double.parseDouble(finalTestTxt.getText()),
				Double.parseDouble(markPart2Txt.getText()), Double.parseDouble(finalPeriodMarkTxt.getText())))
		{
			showGrades();
			clearForm();
		}
	}

	public void updateGrade()
	{
		if (Grades.updateGrade(periodIDTxt.getText(), studentIDTxt.getText(), subjectIDTxt.getText(),
				Double.parseDouble(commitmentTxt.getText()), Double.parseDouble(tasksTxt.getText()),
				Double.parseDouble(essayTxt.getText()), Double.parseDouble(debatesTxt.getText()),
				Double.parseDouble(projectsTxt.getText()), Double.parseDouble(testsTxt.getText()),
				Double.parseDouble(quizzessTxt.getText()), Double.parseDouble(portfolioTxt.getText()),
				Double.parseDouble(markPart1Txt.getText()), Double.parseDouble(finalTestTxt.getText()),
				Double.parseDouble(markPart2Txt.getText()), Double.parseDouble(finalPeriodMarkTxt.getText())))
		{
			showGrades();
			clearForm();
		}
	}

	public void deleteGrade()
	{
		if (Grades.deleteGrade(periodIDTxt.getText(), studentIDTxt.getText(), subjectIDTxt.getText()))
		{
			showGrades();
			clearForm();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}