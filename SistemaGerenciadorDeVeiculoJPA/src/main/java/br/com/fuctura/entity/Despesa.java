package br.com.fuctura.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_despesa")
public class Despesa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	private Double valor;
	private String descricao;
	private LocalDateTime dhCompra;
	
	@PrePersist
	public void setNow() {
		dhCompra = LocalDateTime.now();
	}

	public LocalDateTime getDhCompra() {
		return dhCompra;
	}

	public void setDhCompra(LocalDateTime dhCompra) {
		this.dhCompra = dhCompra;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
