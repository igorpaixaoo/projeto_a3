package main.java.com.igor.projeto_a3.entity;

public class MotoEntity extends VeiculoEntity{
	
	private String carenagem;
	private Float cilindragem;
	
	public MotoEntity(String modelo, String cor, String marca, String placa, Double km, 
			Double preco, String carenagem, Float cilindragem) {
		super(modelo, cor, marca, placa, km, preco);
		this.carenagem = carenagem;
		this.cilindragem = cilindragem;
	}

    public MotoEntity(){

    }

	public String getCarenagem() {
		return carenagem;
	}

	public void setCarenagem(String carenagem) {
		this.carenagem = carenagem;
	}

	public Float getCilindragem() {
		return cilindragem;
	}

	public void setCilindragem(Float cilindragem) {
		this.cilindragem = cilindragem;
	}

    @Override
    public String tipoVeiculo() {
        return "Moto";
    }

    @Override
	public String toString() {
		return "Modelo: " + modelo + ", Cor: " + cor + ", Marca: " + marca + ", Placa: " + placa + ", KM: "
				+ km + ", Preco: " + ", Carenagem: " + carenagem + ", Cilindragem: " + cilindragem;
	}


}
