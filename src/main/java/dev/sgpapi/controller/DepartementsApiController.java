package dev.sgpapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.sgpapi.entite.Departement;
import dev.sgpapi.repository.DepartementRepository;

@RestController
@RequestMapping
public class DepartementsApiController {

	@Autowired
	DepartementRepository departementRepository;

	@GetMapping("/api/departements")
	public List<Departement> listerDepartements() {
		return this.departementRepository.findAll();
	}
}
