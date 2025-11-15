package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.repository.BancoRepository;

public class FinanceiroController {

    //dados financeiro
    public BancoRepository bancoRepository = new BancoRepository();
    private GestaoController gestaoController;

    public FinanceiroController(GestaoController gestaoController){
        this.gestaoController = gestaoController;
    }

    //método para calcular o faturamento total
    public Double faturamentoTotal(){
        Double total = 0.0;

        //somando todos as vendas
        for(VeiculoEntity v : gestaoController.vendasRepository.vendas){
            total += v.getPrecoVenda();
        }

        bancoRepository.setFaturamento(total);

        return total;
    }

    //método para calcular o lucro das vendas
    public Double lucroVendido(){
        double total = 0.0;

        //atribuindo os preços de vendas - e os preços das compras
        for(VeiculoEntity v : gestaoController.vendasRepository.vendas){
            total += v.getPrecoVenda() - v.getPrecoCompra();
        }

        bancoRepository.setLucro(total);

        return total;
    }

    //médodo para calcular o capital disponível
    public Double capital(){
        double totalCompras = 0.0;

        //soma o valor de todos os veículos comprados
        for (VeiculoEntity v : gestaoController.comprasRepository.compras) {
            totalCompras += v.getPrecoCompra();
        }

        //capital = (faturamento - lucro das vendas)-compras
        double capital = (faturamentoTotal() - lucroVendido()) - totalCompras;

        bancoRepository.setCapital(capital);

        return capital;

    }

}
