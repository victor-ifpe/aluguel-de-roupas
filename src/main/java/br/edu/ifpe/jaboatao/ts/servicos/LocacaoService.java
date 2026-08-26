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
		Locacao locacao = new Locacao();
		locacao.setRoupas(roupas);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());

		double valorTotal = 0;
		double valorRoupa = 0;
		for (int i = 0; i < roupas.size(); i++) {
			valorRoupa = roupas.get(i).getValor();
			if (i == 1) {
				valorRoupa *= 0.90;
			}

			if (i == 2) {
				valorRoupa *= 0.85;
			}

			if (i == 3) {
				valorRoupa *= 0.75;
			}

			if (i == 4) {
				valorRoupa *= 0.50;
			}

			valorTotal += valorRoupa;
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