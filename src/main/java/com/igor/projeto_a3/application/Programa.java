package main.java.com.igor.projeto_a3.application;

import main.java.com.igor.projeto_a3.controller.FinanceiroController;
import main.java.com.igor.projeto_a3.controller.GestaoController;
import main.java.com.igor.projeto_a3.controller.RegistrarComprasController;
import main.java.com.igor.projeto_a3.controller.RegistrarVendasController;
import main.java.com.igor.projeto_a3.entity.CaminhaoEntity;
import main.java.com.igor.projeto_a3.entity.CarroEntity;
import main.java.com.igor.projeto_a3.entity.MotoEntity;
import main.java.com.igor.projeto_a3.util.ColorTextEnum;

import java.util.Collections;
import java.util.Scanner;

public class Programa {
    //flag para sinalizar se o programa vai ser encerrado ou não
    private Boolean executed = true;

    //objeto GestaoController (com os métodos crud)
    GestaoController gestao = new GestaoController();
    //objeto FinanceiroController (com as regras de negócio)
    FinanceiroController fc = new FinanceiroController(gestao);

    Scanner sc = new Scanner(System.in);

    public Programa(){
        //inicializando os objetos automaticamente
        CarroEntity c1 = new CarroEntity("AMG One", "Cinza", "Mercedes", "HAM-4444", 10.0, 2000000.0, 1200.0F, 2);
        gestao.veiculosRepository.adicionarVeiculo(c1);
        CarroEntity c2 = new CarroEntity("Mobi Like 1.0", "Prata", "Fiat", "RUS-6363", 0.0, 77000.0, 110.0F, 4);
        gestao.veiculosRepository.adicionarVeiculo(c2);
        CarroEntity c3 = new CarroEntity("Onix 1.0", "Branco", "Chevrolet", "HFS-54FG", 0.0, 95000.0, 115.0F, 4);
        gestao.veiculosRepository.adicionarVeiculo(c3);
        CarroEntity c4 = new CarroEntity("F8", "Vermelho", "Ferrari", "LEC-1616", 1200.0, 3500000.0, 720.0F, 2);
        gestao.veiculosRepository.adicionarVeiculo(c4);
        MotoEntity m1 = new MotoEntity("CG Fan 160", "Vermelha", "Honda", "ETF-854F", 10.0, 25000.0, "Rua", 160f);
        gestao.veiculosRepository.adicionarVeiculo(m1);
        MotoEntity m2 = new MotoEntity("Biz 125", "Vermelha", "Honda", "FJM-45D7", 200.0, 25000.0, "Rua", 160.7f);
        gestao.veiculosRepository.adicionarVeiculo(m2);
        MotoEntity m3 = new MotoEntity("Africa Twin 1100", "Branco", "Honda", "DVS-457H", 0.0, 95000.0, "OffRoad", 1100.24f);
        gestao.veiculosRepository.adicionarVeiculo(m3);
        CaminhaoEntity ce1 = new CaminhaoEntity("Constellation 14.210", "Branca", "Volkswagen", "DSW-48F5", 20.0, 450000.0, 10000.0f, "Grande");
        gestao.veiculosRepository.adicionarVeiculo(ce1);
        CaminhaoEntity ce2 = new CaminhaoEntity("Tector 9-190", "Branca", "Iveco", "MAX-3333", 20.0, 450000.0, 10000.0f, "Grande");
        gestao.veiculosRepository.adicionarVeiculo(ce2);

        System.out.println(ColorTextEnum.COR_BRANCO.cor() + "        GERENCIADOR DE COMPRA E VENDA DE VEÍCULOS"
                + ColorTextEnum.COR_RESET.cor());
        run();
    }


    public void run(){
        //enquanto for true, executa
        while(executed){
            System.out.println("\n");
            String menu = """ 
            ========== MENU ===========
            1 - Financeiro
            2 - Veículos
            3 - Vender
            4 - Comprar
            5 - Encerrar
   
            Escolha uma opção:
            """;

            System.out.println(menu);
            int opcao = sc.nextInt();

            //opções de menu
            switch (opcao){
                case 1:
                    menuFinanceiro();
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
                    System.out.println("SISTEMA ENCERRADO");
                    executed = false;
                    break;
                default:
                    System.out.println(ColorTextEnum.COR_VERMELHO.cor() + "Opção não encontrada!" + ColorTextEnum.COR_RESET.cor());
                    break;
            }
        }
    }

    public void menuFinanceiro(){
        System.out.println("     FINANCEIRO");

        //bug cor
        String cor = ColorTextEnum.COR_VERDE.cor();
        if(fc.bancoRepository.getCapital() <= 1000){
            cor = ColorTextEnum.COR_VERMELHO.cor();
        }

        System.out.println("Faturamento: " + ColorTextEnum.COR_VERDE.cor() + gestao.nf.format(fc.faturamentoTotal())
                + ColorTextEnum.COR_RESET.cor());
        System.out.println("Lucro Total: " + ColorTextEnum.COR_VERDE.cor() + gestao.nf.format(fc.lucroVendido())
                + ColorTextEnum.COR_RESET.cor());
        //System.out.println("Lucro ultima venda: " + gestao.nf.format(fc.calcularLucroVeiculo(gestao)));
        System.out.println("Capital disponível: " + cor + gestao.nf.format(fc.capital())
                + ColorTextEnum.COR_RESET.cor());

    }

    private void menuVender() {
        System.out.println("\n");
        System.out.println("""
                      VENDER VEÍCULOS 
                1 - Vender
                2 - Listar veículos vendidos
                3 - Voltar ao menu
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
        }else if(opcao == 3){
            run();
        }else menuVender();
    }

    private void menuComprar() {
        System.out.println("\n");
        System.out.println("""
                       COMPRAR VEICULOS 
                1 - Comprar
                2 - Listar veículos comprados
                3 - Voltar ao menu
                """);
        RegistrarComprasController rcc = new RegistrarComprasController(gestao);
        System.out.println("Escolha uma opção:");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("\n");
                rcc.comprarVeiculo(fc.bancoRepository);
                break;
            case 2:
                System.out.println("\n");
                rcc.listarVeiculosComprados();
                break;
            case 3:
                run();
                break;
            default:
                System.out.println(ColorTextEnum.COR_VERMELHO.cor() + "Opção não encontrada!" + ColorTextEnum.COR_RESET.cor());
                menuComprar();
                break;
        }
    }

    private void menuVeiculos(){
        System.out.println("""
            ======== VEICULOS =========
            1 - Alterar veículo 
            2 - Listar veículos disponíveis
            3 - Buscar veículo
            4 - Voltar ao menu
         
            Escolha uma opção:
                """);

        int opcao = sc.nextInt();
        switch (opcao){
            case 1:
                gestao.alterar();
                break;
            case 2:
                gestao.listar();
                break;
            case 3:
                gestao.buscar();
                break;
            case 4:
                run();
                break;
            default:
                System.out.println(ColorTextEnum.COR_VERMELHO.cor() + "Opção não encontrada!" + ColorTextEnum.COR_RESET.cor());
                menuVeiculos();
                break;
        }

    }

    public static void main(String[] args){
        new Programa();
    }
}