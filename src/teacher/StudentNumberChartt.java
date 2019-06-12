package teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import admin.StudentsTable;
import database.DBConnection;
import javafx.application.Application;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class StudentNumberChartt extends Application {

   public static void main(String[] args) {
      launch(args);
   }

   @Override
   public void start(Stage stage) throws Exception {
      StackPane pane = new StackPane();
      pane.getChildren().add(createStackedBarChart());
      stage.setScene(new Scene(pane, 800, 500));
      stage.show();
   }

   public ObservableList<XYChart.Series<String, Double>>
         getDummyChartData() {
	   {
		      ObservableList<XYChart.Series<String, Double>> data =
		         FXCollections.observableArrayList();

		      Series<String, Double> gjuheshqipe = new Series<>();
		      Series<String, Double> gjuheangleze = new Series<>();
		      Series<String, Double> gjuhegjermane = new Series<>();
		      Series<String, Double> artmuzikor = new Series<>();
		      Series<String, Double> artfigurativ = new Series<>();
		      Series<String, Double> matematike = new Series<>();
		      Series<String, Double> biologji = new Series<>();
		      Series<String, Double> fizike = new Series<>();
		      Series<String, Double> kimi = new Series<>();
		      Series<String, Double> gjeografi = new Series<>();
		      Series<String, Double> histori = new Series<>();
		      Series<String, Double> edukatefizike = new Series<>();
		      Series<String, Double> tik = new Series<>();
		      Series<String, Double> kulturadheshoqeria = new Series<>();
		      Series<String, Double> ekologji = new Series<>();
		      
		      gjuheshqipe.setName("Gjuhe Shqipe");
		      gjuheangleze.setName("Gjuhe Angleze");
		      gjuhegjermane.setName("Gjuhe Gjermane");
		      artmuzikor.setName("Art Muzikor");
		      artfigurativ.setName("Art Figurativ");
		      matematike.setName("Matematike");
		      biologji.setName("Biologji");
		      fizike.setName("Fizike");
		      kimi.setName("Kimi");
		      gjeografi.setName("Gjeografi");
		      histori.setName("Histori");
		      edukatefizike.setName("Edukate Fizike");
		      tik.setName("TIK");
		      kulturadheshoqeria.setName("Kultura Dhe Shoqeria");
		      ekologji.setName("Ekologji");
		     
		      
		      Random r = new Random();

		      for (int i = 1; i < 4; i++) {

		    	  gjuheshqipe.getData().add(new XYChart.Data<>   
					 (Integer.toString(i), r.nextDouble()));        
					                                                
					 gjuheangleze.getData().add(new XYChart.Data<>  
					 (Integer.toString(i), r.nextDouble()));        
					 gjuhegjermane.getData().add(new XYChart.Data<> 
					 (Integer.toString(i), r.nextDouble()));        
					 artmuzikor.getData().add(new XYChart.Data<>    
					 (Integer.toString(i), r.nextDouble()));        
					 artfigurativ.getData().add(new XYChart.Data<>  
					 (Integer.toString(i), r.nextDouble()));        
					 biologji.getData().add(new XYChart.Data<>      
					 (Integer.toString(i), r.nextDouble()));        
					                                                
					 fizike.getData().add(new XYChart.Data<>        
					 (Integer.toString(i), r.nextDouble()));        
					 kimi.getData().add(new XYChart.Data<>          
					 (Integer.toString(i), r.nextDouble()));        
					 gjeografi.getData().add(new XYChart.Data<>     
					 (Integer.toString(i), r.nextDouble()));        
					 histori.getData().add(new XYChart.Data<>       
					 (Integer.toString(i), r.nextDouble()));        
					 edukatefizike.getData().add(new XYChart.Data<> 
					 (Integer.toString(i), r.nextDouble()));        
					 tik.getData().add(new XYChart.Data<>           
					 (Integer.toString(i), r.nextDouble()));        
					 kulturadheshoqeria.getData().add(new XYChart.Data<>
					 (Integer.toString(i), r.nextDouble()));        
					 ekologji.getData().add(new XYChart.Data<>      
					 (Integer.toString(i), r.nextDouble()));
		      }
		      data.addAll(gjuheshqipe, gjuheangleze, gjuhegjermane, artmuzikor, artfigurativ, matematike, biologji, fizike, kimi, gjeografi, histori, edukatefizike, tik, kulturadheshoqeria, ekologji);
		      return data;
		   }

    
   }

   public XYChart<CategoryAxis, NumberAxis>
         createStackedBarChart() {
      CategoryAxis xAxis = new CategoryAxis();
      NumberAxis yAxis = new NumberAxis();
      StackedBarChart sbc = new StackedBarChart<>(xAxis, yAxis);
      sbc.setData(getDummyChartData());
      sbc.setTitle("Numri i nxenesve ne lendet perkatese:");
      return sbc;
   }
}