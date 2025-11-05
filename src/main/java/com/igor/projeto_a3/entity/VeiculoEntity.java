package main.java.com.igor.projeto_a3.entity;

//classe abstrata para herança
public abstract class VeiculoEntity {
	//atributos classe pai
	protected String modelo;
	protected String cor;
	protected String marca;
	protected String placa;
	protected Double km;
	protected Double preco;
    protected Boolean vendido;

    //construtor
	public VeiculoEntity(String modelo, String cor, String marca, String placa, Double km, Double preco) {
		this.modelo = modelo;
		this.cor = cor;
		this.marca = marca;
		this.placa = placa;
		this.km = km;
		this.preco = preco;
	}
	//construtor sobrecarregado
	public VeiculoEntity() {
		
	}

    //getters and setters
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getKm() {
		return km;
	}

	public void setKm(Double km) {
		this.km = km;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    //toString() pai
    @Override
	public String toString() {
		return "modelo: " + modelo + ", cor: " + cor + ", marca: " + marca + ", placa: " + placa + ", km: "
				+ km + ", preco: " + preco;
	}
	
	
}
