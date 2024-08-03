package br.com.fuctura.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer codigo;
	private String nome;
	@Column(length = 14)
	private String cpf;
	private Integer idade;
	@OneToOne
	@JoinColumn(name = "join_column_estudo")
	private Despesa despesas;

	
	
	public Despesa getDespesas() {
		return despesas;
	}

	public void setDespesas(Despesa despesas) {
		this.despesas = despesas;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
