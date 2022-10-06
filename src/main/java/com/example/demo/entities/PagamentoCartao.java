package com.example.demo.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entities.enums.EstadoPagamento;

@Entity
@Table(name="PAGAMENTO_COM_CARTAO")
public class PagamentoCartao extends Pagamento{
	private static final long serialVersionUID = 1L;

	private Integer qtdParcelas;

	public PagamentoCartao() {}

	public PagamentoCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer qtdParcelas) {
		super(id, estadoPagamento, pedido);
		this.qtdParcelas = qtdParcelas;
	}



	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(qtdParcelas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PagamentoCartao other = (PagamentoCartao) obj;
		return Objects.equals(qtdParcelas, other.qtdParcelas);
	}
	
	
	
	
	
}
