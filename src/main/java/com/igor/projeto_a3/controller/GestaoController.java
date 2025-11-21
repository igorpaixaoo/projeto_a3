package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.CaminhaoEntity;
import main.java.com.igor.projeto_a3.entity.CarroEntity;
import main.java.com.igor.projeto_a3.entity.MotoEntity;
import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.repository.ComprasRepository;
import main.java.com.igor.projeto_a3.repository.VeiculosRepository;
import main.java.com.igor.projeto_a3.repository.VendasRepository;
import main.java.com.igor.projeto_a3.util.ColorTextEnum;

import java.awt.*;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Igor
 */

public class GestaoController {

    //lista de veiculos
    public VeiculosRepository veiculosRepository = new VeiculosRepository();
    public VendasRepository vendasRepository = new VendasRepository();
    public ComprasRepository  comprasRepository = new ComprasRepository();

    VeiculoEntity veiculoCadastrado;

    Scanner sc = new Scanner(System.in);
    public NumberFormat nf = NumberFormat.getCurrencyInstance();

    public GestaoController(){

    }

    //método para cadastrar
    public VeiculoEntity cadastrar(){
        System.out.println("1 - Comprar Carro | 2 - Comprar Moto | 3 - Comprar Caminhão");
        int opcao = sc.nextInt();
        sc.nextLine();

        //opções de objetos (carro, moto, caminhão)
        switch (opcao){
            case 1:
                //criando um objeto carro e atribuindo os dados
                CarroEntity carro = new CarroEntity();

                System.out.println("Marca: ");
                carro.setMarca(sc.nextLine());
                System.out.println("Modelo: ");
                carro.setModelo(sc.nextLine());
                System.out.println("Cor: ");
                carro.setCor(sc.nextLine());
                System.out.println("Placa: ");
                carro.setPlaca(sc.nextLine());
                System.out.println("Km: ");
                carro.setKm(sc.nextDouble());
                sc.nextLine();
                System.out.println("Cavalos: ");
                carro.setCavalos(sc.nextFloat());
                sc.nextLine();
                System.out.println("Passageiros: ");
                carro.setPassageiros(sc.nextInt());
                sc.nextLine();
                System.out.println("Valor da Compra: ");
                carro.setPrecoCompra(sc.nextDouble());
                sc.nextLine();
                //adicionando a lista de veiculos
                veiculosRepository.adicionarVeiculo(carro);
                veiculoCadastrado = carro;
                break;

            case 2:
                //criando um objeto carro e atribuindo os dados
                MotoEntity moto = new MotoEntity();

                System.out.println("Marca: ");
                moto.setMarca(sc.nextLine());
                System.out.println("Modelo: ");
                moto.setModelo(sc.nextLine());
                System.out.println("Cor: ");
                moto.setCor(sc.nextLine());
                System.out.println("Placa: ");
                moto.setPlaca(sc.nextLine());
                System.out.println("Km: ");
                moto.setKm(sc.nextDouble());
                sc.nextLine();
                System.out.println("Cilindragem: ");
                moto.setCilindragem(sc.nextFloat());
                sc.nextLine();
                System.out.println("Carenagem: ");
                moto.setCarenagem(sc.nextLine());
                System.out.println("Valor da Compra: ");
                moto.setPrecoCompra(sc.nextDouble());
                sc.nextLine();
                //adicionando a lista de veiculos
                veiculosRepository.adicionarVeiculo(moto);
                veiculoCadastrado = moto;
                break;
            case 3:
                //criando um objeto carro e atribuindo os dados
                CaminhaoEntity caminhao = new CaminhaoEntity();

                System.out.println("Marca: ");
                caminhao.setMarca(sc.nextLine());
                System.out.println("Modelo: ");
                caminhao.setModelo(sc.nextLine());
                System.out.println("Cor: ");
                caminhao.setCor(sc.nextLine());
                System.out.println("Placa: ");
                caminhao.setPlaca(sc.nextLine());
                System.out.println("Km: ");
                caminhao.setKm(sc.nextDouble());
                sc.nextLine();
                System.out.println("Toneladas: ");
                caminhao.setToneladas(sc.nextFloat());
                sc.nextLine();
                System.out.println("Valor da Compra: ");
                caminhao.setPrecoCompra(sc.nextDouble());
                sc.nextLine();
                //adicionando a lista de veiculos
                veiculosRepository.adicionarVeiculo(caminhao);
                veiculoCadastrado = caminhao;
                break;
            default:
                System.out.println(ColorTextEnum.COR_VERMELHO.cor() + "Opção não encontrada!" + ColorTextEnum.COR_RESET.cor());
                cadastrar();
                break;
        }

        return veiculoCadastrado;
    }

