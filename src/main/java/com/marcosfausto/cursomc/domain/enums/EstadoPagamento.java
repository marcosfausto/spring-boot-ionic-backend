package com.marcosfausto.cursomc.domain.enums;

public enum EstadoPagamento {
	
	PENDENTE(1,"Pagamento pendente"),
	QUITADO(2,"Pagamento quitado"),
	CANCELADO(3,"Pagamento cancelado");

	private int cod;
	private String descricao;
	
	private EstadoPagamento(int cod, String descricao) {
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
	
	public static EstadoPagamento toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		for(EstadoPagamento estado: EstadoPagamento.values()) {
			if(cod.equals(estado.getCod()))
				return estado;
		}
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
	
	
}
