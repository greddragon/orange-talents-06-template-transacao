package br.com.academy.gerson.transacao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.academy.gerson.transacao.service.entity.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String>{

	Page<Transacao> findByCartaoIdCartao(String idcartao, Pageable page);

	

}