    //ADICIONAR VERIFICAÇÃO SE A PLACA NÃO FOR ENCONTRADA
    //método para buscar
    public VeiculoEntity buscar(){
        //verificando se a lista de veiculos não está vazia
        if(!veiculosRepository.veiculos.isEmpty()){
            System.out.println("BUSCAR VEÍCULO (placa):");
            //atributo (placa) digitado
            String atributoDigitado = sc.next();

            //iterando a lista de veículos
            for(int i = 0; i < veiculosRepository.veiculos.size(); i++){
                /*se o atributo (placa) digitado (ignorando se é maiúsculo ou minúsculo) for igual ao atributo
                da lista da posição i, retorna o veículo buscado
                */
                if(atributoDigitado.equalsIgnoreCase(veiculosRepository.veiculos.get(i).getPlaca())){
                    VeiculoEntity v = veiculosRepository.veiculos.get(i);

                    System.out.printf("%-15s %-15s %-12s %-15s %-10s %-7s%n",
                            "MODELO", "MARCA", "PLACA", "PREÇO COMPRA", "COR", "KM");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.printf("%-15s %-15s %-12s %-15s %-10s %-7s%n",
                            v.getModelo(), v.getMarca(), v.getPlaca(),
                            nf.format(v.getPrecoCompra()), v.getCor(), v.getKm());

                    return veiculosRepository.veiculos.get(i);
                }
            }
            System.out.println(ColorTextEnum.COR_VERMELHO.cor() + "Veículo não encontrado!" + ColorTextEnum.COR_RESET.cor());
        }else System.out.println("Não tem veículos disponíveis");

        return null;
    }

    //método para listar
    public void listar(){
        //verificando se a lista de veículos não está vazia
        if(!veiculosRepository.veiculos.isEmpty()){
            System.out.println("VEÍCULOS DISPONÍVEIS");
            //formatando para ficar em formato tabular com o printf()
            System.out.printf("%-20s %-15s %-15s %-10s%n",
                    "MODELO", "MARCA", "PLACA", "PREÇO COMPRA");
            System.out.println("-------------------------------------------------------------------");

            //ADICIONAR PREÇO DA COMPRA (que está na lista ComprasRepository)

            //foreach na lista de veiculos
            for(VeiculoEntity v : veiculosRepository.veiculos) {
                //formatando os atributos com o printf
                System.out.printf("%-20s %-15s %-15s %-10s%n", v.getModelo(), v.getMarca(), v.getPlaca(),
                        nf.format(v.getPrecoCompra()));
                System.out.println("-------------------------------------------------------------------");
            }
            System.out.println("Ordenar: 1 - Modelo, 2 - Marca, 3 - Placa, 4 - Preço, 5 - Voltar");

            int opcao = sc.nextInt();
            ordenar(opcao);

        }else System.out.println("Não tem veículos disponíveis");
    }

