package main.java.com.igor.projeto_a3.repository;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;

import java.util.ArrayList;
import java.util.List;

//repositório para lista
public class VeiculosRepository {
    //lista de veiculos
    public List<VeiculoEntity> veiculos = new ArrayList<>();

    //método adicionar veiculo
    public void adicionarVeiculo(VeiculoEntity veiculo){
        veiculos.add(veiculo);
    }
}
