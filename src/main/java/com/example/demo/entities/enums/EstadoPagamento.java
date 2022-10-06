package com.example.demo.entities.enums;

public enum EstadoPagamento {
	PAGO(1,"Produto Pago."),
	AGUARDANDO(2, "Aguardando pagamento.");
	
	private Integer cod;
	private String description;
	
	private EstadoPagamento(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if(cod==null) {
			throw new IllegalArgumentException("1 or 2 / Pago ou Aguardando pag.");
		}
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		return null;
	}
	
}
