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

    @PostMapping("/motor")
    public void lagre(Motorvogn motorvogn) {
        repo.leggInn(motorvogn);
    }

    @GetMapping("/motor")
    public ArrayList<Motorvogn> hent() {
        return repo.hentAlle();
    }

    @DeleteMapping("/motor")
    public void slett() {
        repo.slettAlle();
    }
}
