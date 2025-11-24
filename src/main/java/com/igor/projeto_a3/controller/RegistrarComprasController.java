package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.repository.BancoRepository;
import main.java.com.igor.projeto_a3.util.ColorTextEnum;

import java.text.NumberFormat;
import java.util.Scanner;

public class RegistrarComprasController {

    private GestaoController gestaoController;

    public RegistrarComprasController(GestaoController gestaoController) {
        this.gestaoController = gestaoController;
    }

    public void comprarVeiculo(BancoRepository bancoRepository) {
        String cor = "";;
        if(bancoRepository.getCapital() <= 1000){
            cor = ColorTextEnum.COR_VERMELHO.cor();
        }else cor = ColorTextEnum.COR_VERDE.cor();

        System.out.println("COMPRAR VEICULO            Capital disponível: " + cor
                + gestaoController.nf.format(bancoRepository.getCapital())
                + ColorTextEnum.COR_RESET.cor());

        //criando uma variável do "tipo" VeiculoEntity atribuído ao método cadastrar() retornando um VeiculoEntity
        VeiculoEntity veiculoCadastrado = gestaoController.cadastrar();

        //subtraindo o valor da capital pelo valor da compra (tirando dinheiro do capital para comprar)
        bancoRepository.setCapital(bancoRepository.getCapital() - veiculoCadastrado.getPrecoCompra());

        //incrementando o contador de veiculos comprados (a cada compra)
        gestaoController.comprasRepository.contVeiculosComprados++;
        //adicionando o veiculo cadastrado na lista de veículos comprados
        gestaoController.comprasRepository.adicionarVeiculoComprado(veiculoCadastrado);

        System.out.println(ColorTextEnum.COR_VERDE.cor() + "Veículo comprado com sucesso!" + ColorTextEnum.COR_RESET.cor());

    }

    public void listarVeiculosComprados(){
        //verificando se a lista não está vazia
        if(!gestaoController.comprasRepository.compras.isEmpty()){
            System.out.println("VEÍCULOS COMPRADOS");
            System.out.printf("%-20s %-15s %-10s %-15s%n",
                    "MODELO", "MARCA", "PLACA", "VALOR DA COMPRA");
            System.out.println("-----------------------------------------------------------------");
            //formatação de números
            NumberFormat nf = NumberFormat.getCurrencyInstance();

            //foreach na lista de veiculos
            for(VeiculoEntity v : gestaoController.comprasRepository.compras) {
                //formatando os atributos com o printf
                System.out.printf("%-20s %-15s %-10s %-15s%n", v.getModelo(), v.getMarca(), v.getPlaca(), nf.format(v.getPrecoCompra()));
                System.out.println("-----------------------------------------------------------------");
            }
            System.out.println(gestaoController.comprasRepository.getContVeiculosComprados() + " veículo(s) comprados(s)");
        }else System.out.println("0 veículos comprados");
    }
}
