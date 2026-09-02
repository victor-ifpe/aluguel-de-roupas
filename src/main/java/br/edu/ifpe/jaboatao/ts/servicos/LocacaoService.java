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

			// Verifica se o valor da roupa é maior que 10
			if (roupa.getValor() < 10) {
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

		// Se o cliente alugar 5 ou mais roupas, aplica um desconto de 10%
		if (roupas.size() >= 5) {
			valorTotal *= 0.90;
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