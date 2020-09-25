package com.marcosfausto.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1,"Pessoa Fisica"),
	PESSOAJURICA(2,"Pessoa Jurica");
	
	private int cod;
	private String descricao;
	
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public static TipoCliente toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		for(TipoCliente tipo: TipoCliente.values()) {
			if(cod.equals(tipo.getCod()))
				return tipo;
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
	
	

}
