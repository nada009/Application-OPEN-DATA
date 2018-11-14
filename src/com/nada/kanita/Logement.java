package com.nada.kanita;

// model class pour logement

public class Logement extends DataModel
{
	public Logement(long id, String title, String shortdesc, String zone, String infos, String services, String contact, String address, String mail, String phone, String openinghours, String interneturl, String appointmenturl, String virtualvisiturl, String bookingurl, String troubleshootingurl, String photo, GeoPoint geopoint)
	{
		super(title, shortdesc, zone, infos, contact, photo, geopoint);
		super.identifiant = id;
		super.services = services;
		super.mail = mail;
		super.phone = phone;
		super.openingHours = openinghours;
		super.internetURL = interneturl;
		super.appointmentURL = appointmenturl;
		super.virtualVisitURL = virtualvisiturl;
		super.bookingURL = bookingurl;
		super.troubleShootingURL = troubleshootingurl;
		super.address = address;
	}
}
