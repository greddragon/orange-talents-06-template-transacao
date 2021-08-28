package br.com.academy.gerson.transacao.kafka.consumer.model;

import javax.persistence.EntityManager;

import br.com.academy.gerson.transacao.service.entity.Cartao;
import br.com.academy.gerson.transacao.service.entity.Estabelecimento;
import br.com.academy.gerson.transacao.service.entity.Transacao;

public class ModelTransacao {

	private String id;
	private Long valor;

	private ModelEstabelecimento estabelecimento;
	private ModelCartao cartao;

	private String efetivadaEm;

	public String getId() {
		return id;
	}

	public Long getValor() {
		return valor;
	}

	public ModelEstabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public ModelCartao getCartao() {
		return cartao;
	}

	public String getEfetivadaEm() {
		return efetivadaEm;
	}

	public Transacao toModel(EntityManager em) {
		
		Cartao cartaoEntity = em.find(Cartao.class, this.cartao.getId());
		
		if(cartaoEntity == null) {
			cartaoEntity = new Cartao(cartao.getId(), cartao.getEmail());
		}
		
		Estabelecimento estabelecimentoEntity = new Estabelecimento(estabelecimento.getNome(), estabelecimento.getCidade(), estabelecimento.getCidade());
		return new Transacao(id, valor, estabelecimentoEntity, cartaoEntity, efetivadaEm);
	}

}
