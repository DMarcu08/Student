package hello.controllers;
import hello.models.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


//Operatiile se efectueaza dupa nume
@RestController
public class SportController {
  private List<Sport> sporturi = new ArrayList<Sport>();

  SportController() {
    Sport s1 = new Sport(1, "Fotbal");
    Sport s2 = new Sport(2, "Baschet");
    Sport s3 = new Sport(3, "Handball");

    sporturi.add(s1);
    sporturi.add(s2);
    sporturi.add(s3);
  }

  @RequestMapping(value="/sport", method = RequestMethod.GET)
  public List<Sport> index() {
    return this.sporturi;
  }

  @RequestMapping(value="/sport/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Sport p : this.sporturi) {
      if(p.getId() == id) {
        return new ResponseEntity<Sport>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/sport/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Sport p : this.sporturi) {
      if(p.getId() == id) {
        this.sporturi.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


    @RequestMapping(value="/sport", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody Sport p) {
        sporturi.add(p);
        String numeSport = p.getName();
        for(Sport p_tmp : this.sporturi) {
            if(p_tmp.getName().equals(numeSport)) {
                return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

	
    @RequestMapping(value="/sport", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Sport p) {
        int idSport = p.getId();
        for(Sport p_tmp : this.sporturi) {
            if(p_tmp.getId()==(idSport)) {
                p_tmp.setId(p.getId());
                p_tmp.setName(p.getName());
				return new ResponseEntity<ArrayList<Sport>>((ArrayList<Sport>) sporturi, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
