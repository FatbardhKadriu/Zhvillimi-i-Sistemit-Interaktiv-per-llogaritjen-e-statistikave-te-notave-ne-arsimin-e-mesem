import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application
{
	 @Override
	    public void start(Stage primaryStage){
	    	primaryStage.setTitle("Hello World!");
	        Button btn = new Button();
	        btn.setText("Say 'Hello World'");
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Hello World!");
	            }
	        });
	        
	        StackPane root = new StackPane();
	        
	        
	        root.getChildren().add(btn);
	        primaryStage.setScene(new Scene(root, 300, 250));
	        primaryStage.show();
	        
	        Button button = new Button("Butoni");
			button.setLayoutX(30);
			button.setLayoutY(20);
			
			pane.getChildren().add(circle);
			pane.getChildren().add(button);
		
			
	    }
	
	public static void main(String[] args) {
        launch(args);
    }
}