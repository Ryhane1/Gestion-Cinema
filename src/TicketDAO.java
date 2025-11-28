import java.sql.*;
import java.util.ArrayList;

public class TicketDAO {

    // Ajouter un ticket
    public void addTicket(Ticket t) throws Exception {
        Connection conn = Database.getConnect();
        String sql = "INSERT INTO Ticket VALUES ( ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, t.getId());
        ps.setInt(2, t.getSeanceId());
        ps.setInt(3, t.getSpectateurId());
        ps.setDouble(4, t.getPrix());

        ps.executeUpdate();
        conn.close();
    }
    

    // Modifier un ticket
    public void updateTicket(Ticket t) throws Exception {
        Connection conn = Database.getConnect();
        String sql = "UPDATE Ticket SET Seance_ID=?, Spectateur_ID=?, Prix=? WHERE Ticket_ID=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, t.getSeanceId());
        ps.setInt(2, t.getSpectateurId());
        ps.setDouble(3, t.getPrix());
        ps.setInt(4, t.getId());

        ps.executeUpdate();
        conn.close();
    }

    // Supprimer un ticket
    public void deleteTicket(int id) throws Exception {
        Connection conn = Database.getConnect();
        String sql = "DELETE FROM Ticket WHERE Ticket_ID=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();
        conn.close();
    }

    // Afficher tous les tickets
    public ArrayList<Ticket> getAllTickets() throws Exception {
        Connection conn = Database.getConnect();
        String sql = "SELECT * FROM Ticket";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Ticket> tickets = new ArrayList<>();

        while (rs.next()) {
            tickets.add(new Ticket(
                    rs.getInt("Ticket_ID"),
                    rs.getInt("Seance_ID"),
                    rs.getInt("Spectateur_ID"),
                    rs.getDouble("Prix")
            ));
        }

        conn.close();
        return tickets;
    }
}
