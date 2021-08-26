package br.com.academy.gerson.transacao.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.academy.gerson.transacao.kafka.consumer.model.ModelTransacao;
import br.com.academy.gerson.transacao.service.entity.Transacao;

@Service
public class TransacaoService {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void salvarTransacao(ModelTransacao modelTransacao) {
		
		Transacao transacao = modelTransacao.toModel();
		
		em.persist(transacao);
		
		log.info("transação cadastrada com sucesso");
	}
}
