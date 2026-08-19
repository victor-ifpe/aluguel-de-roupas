package br.edu.ifpe.jaboatao.ts.servicos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;

public class LocacaoServiceTest {

	LocacaoService service;

	@BeforeEach
	public void setup() {
		service = new LocacaoService();
	}

	List<Roupa> criarRoupas() {
		return Arrays.asList(
				new Roupa("Camisa", "G", 4, 12.0),
				new Roupa("Bermuda", "P", 10, 10.0),
				new Roupa("Calça", "M", 2, 16.0),
				new Roupa("Casaco", "PP", 8, 17.0),
				new Roupa("Regata", "M", 2, 12.0));
	}

	// Teste 1
	@Test
	@DisplayName("Verificando se o cliente consegue alugar 5 roupas")
	public void alugandoVariasRoupas() {
		// Cenario
		Cliente cliente = new Cliente("Cliente 01");
		List<Roupa> roupas = criarRoupas();

		// Acao
		Locacao locacao = service.alugarRoupa(cliente, roupas);

		// Verificacao
		assertEquals(5, locacao.getRoupas().size());
	}

	// Teste 2
	@Test
	@DisplayName("Listando as roupas que tenham o estoque maior que 2")
	public void verificandoEstoque() {
		// Cenario
		Cliente cliente = new Cliente("Felipe");
		List<Roupa> roupas = criarRoupas();

		// Acao
		Locacao locacao = service.alugarRoupa(cliente, roupas);
		ArrayList<Object> roupasEstoque = new ArrayList<>();
		for (Roupa roupa : roupas) {
			if (roupa.getEstoque() > 2) {
				roupasEstoque.add(roupa);
			}
		}

		// Verificao
		assertEquals(3, roupasEstoque.size());
	}

	// Teste 3
	@Test
	@DisplayName("Verificando o dia que que o cliente reservou as roupas")
	public void verificarDiaAluguel() {
		// Cenario
		Cliente cliente01 = new Cliente("Victor");
		Cliente cliente02 = new Cliente("Rafael");

		List<Roupa> roupas01 = Arrays.asList(
				new Roupa("Camisa", "G", 4, 12.0),
				new Roupa("Bermuda", "P", 10, 10.0));

		List<Roupa> roupas02 = Arrays.asList(
				new Roupa("Casaco", "PP", 8, 17.0),
				new Roupa("Regata", "M", 2, 12.0));

		// Acao
		Locacao locacao01 = service.alugarRoupa(cliente01, roupas01);
		Locacao locacao02 = service.alugarRoupa(cliente02, roupas02);

		// Verificacao
		LocalDate dataHoje = LocalDate.now();

		LocalDate dataLocacao01 = locacao01.getDataLocacao()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();

		LocalDate dataLocacao02 = locacao02.getDataLocacao()
				.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate();

		assertEquals(dataHoje, dataLocacao01);
		assertEquals(dataHoje, dataLocacao02);
	}

	// Teste 4
	@Test
	@DisplayName("Verificando o cliente da locacao")
	public void verificarNomeClienteLocacao() {
		// Cenario
		Cliente cliente = new Cliente("Vitoria");

		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 12.0),
				new Roupa("Bermuda", "P", 10, 10.0));

		// Acao
		Locacao locacao01 = service.alugarRoupa(cliente, roupas);

		// Verificacao
		assertEquals("Vitoria", locacao01.getCliente().getNome());
	}

	// Teste 5
	@Test
	@DisplayName("Verificando o valor total da locacao")
	public void verificarValorTotalLocacao() {
		// Cenario
		Cliente cliente = new Cliente("Danilo");
		List<Roupa> roupas = criarRoupas();

		// Acao
		Locacao locacao = service.alugarRoupa(cliente, roupas);
		double tot = 0.0;

		ArrayList<Object> roupasEstoque = new ArrayList<>();
		for (Roupa roupa : roupas) {
			tot += roupa.getValor();
		}

		// Verificacao
		assertEquals(67.0, tot);
	}

	// Teste 6
	@Test
	@DisplayName("Verificando se todas as roupas possuem valor maior que zero")
	public void verificarValorMaiorQueZero() {
		// Cenario
		Cliente cliente = new Cliente("Breno");
		List<Roupa> roupas = Arrays.asList(
				new Roupa("Camisa", "G", 4, 12.0),
				new Roupa("Bermuda", "P", 10, 10.0));

		// Acao
		Locacao locacao = service.alugarRoupa(cliente, roupas);
		ArrayList<Object> roupasValorMaiorZero = new ArrayList<>();
		for (Roupa roupa : roupas) {
			if (roupa.getValor() > 0) {
				roupasValorMaiorZero.add(roupa);
			}
		}

		// Verificao
		assertEquals(roupasValorMaiorZero.size(), roupas.size());
	}

	// Teste 7
	@Test
	@DisplayName("Verificando se todas as roupas possuem estoque maior que zero")
	public void verificarEstoqueMaiorQueZero() {
		// Cenario
		Cliente cliente = new Cliente("Fabio");
		List<Roupa> roupas = Arrays.asList(
			new Roupa("Bermuda", "GG", 1, 15.0),
			new Roupa("Calça", "P", 8, 12.0));

		// Acao
		Locacao locacao = service.alugarRoupa(cliente, roupas);
		ArrayList<Object> roupasEstoqueMaiorZero = new ArrayList<>();
		for (Roupa roupa : roupas) {
			if (roupa.getEstoque() > 0) {
				roupasEstoqueMaiorZero.add(roupa);
			}
		}

		// Verificao
		assertEquals(roupasEstoqueMaiorZero.size(), roupas.size());
	}
}