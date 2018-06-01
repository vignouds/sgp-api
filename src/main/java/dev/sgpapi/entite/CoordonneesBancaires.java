package dev.sgpapi.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CoordonneesBancaires {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nomBanque;
	@Column
	private String iban;
	@Column
	private String bic;

	public CoordonneesBancaires() {
	}

	public CoordonneesBancaires(String nomBanque, String iban, String bic) {
		this.nomBanque = nomBanque;
		this.iban = iban;
		this.bic = bic;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomBanque() {
		return nomBanque;
	}

	public void setNomBanque(String nomBanque) {
		this.nomBanque = nomBanque;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

}
