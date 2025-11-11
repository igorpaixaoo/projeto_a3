package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.repository.BancoRepository;

public class FinanceiroController {

    private BancoRepository bancoRepository = new BancoRepository();
    private GestaoController gestaoController;

    public FinanceiroController(GestaoController gestaoController){
        this.gestaoController = gestaoController;
    }

    public Double faturamentoTotal(){
        Double total = 0.0;

        for(VeiculoEntity v : gestaoController.vendasRepository.vendas){
            total += v.getPrecoVenda();
        }

        return total;
    }

    public Double lucroVendido(){
        double total = 0.0;

        for(VeiculoEntity v : gestaoController.vendasRepository.vendas){
            total += v.getPrecoVenda() - v.getPrecoCompra();
        }

        return total;
    }

    public Double capital(){
        double total = 0.0;

        for(VeiculoEntity v : gestaoController.vendasRepository.vendas){
            total += v.getPrecoVenda() - lucroVendido();
        }

        return total;
    }

}
