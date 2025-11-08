package main.java.com.igor.projeto_a3.application;

import main.java.com.igor.projeto_a3.controller.FaturamentoController;
import main.java.com.igor.projeto_a3.controller.GestaoController;
import main.java.com.igor.projeto_a3.controller.RegistrarComprasController;
import main.java.com.igor.projeto_a3.controller.RegistrarVendasController;

import java.util.Scanner;

public class Programa {
    //flag para sinalizar se o programa vai ser encerrado ou não
    private Boolean executed = true;
    //objeto GestaoController (com os métodos crud)
    GestaoController gestao = new GestaoController();
    Scanner sc = new Scanner(System.in);

    public Programa(){
        run();
    }

    public void run(){
        System.out.println("SISTEMA\n");
        //enquanto for true
        while(executed){
            System.out.println("\n");
            String menu = """ 
            ========== MENU ===========
            1 - Faturamento
            2 - Veículos
            3 - Vender
            4 - Comprar
            5 - Sair
            ===========================
            Escolha uma opção:
            """;

            System.out.println(menu);
            int opcao = sc.nextInt();

            //opções de menu
            switch (opcao){
                case 1:
                    menuFaturamento();
                    break;
                case 2:
                    menuVeiculos();
                    break;
                case 3:
                    menuVender();
                    break;
                case 4:
                    menuComprar();
                    break;
                case 5:
                    System.out.println("Programa encerrado");
                    executed = false;
                    break;
            }
        }
    }

    public void menuFaturamento(){
        FaturamentoController fc = new  FaturamentoController();
    }

    private void menuVender() {
        System.out.println("\n");
        System.out.println("""
                ========== VENDER VEICULOS ==========
                1 - Vender
                2 - Listar veiculos vendidos
                """);
        //objeto RegistrarVendarController
        RegistrarVendasController rvc = new RegistrarVendasController(gestao);

        int opcao = sc.nextInt();
        //verificando opções
        if(opcao == 1) {
            System.out.println("\n");
            //chamando o método venderVeiculo()
            rvc.venderVeiculo();
        }else if(opcao == 2){
            System.out.println("\n");
            //chamando o método listarVeiculos()
            rvc.listarVeiculosVendidos();
        }
    }

    private void menuComprar() {
        System.out.println("\n");
        System.out.println("""
                ========== COMPRAR VEICULOS ==========
                1 - Comprar
                2 - Listar veiculos comprados
                """);
        RegistrarComprasController rcc = new RegistrarComprasController();
    }

    private void menuVeiculos(){
        System.out.println("""
            ========== VEICULOS ===========
            1 - Cadastro
            2 - Listar
            3 - Deletar
            4 - Alterar
            5 - Buscar
            6 - Sair
            ===========================
            Escolha uma opção:
                """);

        int opcao = sc.nextInt();
        switch (opcao){
            case 1:
                gestao.cadastrar();
                break;
            case 2:
                gestao.listar();
                break;
            case 3:
                gestao.deletar();
                break;
            case 4:
                gestao.alterar();
                break;
            case 5:
                gestao.buscar();
                break;
            case 6:
                executed = false;
                break;
        }

    }

    public static void main(String[] args){
        new Programa();
    }
}