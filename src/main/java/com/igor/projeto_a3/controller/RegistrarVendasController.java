package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.repository.VeiculosRepository;
import main.java.com.igor.projeto_a3.repository.VendasRepository;

import java.text.NumberFormat;

public class RegistrarVendasController {
    //trazendo repositórios criados na classe GestaoController
    private GestaoController gestaoController;

    private Integer contVeiculosVendidos = 0;

    public RegistrarVendasController(Integer contVeiculosVendidos) {
        this.contVeiculosVendidos = contVeiculosVendidos;
    }

    //passando como parâmetro a classe GestaoController no construtor
    public RegistrarVendasController(GestaoController gestaoController) {
        this.gestaoController = gestaoController;
    }

    public RegistrarVendasController() {}

    //método vender veiculo
    public void venderVeiculo(){
        //verificando se a lista de veiculos não está vazia
        //criando uma variavel do "tipo" VeiculoEntity atribuido ao método buscar() retornando um VeiculoEntity
        VeiculoEntity veiculoBuscado = gestaoController.buscar();

        System.out.println("Valor da venda: ");
        //settando o preco da venda e incrementando o contador de veiculos
        veiculoBuscado.setPrecoVenda(gestaoController.sc.nextDouble());
        contVeiculosVendidos++;

        //verificadno se o veiculo buscado não é nulo
        //adicionando o veiculo vendido na lista de vendas
        gestaoController.vendasRepository.adicionarVeiculoVendido(veiculoBuscado);
        //removendo o veiculo buscado da lista de veiculos gerais
        gestaoController.veiculosRepository.veiculos.remove(veiculoBuscado);
        System.out.println("Veículo vendido com sucesso!");
    }
    //método listar veiculos vendidos
    public void listarVeiculosVendidos(){
        System.out.printf("%-20s %-15s %-10s %-15s%n",
                "MODELO", "MARCA", "PLACA", "VALOR DA VENDA");
        System.out.println("-----------------------------------------------------------------");
        NumberFormat nf = NumberFormat.getCurrencyInstance();

        //foreach na lista de veiculos
        for(VeiculoEntity v : gestaoController.vendasRepository.vendas) {
            //fortamando os atributos com o printf
            System.out.printf("%-20s %-15s %-10s %-15s%n", v.getModelo(), v.getMarca(), v.getPlaca(), nf.format(v.getPrecoVenda()));
            System.out.println("-----------------------------------------------------------------");
        }
    }

    public Integer getContVeiculosVendidos() {
        return contVeiculosVendidos;
    }

}
