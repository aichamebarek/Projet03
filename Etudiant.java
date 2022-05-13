package petudiants;

import java.sql.Date;

/**
 * Classe Etudiant
 *
 * @author A Mebarek
 *
 */
public class Etudiant implements Comparable<Etudiant> {

	protected Identite infos;
	protected Date dateInscr;
	protected double frais; // frais semestriel;

	// constructeurs
	public Etudiant() {
		this(new Identite(), "9999-01-01", 0.0);
	}

	public Etudiant(Identite infos, String date) {
		setInfos(infos);
		setDateInscr(Date.valueOf(date));
		setFrais(0.0); // pas de frais par d�faut
	}

	public Etudiant(Identite infos, String date, double frais) {
		setInfos(infos);
		setDateInscr(Date.valueOf(date));
		setFrais(frais);
	}

	/************* get-set ******************/
	public Identite getInfos() {
		return infos;
	}

	public void setInfos(Identite infos) {
		this.infos = infos;
	}

	public double getFrais() {
		return frais;
	}

	public void setFrais(double frais) {
		this.frais = frais;
	}

	public void setDateInscr(Date dateInscr) {
		this.dateInscr = (dateInscr);
	}

	public Date getDateInscr() {
		return dateInscr;
	}

	@Override
	public String toString() {
		return infos + "\t" + dateInscr + "\t" + String.format("%.2f $", frais);
	}

	public double calculerFrais() {
		return frais;
	}

	/**
	 * Augmente les frais d'un taux donn�
	 *
	 * @param taux
	 */
	public void augmenterFrais(double taux) {
		if (taux > 0) {
			frais = frais * (1 + taux / 100);
		} else {
			throw new IllegalArgumentException("taux invalide: taux > 0");
		}
	}

	@Override
	public int compareTo(Etudiant autre) {
		// TODO Auto-generated method stub
		return infos.compareTo(autre.infos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((infos == null) ? 0 : infos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Etudiant other = (Etudiant) obj;
		if (infos == null) {
			if (other.infos != null) {
				return false;
			}
		} else if (!infos.equals(other.infos)) {
			return false;
		}
		return true;
	}

} // fin Etudiant
