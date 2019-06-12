package menu;

import java.util.Locale;

import Help.teacherHelp;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;

public class MainMenu
{
	public static MenuBar mainMenu()
	{
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("File");
		Menu edit = new Menu("Edit");
		Menu language = new Menu("Language");

		MenuItem itmShqip = new MenuItem("Shqip");
		MenuItem itmEnglish = new MenuItem("English");
		language.getItems().addAll(itmShqip, itmEnglish);
		edit.getItems().add(language);
		itmShqip.setOnAction(e -> {
			I18N.setLocale(new Locale("al"));
		});
		itmEnglish.setOnAction(e ->{
			I18N.setLocale(new Locale("en"));
		});
		Menu help = new Menu("Help");
		MenuItem itmAbout = new MenuItem("About");
		itmAbout.setOnAction(e->{
			teacherHelp.about();	
		});
		
		
		menuBar.getMenus().addAll(file, edit, help);
	
		return menuBar;
	}
}
