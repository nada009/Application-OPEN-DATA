package com.nada.kanita;

import java.util.List;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApp extends Application
{
	public static final String WINDOW_TITLE = "Nada Project";
	public static final int WINDOW_WIDTH = 1200;
	public static final int WINDOW_HEIGHT = 640;
	public static final int LEFT_CONTENT_WIDTH = 310;
	public static final int RIGHT_CONTENT_width = 310;
	
	public static final String TITLE = "Title";
	public static final String ADDRESS = "Address";
	public static final String DESCRIPTION = "Description";
	
	@Override
	public void start(Stage stage) throws Exception
	{
		HelperFunctions.addNKIcon(stage);
		stage.setTitle(WINDOW_TITLE);
		
		DataModelInfo li = DataModelInfo.getLogementInstance();
		DataModelInfo ri = DataModelInfo.getRestaurantInstance();
		DataModelInfo bi = DataModelInfo.getBibliothequeInstance();
		
		List<DataModel> logements = li.getDataModelList();
		List<DataModel> restaurants = ri.getDataModelList();
		List<DataModel> bibliotheques = bi.getDataModelList();
		
		BorderPane root = new BorderPane();
		
		HBox toolbar = HelperFunctions.addHBox();
		
		HelperFunctions.addHeading("JSON Data Handling", toolbar);
		
		// code to deal with description
		VBox description_content = HelperFunctions.addVBox();
		HelperFunctions.addDescriptionLabels(description_content);
		
		// code to deal with logements
		VBox list_content = HelperFunctions.addVBox();
		
		// search bar
		TextArea search_bar = HelperFunctions.addSearchBar(list_content);
		
		// code to deal with bibliotheques
		HelperFunctions.addHeading("Bibliotheques", "bibliotheques-heading", list_content);
		ListView<String> bibliotheques_view = HelperFunctions.addModelList(bibliotheques, "bibliotheques", list_content);
		HelperFunctions.addListChangeListener(bibliotheques_view, bibliotheques, description_content);
		// end code to deal with bibliotheques
		
		HelperFunctions.addHeading("Logements", "logements-heading", list_content);
		ListView<String> logements_view = HelperFunctions.addModelList(logements, "logements", list_content);
		HelperFunctions.addListChangeListener(logements_view, logements, description_content);
		
		// code to deal with restaurants
		HelperFunctions.addHeading("Restaurants", "restaurants-heading", list_content);
		ListView<String> restaurants_view = HelperFunctions.addModelList(restaurants, "restaurants", list_content);
		HelperFunctions.addListChangeListener(restaurants_view, restaurants, description_content);
		
		// code to handle filtration of results for bibliotheques
		VBox filtered_list_box = HelperFunctions.addVBox();
		
		// empty the list in the beginning
		List<DataModel> filtered_list_bibliotheques = bi.getFilteredList("");
		filtered_list_bibliotheques.clear();
		HelperFunctions.addHeading("Bibliotheques Filter Results", filtered_list_box);
		ListView<String> filtered_list_bibliotheques_view = HelperFunctions.addModelList(filtered_list_bibliotheques, "filtered", filtered_list_box);
		HelperFunctions.addSearchChangeListener(li, search_bar, filtered_list_bibliotheques_view, description_content);
		
		// code to handle filtration of results for logements
		List<DataModel> filtered_list_logements = li.getFilteredList("");
		// empty the list in the beginning
		filtered_list_logements.clear();
		HelperFunctions.addHeading("Logements Filter Results", filtered_list_box);
		ListView<String> filtered_list_logements_view = HelperFunctions.addModelList(filtered_list_logements, "filtered", filtered_list_box);
		HelperFunctions.addSearchChangeListener(li, search_bar, filtered_list_logements_view, description_content);

		// code to handle filtration of results for restaurants
		List<DataModel> filtered_list_restaurants = ri.getFilteredList("");
		// empty the list in the beginning
		filtered_list_restaurants.clear();
		HelperFunctions.addHeading("Restaurants Filter Results", filtered_list_box);
		ListView<String> filtered_list_restaurants_view = HelperFunctions.addModelList(filtered_list_restaurants, "filtered", filtered_list_box);
		HelperFunctions.addSearchChangeListener(ri, search_bar, filtered_list_restaurants_view, description_content);
		
		root.setTop(toolbar);
		root.setLeft(list_content);
		root.setCenter(description_content);
		root.setRight(filtered_list_box);
		
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.web("e5f7ff"));
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
