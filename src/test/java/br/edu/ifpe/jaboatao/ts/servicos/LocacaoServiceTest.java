
package br.edu.ifpe.jaboatao.ts.servicos;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;

public class LocacaoServiceTest {
	private LocacaoService locacaoService;

	@BeforeEach
	public void setUp() {
		locacaoService = new LocacaoService();
	}

	// Teste 4.a
	@Test
	@DisplayName("Questao 4.a - Verificar se o valor da locacao está sendo calculado corretamente para 3 roupas")
	public void verificarValorLocacaoComTresRoupas() {

		// Cenario
		Cliente cliente = new Cliente("Breno");
		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 12.0),
				new Roupa("Bermuda", "P", 10, 10.0),
				new Roupa("Bermuda", "P", 10, 12.0));

		// Acao
		Locacao locacao = locacaoService.alugarRoupa(cliente, roupas);

		// Verificao
		assertEquals(34.0, locacao.getValorLocacao());
	}

	// Teste 4.b.1
	@Test
	@DisplayName("Questao 4.b.1 - Verificando exceção para roupa com valor menor que 10 usando try/catch")
	public void verificarValorRoupaTryCatch() {

		// Cenario
		Cliente cliente = new Cliente("Felipe");
		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 8.0));

		try {
			// Acao
			Locacao locacao = locacaoService.alugarRoupa(cliente, roupas);

		} catch (IllegalArgumentException e) {

			// Verificao
			assertEquals("Exceção: Verificar valor da roupa.", e.getMessage());
		}
	}

	// Teste 4.b.2
	@Test
	@DisplayName("Questao 4.b.2 - Verificando exceção para roupa com valor menor que 10 assertThrows")
	public void verificarValorRoupaAssertThrows() {

		// Cenario
		Cliente cliente = new Cliente("João");
		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 9.0));

		Exception exception = assertThrows(IllegalArgumentException.class,
				() -> locacaoService.alugarRoupa(cliente, roupas));

		// Verificao
		assertEquals("Exceção: Verificar valor da roupa.", exception.getMessage());
	}

	@Test
	@DisplayName("Quem alugar 5 (cinco) ou mais roupas ganhará 10%.")
	public void verificarDescontoCincoMaisRoupas() {

		// Cenario
		Cliente cliente = new Cliente("Breno");

		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 100.0),
				new Roupa("Bermuda", "P", 10, 100.0),
				new Roupa("Casaco", "M", 8, 100.0),
				new Roupa("Camisa", "G", 4, 100.0),
				new Roupa("Bermuda", "P", 10, 100.0));

		// Acao
		Locacao locacao = locacaoService.alugarRoupa(cliente, roupas);

		// Verificacao
		assertEquals(450.0, locacao.getValorLocacao());
	}
}