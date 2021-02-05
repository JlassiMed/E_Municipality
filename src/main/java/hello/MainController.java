package hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {

    private final Logger log= LoggerFactory.getLogger(Admin.class);

    @Autowired
    private  AdminRepository adminrepository;
    @Autowired
    private  ActualiteRepository actualiteRepository;
    @Autowired
    private  CertificatRepository certificatRepository;
    @Autowired
    private  CitoyenRepository citoyenRepository;
    @Autowired
    private  PieceJointeRepository pieceJointeRepository;
    @Autowired
    private  ReclamationRepository reclamationRepository;


    public MainController(AdminRepository repository,ActualiteRepository actualiteRepository,CertificatRepository certificatRepository,CitoyenRepository citoyenRepository,PieceJointeRepository pieceJointeRepository,ReclamationRepository reclamationRepository) {
        this.adminrepository = repository;
        this.actualiteRepository = actualiteRepository;
        this.certificatRepository = certificatRepository;
        this.citoyenRepository = citoyenRepository;
        this.pieceJointeRepository = pieceJointeRepository;
        this.reclamationRepository = reclamationRepository;
    }



        @GetMapping("/loginadmin/{login}/{password}")

        public Admin loginadmin(@PathVariable("login") String login,@PathVariable("password") String password)
        {
           Admin a1=new Admin();
           List<Admin> admin=adminrepository.findAll().stream().filter(x ->x.getLogin_admin().equals(login) && x.getPassword_admin().equals(password)).collect(Collectors.toList());
          if(admin.isEmpty())
           return a1;
          else
          {
            a1=admin.get(0);
            return a1;
          }

        }
    @GetMapping("/logincitoyen/{login}/{password}")

    public Citoyen logincitoyen(@PathVariable("login") String login,@PathVariable("password") String password)
    {
        Citoyen a1=new Citoyen();
        List<Citoyen> admin=citoyenRepository.findAll().stream().filter(x ->x.getLogin_cit().equals(login) && x.getPassword_cit().equals(password)).collect(Collectors.toList());
        if(admin.isEmpty())
            return a1;
        else
        {
            a1=admin.get(0);
            return a1;
        }
    }






        @PostMapping(path="/newcitoyen")
        public  ResponseEntity<Citoyen> newcitoyen(@Valid @RequestBody String login_cit,
                                                   @Valid @RequestBody String password_cit,
                                                   @Valid @RequestBody String nom_cit,
                                                   @Valid @RequestBody String prenom_cit,
                                                   @Valid @RequestBody String photo_cit,
                                                   @Valid @RequestBody String date_naiss,
                                                   @Valid @RequestBody String fonction_cit,
                                                   @Valid @RequestBody String adresse_cit
                                                   ) throws URISyntaxException
        {
            Citoyen citoyen= new Citoyen();
            citoyen.setPrenom_cit(prenom_cit);
            citoyen.setLogin_cit(login_cit);
            citoyen.setNom_cit(nom_cit);
            citoyen.setPhoto_cit(photo_cit);
            citoyen.setPassword_cit(password_cit);
            citoyen.setDate_naiss(date_naiss);
            citoyen.setFonction_cit(fonction_cit);
            citoyen.setAdresse_cit(adresse_cit);
            log.info("Request for adding new admin {}",citoyen);
            Citoyen result = citoyenRepository.save(citoyen);
            return ResponseEntity.created(new URI("/newcitoyen"+result.getNom_cit())).body(result);
        }
    @GetMapping(path="/newactualite/{titre}/{contenu}")
    public  ResponseEntity<Actualite> newActualite(@PathVariable("titre") String titre,
                                                   @PathVariable("contenu") String contenu
                                                   ) throws URISyntaxException
    {
        Actualite actualite= new Actualite();
        actualite.setContenu(contenu);
        actualite.setTitre(titre);

        //actualite.setAdmin(adminrepository.findById((long)2));
        log.info("Request for adding new actualite {}",actualite);
        Actualite result = actualiteRepository.save(actualite);
        return ResponseEntity.created(new URI("/newactualite"+result.getTitre())).body(result);
    }


       @GetMapping("/listcertificat")

        public Collection<Certificat> listCertificat(){
            return certificatRepository.findAll();
        }
    @GetMapping("/listactualite")

    public Collection<Actualite> listactualite(){
        return actualiteRepository.findAll();
    }



        @GetMapping("/listreclamation")

        public Collection<Reclamation> allToys(){
            return reclamationRepository.findAll();
        }


    @PostMapping(path="/newcertificat")
    public  ResponseEntity<Certificat> newcertificat(@Valid @RequestBody String type_Certif,
                                                     @Valid @RequestBody String pdf_certif,
                                                     @Valid @RequestBody Citoyen citoyen
                                                    ) throws URISyntaxException
    {
        Certificat certificat = new Certificat();
        certificat.setPdf_certif(pdf_certif);
        certificat.setType_Certif(type_Certif);
        certificat.setCitoyen(citoyen);
        log.info("Request for adding new admin {}",certificat);
        Certificat result = certificatRepository.save(certificat);
        return ResponseEntity.created(new URI("/newcertificat"+result.getId_certif())).body(result);
    }
    @PostMapping(path="/newreclamation")
    public  ResponseEntity<Reclamation> newreclamation(@Valid @RequestBody String details,
                                                       @Valid @RequestBody String titre,
                                                       @Valid @RequestBody String typeFichier,
                                                       @Valid @RequestBody byte[] piecejointe,
                                                       @Valid @RequestBody Citoyen citoyen
                                                       ) throws URISyntaxException
    {
        Reclamation reclamation = new Reclamation();
        reclamation.setDetails(details);
        reclamation.setTitre(titre);
        reclamation.setTypeFichier(typeFichier);
        reclamation.setPiece_jointe(piecejointe);
        reclamation.setCitoyen(citoyen);
        log.info("Request for adding new admin {}",reclamation);
        Reclamation result = reclamationRepository.save(reclamation);
        return ResponseEntity.created(new URI("/newreclamation"+result.getCode_rec())).body(result);
    }
    @PostMapping(path="/newpieceJointe")
    public  ResponseEntity<PieceJointe> newPieceJointe(@Valid @RequestBody String type_pj,
                                                       @Valid @RequestBody byte[] fichier_pj,
                                                       @Valid @RequestBody Reclamation reclamation) throws URISyntaxException
    {
        PieceJointe pieceJointe= new PieceJointe();
        pieceJointe.setFichier_pj(fichier_pj);
        pieceJointe.setType_pj(type_pj);
        pieceJointe.setReclamation(reclamation);
        log.info("Request for adding new admin {}",pieceJointe);
        PieceJointe result = pieceJointeRepository.save(pieceJointe);
        return ResponseEntity.created(new URI("/newpieceJointe"+result.getId_pj())).body(result);
    }

    @GetMapping("/listadmin")
    public Collection<Admin> listadmin(){
        return adminrepository.findAll();
    }
    @GetMapping("/listcitoyen")
    public Collection<Citoyen> listcitoyen(){
        return citoyenRepository.findAll();
    }



    @PutMapping("/updatecitoyen/{id}")

    public  ResponseEntity<Citoyen> updatecitoyen(@Valid @RequestBody long id,
                                                  @Valid @RequestBody String Nom,
                                                  @Valid @RequestBody String Prenom,
                                                  @Valid @RequestBody String Adresse,
                                                  @Valid @RequestBody String Date_naiss,
                                                  @Valid @RequestBody String Fonction,
                                                  @Valid @RequestBody String Login,
                                                  @Valid @RequestBody String Password,
                                                  @Valid @RequestBody String Photo)
    {
        log.info("Request for updating new citoyen {}", id);

        Optional<Citoyen> citoyenOptional = citoyenRepository.findById(id);

        if (!citoyenOptional.isPresent())
            return ResponseEntity.notFound().build();

        Citoyen toy1=citoyenOptional.get();
        toy1.setCode_cit(id);
        toy1.setNom_cit(Nom);
        toy1.setAdresse_cit(Adresse);
        toy1.setDate_naiss(Date_naiss);
        toy1.setFonction_cit(Fonction);
        toy1.setLogin_cit(Login);
        toy1.setPassword_cit(Password);
        toy1.setPhoto_cit(Photo);
        toy1.setPrenom_cit(Prenom);





        // repository.deleteById(id); //with this a new id will be generated
        Citoyen result=citoyenRepository.save(toy1);

        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(result);
//        Toy toyCopy = new Toy();
//        BeanUtils.copyProperties(toy, toyCopy);
//        ToyService.updateToy(toy);
//
//        Toy ob = new Toy();
//        BeanUtils.copyProperties(toyCopy, ob);
//        return new ResponseEntity<Toy>(ob, HttpStatus.OK);
//
//
//        BeanUtils.copyProperties(toy, toyc);
//        Toy result = repository.save(toy);
//        return ResponseEntity.ok().body(result);
    }





/*









/*   @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }


   /* @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
	*/





   /*

	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	*/
}
