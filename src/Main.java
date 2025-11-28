//import java.sql.Timestamp;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        // Création de la DAO pour les séances
//        SeanceDAO dao = new SeanceDAO();
//
//        // --- 1. Ajouter une nouvelle séance ---
//        // Film_ID doit exister dans la table film
//        Seance nouvelleSeance = new Seance(
//                0,
//                3,
//                Timestamp.valueOf("2025-11-26 18:00:00"),
//                4,
//                80,
//                100
//        );
//
//        dao.ajouterSeance(nouvelleSeance);
//
//
//
//        Seance seanceRecup = dao.getSeanceById(1);
//        if (seanceRecup != null) {
//            System.out.println("Séance récupérée par ID : "
//                    + seanceRecup.getSeance_ID()
//                    + ", Film ID : " + seanceRecup.getFilm_ID()
//                    + ", Horaire : " + seanceRecup.getHoraire()
//                    + ", Salle : " + seanceRecup.getSalle()
//                    + ", Capacité max : " + seanceRecup.getCapacite_Max()
//                    + ", Spectateurs inscrits : " + seanceRecup.getSpectateursInscrits()
//            );
//        } else {
//            System.out.println("Aucune séance trouvée avec l'ID spécifié.");
//        }
//
//        //  Récupérer toutes les séances
//        List<Seance> toutesSeances = dao.getAllSeance();
//        System.out.println("\nListe de toutes les séances :");
//        for (Seance seance : toutesSeances) {
//            System.out.println("ID : " + seance.getSeance_ID()
//                    + ", Film ID : " + seance.getFilm_ID()
//                    + ", Horaire : " + seance.getHoraire()
//                    + ", Salle : " + seance.getSalle()
//                    + ", Capacité max : " + seance.getCapacite_Max()
//                    + ", Spectateurs inscrits : " + seance.getSpectateursInscrits()
//            );
//        }
//    }
//}
