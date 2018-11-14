package com.nada.kanita;

// model class for restaurants

public class Restaurant extends DataModel
{
	public Restaurant(String id, String title, String shortdesc, String zone, String infos, String contact, String photo, GeoPoint geopoint, String type)
	{
		super(title, shortdesc, zone, infos, contact, photo, geopoint);
		super.restaurantId = id;
		super.typeRestaurant = type;
	}
}
