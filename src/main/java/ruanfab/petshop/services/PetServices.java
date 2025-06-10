package ruanfab.petshop.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ruanfab.petshop.models.PetModel;

@Service
public class PetServices {
    
    
    private List<PetModel> petList = new ArrayList<>();
    
    public List<PetModel> verAnimais(){
        return petList;
    }

    public String addPet(String nome, String tipo_animal, String raca, int idade, char sexo){

        if (petList.stream().filter(animal -> animal.getNome().equals(nome) && animal.getRaca().equals(raca) && animal.getTipo_animal().equals(tipo_animal) && animal.getIdade() == idade).findFirst().isPresent()){
            return "Animal já registrado!";
        }

        PetModel novoAnimal = new PetModel(nome, tipo_animal, raca, idade, sexo);
        petList.add(novoAnimal);

        return "Animal adicionado com sucesso";
    }

    public String removePet(String nome){
        if (petList.stream().filter(animal -> animal.getNome().equals(nome)).findFirst().isPresent()){
            System.out.println("Existo");

            petList.removeIf(animal -> animal.getNome().equals(nome));
    
            return "Animal removido com sucesso!";
        }
        else {
            System.out.println("num achei");

            return "not found";
        }
    }
}