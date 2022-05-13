package petudiants;
import java.util.*;

public class Utils {
	/**
	 * Tri d'un ArrayList par ordre croissant 
	 * des noms de famille
	 * @param ArrayList
	 */

	public static void trier(ArrayList<Etudiant> liste){
		int indMin;

		for (int i = 0; i < liste.size() - 1; i++ )  { 	
			indMin = i;
			for (int j = i + 1 ; j < liste.size()  ; j++ )	{
				String nomj=liste.get(j).getInfos().getNomFamille();
				String nomMin=liste.get(indMin).getInfos().getNomFamille();
				//comparer les deux noms
				if( nomj.compareTo(nomMin) < 0){ 
					indMin =  j;
				}//fin if
			}//finfor j

			if(  indMin !=  i  ) {	//permuter si nécessaire
				Etudiant temp=liste.get(i);
				liste.set(i, liste.get(indMin)); 
				liste.set(indMin, temp );

			}

		}//fin for(i)
	}
	/**
	 * Tri d'un tableau par ordre croissant 
	 * des noms de famille
	 * @param tab
	 */
	public static void trier(Etudiant[] tab, int nb) {

		int indMin;
		for(int i = 0; i < nb - 1; i++){
			indMin = i;

			for(int j = i + 1; j < nb; j++){
				if( tab[j].getInfos().getNomFamille().
						compareTo(tab[indMin].getInfos().getNomFamille()) < 0){ 
					indMin =  j;
				}	
			}

			if(  indMin !=  i  ) {	//permuter si nécessaire
				Etudiant	tempo1 = tab[i];
				tab[i] = tab[indMin];
				tab[indMin]=(tempo1);

			}
		}
	}
	
	/**
	 * Recherche séquentielle d'une valeur dans un ArrayList d'étudiants
	 * @param liste	- 
	 * @param valRech - valeur recherchée (String)
	 * @return - la position dans la liste
	 */
	public static int recherSeq(ArrayList<Etudiant> liste, String code) {
		boolean trouve = false;
		int posRech = -1;
		for (int i = 0; i < liste.size() && !trouve; i++) {
			Identite id = liste.get(i).getInfos();
			if (id.getNoDossier().equalsIgnoreCase(code)) {
				posRech = i;
			}
		} // fin for

		return posRech;
	}
	
}
