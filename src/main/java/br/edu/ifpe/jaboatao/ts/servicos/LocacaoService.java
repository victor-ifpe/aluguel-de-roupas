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
		for (Roupa roupa : roupas) {
			valorTotal += roupa.getValor();
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