package se.mohsen.restfulllecture_ex.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {


    @RequestMapping(method = RequestMethod.GET, path = {"/index"})
    public String helloWorld() {


        return "<h1>hello there- Message from home controller</h1>";
    }

    @GetMapping(path = "message")
    public ResponseEntity<String> responseString(@RequestParam(value = "message", defaultValue = "default value for text message") String message) {

        return ResponseEntity.status(200).body(message);
    }

    @GetMapping
    public ResponseEntity<Void> foo() {
        return ResponseEntity.notFound().build();
    }
}
