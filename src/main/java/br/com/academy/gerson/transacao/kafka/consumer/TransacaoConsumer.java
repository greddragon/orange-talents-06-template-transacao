package br.com.academy.gerson.transacao.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import br.com.academy.gerson.transacao.kafka.consumer.model.ModelTransacao;
import br.com.academy.gerson.transacao.service.TransacaoService;

@Component
public class TransacaoConsumer {
	
	@Autowired
	TransacaoService transacaoService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@KafkaListener(topics = "${transaction.topic}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "kafkaListenerContainerFactory")
	public void consumer(final ConsumerRecord<String, ModelTransacao> consumerRecord) {
		log.info("key: " + consumerRecord.key());
		log.info("Headers: " + consumerRecord.headers());
		log.info("Partion: " + consumerRecord.partition());
		log.info("Order: " + consumerRecord.value().getId());

		transacaoService.salvarTransacao(consumerRecord.value());

	}

}