    //método para ordenar a lista de VeiculoEntity por algum atributo
    public int ordenar(int opcaoOrdem){
        switch (opcaoOrdem){
            case 1:
                //ordenar pelo modelo
                veiculosRepository.veiculos.sort(Comparator.comparing(VeiculoEntity::getModelo));
                break;
            case 2:
                //ordenar pela marca
                veiculosRepository.veiculos.sort(Comparator.comparing(VeiculoEntity::getMarca));
                break;
            case 3:
                //ordenar pela placa
                veiculosRepository.veiculos.sort(Comparator.comparing(VeiculoEntity::getPlaca));
                break;
            case 4:
                //ordenar pelo valor
                veiculosRepository.veiculos.sort(Comparator.comparing(VeiculoEntity::getPrecoCompra));
                break;
            case 5:
                return 0;
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
        listar();

        return 0;
    }

    //método para deletar
    public VeiculoEntity deletar(){
        //verificando se a lista de veiculos não está vazia
        if (!veiculosRepository.veiculos.isEmpty()) {
            System.out.println("DELETAR VEÍCULO");
            //o objeto a ser deletado vai ser retornado pelo método buscar()
            VeiculoEntity deletarVeiculo = buscar();

            //verificando se deseja deletar
            System.out.println("Deseja realmente deletar o veículo? S / N");
            char opcao = sc.next().charAt(0);
            //se o character (ignorando se é maiusculo ou minusculo) for igual opção "S", remove o veículo da lista
            if (Character.toString(opcao).equalsIgnoreCase("S")){
                veiculosRepository.veiculos.remove(deletarVeiculo);
                System.out.println("veiculo removido com sucesso!");
            }else if (Character.toString(opcao).equalsIgnoreCase("N")) System.out.println("Veiculo não deletado!");
        }

        return null;
    }

    //método para alterar veiculos
    public void alterar(){
        //verificando se a lista de veiculos não está vazia
        if(!veiculosRepository.veiculos.isEmpty()){
            System.out.println("\n");
            System.out.println("ALTERAR VEICULO");
            //objeto a ser encontrado com o método buscar()
            VeiculoEntity veiculoEncontrado = buscar();

            if(veiculoEncontrado != null){
                //verificando se o objeto "veiculoEncontrado" é uma instância de CarroEntity
                //se for, o objeto encontrado passa a ser alterado
                if(veiculoEncontrado instanceof CarroEntity){
                    System.out.println("Marca: ");
                    veiculoEncontrado.setMarca(sc.nextLine());
                    System.out.println("Modelo: ");
                    veiculoEncontrado.setModelo(sc.nextLine());
                    System.out.println("Cor: ");
                    veiculoEncontrado.setCor(sc.nextLine());
                    System.out.println("Placa: ");
                    veiculoEncontrado.setPlaca(sc.nextLine());
                    System.out.println("Km: ");
                    veiculoEncontrado.setKm(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Preco da Compra: ");
                    veiculoEncontrado.setPrecoCompra(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Cavalos: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((CarroEntity) veiculoEncontrado).setCavalos(sc.nextFloat());
                    sc.nextLine();
                    System.out.println("Passageiros: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((CarroEntity) veiculoEncontrado).setPassageiros(sc.nextInt());
                    sc.nextLine();

                }
                //verificando se o objeto "veiculoEncontrado" é uma instância de MotoEntity
                //se for, o objeto encontrado passa a ser alterado
                else if(veiculoEncontrado instanceof MotoEntity) {
                    System.out.println("Marca: ");
                    veiculoEncontrado.setMarca(sc.nextLine());
                    System.out.println("Modelo: ");
                    veiculoEncontrado.setModelo(sc.nextLine());
                    System.out.println("Cor: ");
                    veiculoEncontrado.setCor(sc.nextLine());
                    System.out.println("Placa: ");
                    veiculoEncontrado.setPlaca(sc.nextLine());
                    System.out.println("Km: ");
                    veiculoEncontrado.setKm(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Preco Compra: ");
                    veiculoEncontrado.setPrecoCompra(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Cilindragem: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((MotoEntity) veiculoEncontrado).setCilindragem(sc.nextFloat());
                    sc.nextLine();
                    System.out.println("Carenagem: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((MotoEntity) veiculoEncontrado).setCarenagem(sc.nextLine());
                    sc.nextLine();
                }
                //verificando se o objeto "veiculoEncontrado" é uma instância de CaminhaoEntity
                //se for, o objeto encontrado passa a ser alterado
                else if(veiculoEncontrado instanceof CaminhaoEntity) {
                    System.out.println("Marca: ");
                    veiculoEncontrado.setMarca(sc.nextLine());
                    System.out.println("Modelo: ");
                    veiculoEncontrado.setModelo(sc.nextLine());
                    System.out.println("Cor: ");
                    veiculoEncontrado.setCor(sc.nextLine());
                    System.out.println("Placa: ");
                    veiculoEncontrado.setPlaca(sc.nextLine());
                    System.out.println("Km: ");
                    veiculoEncontrado.setKm(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Preco da Compra: ");
                    veiculoEncontrado.setPrecoCompra(sc.nextDouble());
                    sc.nextLine();
                    System.out.println("Toneladas: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((CaminhaoEntity) veiculoEncontrado).setToneladas(sc.nextFloat());
                    sc.nextLine();
                    System.out.println("Cabine: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((CaminhaoEntity) veiculoEncontrado).setCabine(sc.nextLine());
                    sc.nextLine();
                }
            }
        }else System.out.println("Não tem veículos disponíveis!");
    }
}
