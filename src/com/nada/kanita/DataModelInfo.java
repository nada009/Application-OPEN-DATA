package com.nada.kanita;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// this class reads the logement file and makes an array of Logement

public class DataModelInfo
{
	// we are working with three files, logements.json and restaurants.json and bibliotheque.json
	private static DataModelInfo logementsModelInfo;
	private static DataModelInfo restaurantsModelInfo;
	private static DataModelInfo bibliothequesModelInfo;
	
	private static final String LOGEMENT_FILE = "json_files/logements.json";
	private static final String RESTAURANT_FILE = "json_files/restaurants.json";
	private static final String BIBLIOTHEQUE_FILE = "json_files/bibliotheques.json";
	
	private JSONParser parser;
	
	// list to hold datamodel objects
	private List<DataModel> datamodels;
	private JSONObject field;
	
	public static DataModelInfo getLogementInstance()
	{
		if( logementsModelInfo != null )
		{
			return logementsModelInfo;
		}
		
		return new DataModelInfo(LOGEMENT_FILE);
	}
	
	public static DataModelInfo getRestaurantInstance()
	{
		if( restaurantsModelInfo != null )
		{
			return logementsModelInfo;
		}
		
		return new DataModelInfo(RESTAURANT_FILE);
	}
	
	public static DataModelInfo getBibliothequeInstance()
	{
		if( bibliothequesModelInfo != null )
		{
			return bibliothequesModelInfo;
		}
		
		return new DataModelInfo(BIBLIOTHEQUE_FILE);
	}
	
	// datatype is the information we are using
	// either logements or restaurants
	private DataModelInfo(String type)
	{
		// initialize logements
		datamodels = new ArrayList<DataModel>();
		parser = new JSONParser();
		
		if( type.equals(LOGEMENT_FILE) )
		{
			parseLogementsFile();
		}
		else if( type.equals(RESTAURANT_FILE) )
		{
			parseRestaurantsFile();
		}
		else if( type.equals(BIBLIOTHEQUE_FILE) )
		{
			parseBibliothequesFile();
		}
	}
	
