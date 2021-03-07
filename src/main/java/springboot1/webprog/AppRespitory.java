package springboot1.webprog;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

    @Repository
    public class AppRespitory {
        private final ArrayList<film> filmliste = new ArrayList<>();

        public void leggInn(film film) {
            filmliste.add(film);
        }

        public ArrayList<film> hentAlle() {
            return filmliste;
        }

        public void slettAlle() {
            filmliste.clear();
        }
    }


