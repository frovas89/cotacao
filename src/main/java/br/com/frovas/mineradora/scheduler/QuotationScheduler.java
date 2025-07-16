package br.com.frovas.mineradora.scheduler;

import br.com.frovas.mineradora.message.KafkaEvents;
import br.com.frovas.mineradora.service.QuotationService;
import io.quarkus.scheduler.Scheduled;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.Transient;

@ApplicationScoped
public class QuotationScheduler {


    private final Logger LOG = LoggerFactory.getLogger(QuotationScheduler.class);

    @Inject
    QuotationService quotationService;

    @Transactional
    @Scheduled(every = "35s", identity = "task-job")
    void schedule() {
        LOG.error("-- Executando scheduler --");
        quotationService.getCurrencyPrice();
    }

}
