package main.java.com.igor.projeto_a3.entity;

//classe filha herdando da classe pai
public class CarroEntity extends VeiculoEntity{
	//atributos da classe filha
	private Float cavalos;
	private Integer passageiros;

    //construtor (pegando atributos da classe pai)
	public CarroEntity(String modelo, String cor, String marca, String placa, Double km, Double preco, Float cavalos, Integer passageiros) {
		super(modelo, cor, marca, placa, km, preco);
		this.cavalos = cavalos;
		this.passageiros = passageiros;
	}
    //construtor sobrecarregado
	public CarroEntity() {}

    //getters and setters
	public Float getCavalos() {
		return cavalos;
	}

	public void setCavalos(Float cavalos) {
		this.cavalos = cavalos;
	}

	public Integer getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(Integer passageiros) {
		this.passageiros = passageiros;
	}

    //método toString()
	@Override
	public String toString() {
		return "Modelo: " + modelo + ", Cor: " + cor + ", Marca: " + marca + ", Placa: " + placa + ", KM: "
				+ km +  ", Cavalos: " + cavalos +  ", Passageiros: " + passageiros;
	}

}
