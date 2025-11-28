
    public class Ticket {
        private int id;
        private int seanceId;
        private int spectateurId;
        private double prix;

        public Ticket(int id, int seanceId, int spectateurId, double prix) {
            this.id = id;
            this.seanceId = seanceId;
            this.spectateurId = spectateurId;
            this.prix = prix;
        }

        public int getId() { return id; }
        public int getSeanceId() { return seanceId; }
        public int getSpectateurId() { return spectateurId; }
        public double getPrix() { return prix; }

        @Override
        public String toString() {
            return "Ticket " + id +
                    " | Seance=" + seanceId +
                    " | Spectateur=" + spectateurId +
                    " | Prix=" + prix + " DH";
        }
    }


