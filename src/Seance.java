import java.sql.Timestamp;

public class Seance {
    private int Seance_ID;
    private int Film_ID;
    private Timestamp Horaire;
    private int Salle;
    private int Capacite_Max;
    private int spectateursInscrits;


    public Seance(int seance_ID, int film_ID, Timestamp horaire, int salle, int capacite_Max, int spectateursInscrits){
        this.Seance_ID = seance_ID;
        this.Film_ID = film_ID;
        this.Horaire = horaire;
        this.Salle = salle;
        this.Capacite_Max = capacite_Max;
        this.spectateursInscrits = spectateursInscrits;
    }


    public int getSeance_ID() { return Seance_ID; }
    public int getFilm_ID() { return Film_ID; }
    public Timestamp getHoraire() { return Horaire; }
    public int getSalle() { return Salle; }
    public int getCapacite_Max() { return Capacite_Max; }
    public int getSpectateursInscrits() { return spectateursInscrits; }


    public void setSeance_ID(int seance_ID) { this.Seance_ID = seance_ID; }
    public void setFilm_ID(int film_ID) { this.Film_ID = film_ID; }
    public void setHoraire(Timestamp horaire) { this.Horaire = horaire; }
    public void setSalle(int salle) { this.Salle = salle; }
    public void setCapacite_Max(int capacite_Max) { this.Capacite_Max = capacite_Max; }
    public void setSpectateursInscrits(int spectateursInscrits) { this.spectateursInscrits = spectateursInscrits; }

    public void afficherSeance() {
        System.out.println("Nouvelle ajouter ");
    }
    public void supprimerSeance(int index) {
        if (index >= 0 && index < seances.size()) {
            String seanceSupprimee = seances.remove(index);
            System.out.println("Séance supprimée : " + seanceSupprimee);
        } else {
            System.out.println("Index invalide, impossible de supprimer.");
        }
    }
    @Override
    public String toString() {
        return "Seance{" +
                "Seance_ID=" + Seance_ID +
                ", Film_ID=" + Film_ID +
                ", Horaire=" + Horaire +
                ", Salle=" + Salle +
                ", Capacite_Max=" + Capacite_Max +
                ", spectateursInscrits=" + spectateursInscrits +
                '}';
    }
}
