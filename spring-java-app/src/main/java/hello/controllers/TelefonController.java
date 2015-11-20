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
public class TelefonController {
  private List<Telefon> telefoane = new ArrayList<Telefon>();

  TelefonController() {
	  Telefon t1 = new Telefon(1, "Iphone");
	  Telefon t2 = new Telefon(2, "Samsung");
	  Telefon t3 = new Telefon(3, "Lenovo");

	  telefoane.add(t1);
	  telefoane.add(t2);
	  telefoane.add(t3);
  }

  @RequestMapping(value="/telefon", method = RequestMethod.GET)
  public List<Telefon> index() {
    return this.telefoane;
  }

  @RequestMapping(value="/telefon/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Telefon t : this.telefoane) {
      if(t.getId() == id) {
        return new ResponseEntity<Telefon>(t, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/telefon/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Telefon t : this.telefoane) {
      if(t.getId() == id) {
        this.telefoane.remove(t);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="telefon/{name}",method = RequestMethod.POST)
  public ResponseEntity addTelefon(@PathVariable("name")String name){
	  int counter =  telefoane.size() + 1;
	  Telefon t1 = new Telefon(counter,name);
	  telefoane.add(t1);
	  return new ResponseEntity<Telefon>(t1, new HttpHeaders(),HttpStatus.OK);
  }
  
  @RequestMapping(value="/telefon/{id}", method = RequestMethod.PUT)
  public ResponseEntity putFilm(@PathVariable("id") int id){
    for(Telefon t : this.telefoane) {
    if(t.getId() == id) {
    t.setName("Nokia");
    return new ResponseEntity<Telefon>(t, new HttpHeaders(), HttpStatus.OK);
  }
}
  return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
}
  
  
  
}