package br.cederj.comp.ano2009;

public class AP2_2009_1_Q2 {
	private State state;
	private String responsavel;
	protected abstract class State { 
		void encaminhar(String pessoa) throws AcaoInvalidaException {
			throw new AcaoInvalidaException(state,"encaminhar");
		}
		void fechar() 
		throws AcaoInvalidaException {
			throw new AcaoInvalidaException(state,"fechar");
		}
		void aceitar()
		throws AcaoInvalidaException {
			throw new AcaoInvalidaException(state,"aceitar");
		}
		void reabrir()
		throws AcaoInvalidaException {
			throw new AcaoInvalidaException(state,"reabrir");
		}
	}
	private class Aberto extends State {
		void encaminhar(String pessoa) 
		throws AcaoInvalidaException {
			responsavel = pessoa;
			state = new EmAndamento();
		}
		public String toString() {
			return "Aberto";
		}
	}
	private class EmAndamento extends State {
		void encaminhar(String pessoa) 
		throws AcaoInvalidaException {
			responsavel = pessoa;
		}
		void fechar()
		throws AcaoInvalidaException {
			state = new Solucionado();
		}
		public String toString() {
			return "Em andamento, pelo responsável "+responsavel;
		}
	}
	private class Aceito extends State {
		public String toString() {
			return "Aceito";
		}
	}
	private class Solucionado extends State {
		void aceitar() 
		throws AcaoInvalidaException {
			state = new Aceito();
		}
		void reabrir() throws AcaoInvalidaException {
			responsavel = null;
			state = new Aberto();
		}
		void fechar()
		throws AcaoInvalidaException {
			state = new Solucionado();
		}
		public String toString() {
			return "Solucionado";
		}
	}
	public AP2_2009_1_Q2() {
		state = new Aberto();
	}
	public void encaminhar(String pessoa) 
	throws AcaoInvalidaException {
		state.encaminhar(pessoa);
	}
	public void fechar() 
	throws AcaoInvalidaException {
		state.fechar();
	}
	public void aceitar()
	throws AcaoInvalidaException {
		state.aceitar();
	}
	public void reabrir()
	throws AcaoInvalidaException {
		state.reabrir();
	}
	public String toString() {
		return state.toString();
	}
	public static void main (String[] args) {
		try {
			AP2_2009_1_Q2 t = new AP2_2009_1_Q2();
			System.out.println (t);
			t.encaminhar ("Joao");
			System.out.println (t);
			t.encaminhar ("José");
			System.out.println (t);
			t.fechar ();
			System.out.println (t);
			t.reabrir();
			System.out.println (t);
			t.encaminhar ("Maria");
			System.out.println (t);
			t.fechar();
			System.out.println (t);
			t.aceitar(); 
			System.out.println (t);
			t.fechar();
			System.out.println (t);
		} catch (AcaoInvalidaException e) {
			System.out.println (e);
		}
	}
}
class AcaoInvalidaException extends Exception {
	AcaoInvalidaException (AP2_2009_1_Q2.State from, String acao) {
		super("Transicao invalida: " + from + " nao permite a acao " + 
				acao);
	}
	AcaoInvalidaException (String msg) {
		super(msg);
	}
}