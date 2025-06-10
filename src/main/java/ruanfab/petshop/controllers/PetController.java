package ruanfab.petshop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ruanfab.petshop.models.PetModel;
import ruanfab.petshop.services.PetServices;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    PetServices petService;
    
    @GetMapping("/verPets")
    public ResponseEntity<List<PetModel>> verPets(){
        return ResponseEntity.ok(petService.verAnimais());
    }

    @PostMapping("/addPet")
    public ResponseEntity<String> addPet(@RequestBody PetModel body){
        if (petService.addPet(body.getNome(), body.getTipo_animal(), body.getRaca(), body.getIdade(), body.getSexo()).equals("Animal já registrado!")){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Animal já Registrado");
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body("animal registrado com sucesso!");
        }
    }

    @PostMapping("/removePet/{nome}")
    public ResponseEntity<String> removePet(@PathVariable("nome") String nome){

        if (petService.removePet(nome).equals("Animal removido com sucesso!")){
            return ResponseEntity.ok("Excluido com Sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Animal não encontrado!");
        }
    }

    @PostMapping("/updtPet/{nome}/{tipo_animal}")
    public ResponseEntity<String> updtPet(@PathVariable("nome") String nome_alterar, @PathVariable("tipo_animal") String tipo_animal_alterar, 
    @RequestBody PetModel body){
        if (petService.updatePet(Optional.ofNullable(body.getNome()), Optional.ofNullable(body.getTipo_animal()), Optional.ofNullable(body.getRaca()), Optional.ofNullable(body.getIdade()), Optional.ofNullable(body.getSexo()), nome_alterar, tipo_animal_alterar).equals("Sucess")){
            return ResponseEntity.ok("Alterado com Sucesso!");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Algo deu errado");
        }
        
    }
}
