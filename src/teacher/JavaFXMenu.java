package teacher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXMenu extends Application
{
	@Override
	public void start(Stage stage)
	{

		 

	        

	        
	        
	        Menu menu1 = new Menu("Menu 1");

	        MenuBar menuBar = new MenuBar();

	        menuBar.getMenus().add(menu1);
		
		BorderPane root = new BorderPane();
		root.setLeft(Menu());
		stage.setScene(new Scene(root));
		stage.show();
	}
		
	private VBox Menu()
	{
		VBox vbox = new VBox();
		vbox.setPrefWidth(50);
		
		vbox.getChildren().add(Item(String.valueOf("vendos")));
		vbox.getChildren().add(Item(String.valueOf("showresults")));
		vbox.getChildren().add(Item(String.valueOf("nota")));
		vbox.getChildren().add(Item(String.valueOf("oret")));

		vbox.setStyle("-fx-background-color: #666666");
		return vbox;
	}
	
	private HBox Item(String icon)
	{
		Image image = new Image(JavaFXMenu.class.getResource("/images/" + icon + ".png").toExternalForm());
		ImageView imageView = new ImageView(image);
		Button btn = new Button();
		btn.setGraphic(imageView);
		btn.setPrefSize(45, 50);
		btn.setStyle("-fx-background-color: #666666");	
		Pane paneIndicator = new Pane();
		paneIndicator.setPrefSize(5, 50);
		paneIndicator.setStyle("-fx-background-color: #666666");
		
		menuDecorator(btn, paneIndicator);
		
		HBox hbox = new HBox(paneIndicator, btn);
	
		return hbox;
		
	}
	
	private void menuDecorator(Button btn, Pane pane)
	{
		btn.setOnMouseEntered(value -> {
			btn.setStyle("-fx-background-color: #666666");
			pane.setStyle("-fx-background-color: #666666");
		});
		
		btn.setOnMouseExited(value -> {
			btn.setStyle("-fx-background-color: #333333");
			pane.setStyle("-fx-background-color: #333333");
		});
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
