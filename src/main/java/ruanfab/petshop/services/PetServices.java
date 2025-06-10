package ruanfab.petshop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public String updatePet(Optional<String> nome, Optional<String> tipo_animal, Optional<String> raca, Optional <Integer> idade, Optional <Character> sexo, String nome_alterar, String tipo_animal_alterar){
        
        try {
            Optional<PetModel> retorno_pesquisa = petList.stream().filter(animal -> animal.getNome().equals(nome_alterar) && animal.getTipo_animal().equals(tipo_animal_alterar)).findFirst();

            if(retorno_pesquisa.isEmpty()){
                throw new Exception("Animal não encontrado");
            }

            if (nome.isPresent()){
                retorno_pesquisa.ifPresent(animal -> animal.setNome(nome.get()));
            }
            
            if (tipo_animal.isPresent()){
                retorno_pesquisa.ifPresent(animal -> animal.setTipo_animal(tipo_animal.get()));
            }
            
            if (raca.isPresent()){
                retorno_pesquisa.ifPresent(animal -> animal.setRaca(raca.get()));
            }
            
            if (idade.isPresent()){
                int idade_int = idade.get();
                retorno_pesquisa.ifPresent(animal -> animal.setIdade(idade_int));
            }
            
            if (sexo.isPresent()){
                retorno_pesquisa.ifPresent(animal -> animal.setSexo(sexo.get()));
            }
            return "Sucess";
        } catch (Exception e) {
            System.out.print(e);
            return "Error: " + e;
        }
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