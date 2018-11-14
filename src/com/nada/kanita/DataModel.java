package com.nada.kanita;

public abstract class DataModel
{
	private static final String UNAVAILABLE = "Non Disponible";
	
	/* bibliotheques data start */
	protected String uai_etab_porteur, code_postale;
	protected long nombre_de_places;
	protected String horaires_semaine;
	protected String ouverture_22_5j_semaine;
	protected String nombre_de_semaines_an;
	protected String date_mis_en_place;
	protected String horaires_samedi;
	protected String ouverture_samedi_19h;
	protected String horaires_diamanche;
	protected String ouverture_dimanche;
	protected String horaires_noel_pacques;
	protected String ouverture_conge;
	protected String com_code;
	protected String com_nom;
	protected String uucr_id;
	protected String uucr_nom;
	protected String dep_id;
	protected String aca_id;
	protected String aca_nom;
	protected String reg_id;
	protected String reg_nom;
	protected String localisation;
	/* bibliotheques data end */
	
	protected long identifiant;
	protected String restaurantId;
	protected String typeRestaurant;
	protected String title;
	protected String zone;
	protected String infos;
	protected String contact;
	protected String address;
	protected String photo;
	protected GeoPoint geoPoint;
	protected String shortDesc;
	protected String services;
	protected String mail;
	protected String phone;
	protected String openingHours;
	protected String internetURL;
	protected String appointmentURL;
	protected String virtualVisitURL;
	protected String bookingURL;
	protected String troubleShootingURL;
	
	public DataModel(String title, String shortdesc, String zone, String infos, String contact, String photo, GeoPoint geopoint)
	{
		this.title = title;
		this.shortDesc = shortdesc;
		this.zone = zone;
		this.infos = infos;
		this.contact = contact;
		this.photo = photo;
		this.geoPoint = geopoint;
	}
	
	public long getIdentifiant()
	{
		return identifiant;
	}

	public String getTitle()
	{
		return title != null ? title : UNAVAILABLE;
	}

	public String getZone()
	{
		return zone != null ? zone : UNAVAILABLE;
	}

	public String getInfos()
	{
		return infos != null ? infos : UNAVAILABLE;
	}

	public String getContact()
	{
		return contact != null ? contact : UNAVAILABLE;
	}

	public String getAddress()
	{
		return address != null ? address : UNAVAILABLE;
	}

	public String getPhoto()
	{
		return photo != null ? photo : UNAVAILABLE;
	}
	
	public GeoPoint getGeoPoint()
	{
		return geoPoint;
	}

	public String getShortDesc()
	{
		return shortDesc != null ? shortDesc : UNAVAILABLE;
	}
	
	public String getServices()
	{
		return services != null ? services : UNAVAILABLE;
	}

	public String getMail()
	{
		return mail != null ? mail : UNAVAILABLE;
	}

	public String getPhone()
	{
		return phone != null ? phone : UNAVAILABLE;
	}
	
	public String getOpeningHours()
	{
		return openingHours != null ? openingHours : UNAVAILABLE;
	}

	public String getInternetURL()
	{
		return internetURL != null ? internetURL : UNAVAILABLE;
	}
	
	public String getAppointmenURLt()
	{
		return appointmentURL != null ? appointmentURL : UNAVAILABLE;
	}

	public String getVirtualVisitURL()
	{
		return virtualVisitURL != null ? virtualVisitURL : UNAVAILABLE;
	}

	public String getBookingURL()
	{
		return bookingURL != null ? bookingURL : UNAVAILABLE;
	}

	public String getTroubleShootingURL()
	{
		return troubleShootingURL != null ? troubleShootingURL : UNAVAILABLE;
	}
	
	public String getTypeRestaurant()
	{
		return typeRestaurant != null ? typeRestaurant : UNAVAILABLE;
	}
	
	public String getUai_etab_porteur()
	{
		return uai_etab_porteur != null ? uai_etab_porteur : UNAVAILABLE;
	}

	public String getCode_postale()
	{
		return code_postale != null ? code_postale : UNAVAILABLE;
	}

	public long getNombre_de_places()
	{
		return nombre_de_places;
	}

	public String getHoraires_semaine()
	{
		return horaires_semaine != null ? horaires_semaine : UNAVAILABLE;
	}

	public String getOuverture_22_5j_semaine()
	{
		return ouverture_22_5j_semaine != null ? ouverture_22_5j_semaine : UNAVAILABLE;
	}

	public String getNombre_de_semaines_an()
	{
		return nombre_de_semaines_an != null ? nombre_de_semaines_an : UNAVAILABLE;
	}

	public String getDate_mis_en_place()
	{
		return date_mis_en_place != null ? date_mis_en_place : UNAVAILABLE;
	}

	public String getHoraires_samedi()
	{
		return horaires_samedi != null ? horaires_samedi : UNAVAILABLE;
	}

	public String getOuverture_samedi_19h()
	{
		return ouverture_samedi_19h != null ? ouverture_samedi_19h : UNAVAILABLE;
	}

	public String getHoraires_diamanche()
	{
		return horaires_diamanche != null ? horaires_diamanche : UNAVAILABLE;
	}

	public String getOuverture_dimanche()
	{
		return ouverture_dimanche != null ? ouverture_dimanche : UNAVAILABLE;
	}

	public String getHoraires_noel_pacques()
	{
		return horaires_noel_pacques != null ? horaires_noel_pacques : UNAVAILABLE;
	}

	public String getOuverture_conge()
	{
		return ouverture_conge != null ? ouverture_conge : UNAVAILABLE;
	}

	public String getCom_code()
	{
		return com_code != null ? com_code : UNAVAILABLE;
	}

	public String getCom_nom()
	{
		return com_nom != null ? com_nom : UNAVAILABLE;
	}

	public String getUucr_id()
	{
		return uucr_id != null ? uucr_id : UNAVAILABLE;
	}

	public String getUucr_nom()
	{
		return uucr_nom != null ? uucr_nom : UNAVAILABLE;
	}

	public String getDep_id()
	{
		return dep_id != null ? dep_id : UNAVAILABLE;
	}

	public String getAca_id()
	{
		return aca_id != null ? aca_id : UNAVAILABLE;
	}

	public String getAca_nom()
	{
		return aca_nom != null ? aca_nom : UNAVAILABLE;
	}

	public String getReg_id()
	{
		return reg_id != null ? reg_id : UNAVAILABLE;
	}

	public String getReg_nom()
	{
		return reg_nom != null ? reg_nom : UNAVAILABLE;
	}

	public String getLocalisation()
	{
		return localisation != null ? localisation : UNAVAILABLE;
	}

	public String getRestaurantId()
	{
		return restaurantId != null ? restaurantId : UNAVAILABLE;
	}

	public String getAppointmentURL()
	{
		return appointmentURL != null ? appointmentURL : UNAVAILABLE;
	}

	@Override
	public String toString()
	{
		return this.zone + this.title + this.address;
	}
}
