package dev.sgpapi.entite;

import javax.persistence.Embeddable;

@Embeddable
public class CoordonneesBancaires {

	private String nomBanque;
	private String iban;
	private String bic;

	public CoordonneesBancaires() {
	}

	public CoordonneesBancaires(String nomBanque, String iban, String bic) {
		this.nomBanque = nomBanque;
		this.iban = iban;
		this.bic = bic;
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
