package com.nada.kanita;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
		stage.setTitle(WINDOW_TITLE);
		
		DataModelInfo li = DataModelInfo.getLogementInstance();
		List<DataModel> logements = li.getLogementList();
		
		BorderPane root = new BorderPane();
		
		HBox toolbar = HelperFunctions.addHBox();
		VBox list_content = HelperFunctions.addVBox();
		
		TextArea search_bar = HelperFunctions.addSearchBar(list_content);
		ListView<String> logements_view = HelperFunctions.addModelList(logements, list_content);
		
		VBox description_content = HelperFunctions.addVBox();
		
		HelperFunctions.addDescriptionLabels(description_content);
		HelperFunctions.addListChangeListener(logements_view, logements, description_content);
		
		VBox filtered_list_content = HelperFunctions.addVBox();
		
		HelperFunctions.addHeading("Filter Results", filtered_list_content);
		
		// empty the list in the beginning
		List<DataModel> filtered_list = li.getFilteredList("");
		filtered_list.clear();
		ListView<String> filtered_list_view = HelperFunctions.addModelList(filtered_list, filtered_list_content);
		HelperFunctions.addSearchChangeListener(li, search_bar, filtered_list_view, description_content);
		
		root.setTop(toolbar);
		root.setLeft(list_content);
		root.setCenter(description_content);
		root.setRight(filtered_list_content);
		
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.web("e5f7ff"));
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
