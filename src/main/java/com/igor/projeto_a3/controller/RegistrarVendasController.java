package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.service.ImpostoCreditoService;
import main.java.com.igor.projeto_a3.service.ImpostoDebitoService;
import main.java.com.igor.projeto_a3.service.ImpostoPixService;
import main.java.com.igor.projeto_a3.service.ImpostoService;
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

    //método para selecionar o tipo de pagamento, consequentemente retornando a classe que implementa ImpostoService
    public ImpostoService selecionarTipoPagamento(){

        System.out.println("Selecionando tipo de pagamento  1-PIX/Dinheiro  2-Débito  3-Crédito");
        int opcao = gestaoController.sc.nextInt();
        //opções
        switch (opcao){
            case 1:
                return new ImpostoPixService();
            case 2:
                return new ImpostoDebitoService();
            case 3:
                return new ImpostoCreditoService();
        }
        return null;
    }

    //método vender veiculo
    public void venderVeiculo(){
        //listando os veículos disponíveis
        gestaoController.listar();

        //criando uma variável do "tipo" VeiculoEntity atribuído ao método buscar() retornando um VeiculoEntity
        VeiculoEntity veiculoBuscado = gestaoController.buscar();

        //injetando o método na "variável" impostoService do tipo ImpostoService (interface)
        ImpostoService impostoService = selecionarTipoPagamento();

        if(veiculoBuscado != null){
            System.out.println("\nValor da venda: ");

            //preco de venda sem imposto
            double precoVenda = gestaoController.sc.nextDouble();

            System.out.println("Deseja trocar o tipo de pagamento? S/N");
            char opcao = gestaoController.sc.next().charAt(0);

            if(Character.toString(opcao).equalsIgnoreCase("S")){
                selecionarTipoPagamento();
            }else if(Character.toString(opcao).equalsIgnoreCase("N")){
                //preço de venda com imposto
                Double precoVendaImposto = precoVenda + impostoService.calcularImposto(precoVenda);

                //settando o preço da venda e incrementando o contador de veiculos
                veiculoBuscado.setPrecoVenda(precoVendaImposto);
                //incrementando o contador de veiculos vendidos a cada venda
                gestaoController.vendasRepository.contVeiculosVendidos++;
                //adicionando o veículo vendido na lista de vendas
                gestaoController.vendasRepository.adicionarVeiculoVendido(veiculoBuscado);
                //removendo o veículo buscado da lista de veículos gerais
                gestaoController.veiculosRepository.veiculos.remove(veiculoBuscado);

                System.out.println("\n");
                System.out.println(ColorTextEnum.COR_VERDE.cor() + "Veículo vendido com sucesso!" + ColorTextEnum.COR_RESET.cor());

            }

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
