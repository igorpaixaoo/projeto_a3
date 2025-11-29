package main.java.com.igor.projeto_a3.service;

public class ImpostoCreditoService implements ImpostoService {

    private static final Double TAXA = 0.10;

    @Override
    public double calcularImposto(Double preco) {
        return preco * TAXA;
    }
}
