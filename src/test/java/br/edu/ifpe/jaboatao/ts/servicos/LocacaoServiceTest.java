package br.edu.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;

public class LocacaoServiceTest {

	// Teste 4.a
	@Test
	@DisplayName("Questao 4.a - Verificar valor da locacao com 2 roupas.")
	public void verificarValorLocacaoComDuasRoupas() {

		// Cenario
		Cliente cliente = new Cliente("Breno");
		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 12.0),
				new Roupa("Bermuda", "P", 10, 10.0));

		// Acao
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao = locacaoService.alugarRoupa(cliente, roupas);

		// Verificao
		assertEquals(22.0, locacao.getValorLocacao());
	}

	// Teste 4.b.1
	@Test
	@DisplayName("Questao 4.b.1 - Verificando exceção para lista de roupas vazia usando try/catch")
	public void verificarValorRoupaTryCatch() {

		// Cenario
		Cliente cliente = new Cliente("Felipe");
		List<Roupa> roupas = Arrays.asList();

		try {
			// Acao
			LocacaoService locacaoService = new LocacaoService();
			locacaoService.alugarRoupa(cliente, roupas);

		} catch (IllegalArgumentException e) {

			// Verificao
			assertEquals("Exceção: Roupa nula.", e.getMessage());
		}
	}

	// Teste 4.b.2
	@Test
	@DisplayName("Questao 4.b.2 - Verificando exceção para roupa com valor <= 0 usando assertThrows")
	public void verificarValorRoupaAssertThrows() {

		// Cenario
		Cliente cliente = new Cliente("João");
		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 0.0));

		// Acao
		LocacaoService locacaoService = new LocacaoService();

		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> locacaoService.alugarRoupa(cliente, roupas));

		// Verificao
		assertEquals("Exceção: Verificar valor da roupa.", exception.getMessage());
	}

	@Test
	@DisplayName("Questao 5.a - Verificar desconto de 10% para 3 roupas")
	public void verificarDescontoTresRoupas() {

		// Cenario
		Cliente cliente = new Cliente("Breno");

		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 50.0),
				new Roupa("Bermuda", "P", 10, 50.0),
				new Roupa("Casaco", "M", 8, 50.0));

		// Acao
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao = locacaoService.alugarRoupa(cliente, roupas);

		// Verificacao
		assertEquals(135.0, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Questao 5.b - Verificar desconto de 15% para 4 ou mais roupas")
	public void verificarDescontoQuatroRoupas() {

		// Cenario
		Cliente cliente = new Cliente("Breno");

		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 50.0),
				new Roupa("Bermuda", "P", 10, 50.0),
				new Roupa("Casaco", "M", 8, 50.0),
				new Roupa("Calca", "M", 2, 50.0));

		// Acao
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao = locacaoService.alugarRoupa(cliente, roupas);

		// Verificacao
		assertEquals(170.0, locacao.getValorLocacao());
	}

	@Test
	@DisplayName("Questao 5.c - Verificar desconto extra de 20% para valor maior ou igual a R$199")
	public void verificarDescontoExtra() {

		// Cenario
		Cliente cliente = new Cliente("Breno");

		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 100.0),
				new Roupa("Bermuda", "P", 10, 100.0),
				new Roupa("Casaco", "M", 8, 100.0));

		// Acao
		LocacaoService locacaoService = new LocacaoService();
		Locacao locacao = locacaoService.alugarRoupa(cliente, roupas);

		// Verificacao
		assertEquals(216.0, locacao.getValorLocacao());
	}
}