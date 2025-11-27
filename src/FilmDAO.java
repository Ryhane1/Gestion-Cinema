import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmDAO {

    public void addFilm(Film film) {
        String sql = "INSERT INTO film (titre, duree, categorie) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, film.getTitre());
            stmt.setInt(2, film.getDuree());
            stmt.setString(3, film.getCategorie());

            stmt.executeUpdate();
            System.out.println("Film added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding film");
            e.printStackTrace();
        }
    }

    public List<Film> getAllFilms() {
        List<Film> films = new ArrayList<>();
        String sql = "SELECT * FROM film";

        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                films.add(new Film(
                        rs.getInt("Film_ID"),
                        rs.getString("Titre"),
                        rs.getInt("Duree"),
                        rs.getString("Categorie")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching films");
            e.printStackTrace();
        }

        return films;
    }
}
