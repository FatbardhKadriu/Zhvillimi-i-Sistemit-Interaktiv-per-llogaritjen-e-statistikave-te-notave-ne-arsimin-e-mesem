package teacher;

import java.sql.ResultSet;
import java.sql.Statement;
import database.DBConnection;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChartTab {
	Tab tab;

	public ChartTab(Tab tab)
	{
		this.tab = tab;
	}
	
	public int mjaft;
	public int mire;
	public int shumemire;
	public int shkelqyeshem;

	public void open() {
	
		StackPane pane = new StackPane();
		pane.getChildren().add(createPieChart());
		tab.setContent(pane);
	}

	public PieChart createPieChart() {
		PieChart pie = new PieChart();
		ObservableList<PieChart.Data> data = FXCollections.observableArrayList();

		try {

			String query = "SELECT * FROM CountStudents";

			Statement st = DBConnection.getConnection().createStatement();

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				 mjaft = rs.getInt("mjaft");
				 mire = rs.getInt("mire");
				 shumemire = rs.getInt("shumemire");
				 shkelqyeshem=rs.getInt("shkelqyeshem");

				// print the results
				System.out.format("%s, %s, %s, %s", mjaft, mire, shumemire, shkelqyeshem);
			}
			st.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		data.addAll(new PieChart.Data("mjaft", mjaft), new PieChart.Data("mire", mire),
				new PieChart.Data("shumemire", shumemire), new PieChart.Data("shkelqyeshem", shkelqyeshem));

		pie.setData(data);
		pie.setTitle("Suksesi i klases");
		return pie;
	}

}