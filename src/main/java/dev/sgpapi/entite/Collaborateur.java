package dev.sgpapi.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Collaborateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String matricule;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private LocalDate dateNaissance;
	@Column
	private String adresse;
	@Column
	private String numeroSS;
	@Column
	private String emailPro;
	@Column
	private String photo;
	@Column
	private boolean actif;
	@ManyToOne
	private Departement departement;
	@Embedded
	private CoordonneesBancaires coordonneesBancaires;

	public Collaborateur() {

	}

	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateNaissance, String adresse,
			String numeroSS, String emailPro, String photo, boolean actif, Departement departement,
			CoordonneesBancaires coordonneesBancaires) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.numeroSS = numeroSS;
		this.emailPro = emailPro;
		this.photo = photo;
		this.actif = actif;
		this.departement = departement;
		this.coordonneesBancaires = coordonneesBancaires;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumeroSS() {
		return numeroSS;
	}

	public void setNumeroSS(String numeroSS) {
		this.numeroSS = numeroSS;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public CoordonneesBancaires getCoordonneesBancaires() {
		return coordonneesBancaires;
	}

	public void setCoordonneesBancaires(CoordonneesBancaires coordonneesBancaires) {
		this.coordonneesBancaires = coordonneesBancaires;
	}

}
