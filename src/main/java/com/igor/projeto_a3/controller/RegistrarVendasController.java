package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.util.ColorTextEnum;

import java.text.NumberFormat;

/**
 * @author Igor
 */

public class RegistrarVendasController {
    //trazendo repositórios criados na classe GestaoController
    private GestaoController gestaoController;

    //passando como parâmetro a classe GestaoController no construtor
    public RegistrarVendasController(GestaoController gestaoController) {
        this.gestaoController = gestaoController;
    }

    public RegistrarVendasController() {}

    //método vender veiculo
    public void venderVeiculo(){
        gestaoController.listar();

        //criando uma variável do "tipo" VeiculoEntity atribuído ao método buscar() retornando um VeiculoEntity
        VeiculoEntity veiculoBuscado = gestaoController.buscar();

        if(veiculoBuscado != null){
            System.out.println("\nValor da venda: ");
            //settando o preço da venda e incrementando o contador de veiculos
            veiculoBuscado.setPrecoVenda(gestaoController.sc.nextDouble());

            //incrementando o contador de veiculos vendidos a cada venda
            gestaoController.vendasRepository.contVeiculosVendidos++;

            //verificando se o veículo buscado não é nulo
            //adicionando o veículo vendido na lista de vendas
            gestaoController.vendasRepository.adicionarVeiculoVendido(veiculoBuscado);
            //removendo o veículo buscado da lista de veículos gerais
            gestaoController.veiculosRepository.veiculos.remove(veiculoBuscado);

            System.out.println("\n");
            System.out.println(ColorTextEnum.COR_VERDE.cor() + "Veículo vendido com sucesso!" + ColorTextEnum.COR_RESET.cor());
        }
    }
    //método listar veiculos vendidos
    public void listarVeiculosVendidos(){
        //verificando se a lista não está vazia
        if(!gestaoController.vendasRepository.vendas.isEmpty()){
            System.out.println("VEÍCULOS VENDIDOS");
            System.out.printf("%-20s %-15s %-10s %-15s%n",
                    "MODELO", "MARCA", "PLACA", "VALOR DA VENDA");
            System.out.println("-----------------------------------------------------------------");
            //formatação de números
            NumberFormat nf = NumberFormat.getCurrencyInstance();

            //foreach na lista de veiculos
            for(VeiculoEntity v : gestaoController.vendasRepository.vendas) {
                //formatando os atributos com o printf
                System.out.printf("%-20s %-15s %-10s %-15s%n", v.getModelo(), v.getMarca(), v.getPlaca(), nf.format(v.getPrecoVenda()));
                System.out.println("-----------------------------------------------------------------");
            }
            System.out.println(gestaoController.vendasRepository.getContVeiculosVendidos() + " veículo(s) vendido(s)");
        }else System.out.println("0 veículos vendidos");
    }

}
