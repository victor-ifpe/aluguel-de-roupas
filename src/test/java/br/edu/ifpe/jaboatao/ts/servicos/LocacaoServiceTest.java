package br.edu.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoServiceTest {

	LocacaoService service;

	@BeforeEach
	public void setup() {
		service = new LocacaoService();
	}

	List<Roupa> criarRoupas() {
		return Arrays.asList(
			new Roupa("Camisa","G",4,12.0),
			new Roupa("Bermuda","P",10,10.0),
			new Roupa("Calça","M",2,16.0),
			new Roupa("Casaco","PP",8,17.0),
			new Roupa("Regata","M",2,12.0)
		);
	}



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



	@Test
	@DisplayName("Listando as roupas que tenham o estoque maior que 2")
	public void verificandoEstoque() {

		// Cenario
        Cliente cliente = new Cliente("Cliente 01");
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



	// @Test
	// @DisplayName("Verificando o dia que que o cliente reservou as roupas")

	// public void verificarDiaAluguel() {

	// 	// Cenario
	// 	Cliente cliente01 = new Cliente("Victor");
	// 	Cliente cliente02 = new Cliente("Rafael");

	// 	List<Roupa> roupas01 = Arrays.asList(
	// 		new Roupa("Camisa","G",4,12.0),
	// 		new Roupa("Bermuda","P",10,10.0)
	// 	);

	// 	List<Roupa> roupas02 = Arrays.asList(
	// 		new Roupa("Casaco","PP",8,17.0),
	// 		new Roupa("Regata","M",2,12.0)
	// 	);


	// 	// Acao
	// 	Locacao locacao01 = service.alugarRoupa(cliente01, roupas01);
	// 	Locacao locacao02 = service.alugarRoupa(cliente02, roupas02);


	// 	// Verificao
	// 	assertEquals("15-08-2026", locacao01.getDataLocacao());



	// }
		

	

}