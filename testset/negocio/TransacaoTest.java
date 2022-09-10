package negocio;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TransacaoTest {

	Transacao transacao;
	Locacao locacao1;
	Locacao locacao2;
	Locacao locacao3;
	Locacao locacao4;
	Filme filme1;
	Filme filme2;
	Filme filme3;
	Cliente cliente_1;
	Cliente cliente_2;
	Cliente cliente_3;
	Cliente cliente4;
	Desconto descontoAcao;

	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		locacao4 = new Locacao();
		
		filme1 = new Filme("300 Spartanus", Genero.ACAO);
		filme1.valorCompra = 100;
		filme1.id = 1;

		filme2 = new Filme("Procurando Nemo", Genero.ANIMACAO);
		filme2.valorCompra = 50;
		filme2.id = 2;
		
		filme3 = new Filme("O poderoso chefão", Genero.POLICIAL);
		filme3.valorCompra = 150;
		filme3.id = 3;
		
		cliente_1 = new Cliente("Caio", 1);
		cliente_1.clienteAtivo();
		cliente_2 = new Cliente("Andrea", 2);
		cliente_2.clienteAtivo();
		cliente_3 = new Cliente("Lucas", 1);
		cliente_3.clienteInativo();
		
		locacao1.alugar(cliente_1, filme1);
		locacao1.setDataLocacao("01/09/2022");
		locacao1.setHoraLocacao("20:30");
		locacao1.valorAluguel = 30;
		
		locacao2.alugar(cliente_2, filme2);
		locacao2.setDataLocacao("30/07/2022");
		locacao2.setHoraLocacao("12:30");
		locacao2.valorAluguel = 40;
		
		locacao3.alugar(cliente_3, filme3); //esse não foi feito
		locacao3.setDataLocacao("30/07/2022");
		locacao3.setHoraLocacao("12:30");
		locacao3.valorAluguel = 20;
		
		locacao4.alugar(cliente_2, filme2);
		locacao4.setDataLocacao("30/07/2022");
		locacao4.setHoraLocacao("12:30");
		locacao4.valorAluguel = 20;
		
		transacao = new Transacao();
		transacao.addLocacao(locacao1);
		transacao.addLocacao(locacao2);
		transacao.addLocacao(locacao3);
		transacao.addLocacao(locacao4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void alugueisListTest() {
		
		assertEquals(transacao.alugueis.get(0).cliente.nome, "Caio");
		assertEquals(transacao.alugueis.get(1).cliente.nome, "Andrea");
		assertEquals(transacao.alugueis.size(), 3);

		assertTrue("Filme deveria ser selecionado corretamente",transacao.alugueis.get(1).filme.id==2);
	}
	@Test
	public void buscaCliente() {
		assertTrue(transacao.buscaCliente(1) == cliente_1);
	} 

	@Test
	public void valorLocacaoTotalTest() {
		assertEquals(200, transacao.valorLocacaoTotal(), 0.1);
	}

	@Test 
	public void calculoLucroTest() {
		assertEquals(120.0, transacao.calculoLucro(2), 0.1);
	}
	
	@Test 
	public void filmeMaisAlugadoTest() {
		assertTrue(transacao.generoMaisAlugado() == Genero.ANIMACAO);
	}
	
	@Test
	public void descontoTest() {
		descontoAcao = new Desconto(Genero.ACAO, 0.1);
		locacao1.setValorAluguel(50, descontoAcao);
		assertEquals(45, locacao1.valorAluguel,.1);
	}
	
	@Test
	public void transacaoFilmesFavoristosTest() {
		FilmesFavoritos listaFilmes = new FilmesFavoritos();
		listaFilmes.addFilme(filme1);
		listaFilmes.addFilme(filme3);
		assertTrue(listaFilmes.buscaFilmeId(1).nome == filme1.nome);
		assertTrue(listaFilmes.buscaFilmeNome("O PODEROSO CHEFÃO").nome == filme3.nome);
		
		Locacao locacao4 = new Locacao();
		locacao4.alugar(cliente_1, listaFilmes.buscaFilmeId(1));
		assertTrue(locacao4.filme.nome == filme1.nome);
		assertTrue(locacao4.cliente.nome == cliente_1.nome);
		
	}
	

}
