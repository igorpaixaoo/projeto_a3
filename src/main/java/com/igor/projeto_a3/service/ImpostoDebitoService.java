package main.java.com.igor.projeto_a3.service;

public class ImpostoDebitoService implements ImpostoService{

    private static final Double TAXA = 0.05;

    @Override
    public double calcularImposto(Double preco) {
        return preco * TAXA;
    }
}
