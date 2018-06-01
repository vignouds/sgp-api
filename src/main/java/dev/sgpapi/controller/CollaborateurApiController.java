package dev.sgpapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpapi.entite.Collaborateur;
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

	// PUT /api/collaborateurs/[MATRICULE]

	// GET /api/collaborateurs/[MATRICULE]/banque

	// PUT /api/collaborateurs/[MATRICULE]/banque

}
