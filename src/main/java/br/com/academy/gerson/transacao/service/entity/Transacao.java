package br.com.academy.gerson.transacao.service.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Transacao {

	@Id
	private String id;
	@NotNull
	private Long valor;

	@ManyToOne(cascade = CascadeType.PERSIST)
	private Estabelecimento estabelecimento;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Cartao cartao;

	private LocalDateTime efetivadaEm;
	
	@Deprecated
	public Transacao() {

	}

	public Transacao(String id, @NotNull Long valor, Estabelecimento estabelecimento,
			Cartao cartao, String efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = LocalDateTime.parse(efetivadaEm);
	}

	public String getId() {
		return id;
	}

	public Long getValor() {
		return valor;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return efetivadaEm;
	}
	
	
}
