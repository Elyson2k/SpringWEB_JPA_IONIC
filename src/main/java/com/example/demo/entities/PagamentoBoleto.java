package com.example.demo.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.demo.entities.enums.EstadoPagamento;

@Entity
@Table(name="PAGAMENTO_COM_BOLETO")
public class PagamentoBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date vencimento;
	private Date pagamento;
	
	public PagamentoBoleto() {}

	public PagamentoBoleto(Integer id, EstadoPagamento estadoPagamento, Date vencimento,
			Date pagamento, Pedido pedido) {
		super(id, estadoPagamento, pedido);
		this.vencimento = vencimento;
		this.pagamento = pagamento;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Date getPagamento() {
		return pagamento;
	}

	public void setPagamento(Date pagamento) {
		this.pagamento = pagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(pagamento, vencimento);
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
		PagamentoBoleto other = (PagamentoBoleto) obj;
		return Objects.equals(pagamento, other.pagamento) && Objects.equals(vencimento, other.vencimento);
	}

}
