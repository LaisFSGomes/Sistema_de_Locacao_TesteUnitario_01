package negocio;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	protected String dataLocacao;
	protected String horaLocacao;
	
	public void alugar(Cliente c, Filme f) {
		this.cliente = c;
		this.filme = f;
		if (cliente.ativo) {
			this.cliente = c;
			this.filme = f;
		}
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel=valorAluguel;
	}
	public void setDataLocacao(String data) {
		this.dataLocacao = data;
	}
	public void setHoraLocacao(String hora) {
		this.horaLocacao = hora;
	}
}
