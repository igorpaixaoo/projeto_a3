package main.java.com.igor.projeto_a3.entity;

//classe filha herdando da classe pai
public class CaminhaoEntity extends VeiculoEntity{
    //atributos da classe filha
	private Float toneladas;
	private String cabine;

    //construtor (pegando atributos da classe pai)
	public CaminhaoEntity(String modelo, String cor, String marca, String placa, Double km, 
			Double preco, Float toneladas, String cabine) {
		super(modelo, cor, marca, placa, km, preco);
		this.toneladas = toneladas;
		this.cabine = cabine;
	}
    //construtor sobrecarregado
	public CaminhaoEntity() {}

    //getters and setters
	public Float getToneladas() {
		return toneladas;
	}

	public void setToneladas(Float toneladas) {
		this.toneladas = toneladas;
	}

	public String getCabine() {
		return cabine;
	}

	public void setCabine(String cabine) {
		this.cabine = cabine;
	}

    //toString()
	@Override
	public String toString() {
		return "modelo: " + modelo + ", cor: " + cor + ", marca: " + marca + ", placa: " + placa + ", km: "
				+ km + ", preco: " + preco;
	}
}
