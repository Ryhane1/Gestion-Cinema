import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn = DbConnection.getConnection();
        if(conn == null){
            System.out.println("Connection Failed!");
        }else {
            System.out.println("Connected Successfully!");
        }
        Scanner sc = new Scanner(System.in);

        System.out.print("Nom film: ");
        String titre = sc.nextLine();

        System.out.print("Duree (b hours): ");
        int duree = sc.nextInt();
        sc.nextLine();

        System.out.print("Categorie: ");
        String categorie = sc.nextLine();

        Film filmInput = new Film(titre, duree, categorie);
        FilmDAO dao = new FilmDAO();
        dao.addFilm(filmInput);

        System.out.println("Film add Successfully!");

        List<Film> film = dao.getAllFilms();
        for (Film films : film) {
            System.out.println("Titre: " + films.getTitre());
            System.out.println("Duree: " + films.getDuree()+ " h");
            System.out.println("Categorie: " + films.getCategorie());
            System.out.println("---------------------------");
        }



    }
}