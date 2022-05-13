package petudiants;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

public class College {
	// atrributs
	public static final int NB_ETUD = 200;
	private String nom;
	// private Etudiant tabEtudiants[];
	private ArrayList<Etudiant> listeEtudiants;
	// private int nbEtudiants;

	public College() {
		this("");
	}

	public College(String nom) {
		this.nom = nom;
		listeEtudiants = new ArrayList<>();
		// this.listeEtudiants = new Etudiant[NB_ETUD];
	}

	/**
	 * Ajoute nouvel etudiant
	 *
	 * @param etud
	 */
	public void ajouterEtudiant(Etudiant etud) {
		if (etud != null && listeEtudiants.size() < NB_ETUD) {
			// listeEtudiants[nbEtudiants] = etud;
			// nbEtudiants++;
			listeEtudiants.add(etud);
		}
	}

	/**
	 * Augmenter les frais des �tudiants pr type
	 *
	 * @param taux
	 * @return
	 */
	public void augmenterFrais(double taux) {
		for (int i = 0; i < listeEtudiants.size(); i++) {
			// (tabEtudiants[i]).augmenterFrais(taux);
			Etudiant etudi = listeEtudiants.get(i);
			etudi.augmenterFrais(taux);
		} // fin for
	}

	/**
	 * pour afficher la liste des etudiants
	 *
	 */
	@Override
	public String toString() {
		String message = "";
		for (Etudiant etud : listeEtudiants) {
			message += etud.toString() + "\n";
		}
		message += "\n\tTotal des frais : " + String.format("%.1f $", totalFrais());
		return message;
	}

	/**
	 * recherche par annee d'inscription
	 *
	 * @param annee(int)
	 * @return String
	 */
	public String rapport(int annee) {
		String message = "";
		for (Etudiant etud : listeEtudiants) {
			Date dateEtud = etud.getDateInscr();
			int an = dateEtud.toLocalDate().getYear();
			if (an == annee) {
				message += etud.toString() + "\n";
			}
		} // fin while
		if (message.isEmpty()) {
			return "Aucun Etudiant inscrit � cette date";
		} else {
			return "\n" + message;
		}
	}

	/**
	 * Total des frais du college
	 *
	 * @return double
	 */
	public double totalFrais() {
		double somme = 0;
		for (Etudiant etud : listeEtudiants) {
			somme += etud.calculerFrais();
		}

		return somme;
	}

	/**
	 * retourne le nombre d'�tudiants
	 *
	 * @return int
	 */
	public int getNbEtudiants() {
		return listeEtudiants.size();
	}

	/**
	 * trier les etudiants par nom de famille
	 */
	public void trier() {
		// Utils.trier(listeEtudiants);
		Collections.sort(listeEtudiants);
	}

	// recherche dUn etudiant par code
	public Etudiant getEtudiant(String code) {
		int i = Utils.recherSeq(listeEtudiants, code);
		return listeEtudiants.get(i);
	}

	// get-set
	public Etudiant getEtudiant(int i) {
		return listeEtudiants.get(i);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setEtudiant(Etudiant etud, int i) {
		listeEtudiants.set(i, etud);
	}

	public ArrayList<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(ArrayList<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

	public int getNbEtud() {
		return listeEtudiants.size();
	}

}
