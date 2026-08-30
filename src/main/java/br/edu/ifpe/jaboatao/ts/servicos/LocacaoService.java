package br.edu.ifpe.jaboatao.ts.servicos;

//br.edu.ifpe.jaboata.ts.servicos
import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.entidades.Roupa;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoService {

	public Locacao alugarRoupa(Cliente cliente, List<Roupa> roupas) {

		// Tratamento de excecoes
		for (Roupa roupa : roupas) {

			// Verifica se existe roupa
			if (roupa == null) {
				throw new IllegalArgumentException("Exceção: Roupa nula.");
			}

			// Verifica se o valor da roupa é maior que zero
			if (roupa.getValor() <= 0) {
				throw new IllegalArgumentException("Exceção: Verificar valor da roupa.");
			}
		}

		Locacao locacao = new Locacao();
		locacao.setRoupas(roupas);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());

		// Calcula o valor total das roupas
		double valorTotal = 0;

		for (Roupa roupa : roupas) {
			valorTotal += roupa.getValor();
		}

		// 3 roupas = 10% de desconto
		if (roupas.size() == 3) {
			valorTotal *= 0.90;
		}

		// 4 ou mais roupas = 15% de desconto
		else if (roupas.size() >= 4) {
			valorTotal *= 0.85;
		}

		// Valor da locação maior ou igual a R$ 199,00
		// ganha mais 20% de desconto
		if (valorTotal >= 199.00) {
			valorTotal *= 0.80;
		}

		locacao.setValorLocacao(valorTotal);

		// Definir a entrega para 3 dias depois.
		Date dataEntrega = ManipulandoDatas.novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		// Salvando a locacao...
		// O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}

}