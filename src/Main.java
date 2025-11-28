import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        TicketDAO tdao = new TicketDAO();

        System.out.println("\n===== MENU TICKET =====");
        System.out.println("1. Ajouter un ticket");
        System.out.println("2. Modifier un ticket");
        System.out.println("3. Supprimer un ticket");
        System.out.println("4. Afficher tous les tickets");
        System.out.print("Choix : ");
        int choix = input.nextInt(); input.nextLine();

        switch(choix) {

            case 1:
                System.out.print("ID Ticket : ");
                int tid = input.nextInt(); input.nextLine();

                System.out.print("ID Seance : ");
                int sid = input.nextInt(); input.nextLine();

                System.out.print("ID Spectateur : ");
                int spid = input.nextInt(); input.nextLine();

                System.out.print("Prix du ticket : ");
                double prix = input.nextDouble(); input.nextLine();

                tdao.addTicket(new Ticket( tid ,sid, spid, prix));
                System.out.println("✔ Ticket ajouté !");
                break;

            case 2:
                System.out.print("ID Ticket à modifier : ");
                int tidm = input.nextInt(); input.nextLine();

                System.out.print("Nouvelle ID Seance : ");
                int nsid = input.nextInt(); input.nextLine();

                System.out.print("Nouvelle ID Spectateur : ");
                int nspid = input.nextInt(); input.nextLine();

                System.out.print("Nouveau prix : ");
                double nprix = input.nextDouble(); input.nextLine();

                tdao.updateTicket(new Ticket(tidm, nsid, nspid, nprix));
                System.out.println("✔ Ticket modifié !");
                break;

            case 3:
                System.out.print("ID Ticket à supprimer : ");
                int tids = input.nextInt(); input.nextLine();
                tdao.deleteTicket(tids);
                System.out.println("✔ Ticket supprimé !");
                break;

            case 4:
                System.out.println("\n===== LISTE DES TICKETS =====");
                for (Ticket t : tdao.getAllTickets()) {
                    System.out.println(t);
                }
                break;

            default:
                System.out.println("❌ Choix invalide !");
        }
    }
}