package ruanfab.petshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class PetController {
    
    private List<String> animals = new ArrayList<>();

    private ObjectMapper objectMapper;

    public PetController(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }
    

    @GetMapping(path= "/pets")
    public ResponseEntity<String> verPet() throws JsonProcessingException {
        return ResponseEntity.ok(objectMapper.writeValueAsString(animals));
    }
}
