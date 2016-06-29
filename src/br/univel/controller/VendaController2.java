package br.univel.controller;

import br.univel.model.Venda2;

public class VendaController2 extends Venda2 {

	public void gravarVenda(Venda2 venda) {

		VendaController2 vd = new VendaController2();
		
		vd.setCliente(venda.getCliente());
		vd.setCusto(venda.getCusto());
		vd.setDataHora(venda.getDataHora());
		vd.setProdutos(venda.getProdutos());
		vd.setnNota(venda.getnNota());
	}

}
