package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import negocio.Cliente;
import negocio.Filme;
import negocio.Genero;
import negocio.Locacao;
import negocio.Transacao;

public class TransacaoTest {

	Transacao transacao;
	Locacao locacao1;
	Locacao locacao2;
	Locacao locacao3;
	Filme filme1;
	Filme filme2;
	Filme filme3;
	Cliente cliente_1;
	Cliente cliente_2;
	Cliente cliente_3;
	Cliente cliente4;

	@Before
	public void setUp() throws Exception {
		locacao1 = new Locacao();
		locacao2 = new Locacao();
		locacao3 = new Locacao();
		
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
		
		locacao2.alugar(cliente_2, filme2);
		locacao2.setDataLocacao("30/07/2022");
		locacao2.setHoraLocacao("12:30");
		
		locacao3.alugar(cliente_3, filme3); //esse não foi feito
		locacao3.setDataLocacao("30/07/2022");
		locacao3.setHoraLocacao("12:30");
		
		transacao = new Transacao();
		transacao.addLocacao(locacao1);
		transacao.addLocacao(locacao2);
		transacao.addLocacao(locacao3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void alugueisListTest() {
		
		assertEquals(transacao.alugueis.get(0).cliente.nome, "Caio");
		assertEquals(transacao.alugueis.get(1).cliente.nome, "Andrea");
		assertEquals(transacao.alugueis.size(), 2);

		assertTrue("Filme deveria ser selecionado corretamente",transacao.alugueis.get(1).filme.id==2);
//		assertEquals(150, transacao.valorLocacaoTotal(), 0.1);
	}
	@Test
	public void buscaCliente() {
		assertTrue(transacao.buscaCliente(1) == cliente_1);
	} 


	@Test
	public void valorLocacaoTotalTest2() {
//
//		transacao.alugueis.add(locacao1);
//		transacao.alugueis.add(locacao2);
//		transacao.alugueis.add(locacao2);
//		assertEquals(200, transacao.valorLocacaoTotal(), 0.1);
	}

	@Test 
	public void buscaClienteIdTest() {
		
//		transacao.alugueis.add(locacao2);
//		assertEquals("Thiago",transacao.buscaCliente(3).nome);
	}
	
	@Test 
	public void calculoLucroTest() {
		
//		locacao2.setValorAluguel(25);
//		transacao.alugueis.add(locacao2);
//		
//		assertEquals(50,transacao.calculoLucro(20),0.01);
	}
	public void test1() {

//		assertEquals(Math.PI, 3.14, 0.01);
//		assertTrue("java".equalsIgnoreCase("Java"));
//		Filme f =new Filme("a", Genero.ROMANCE);
//		assertNull(f); // assertNotNull();
//		Filme f2 =new Filme("a", Genero.ROMANCE);
//
//		assertTrue(f==f2);
//		
//		assertSame(f, f2); // asserNotSame)();
//
//		assertTrue("Comparacao de objetos", f == f2);

	}

}