	private void parseBibliothequesFile()
	{
		try
		{
			Object json_file = parser.parse(new FileReader(BIBLIOTHEQUE_FILE));
			JSONArray file_array = (JSONArray) json_file;
			JSONObject temp = null;
			
			for( int i = 0; i < file_array.size(); ++i )
			{
				temp = (JSONObject) file_array.get(i);
				this.field = (JSONObject) temp.get("fields");
				JSONArray coordinates = (JSONArray) this.field.get("geolocalisation");
				
				String uai_etab_porteur = this.getJsonString("uai_etablissement_porteur");
				String etab_porteur = this.getJsonString("etablissement_porteur");
				String profile_disciplinaire = this.getJsonString("profil_disciplinaire");
				String localisation = this.getJsonString("localisation");
				String nom_de_la_bu = this.getJsonString("nom_de_la_bu");
				String addresse_geographique = this.getJsonString("adresse_geographique");
				String code_postal = this.getJsonString("code_postal");
				String ville = this.getJsonString("ville");
				long nombre_de_places = this.getJsonInteger("nombre_de_places");
				String horaires_semaine = this.getJsonString("horaires_semaine");
				String ouverture_22_5j_semaine = this.getJsonString("ouverture_22h_5j_semaine");
				String nombre_de_semaines_an = this.getJsonString("nombre_de_semaines_an");
				String date_mis_en_place = this.getJsonString("date_de_mise_en_place");
				String horaires_samedi = this.getJsonString("horaires_le_samedi");
				String ouverture_samedi_19h = this.getJsonString("ouverture_le_samedi_jusqu_a_19h");
				String horaires_diamanche = this.getJsonString("horaires_du_dimanche");
				String ouverture_dimanche = this.getJsonString("ouverture_dimanche");
				String horaires_noel_pacques = this.getJsonString("horaire_ouverture_semaine_noel_paques");
				String ouverture_conge = this.getJsonString("ouverture_conges_universitaires");
				String com_code = this.getJsonString("com_code");
				String com_nom = this.getJsonString("com_nom");
				String uucr_id = this.getJsonString("uucr_id");
				String uucr_nom = this.getJsonString("uucr_nom");
				String dep_id = this.getJsonString("dep_id");
				String aca_id = this.getJsonString("aca_id");
				String aca_nom = this.getJsonString("aca_nom");
				String reg_id = this.getJsonString("reg_id");
				String reg_nom = this.getJsonString("reg_nom");
				double xcoord = (double) coordinates.get(0);
				double ycoord = (double) coordinates.get(1);
				GeoPoint geopoint = new GeoPoint(xcoord, ycoord);
				// create new Logement object with intended data
				Bibliotheque b = new Bibliotheque(uai_etab_porteur, etab_porteur, profile_disciplinaire, localisation, geopoint, nom_de_la_bu, addresse_geographique, code_postal, ville, nombre_de_places, horaires_semaine, ouverture_22_5j_semaine, nombre_de_semaines_an, date_mis_en_place, horaires_samedi, ouverture_samedi_19h, horaires_diamanche, ouverture_dimanche, horaires_noel_pacques, ouverture_conge, com_code, com_nom, uucr_id, uucr_nom, dep_id, aca_id, aca_nom, reg_id, reg_nom);
				this.datamodels.add(b);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
	}

	private void parseRestaurantsFile()
	{
		try
		{
			Object json_file = parser.parse(new FileReader(RESTAURANT_FILE));
			JSONArray file_array = (JSONArray) json_file;
			JSONObject temp = null;
			
			for( int i = 0; i < file_array.size(); ++i )
			{
				temp = (JSONObject) file_array.get(i);
				this.field = (JSONObject) temp.get("fields");
				JSONArray coordinates = (JSONArray) this.field.get("geolocalisation");
				
				String id = this.getJsonString("id");
				String title = this.getJsonString("title");
				String shortdesc = this.getJsonString("short_desc");
				String zone = this.getJsonString("zone");
				String infos = this.getJsonString("infos");
				String contact = this.getJsonString("contact");
				String photo = this.getJsonString("photo");
				double xcoord = (double) coordinates.get(0);
				double ycoord = (double) coordinates.get(1);
				GeoPoint geopoint = new GeoPoint(xcoord, ycoord);
				String type = this.getJsonString("type");
				
				// create new Logement object with intended data
				Restaurant r = new Restaurant(id, title, shortdesc, zone, infos, contact, photo, geopoint, type);
				this.datamodels.add(r);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
	
	private void parseLogementsFile()
	{
		try
		{
			Object json_file = parser.parse(new FileReader(LOGEMENT_FILE));
			JSONArray file_array = (JSONArray) json_file;
			JSONObject temp = null;
			
			for( int i = 0; i < file_array.size(); ++i )
			{
				temp = (JSONObject) file_array.get(i);
				this.field = (JSONObject) temp.get("fields");
				JSONArray coordinates = (JSONArray) this.field.get("geocalisation");
				
				long id = this.getJsonInteger("id");
				String title = this.getJsonString("title");
				String shortdesc = this.getJsonString("short_desc");
				String zone = this.getJsonString("zone");
				String infos = this.getJsonString("infos");
				String services = this.getJsonString("services");
				String contact = this.getJsonString("contact");
				String address = this.getJsonString("address");
				String mail = this.getJsonString("mail");
				String phone = this.getJsonString("phone");
				String openinghours = this.getJsonString("openinghours");
				String interneturl = this.getJsonString("interneturl");
				String appointmenturl = this.getJsonString("appointmenturl");
				String virtualvisiturl = this.getJsonString("virtualvisiturl");
				String bookingurl = this.getJsonString("bookingurl");
				String troubleshootingurl = this.getJsonString("troubleshootingurl");
				String photo = this.getJsonString("photo");
				double xcoord = (double) coordinates.get(0);
				double ycoord = (double) coordinates.get(1);
				GeoPoint geopoint = new GeoPoint(xcoord, ycoord);
				
				// create new Logement object with intended data
				Logement l = new Logement(id, title, shortdesc, zone, infos, services, contact, address, mail, phone, openinghours, interneturl, appointmenturl, virtualvisiturl, bookingurl, troubleshootingurl, photo, geopoint);
				this.datamodels.add(l);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
	
	// functions to obtain certain types of data from json file
	private long getJsonInteger(String s)
	{
		return (long) this.field.get(s);
	}
	
	private String getJsonString(String s)
	{
		return (String) this.field.get(s);
	}
	
	// get the list of Logement objects
	public List<DataModel> getDataModelList()
	{
		return new ArrayList<DataModel>(this.datamodels);
	}
	
	// zone filtered list
	public List<DataModel> getFilteredList(String filtertext)
	{
		List<DataModel> zonefiltered = new ArrayList<>();
		
		for( DataModel dm : datamodels )
		{
			if( dm.toString().toLowerCase().contains(filtertext.toLowerCase()) )
			{
				zonefiltered.add(dm);
			}
		}
		
		return zonefiltered;
	}
}
