package ruanfab.petshop.services;

import org.springframework.stereotype.Service;


@Service // Informa que é uma classe Service
public class TesteService {
    
    public int teste(int a, int b) {
        return a + b;
    }
}
