package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.repository.VeiculosRepository;
import main.java.com.igor.projeto_a3.repository.VendasRepository;

public class RegistrarVendasController {
    //trazendo repositórios criados na classe GestaoController
    private GestaoController gestaoController;

    private Integer contVeiculos;
    private Double precoVenda;

    public RegistrarVendasController(Integer contVeiculos, Double precoVenda) {
        this.contVeiculos = contVeiculos;
        this.precoVenda = precoVenda;
    }

    //passando como parâmetro a classe GestaoController no construtor
    public RegistrarVendasController(GestaoController gestaoController) {
        this.gestaoController = gestaoController;
    }

    public RegistrarVendasController() {}

    //método vender veiculo
    public void venderVeiculo(){
        //verificando se a lista de veiculos não está vazia
        if(!gestaoController.vendasRepository.vendas.isEmpty()){
            //buscando veiculo
            VeiculoEntity veiculoBuscado = gestaoController.buscar();

            //verificadno se o veiculo buscado não é nulo
            if(veiculoBuscado != null){
                //adicionando o veiculo vendido na lista de vendas
                gestaoController.vendasRepository.adicionarVeiculoVendido(veiculoBuscado);
                //removendo o veiculo buscado da lista de veiculos gerais
                gestaoController.veiculosRepository.veiculos.remove(veiculoBuscado);
                System.out.println("Veículo vendido com sucesso!");
            }
        }
    }
    //método listar veiculos vendidos
    public void listarVeiculosVendidos(){
        System.out.printf("%-20s %-15s %-15s%n",
                "MODELO", "MARCA", "PLACA");
        System.out.println("---------------------------------------------");
        //foreach na lista de veiculos
        for(VeiculoEntity v : gestaoController.vendasRepository.vendas) {
            //fortamando os atributos com o printf
            System.out.printf("%-20s %-15s %-15s%n", v.getModelo(), v.getMarca(), v.getPlaca());
            System.out.println("---------------------------------------------");
        }
    }

    public void setContVeiculos(Integer contVeiculos) {
        this.contVeiculos = contVeiculos;
    }

    public Integer getContVeiculos() {
        return contVeiculos;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoVenda(){
        return precoVenda;
    }

}
