package hello.controller;
import hello.models.*;

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


@RestController
public class SportController {
  private List<Sport> sporturi = new ArrayList<Sport>();

  SportController() {
	  Sport s1 = new Sport(1, "Fotbal");
	  Sport s2 = new Sport(2, "Baschet");
	  Sport s3 = new Sport(3, "Tenis");

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
    for(Sport s : this.sporturi) {
      if(s.getId() == id) {
        return new ResponseEntity<Sport>(s, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/sport/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Sport s : this.sporturi) {
      if(s.getId() == id) {
        this.sporturi.remove(s);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  
  // POST 
  @RequestMapping(value="sport/{id}/{name}",method = RequestMethod.POST)
  public ResponseEntity addSport(@PathVariable("id") int id,
		  						 @PathVariable("name")String name){
	  Sport s1 = new Sport(id,name);
	  sporturi.add(s1);
	  return new ResponseEntity<Sport>(s1 ,new HttpHeaders(),HttpStatus.OK);
  }
    
  
  @RequestMapping(value="/sport/{id}", method = RequestMethod.PUT)
  public ResponseEntity putFilm(@PathVariable("id") int id){
    for(Sport s : this.sporturi) {
    if(s.getId() == id) {
    s.setName("Snooker");
    return new ResponseEntity<Sport>(s, new HttpHeaders(), HttpStatus.OK);
  }
}
  return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
}
  
}