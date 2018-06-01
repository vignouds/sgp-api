package dev.sgpapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpapi.entite.Collaborateur;
import dev.sgpapi.repository.CollaborateurRepository;

@RestController
@RequestMapping("/api/collaborateurs")
public class CollaborateurApiController {

	@Autowired
	private CollaborateurRepository collaborateurRepository;

	@GetMapping
	public List<Collaborateur> listerCollaborateurs() {
		return this.collaborateurRepository.findAll();
	}
}
