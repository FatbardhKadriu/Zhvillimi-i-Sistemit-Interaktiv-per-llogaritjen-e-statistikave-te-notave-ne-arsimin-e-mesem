import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import admin.MainLogin;
import admin.StudentsPanel;
import admin.StudentsPanel;
import admin.TeachersPanel;
import admin.TeachersTable;
import student.StudentLogin;;

public class Main extends Application{
	
	private Button admin;
	private Button teacher;
	private Button student;
	@Override
	public void start(Stage primaryStage)
	{
		Image image1 = new Image("images/admin.png");
		Image image2 = new Image("images/teacher.jpg");
		Image image3 = new Image("images/student.png");
		ImageView adminImage = new ImageView(image1);
		ImageView teacherImage = new ImageView(image2);
		ImageView studentImage = new ImageView(image3);
		adminImage.setFitHeight(100);
		adminImage.setFitWidth(100);
		studentImage.setFitHeight(100);
		studentImage.setFitWidth(100);
		teacherImage.setFitHeight(100);
		teacherImage.setFitWidth(100);
		HBox pane = new HBox(30);
		admin = new Button("Admin", adminImage);
		teacher = new Button("Teacher", teacherImage);
		student = new Button("Student", studentImage);
		admin.setOnAction(e -> {
			MainLogin.createStage();
		});
		teacher.setOnAction(e -> {
			//
		});
		student.setOnAction(e -> {
			StudentLogin.createStage();
		});
		pane.getChildren().addAll(admin, teacher, student);
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane, 600, 300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Main");
		primaryStage.show();
	}
	

}
