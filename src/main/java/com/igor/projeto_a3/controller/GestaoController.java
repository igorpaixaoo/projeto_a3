package main.java.com.igor.projeto_a3.controller;

import main.java.com.igor.projeto_a3.entity.CaminhaoEntity;
import main.java.com.igor.projeto_a3.entity.CarroEntity;
import main.java.com.igor.projeto_a3.entity.MotoEntity;
import main.java.com.igor.projeto_a3.entity.VeiculoEntity;
import main.java.com.igor.projeto_a3.repository.VeiculosRepository;
import main.java.com.igor.projeto_a3.repository.VendasRepository;

import java.util.Scanner;

public class GestaoController {

    //lista de veiculos
    public VeiculosRepository veiculosRepository = new VeiculosRepository();
    public VendasRepository vendasRepository = new VendasRepository();

    Scanner sc = new Scanner(System.in);

    public GestaoController(){
        //inicializando os objetos automaticamente
        CarroEntity c1 = new CarroEntity();
        c1.setMarca("Mercedes");
        c1.setModelo("AMG One");
        c1.setCor("Cinza");
        c1.setPlaca("OGC-874F");
        c1.setPreco(14500.0);
        c1.setKm(10.0);
        c1.setCavalos(1200.0F);
        c1.setPassageiros(2);
        veiculosRepository.adicionarVeiculo(c1);

        MotoEntity m1 = new MotoEntity();
        m1.setMarca("Honda");
        m1.setModelo("CG Fan 160");
        m1.setCor("Vermelha");
        m1.setPlaca("ETF-854F");
        m1.setPreco(25000.0);
        m1.setKm(0.0);
        m1.setCarenagem("De rua");
        m1.setCilindragem(162.7f);
        veiculosRepository.adicionarVeiculo(m1);

        CaminhaoEntity ce1 = new CaminhaoEntity();
        ce1.setMarca("Scania");
        ce1.setModelo("P400");
        ce1.setCor("Branca");
        ce1.setPlaca("FGD-4457");
        ce1.setPreco(350000.0);
        ce1.setKm(15.0);
        ce1.setCabine("Grande");
        ce1.setToneladas(10000.0f);
        veiculosRepository.adicionarVeiculo(ce1);
    }

    //método para cadastrar
    public void cadastrar(){
        System.out.println("1 - Cadastrar Carro | 2 - Cadastrar Moto | 3 - Cadastrar Caminhão");
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
                System.out.println("Preco: ");
                carro.setPreco(sc.nextDouble());
                System.out.println("Cavalos: ");
                carro.setCavalos(sc.nextFloat());
                System.out.println("Passageiros: ");
                carro.setPassageiros(sc.nextInt());
                //adicionando a lista de veiculos
                veiculosRepository.adicionarVeiculo(carro);
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
                System.out.println("Preco: ");
                moto.setPreco(sc.nextDouble());
                System.out.println("Cilindragem: ");
                moto.setCilindragem(sc.nextFloat());
                System.out.println("Carenagem: ");
                moto.setCarenagem(sc.nextLine());
                //adicionando a lista de veiculos
                veiculosRepository.adicionarVeiculo(moto);
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
                System.out.println("Preco: ");
                caminhao.setPreco(sc.nextDouble());
                System.out.println("Toneladas: ");
                caminhao.setToneladas(sc.nextFloat());
                System.out.println("Cabine: ");
                caminhao.setCabine(sc.nextLine());
                //adicionando a lista de veiculos
                veiculosRepository.adicionarVeiculo(caminhao);
                break;
        }
    }

    //método para buscar
    public VeiculoEntity buscar(){
        System.out.println("\n");
        //verificando se a lista de veiculos não está vazia
        if(!veiculosRepository.veiculos.isEmpty()){
            System.out.println("Buscar veiculo (placa): ");
            //atributo (placa) digitado
            String atributoDigitado = sc.nextLine();

            //iterando a lista de veículos
            for(int i = 0; i < veiculosRepository.veiculos.size(); i++){
                /*se o atributo (placa) digitado (ignorando se é maiusculo ou minusculo) for igual ao atributo
                da lista da posição i, retorna o veiculo buscado
                */
                if(atributoDigitado.equalsIgnoreCase(veiculosRepository.veiculos.get(i).getPlaca())){
                    System.out.println(veiculosRepository.veiculos.get(i));
                    return veiculosRepository.veiculos.get(i);
                }
            }
        }else System.out.println("Veiculo não encontrado!");

        return null;
    }

    //método para listar
    public void listar(){
        System.out.println("\n");
        //verificando se a lista de veiculos não está vazia
        if(!veiculosRepository.veiculos.isEmpty()){
            //formatando para ficar em formato tabular com o printf()
            System.out.printf("%-20s %-15s %-15s%n",
                    "MODELO", "MARCA", "PLACA");
            System.out.println("---------------------------------------------");
            //foreach na lista de veiculos
            for(VeiculoEntity v : veiculosRepository.veiculos) {
                //fortamando os atributos com o printf
                System.out.printf("%-20s %-15s %-15s%n", v.getModelo(), v.getMarca(), v.getPlaca());
                System.out.println("---------------------------------------------");
            }
        }
    }

    //método para deletar
    public VeiculoEntity deletar(){
        System.out.println("\n");
        //verificando se a lista de veiculos não está vazia
        if (!veiculosRepository.veiculos.isEmpty()) {
            System.out.println("Deletar veiculo");
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
            System.out.println("Alterar veiculo");
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
                    System.out.println("Preco: ");
                    veiculoEncontrado.setPreco(sc.nextDouble());
                    System.out.println("Cavalos: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((CarroEntity) veiculoEncontrado).setCavalos(sc.nextFloat());
                    System.out.println("Passageiros: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((CarroEntity) veiculoEncontrado).setPassageiros(sc.nextInt());

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
                    System.out.println("Preco: ");
                    veiculoEncontrado.setPreco(sc.nextDouble());
                    System.out.println("Cilindragem: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((MotoEntity) veiculoEncontrado).setCilindragem(sc.nextFloat());
                    System.out.println("Carenagem: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((MotoEntity) veiculoEncontrado).setCarenagem(sc.nextLine());
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
                    System.out.println("Preco: ");
                    veiculoEncontrado.setPreco(sc.nextDouble());
                    System.out.println("Toneladas: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((CaminhaoEntity) veiculoEncontrado).setToneladas(sc.nextFloat());
                    System.out.println("Cabine: ");
                    //downcasting (conversão explícita da classe pai para classe filha)
                    ((CaminhaoEntity) veiculoEncontrado).setCabine(sc.nextLine());
                }
            }
        }
    }

}
