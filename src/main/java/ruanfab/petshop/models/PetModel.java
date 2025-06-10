package ruanfab.petshop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PetModel {
    private String nome;
    private String tipo_animal;
    private String raca;
    private int idade;
    private char sexo;
}
