package main.java.com.igor.projeto_a3.repository;

import main.java.com.igor.projeto_a3.controller.RegistrarVendasController;
import main.java.com.igor.projeto_a3.entity.VeiculoEntity;

import java.util.ArrayList;
import java.util.List;

//repositório para lista
public class VendasRepository {
    //lista de veiculos vendidos
    public List<VeiculoEntity> vendas = new ArrayList<>();

    //método para adicionar veiculo vendido
    public void adicionarVeiculoVendido(VeiculoEntity veiculo){
        vendas.add(veiculo);
    }
}
