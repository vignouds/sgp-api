package dev.sgpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.sgpapi.entite.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

}
