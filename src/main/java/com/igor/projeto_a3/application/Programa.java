package main.java.com.igor.projeto_a3.application;

import main.java.com.igor.projeto_a3.controller.FinanceiroController;
import main.java.com.igor.projeto_a3.controller.GestaoController;
import main.java.com.igor.projeto_a3.controller.RegistrarComprasController;
import main.java.com.igor.projeto_a3.controller.RegistrarVendasController;
import main.java.com.igor.projeto_a3.entity.CaminhaoEntity;
import main.java.com.igor.projeto_a3.entity.CarroEntity;
import main.java.com.igor.projeto_a3.entity.MotoEntity;

import java.util.Scanner;

public class Programa {
    //flag para sinalizar se o programa vai ser encerrado ou não
    private Boolean executed = true;
    //objeto GestaoController (com os métodos crud)
    GestaoController gestao = new GestaoController();

    Scanner sc = new Scanner(System.in);

    public Programa(){
        //inicializando os objetos automaticamente
        CarroEntity c1 = new CarroEntity();
        c1.setMarca("Mercedes");
        c1.setModelo("AMG One");
        c1.setCor("Cinza");
        c1.setPlaca("OGC-874F");
        c1.setPrecoCompra(2000000.0);
        c1.setKm(10.0);
        c1.setCavalos(1200.0F);
        c1.setPassageiros(2);
        gestao.veiculosRepository.adicionarVeiculo(c1);

        MotoEntity m1 = new MotoEntity();
        m1.setMarca("Honda");
        m1.setModelo("CG Fan 160");
        m1.setCor("Vermelha");
        m1.setPlaca("ETF-854F");
        m1.setPrecoCompra(25000.0);
        m1.setKm(0.0);
        m1.setCarenagem("De rua");
        m1.setCilindragem(162.7f);
        gestao.veiculosRepository.adicionarVeiculo(m1);

        CaminhaoEntity ce1 = new CaminhaoEntity();
        ce1.setMarca("Scania");
        ce1.setModelo("P400");
        ce1.setCor("Branca");
        ce1.setPlaca("FGD-4457");
        ce1.setPrecoCompra(300000.0);
        ce1.setKm(15.0);
        ce1.setCabine("Grande");
        ce1.setToneladas(10000.0f);
        gestao.veiculosRepository.adicionarVeiculo(ce1);

        run();
    }

    public void run(){
        System.out.println("SISTEMA\n");
        //enquanto for true, executa
        while(executed){
            System.out.println("\n");
            String menu = """ 
            ========== MENU ===========
            1 - Faturamento (implementando)
            2 - Veículos
            3 - Vender
            4 - Comprar/Cadastrar
            5 - Sair
            ===========================
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
                    System.out.println("Programa encerrado");
                    executed = false;
                    break;
            }
        }
    }

    public void menuFinanceiro(){
        System.out.println("FINANCEIRO:");
        FinanceiroController fc = new FinanceiroController(gestao);

        System.out.println("Faturamento: " + gestao.nf.format(fc.faturamentoTotal()));
        System.out.println("Lucro: " + gestao.nf.format(fc.lucroVendido()));
        //System.out.println("Lucro por venda: " + gestao.nf.format(fc.calcularLucroVeiculo(gestao)));
        System.out.println("Capital disponível: " + gestao.nf.format(fc.capital()));

    }

    private void menuVender() {
        System.out.println("\n");
        System.out.println("""
                ========== VENDER VEÍCULOS ==========
                1 - Vender
                2 - Listar veículos vendidos
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
                2 - Listar veículos comprados
                """);
        RegistrarComprasController rcc = new RegistrarComprasController(gestao);
        System.out.println("Escolha uma opção:");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("\n");
                rcc.comprarVeiculo();
                break;
            case 2:
                System.out.println("\n");
                rcc.listarVeiculosComprados();
                break;
        }
    }

    private void menuVeiculos(){
        System.out.println("""
            ========== VEICULOS ===========
            1 - Alterar veículo 
            2 - Listar veículos disponíveis
            3 - Buscar veículo
            4 - Sair
            ===========================
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
                executed = false;
                break;
        }

    }

    public static void main(String[] args){
        new Programa();
    }
}