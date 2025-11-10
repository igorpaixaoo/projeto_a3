package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.repository.BancoRepository;

public class FinanceiroController {

    private BancoRepository bancoRepository = new BancoRepository();
    private GestaoController gestaoController;

    public FinanceiroController(GestaoController gestaoController){
        this.gestaoController = gestaoController;
    }

    /// BUGGGGGGGGGGGGGGGGGGGGGGGGG
    public double calcularLucro(){
        double totalValorCusto = 0.0;

        for(VeiculoEntity v : gestaoController.veiculosRepository.veiculos){
            for(VeiculoEntity v2 : gestaoController.vendasRepository.vendas){
                totalValorCusto += v.getPreco() + v2.getPreco();
            }

        }

        //bug bug bug bug

        System.out.println(totalValorCusto);

        return bancoRepository.getFaturamento() - totalValorCusto;
    }

    public double calcularSaldo(){
        return 0.0;
    }

    public double calcularFaturamento(){
        for(VeiculoEntity v : gestaoController.vendasRepository.vendas){
            return bancoRepository.faturamento += v.getPrecoVenda();
        }
        return 0.0;
    }

}
