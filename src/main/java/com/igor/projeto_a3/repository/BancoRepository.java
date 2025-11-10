package main.java.com.igor.projeto_a3.repository;

public class BancoRepository {

    private Double saldo = 0.0;
    private Double lucro = 0.0;
    public Double faturamento = 0.0;

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
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
