package teacher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			//--Add TabPane
			
			TabPane tp = new TabPane();
			
		
			
			
			//--Add the tabs inside the TabPane
			
			Tab tb1 = new Tab("first tab");
			tp.getTabs().addAll(tb1);
			
			VBox v1 = new VBox();
			
			tp.prefWidthProperty().bind(primaryStage.widthProperty());
			
			//--Call the first tab and put tab inside
			new first_tab(tb1).open();
			
			
			
			
			v1.getChildren().addAll(tp);
			
			AnchorPane root = new AnchorPane();
			root.getChildren().addAll(v1);
			Scene scene = new Scene(root, 400, 400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.show();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		launch(args);
	}

}
