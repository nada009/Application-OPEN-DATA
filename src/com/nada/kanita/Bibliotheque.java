package com.nada.kanita;

public class Bibliotheque extends DataModel
{
	public Bibliotheque(String uai_etab_porteur, String etab_porteur, String profile_disciplinaire, String localisation, GeoPoint geopoint, String nom_de_la_bu, String addresse_geographique, String code_postal, String ville, long nombre_de_places, String horaires_semaine, String ouverture_22_5j_semaine, String nombre_de_semaines_an, String date_mis_en_place, String horaires_samedi, String ouverture_samedi_19h, String horaires_diamanche, String ouverture_dimanche, String horaires_noel_pacques, String ouverture_conge, String com_code, String com_nom, String uucr_id, String uucr_nom, String dep_id, String aca_id, String aca_nom, String reg_id, String reg_nom)
	{
		super(nom_de_la_bu, profile_disciplinaire, ville, addresse_geographique, "", "", geopoint);
		this.uai_etab_porteur = uai_etab_porteur;
		this.horaires_semaine = horaires_semaine;
		this.ouverture_22_5j_semaine = ouverture_22_5j_semaine;
		this.nombre_de_semaines_an = nombre_de_semaines_an;
		this.date_mis_en_place = date_mis_en_place;
		this.horaires_samedi = horaires_samedi;
		this.ouverture_samedi_19h = ouverture_samedi_19h;
		this.horaires_diamanche = horaires_diamanche;
		this.ouverture_dimanche = ouverture_dimanche;
		this.horaires_noel_pacques = horaires_noel_pacques;
		this.ouverture_conge = ouverture_conge;
		this.com_code = com_code;
		this.uucr_id = uucr_id;
		this.uucr_nom = uucr_nom;
		this.dep_id = dep_id;
		this.aca_id = aca_id;
		this.reg_id = reg_id;
		this.reg_nom = reg_nom;
		this.localisation = localisation;
	}

	@Override
	public String toString()
	{
		return uai_etab_porteur + code_postale + title + address
				+ nombre_de_places + horaires_semaine + infos + zone
				+ ouverture_22_5j_semaine + geoPoint
				+ nombre_de_semaines_an + date_mis_en_place
				+ horaires_samedi + ouverture_samedi_19h
				+ horaires_diamanche + ouverture_dimanche
				+ horaires_noel_pacques + ouverture_conge + com_code
				+ com_nom + uucr_id + uucr_nom + dep_id
				+ aca_id + aca_nom + reg_id + reg_nom
				+ localisation;
	}
}
