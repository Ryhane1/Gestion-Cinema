import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SeanceDAO {

public void ajouterSeance(Seance seance) {
    String sql = "INSERT INTO seance(Film_ID, Horaire, Salle, Capacite_Max, spectateursInscrits) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        stmt.setInt(1, seance.getFilm_ID());
        stmt.setTimestamp(2, seance.getHoraire());
        stmt.setInt(3, seance.getSalle());
        stmt.setInt(4, seance.getCapacite_Max());
        stmt.setInt(5, seance.getSpectateursInscrits());

        stmt.executeUpdate();


        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            seance.setSeance_ID(rs.getInt(1));
        }

        System.out.println("Séance ajoutée avec succès ! ID = " + seance.getSeance_ID());
    } catch (SQLException e) {
        System.out.println("Erreur lors de l'ajout de la séance");
        e.printStackTrace();
    }
}



    public Seance getSeanceById(int id) {
        String sql = "SELECT * FROM seance WHERE Seance_ID = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Seance(
                        rs.getInt("Seance_ID"),
                        rs.getInt("Film_ID"),
                        rs.getTimestamp("Horaire"),
                        rs.getInt("Salle"),
                        rs.getInt("Capacite_Max"),
                        rs.getInt("spectateursInscrits")
                );
            } else {
                System.out.println("Séance non trouvée !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération de la séance");
            e.printStackTrace();
        }
        return null;
    }


    public List<Seance> getAllSeance() {
        List<Seance> seances = new ArrayList<>();
        String sql = "SELECT * FROM seance";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                seances.add(new Seance(
                        rs.getInt("Seance_ID"),
                        rs.getInt("Film_ID"),
                        rs.getTimestamp("Horaire"),
                        rs.getInt("Salle"),
                        rs.getInt("Capacite_Max"),
                        rs.getInt("spectateursInscrits")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des séances");
            e.printStackTrace();
        }

        return seances;
    }
}
