package teacher;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import menu.MainMenu;

public class JavaFXMenu extends Application
{
	private BorderPane root = new BorderPane();
	private TabPane tabPane = new TabPane();
	List<Tab> openTabs = new ArrayList<>();
	SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();

	@Override
	public void start(Stage stage)
	{
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Menu 1");
		menuBar.getMenus().add(menu1);

		root.setTop(MainMenu.mainMenu());
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

		vbox.setStyle("-fx-background-color: #CCCCCC");
		return vbox;
	}

	private HBox Item(String icon)
	{
		Image image = new Image(JavaFXMenu.class.getResource("/images/" + icon + ".png").toExternalForm());
		ImageView imageView = new ImageView(image);
		Button btn = new Button();
		btn.setGraphic(imageView);
		btn.setPrefSize(45, 50);
		btn.setStyle("-fx-background-color: #CCCCCC");

		Tab tabOret = new Tab("Oret");
		Tab tabVendos = new Tab("Vendos");
		Tab tabNota = new Tab("Nota");
		Tab tabShowResults = new Tab("Show Results");
		
		btn.setOnMouseClicked(e -> {

			switch (icon)
			{
			case "oret":
				if (!openTabs.contains(tabOret))
				{
					tabPane.getTabs().addAll(tabOret);
					openTabs.add(tabOret);
				}
				else
				{
					selectionModel.select(tabOret);
				}
				break;
			case "vendos":
				if (!openTabs.contains(tabVendos))
				{
					tabPane.getTabs().addAll(tabVendos);
					openTabs.add(tabVendos);
				}
				else
				{
					selectionModel.select(tabVendos);
				}
				break;
			case "nota":
				if (!openTabs.contains(tabNota))
				{
					tabPane.getTabs().addAll(tabNota);
					new GradesTab(tabNota).open();
					openTabs.add(tabNota);
				}
				else
				{
					selectionModel.select(tabNota);
				}
				break;
			case "showresults":
				if (!openTabs.contains(tabShowResults))
				{
					tabPane.getTabs().addAll(tabShowResults);
					openTabs.add(tabShowResults);
				}
				else
				{
					selectionModel.select(tabShowResults);
				}
				break;
			}
		});
		
		tabOret.setOnClosed(event -> {
			openTabs.remove(tabOret);
		});
		tabVendos.setOnClosed(event -> {
			openTabs.remove(tabVendos);
		});
		tabNota.setOnClosed(event -> {
			openTabs.remove(tabNota);
		});
		tabShowResults.setOnClosed(event -> {
			openTabs.remove(tabShowResults);
		});

		btn.setOnMouseReleased(e -> {
			root.setCenter(tabPane);
		});

		Pane paneIndicator = new Pane();
		paneIndicator.setPrefSize(5, 50);
		paneIndicator.setStyle("-fx-background-color: #CCCCCC");

		menuDecorator(btn, paneIndicator);

		HBox hbox = new HBox(paneIndicator, btn);

		return hbox;

	}

	private void menuDecorator(Button btn, Pane pane)
	{
		btn.setOnMouseEntered(value -> {
			btn.setStyle("-fx-background-color: #999999");
			pane.setStyle("-fx-background-color: #999999");
		});

		btn.setOnMouseExited(value -> {
			btn.setStyle("-fx-background-color: #CCCCCC");
			pane.setStyle("-fx-background-color: #CCCCCC");
		});
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}