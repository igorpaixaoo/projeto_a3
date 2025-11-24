package main.java.com.igor.projeto_a3.repository;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;

import java.util.ArrayList;
import java.util.List;

//repositório para lista
public class ComprasRepository {
    //lista de veiculos comprados
    public List<VeiculoEntity> compras = new ArrayList<>();

    //contador de veiculos comprados
    public Integer contVeiculosComprados = 0;
    //método adicionar veiculo comprado na lista
    public void adicionarVeiculoComprado(VeiculoEntity veiculo){
        compras.add(veiculo);
    }

    public Integer getContVeiculosComprados() {
        return contVeiculosComprados;
    }


}
