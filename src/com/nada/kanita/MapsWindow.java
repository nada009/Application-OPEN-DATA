package com.nada.kanita;

import java.util.List;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MapsWindow extends BorderPane
{
	private int index, proximity_list_size;
	
	private final WebView browser;
	private final WebEngine webEngine;
	
	private final Button next, prev;
	
	private List<DataModel> proximity_list;
	private GeoPoint gp;
	
	private final String url_part1, url_part2;
	
	public MapsWindow(DataModel datamodel)
	{
		if( datamodel instanceof Logement )
		{
			this.proximity_list = DataModelInfo.getLogementInstance().getFilteredList(datamodel.getZone());
		}
		else if( datamodel instanceof Restaurant )
		{
			this.proximity_list = DataModelInfo.getRestaurantInstance().getFilteredList(datamodel.getZone());
		}
		else if( datamodel instanceof Bibliotheque )
		{
			this.proximity_list = DataModelInfo.getBibliothequeInstance().getFilteredList(datamodel.getZone());
		}
		
		this.index = 0;
		this.proximity_list_size = this.proximity_list.size();
		
		this.gp = datamodel.getGeoPoint();
		
		HBox toolbar = HelperFunctions.addHBox();
		
		this.next = HelperFunctions.addButton("Next", toolbar);
		this.prev = HelperFunctions.addButton("Previous", toolbar);
		
		browser = new WebView();
		webEngine = browser.getEngine();
		
		this.url_part1 = "https://www.google.com.sa/maps/search/";
		this.url_part2 = "?hl=en";
		
		webEngine.load(url_part1 + gp.toString() + this.url_part2);
		
		this.setButtonHandlers();
		
		super.setTop(toolbar);
		super.setCenter(browser);
	}
	
	private void setButtonHandlers()
	{
		next.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event)
			{
				nextAreaInZone();
			}
		});
		
		prev.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event event)
			{
				prevAreaInZone();
			}
		});
	}
	
	private int incrementIndex()
	{
		if( ( index + 1 ) < proximity_list_size )
		{
			index += 1;
		}
		else
		{
			index = 0;
		}
		
		return index;
	}
	
	private int decrementIndex()
	{
		if( ( index - 1 ) < 0 )
		{
			index = proximity_list_size - 1;
		}
		else
		{
			index -= 1;
		}
		
		return index;
	}
	
	private void nextAreaInZone()
	{
		incrementIndex();
		GeoPoint gp = this.proximity_list.get(index).getGeoPoint();
		
		webEngine.load(this.url_part1 + gp.toString() + this.url_part2);
	}
	
	private void prevAreaInZone()
	{
		decrementIndex();
		GeoPoint gp = this.proximity_list.get(index).getGeoPoint();
		
		webEngine.load(this.url_part1 + gp.toString() + this.url_part2);
	}
}
