package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.repository.VeiculosRepository;
import main.java.com.igor.projeto_a3.repository.VendasRepository;

public class RegistrarVendasController {
    //repositórios
    private VendasRepository vendasRepository = new VendasRepository();
    private VeiculosRepository veiculosRepository = new VeiculosRepository();

    private GestaoController gestaoController;

    private Integer contVeiculos;

    public RegistrarVendasController(Integer contVeiculos) {
        this.contVeiculos = contVeiculos;
    }
    public RegistrarVendasController() {}

    //método vender veiculo
    //BUG!!!!!!!
    public void venderVeiculo(){
        //verificando se a lista de veiculos não está vazia
        if(!vendasRepository.vendas.isEmpty()){
            //buscando veiculo
            VeiculoEntity veiculoBuscado = gestaoController.buscar();

            //verificadno se o veiculo buscado não é nulo
            if(veiculoBuscado != null){
                veiculosRepository.veiculos.remove(veiculoBuscado);
                System.out.println("Veículo vendido com sucesso!");
                vendasRepository.adicionarVeiculoVendido(veiculoBuscado);
            }
        }
    }

    public void listarVeiculosVendidos(){
        System.out.printf("%-20s %-15s %-15s%n",
                "MODELO", "MARCA", "PLACA");
        System.out.println("---------------------------------------------");
        //foreach na lista de veiculos
        for(VeiculoEntity v : vendasRepository.vendas) {
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

}
