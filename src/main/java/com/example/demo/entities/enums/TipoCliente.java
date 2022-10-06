package com.example.demo.entities.enums;

public enum TipoCliente {
	PESSOA_FISICA(1,"Pessoa Fisica"),
	PESSOA_JURIDICA(2, "Pessoa Juridica");
	
	private Integer cod;
	private String description;
	
	private TipoCliente(int cod, String description) {
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

	public static TipoCliente toEnum(Integer cod) {
		if(cod==null) {
			throw new IllegalArgumentException("1 or 2 / Pessoa F. ou Pessoa J.");
		}
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod()))
				return x;
		}
		return null;
	}
	
}
