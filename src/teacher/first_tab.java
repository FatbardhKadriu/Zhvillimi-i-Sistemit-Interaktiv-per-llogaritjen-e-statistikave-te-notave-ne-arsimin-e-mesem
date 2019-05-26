package teacher;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class first_tab
{
	Tab tab;
	
	//--Make the constructor of class 
	
	public first_tab()
	{
		this.tab = tab;
	}
	
	//--Make the function
	
	public void open()
	{
		Label l1 = new Label("This is our first tab");
		TextField tf1 = new TextField("First Name");
		TextField tf2 = new TextField("Second Name");
		Button b1 = new Button("Insert");
		
		VBox v1 = new VBox();
		v1.setSpacing(10);
		
		//--Add inside tab
		
		v1.getChildren().addAll(l1, tf1, tf2, b1);
		
		tab.setContent(v1);
		
	}
}
