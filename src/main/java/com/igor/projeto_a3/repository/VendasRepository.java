package main.java.com.igor.projeto_a3.repository;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;

import java.util.ArrayList;
import java.util.List;

//repositório para lista
public class VendasRepository {
    //lista de veículos vendidos
    public List<VeiculoEntity> vendas = new ArrayList<>();
    //contador de veículos vendidos
    public Integer contVeiculosVendidos = 0;

    //método para adicionar veiculo vendido
    public void adicionarVeiculoVendido(VeiculoEntity veiculo){
        vendas.add(veiculo);
    }

    public Integer getContVeiculosVendidos(){
        return  contVeiculosVendidos;
    }
}
