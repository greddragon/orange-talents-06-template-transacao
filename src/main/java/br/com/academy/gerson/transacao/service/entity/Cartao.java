package br.com.academy.gerson.transacao.service.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {

	@Id
	@NotBlank
	private String idCartao;
	@NotBlank
	private String email;

	@Deprecated
	public Cartao() {

	}

	public Cartao(@NotBlank String idCartao, @NotBlank String email) {
		this.idCartao = idCartao;
		this.email = email;
	}

	public String getIdCartao() {
		return idCartao;
	}

	public String getEmail() {
		return email;
	}

}
