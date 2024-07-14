package br.com.fuctura.entidade;

public class Usuario {
	private int codigo;
	private String cpf;
	private int idade;

	// getter and setter
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", cpf=" + cpf + ", idade=" + idade + "]";
	}

}
