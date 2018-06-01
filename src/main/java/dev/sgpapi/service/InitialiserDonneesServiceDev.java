package dev.sgpapi.service;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sgpapi.entite.Collaborateur;
import dev.sgpapi.entite.CoordonneesBancaires;
import dev.sgpapi.entite.Departement;
import dev.sgpapi.repository.CollaborateurRepository;
import dev.sgpapi.repository.CoordonneesBancairesRepository;
import dev.sgpapi.repository.DepartementRepository;

@Service
@Transactional
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@Autowired
	CollaborateurRepository collaborateurRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	CoordonneesBancairesRepository coordonneesBancairesRepository;

	@Override
	public void initialiser() {
		Departement departement1 = new Departement("RH");
		Departement departement2 = new Departement("Comptabilité");
		Departement departement3 = new Departement("Informatique");

		CoordonneesBancaires coordonneesBancaires1 = new CoordonneesBancaires("Credit Agricole", "464646", "azazaz");
		CoordonneesBancaires coordonneesBancaires2 = new CoordonneesBancaires("Caisse D'Epargne", "515151", "nbnbnb");
		CoordonneesBancaires coordonneesBancaires3 = new CoordonneesBancaires("HSBC", "989898", "upupup");

		Collaborateur collaborateur1 = new Collaborateur("M01", "homme", "invisible", LocalDate.now(), "inconnue",
				"000000", "none", "pas de photo", false, departement1, coordonneesBancaires1);
		Collaborateur collaborateur2 = new Collaborateur("M02", "Bourdau", "Valentin", LocalDate.now(), "Nantes",
				"123456", "val.dta", "photo.val", true, departement2, coordonneesBancaires2);
		Collaborateur collaborateur3 = new Collaborateur("M03", "Cooper", "Sheldon", LocalDate.now(), "Pasadena",
				"789321", "shel.dta", "photo.shel", true, departement3, coordonneesBancaires3);

		departementRepository.save(departement1);
		departementRepository.save(departement2);
		departementRepository.save(departement3);
		coordonneesBancairesRepository.save(coordonneesBancaires1);
		coordonneesBancairesRepository.save(coordonneesBancaires2);
		coordonneesBancairesRepository.save(coordonneesBancaires3);
		collaborateurRepository.save(collaborateur1);
		collaborateurRepository.save(collaborateur2);
		collaborateurRepository.save(collaborateur3);
	}
}
