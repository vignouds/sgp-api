package dev.sgpapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpapi.entite.Collaborateur;
import dev.sgpapi.entite.CoordonneesBancaires;
import dev.sgpapi.exception.ItemNotFoundException;
import dev.sgpapi.repository.CollaborateurRepository;

@RestController
public class CollaborateurApiController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;

	@GetMapping("/api/collaborateurs")
	public List<Collaborateur> listerCollaborateurs() {
		return this.collaborateurRepository.findAll();
	}

	/*
	 * @GetMapping("/api/collaborateurs") public List<Collaborateur>
	 * findCollaborateurByDepartementId(@RequestParam("departement") Integer id)
	 * {
	 * 
	 * return this.collaborateurRepository.findAll().stream() .filter(collab ->
	 * collab.getDepartement().getId().equals(id)).collect(Collectors.toList());
	 * 
	 * }
	 */

	// GET /api/collaborateurs?departement=[ID_DEPARTEMENT]

	@GetMapping("/api/collaborateurs/{collaborateurMatricule}")
	public Collaborateur findCollaborateur(@PathVariable String collaborateurMatricule) throws ItemNotFoundException {

		if (this.collaborateurRepository.findByMatricule(collaborateurMatricule) == null) {
			throw new ItemNotFoundException();
		}

		return this.collaborateurRepository.findByMatricule(collaborateurMatricule);
	}

	@PutMapping("/api/collaborateurs/{collaborateurMatricule}")
	public void majCollaborateur(@PathVariable String collaborateurMatricule, @RequestBody Collaborateur collaborateur)
			throws ItemNotFoundException {

		if (this.collaborateurRepository.findByMatricule(collaborateurMatricule) == null) {
			throw new ItemNotFoundException();
		}

		collaborateur.setId(this.collaborateurRepository.findByMatricule(collaborateurMatricule).getId());
		this.collaborateurRepository.save(collaborateur);
	}

	@GetMapping("/api/collaborateurs/{collaborateurMatricule}/banque")
	public CoordonneesBancaires findCollaborateurCoordoBancaires(@PathVariable String collaborateurMatricule)
			throws ItemNotFoundException {

		if (this.collaborateurRepository.findByMatricule(collaborateurMatricule) == null) {
			throw new ItemNotFoundException();
		}

		return this.collaborateurRepository.findByMatricule(collaborateurMatricule).getCoordonneesBancaires();
	}

	@PutMapping("/api/collaborateurs/{collaborateurMatricule}/banque")
	public void majCoordonnesBancaires(@PathVariable String collaborateurMatricule,
			@RequestBody CoordonneesBancaires coordonneesBancaires) throws ItemNotFoundException {

		Collaborateur collaborateur = this.collaborateurRepository.findByMatricule(collaborateurMatricule);
		if (collaborateur == null) {
			throw new ItemNotFoundException();
		}

		collaborateur.setCoordonneesBancaires(coordonneesBancaires);
		this.collaborateurRepository.save(collaborateur);
	}
}
