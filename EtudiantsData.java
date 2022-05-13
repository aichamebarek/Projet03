package petudiants;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class EtudiantsData {

	public enum TypeAcces {
		Open, Save
	}

	public static String path = "./resources/Ahuntsic.txt";

	/************************ Fichiers Texte ***************/

	public static void charger(College col) {

		String ligne;
		Etudiant etud = null;
		path = selectionFichier(TypeAcces.Open);
		try (BufferedReader fichier = new BufferedReader(new FileReader(path));) {
			ligne = fichier.readLine();
			while (ligne != null && col.getNbEtudiants() < College.NB_ETUD) {
				StringTokenizer str = new StringTokenizer(ligne, "[\t]");
				//// extraire donneees d'Etudiant
				Identite infos = new Identite(str.nextToken());
				String date = str.nextToken();// LocalDate.parse(morceaux[1]);
				double frais = Double.parseDouble(str.nextToken());
				// System.out.println("frais : " + frais );
				if (!str.hasMoreTokens()) {
					// Etudiant a temps plein
					etud = new Etudiant(infos, date, frais);
				} else {// Etudiant Partiel
					int heures = Integer.parseInt(str.nextToken());
					etud = new EtudiantPartiel(infos, date, frais, heures);
				}
				col.ajouterEtudiant(etud);
				// lire ligne suivante
				ligne = fichier.readLine();
			}
		} catch (IOException ex) {
			System.out.println("Une erreur s'est produite en acc�dant au fichier " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	/************************ serialisation XML ***************/

	public static void enregistrerXML(College college) {
		path = selectionFichier(TypeAcces.Save);
		try (XMLEncoder writer = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)));) {
			writer.writeObject(college);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public static College chargerXML() {
		path = selectionFichier(TypeAcces.Open);
		College colCharge = null;
		try (XMLDecoder reader = new XMLDecoder(new FileInputStream(path));) {
			colCharge = (College) reader.readObject();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return colCharge;
	}

	public static String selectionFichier(TypeAcces type) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int result = 0;
		switch (type) {
		case Open:
			result = fileChooser.showOpenDialog(null);
			break;
		case Save:
			result = fileChooser.showSaveDialog(null);
		}
		if (result == JFileChooser.APPROVE_OPTION) {
			// retourne le path du fichier s�lectionn�
			return fileChooser.getSelectedFile().getPath();
		} else {
			return "./resources/Ahuntsic.xml";
		}
	}
}
