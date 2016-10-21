package br.cederj.comp.ano2008;

/* Classe abstrata que modela a estrutura de um e-mail 
 */
abstract class EmailAbstrato {
	// Atributos de um e-mail
	private String remetente;
	private String destinatario;
	private String assunto;
	private String mensagem;
	
	// Métodos que obrigam a sobrecarga por parte das
	//classes que especializam esta
	public abstract String de();
	public abstract String para();
	public abstract String assunto();
	public abstract String saudacaoInicial();
	public abstract String saudacaoFinal();
	
	// Construtor default de um e-mail
	public EmailAbstrato(String remet, 
						 String dest, 
						 String ass, 
						 String msg) {
		remetente = remet;
		destinatario = dest;
		assunto = ass;
		mensagem = msg;
	}
	
	// Métodos get/set para os atributos do e-mail
	public String getRemetente() {
		return remetente;
	}
	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	// Este método obtem a mensagem completa, 
	//combinando os dados presentes no e-mail
	public String obtemMensagemCompleta () {
		String cabecalho = this.de() + " " + this.getRemetente() + "\n" +
						   this.para() + " " + this.getDestinatario() + "\n" +
						   this.assunto() + " " + this.getAssunto() + "\n" +
						   "\n" +
						   this.saudacaoInicial() + " " + this.getDestinatario() +
						   "\n";
		
		String rodape = "\n" +
		 				this.saudacaoFinal() + "\n" +
						this.getRemetente();
		
		return cabecalho + this.getMensagem() + rodape;						   
	}
}

/* Classe concreta para o Português */
class EmailPortugues extends EmailAbstrato {
	public EmailPortugues(String remet, String dest, String ass, String msg) {
		super(remet, dest, ass, msg);
	}

	public String de() {
		return "De:";
	}

	public String para() {
		return "Para:";
	}
	
	public String assunto() {
		return "Assunto:";
	}
	
	public String saudacaoInicial() {
		return "Querido(a)";
	}

	public String saudacaoFinal() {
		return "Sinceramente";
	}
}

/* Classe concreta para o Inglês */
class EmailIngles extends EmailAbstrato {
	public EmailIngles(String remet, String dest, String ass, String msg) {
		super(remet, dest, ass, msg);
	}

	public String de() {
		return "From:";
	}

	public String para() {
		return "To:";
	}
	
	public String assunto() {
		return "Subject:";
	}

	public String saudacaoInicial() {
		return "Dear(a)";
	}

	public String saudacaoFinal() {
		return "Sincerely";
	}
}

/* Classe Principal com exemplos de instanciação
 * de objetos das classes criadas. */
public class AP3_2008_1_Q4 {
	public static void main(String[] args) {
		EmailAbstrato email = new EmailPortugues("Bazilio", "Aluno", "boa prova", 
				"Este e-mail é para desejar-lhe boa sorte!");
		System.out.println(email.obtemMensagemCompleta());
		EmailAbstrato emailIng = new EmailIngles("Bazilio", "Aluno", "Boa prova", 
				"Este e-mail é para desejar-lhe boa sorte!");
		System.out.println(emailIng.obtemMensagemCompleta());
	}
}
