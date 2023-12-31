package blog.peterstadler.com.blog;
import java.util.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class CardController {
 
@Autowired
private CardService service;
     
// RESTful API methods for Retrieval operations

//findAll records and return them as a list
@GetMapping("/cards")
public List<Card> list() {
    return service.listAll();
}

//find one record by the ID and return only this one record
@GetMapping("/cards/{id}")
public Card get(@PathVariable Integer id) {
    return service.get(id);
}

// RESTful API method for Create operation
@PostMapping("/cards")
public Card create(@RequestBody Card card) {
    return service.create(card);
}

// RESTful API method for Update operation

//use the ID to find an already exisiting record in the DB.
//Then replace the other attributes with their new values.
@PutMapping("/cards/{id}")
public Card replace(@RequestBody Card newCard, @PathVariable Integer id) {
    return service.replace(newCard, id);
}

// RESTful API method for Delete operation
@DeleteMapping("/cards/{id}")
public void delete(@PathVariable Integer id) {
    service.delete(id);
}

}