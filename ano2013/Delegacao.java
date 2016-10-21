package br.cederj.comp.ano2013;

// Aluno

interface IAluno {
	double getCr();
}

class Aluno implements IAluno {
	public double getCr() {
		return 0;
	}
}

// Funcionario

interface IFuncionario {
	double getSalario();
}

class Funcionario implements IFuncionario {
	public double getSalario() {
		return 0;
	}
}

// Estagiario

class Estagiario {
	IAluno aluno;
	IFuncionario func;
	
	public Estagiario (IAluno aluno, IFuncionario func) {
		this.aluno = aluno;
		this.func = func;
	}
}

public class Delegacao {
	public static void main(String[] args) {
		
	}
}
