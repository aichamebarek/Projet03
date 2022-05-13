package petudiants;

public class Identite {
	// atributs
	private String prenom;
	private String nomFamille;
	private String noDossier;

	// Constructeurs
	public Identite() {
		this("", "", "");
	}

	public Identite(String prenom, String nomF, String noDossier) {
		setNomFamille(nomF);
		setPrenom(prenom);
		setNoDossier(noDossier);
	}

	public Identite(String infos) {
		String[] morceaux = infos.split("[,]");
		setPrenom(morceaux[0].trim());
		setNomFamille(morceaux[1].trim());
		setNoDossier(morceaux[2].trim());

	}

	/***************** 8get-set ********************/
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomFamille() {
		return nomFamille;
	}

	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}

	public String getNoDossier() {
		return noDossier;
	}

	public void setNoDossier(String noDossier) {
		this.noDossier = noDossier;
	}

	@Override
	public String toString() {
		String message = "";
		if (prenom != null) {
			message += prenom + ", ";
		}
		if (nomFamille != null) {
			message += nomFamille + ", ";
		}
		if (noDossier != null) {
			message += noDossier;
		}
		return message;
	}

	/**
	 * @param infos
	 * @return
	 */
	public int compareTo(Identite infos) {
		// TODO Auto-generated method stub
		return noDossier.compareTo(infos.noDossier);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noDossier == null) ? 0 : noDossier.hashCode());
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
		Identite other = (Identite) obj;
		if (noDossier == null) {
			if (other.noDossier != null) {
				return false;
			}
		} else if (!noDossier.equals(other.noDossier)) {
			return false;
		}
		return true;
	}

}// fin Identite
