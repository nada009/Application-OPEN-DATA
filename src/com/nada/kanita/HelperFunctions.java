package com.nada.kanita;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelperFunctions
{
	private static Text title_text;
	private static Text addr_text;
	private static Text desc_text;
	private static Text coords;
	private static Text plus_details;

	public static HBox addHBox()
	{
		HBox hbox = new HBox();
		
		hbox.setPadding(new Insets(15, 15, 15, 15));
		hbox.setSpacing(10);
		hbox.setPrefHeight(50);
		hbox.setStyle("-fx-background-color: #ced3ff");
		
		return hbox;
	}
	
	public static VBox addVBox()
	{
		VBox vbox = new VBox();
		
		vbox.setPadding(new Insets(15, 15, 15, 15));
		vbox.setSpacing(10);
		vbox.setPrefWidth(350);
		
		return vbox;
	}
	
	public static Button addButton(String text, Pane parent)
	{
		Button button = new Button(text);
		
		button.setPadding(new Insets(5, 5, 5, 5));
		
		parent.getChildren().add(button);
		
		return button;
	}

	public static ToggleButton addToggleButton(String text, Pane parent)
	{
		ToggleButton button = new ToggleButton(text);
		
		button.setPadding(new Insets(5, 5, 5, 5));
		
		parent.getChildren().add(button);
		
		return button;
	}
	
	public static TextArea addSearchBar(Pane parent)
	{
		TextArea searchBar = new TextArea();
		
		searchBar.setStyle("-fx-font-size: 16px");
		searchBar.setPromptText("Search...");
		searchBar.setPadding(new Insets(3, 0, 3, 0));
		searchBar.setPrefHeight(50);
		
		parent.getChildren().add(searchBar);
		
		return searchBar;
	}
	
	public static ListView<String> addModelList(List<DataModel> dataModel, String ref, Pane parent)
	{
		ListView<String> source_list = new ListView<>();
		String s;
		
		source_list.getStyleClass().add(ref);
		source_list.setPadding(new Insets(5, 10, 5, 10));
		source_list.setPrefHeight(MainApp.WINDOW_HEIGHT);
		
		Iterator<DataModel> iter = dataModel.iterator();
		while( iter.hasNext() )
		{
			s = iter.next().getTitle();
			source_list.getItems().add(s);
		}
		
		parent.getChildren().add(source_list);
		
		return source_list;
	}
	
	public static void removeModelList(String ref, Pane parent)
	{
		parent.getChildren().remove(parent.lookup("." + ref));
		
		return;
	}
	
	public static Label addLabel(String text, int font_size, Pane parent)
	{
		Label label = new Label(text);

		label.setStyle("-fx-font-weight: bold;"
				+ "-fx-font-size: " + font_size + "px");
		label.setTextFill(Color.web("#96494d"));
		
		parent.getChildren().add(label);
		
		return label;
	}
	
	public static Text addText(String content, int font_size, Pane parent)
	{
		Text text = new Text();
		
		text.setText(content);
		text.setStyle("-fx-font-size: " + font_size + "px");
		
		parent.getChildren().add(text);
		
		return text;
	}
	
	public static void addDescriptionLabels(Pane parent)
	{
		addLabel(MainApp.TITLE, 16, parent);
		title_text = addText("", 14, parent);
		addLabel(MainApp.ADDRESS, 16, parent);
		addr_text = addText("", 14, parent);
		addLabel(MainApp.DESCRIPTION, 16, parent);
		desc_text = addText("", 14, parent);
		addLabel("Localisation", 16, parent);
		coords = addText("", 14, parent);
		plus_details = addLinkText("", 13, parent);
		
		return;
	}
	
	public static void removeDescriptionLabels(Pane parent)
	{
		return;
	}
	
	// if in_out is true then hand cursor
	// else normal cursor
	public static void openDetailsWindow(Node node, DataModel datamodel)
	{
		toggleHandCursor(node);
		
		node.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event)
			{
				final BorderPane details_root = new DetailsWindow(datamodel);
				final Scene details_scene = new Scene(details_root, 600, 400, Color.web("#f0f0f0"));
				final Stage details_stage = new Stage();
				
				addNKIcon(details_stage);
				details_stage.setTitle(datamodel.getTitle());
				details_stage.setScene(details_scene);
				details_stage.show();
			}
		});
		
		return;
	}
	
	public static void addNKIcon(Stage stage)
	{
		String image_file = getImageFromPath("images/nk.png");
		stage.getIcons().add(new Image(image_file));
		
		return;
	}
	
	public static void addListChangeListener(ListView<String> source_list, List<DataModel> datamodel, Pane parent)
	{
		source_list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				int idx = source_list.getSelectionModel().getSelectedIndex();
				// verify that index is not less than 1
				// used when the searchbar has no content inside
				if( idx > -1 && idx < datamodel.size() )
				{
					DataModel dm = datamodel.get(idx);
					
					String title = dm.getTitle();
					if( title != null )
					{
						title_text.setText(title);
					}
					
					String address = dm.getAddress();
					if( address != null )
					{
						addr_text.setText(address);
					}
					
					String description = dm.getShortDesc();
					if( description != null )
					{
						desc_text.setText(description);
					}
					
					String geopoint = dm.getGeoPoint().toString();
					if( geopoint != null )
					{
						coords.setText(geopoint);
					}
					else
					{
						coords.setText("No location available");
					}
					plus_details.setText("Plus de details..");
					openDetailsWindow(plus_details, dm);
				}
			}
		});
		
		return;
	}
	
	public static void modifyModelList(ListView<String> listview, List<DataModel> datamodel)
	{
		listview.getItems().clear();
		String s;
		
		Iterator<DataModel> iter = datamodel.iterator();
		while( iter.hasNext() )
		{
			s = iter.next().getTitle();
			listview.getItems().add(s);
		}
		
		return;
	}
	
	public static void addSearchChangeListener(DataModelInfo dm_instance, TextArea search, ListView<String> listview, Pane parent)
	{
		search.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
			{
				if( newValue.length() < 1 )
				{
					listview.getItems().clear();
				}
				if( newValue.length() >= 3 )
				{
					// couldn't find a way to return a filtered list from here
					// so the functions for modifying the list and displaying details is done here
					final List<DataModel> filtered_list = dm_instance.getFilteredList(newValue);
					modifyModelList(listview, filtered_list);
					addListChangeListener(listview, filtered_list, parent);
				}
			}
		});
		
		return;
	}
	
	public static Text addHeading(String content, Pane parent)
	{
		Text heading = addHeading(content, "default", parent);
		
		return heading;
	}

	public static Text addHeading(String content, String ref, Pane parent)
	{
		Text heading = addText(content, 20, parent);
		heading.getStyleClass().add(ref);
		heading.setFill(Color.web("#5e0004"));
		
		return heading;
	}

	public static ScrollPane addScrollPane()
	{
		return new ScrollPane();
	}
	
	public static void toggleHandCursor(Node node)
	{
		Scene scene = node.getScene();
		
		node.setOnMouseEntered(new EventHandler<Event>() {
			@Override
			public void handle(Event event)
			{
				if( scene != null )
				{
					scene.setCursor(Cursor.HAND);
				}
				node.setStyle("-fx-border-color: #0000ff;"
						+ "-fx-border-width: 0 0 1 0;"
						+ "-fx-font-style: italic;");
			}
		});
		
		node.setOnMouseExited(new EventHandler<Event>() {
			@Override
			public void handle(Event event)
			{
				if( scene != null )
				{
					scene.setCursor(Cursor.DEFAULT);
				}
				node.setStyle("-fx-border-color: #0000ff;"
						+ "-fx-border-width: 0 0 0 0;"
						+ "-fx-font-style: italic;");
			}
		});
		
		return;
	}

	public static Text addLinkText(String content, int font_size, Pane parent)
	{
		Text t = addText(content, font_size, parent);
		t.setFill(Color.BLUE);
		t.setStyle("-fx-font-style: italic;");
		
		return t;
	}
	
	public static void openMapsWindow(Node node, DataModel datamodel)
	{
		toggleHandCursor(node);
		
		node.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event)
			{
				final BorderPane maps_root = new MapsWindow(datamodel);
				final Scene maps_scene = new Scene(maps_root, 1000, 650, Color.web("#f0f0f0"));
				final Stage maps_stage = new Stage();
				
				addNKIcon(maps_stage);
				maps_stage.setTitle(datamodel.getTitle());
				maps_stage.setScene(maps_scene);
				maps_stage.show();
			}
		});
		
		return;
	}
	
	// used to load icon from images folder
	public static String getImageFromPath(String path)
	{
		File file = new File(path);
		String filename = "file:///" + file.getAbsolutePath().replace("\\", "//");
		
		return filename;
	}
}
