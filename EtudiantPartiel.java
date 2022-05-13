package petudiants;
/**classe EtudiantPartiel
  */


import java.text.*;

public class EtudiantPartiel  extends Etudiant {

      private int nbHeures; 

    //constructeurs
      public EtudiantPartiel(){super();}   
      
      public EtudiantPartiel(Identite infos, String date, double frais, int nbHeures) {
        super( infos, date, frais);
        setNbHeures(nbHeures);
      }

      public double calculerFrais() {
          return frais * nbHeures ;//frais horaire
      }
   
      public String toString() {
             return super.toString() + "\t" + String.format("%3dh",nbHeures) + "\t"  +
              String.format("%.1f $",calculerFrais());
      }

/**************get-set*********************/
    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }
    public int getNbHeures() {
        return nbHeures;
    }
}
