package main.java.com.igor.projeto_a3.repository;

public class BancoRepository {

    public Double capital = 0.0;
    private Double lucro = 0.0;
    private Double faturamento = 0.0;

    public Double getCapital() {
        return capital;
    }

    public void setCapital(Double capital) {
        this.capital = capital;
    }

    public Double getLucro() {
        return lucro;
    }

    public void setLucro(Double lucro) {
        this.lucro = lucro;
    }

    public Double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Double faturamento) {
        this.faturamento = faturamento;
    }
}
