package springboot1.webprog;

/*
import eriksommer.webprog.lagringserver.model.Motorvogn;
import eriksommer.webprog.lagringserver.repository.AppRepository;
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lagringserver/")
public class FilmController {

    @Autowired
    AppRespitory repo;

    @PostMapping("/film")
    public void lagre(film film) {
        repo.leggInn(film);
    }

    @GetMapping("/film")
    public ArrayList<film> hent() {
        return repo.hentAlle();
    }
    @GetMapping("hentFilmer")
    public List<film> hentFilmer() {
        List <film> listFilmer = new ArrayList<>();
        listFilmer.add(new film("Cinderella"));
        listFilmer.add(new film("A walk to remember"));
        listFilmer.add(new film("Spiderman"));
                listFilmer.add(new film("Superman"));
        listFilmer.add(new film("Toys tale"));
        listFilmer.add(new film("Hunter"));
        return listFilmer;
    }


    @DeleteMapping("/film")
    public void slett() {
        repo.slettAlle();
    }
}
