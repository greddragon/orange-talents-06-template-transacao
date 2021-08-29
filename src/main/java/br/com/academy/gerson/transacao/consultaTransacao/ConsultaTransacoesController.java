package br.com.academy.gerson.transacao.consultaTransacao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.academy.gerson.transacao.repository.TransacaoRepository;
import br.com.academy.gerson.transacao.service.entity.Transacao;

@RestController
@RequestMapping("api/consultacartao")
public class ConsultaTransacoesController {

	Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private TransacaoRepository repository;

	@GetMapping("/{idcartao}")
	public ResponseEntity<?> consultar(@PathVariable String idcartao) {

		String ordenacao = "efetivadaEm";

		Pageable page = PageRequest.of(0, 10, Direction.DESC, ordenacao);

		Page<Transacao> transacao = repository.findByCartaoIdCartao(idcartao, page);

		if (transacao.isEmpty()) {
			log.error("Cartão não existe");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		List<Transacao> listTransacao = transacao.getContent();

		log.info("Transações enviadas com sucesso");
		return ResponseEntity.ok().body(listTransacao);
	}
}
