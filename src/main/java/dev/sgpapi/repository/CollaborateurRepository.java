package dev.sgpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpapi.entite.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, Integer> {

}
