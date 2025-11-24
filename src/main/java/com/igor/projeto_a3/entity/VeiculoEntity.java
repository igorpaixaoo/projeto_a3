package main.java.com.igor.projeto_a3.entity;

//classe abstrata para herança
public abstract class VeiculoEntity{
	//atributos classe pai
	protected String modelo;
	protected String cor;
	protected String marca;
	protected String placa;
	protected Double km;
    protected Double precoVenda, precoCompra;
    protected Boolean vendido;

    //construtor
	public VeiculoEntity(String modelo, String cor, String marca, String placa, Double km, Double precoCompra) {
		this.modelo = modelo;
		this.cor = cor;
		this.marca = marca;
		this.placa = placa;
		this.km = km;
        this.precoCompra = precoCompra;
	}

    public VeiculoEntity(){

    }

    public abstract String tipoVeiculo();

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


    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    //toString() pai
    @Override
	public String toString() {
		return "modelo: " + modelo + ", cor: " + cor + ", marca: " + marca + ", placa: " + placa + ", km: "
				+ km;
	}
}
