package ruanfab.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ruanfab.petshop.DTOs.TestePosting;
import ruanfab.petshop.services.TesteService;


@RestController // Informa que é um request body
@RequestMapping("/teste") // Uma anotação que informa que vai "ouvir" tudo que passar pela rota ("/teste") (no caso o nome da rota)
public class TesteController {

    @Autowired
    private TesteService testeService;

    @GetMapping("/getting") // Anotação que informa que a rota "/getting" é um Get | OBS: não precisa da string interna, ai nesse caso é só acessar a rota "/teste"
    public String teste() {
        return "Deu certo";
    }

    @PostMapping("/posting")
    public ResponseEntity<String> posting(@RequestBody TestePosting body) {
        int resultado =  testeService.teste(body.getA(), body.getB());
        return ResponseEntity.ok(String.format("Resultado de 7 + 8: %d", resultado));
    }
}


// 