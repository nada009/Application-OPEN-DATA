package com.nada.kanita;

import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class DetailsWindow extends BorderPane
{
	private DataModel datamodel;

	private VBox details;

	public DetailsWindow(DataModel datamodel)
	{
		ScrollPane spane = HelperFunctions.addScrollPane();
		this.details = HelperFunctions.addVBox();
		this.datamodel = datamodel;

		if( datamodel instanceof Logement )
		{
			showLogementDetails();
		}
		else if( datamodel instanceof Restaurant )
		{
			showRestaurantDetails();
		}
		else if( datamodel instanceof Bibliotheque )
		{
			showBibliothequeDetails();
		}
		Text maps = HelperFunctions.addLinkText("Show in maps", 13, details);
		HelperFunctions.openMapsWindow(maps, datamodel);
		
		spane.setPannable(true);
		spane.setContent(this.details);
		super.setCenter(spane);
	}

	private void showBibliothequeDetails()
	{
		HelperFunctions.addText("Etablissement: " + datamodel.uai_etab_porteur, 13, details);
		HelperFunctions.addText("Profil disciplinaire: " + datamodel.getShortDesc(), 13, details);
		HelperFunctions.addText("Nom de la bibliotheque: " + datamodel.title, 13, details);
		HelperFunctions.addText("Ville: " + datamodel.getZone(), 13, details);
		HelperFunctions.addText("Adresse: " + datamodel.getAddress(), 13, details);
		HelperFunctions.addText("Code Postal: " + datamodel.getCode_postale(), 13, details);
		HelperFunctions.addText("Horaires semaine: " + datamodel.getHoraires_semaine(), 13, details);
		HelperFunctions.addText("Ouvert samedi: " + datamodel.getOuverture_samedi_19h(), 13, details);
		HelperFunctions.addText("Horaires samedi: " + datamodel.getHoraires_samedi(), 13, details);
		HelperFunctions.addText("Ouvert dimanche: " + datamodel.getOuverture_dimanche(), 13, details);
		HelperFunctions.addText("Horaires dimanche: " + datamodel.getHoraires_diamanche(), 13, details);
		HelperFunctions.addText("Academie: " + datamodel.getAca_nom(), 13, details);
		HelperFunctions.addText("Region: " + datamodel.getReg_nom(), 13, details);
	}

	private void showSharedDetails()
	{
		HelperFunctions.addText("Title: " + datamodel.getTitle(), 13, details);
		HelperFunctions.addText("Address: " + datamodel.getAddress(), 13, details);
		HelperFunctions.addText("Description: " + datamodel.getShortDesc(), 13, details);
		HelperFunctions.addText("Zone: " + datamodel.getZone(), 13, details);
		HelperFunctions.addText("Services: " + datamodel.getServices(), 13, details);
		HelperFunctions.addText("Contact: " + datamodel.getContact(), 13, details);
		Text link = HelperFunctions.addLinkText("URL to image: " + datamodel.getInternetURL(), 13, details);
		
		HelperFunctions.toggleHandCursor(link);
	}

	private void showRestaurantDetails()
	{
		showSharedDetails();
		HelperFunctions.addText("Type Restaurant: " + datamodel.getTitle(), 13, details);
	}

	private void showLogementDetails()
	{
		showSharedDetails();
		HelperFunctions.addText("Mail: " + datamodel.getTitle(), 13, details);
		HelperFunctions.addText("Phone: " + datamodel.getAddress(), 13, details);
		HelperFunctions.addText("Internet URL: " + datamodel.getShortDesc(), 13, details);
		HelperFunctions.addText("Appointment URL: " + datamodel.getTitle(), 13, details);
		HelperFunctions.addText("Virtual Visit URL: " + datamodel.getAddress(), 13, details);
		HelperFunctions.addText("Booking URL: " + datamodel.getShortDesc(), 13, details);
	}
}
