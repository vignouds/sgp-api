package dev.sgpapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpapi.entite.Collaborateur;
import dev.sgpapi.entite.CoordonneesBancaires;
import dev.sgpapi.exception.ItemNotFoundException;
import dev.sgpapi.repository.CollaborateurRepository;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurApiController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;

	@CrossOrigin
	@GetMapping
	public List<Collaborateur> listerCollaborateurs() {
		return this.collaborateurRepository.findAll();
	}

	@CrossOrigin
	@GetMapping(params = "departement")
	public List<Collaborateur> findCollaborateurByDepartementId(@RequestParam("departement") Integer id) {

		return this.collaborateurRepository.findAll().stream()
				.filter(collab -> collab.getDepartement().getId().equals(id)).collect(Collectors.toList());
	}

	@CrossOrigin
	@GetMapping("/{collaborateurMatricule}")
	public Collaborateur findCollaborateur(@PathVariable String collaborateurMatricule) throws ItemNotFoundException {

		if (this.collaborateurRepository.findByMatricule(collaborateurMatricule) == null) {
			throw new ItemNotFoundException();
		}

		return this.collaborateurRepository.findByMatricule(collaborateurMatricule);
	}

	@CrossOrigin
	@PutMapping("/{collaborateurMatricule}")
	public void majCollaborateur(@PathVariable String collaborateurMatricule, @RequestBody Collaborateur collaborateur)
			throws ItemNotFoundException {

		if (this.collaborateurRepository.findByMatricule(collaborateurMatricule) == null) {
			throw new ItemNotFoundException();
		}

		collaborateur.setId(this.collaborateurRepository.findByMatricule(collaborateurMatricule).getId());
		this.collaborateurRepository.save(collaborateur);
	}

	@CrossOrigin
	@GetMapping("/{collaborateurMatricule}/banque")
	public CoordonneesBancaires findCollaborateurCoordoBancaires(@PathVariable String collaborateurMatricule)
			throws ItemNotFoundException {

		if (this.collaborateurRepository.findByMatricule(collaborateurMatricule) == null) {
			throw new ItemNotFoundException();
		}

		return this.collaborateurRepository.findByMatricule(collaborateurMatricule).getCoordonneesBancaires();
	}

	@CrossOrigin
	@PutMapping("/{collaborateurMatricule}/banque")
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
