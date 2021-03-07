package springboot1.webprog;

/*
import eriksommer.webprog.lagringserver.model.Motorvogn;
import eriksommer.webprog.lagringserver.repository.AppRepository;
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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

    @DeleteMapping("/film")
    public void slett() {
        repo.slettAlle();
    }
}
