package br.com.douglasffilho.rxcapabilities.domain.impl.step1

import br.com.douglasffilho.rxcapabilities.domain.Actor
import br.com.douglasffilho.rxcapabilities.domain.Scenario
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

import java.util.concurrent.Future

@Slf4j
@Service
@Profile("step1")
class Step1Scenario implements Scenario {

    @Autowired
    private Actor actor

    @Override
    def play() {
        long init = System.nanoTime()
        log.info("Started tasks")

        Future<Integer> future1 = actor.doAction('task1') as Future<Integer>
        Future<Integer> future2 = actor.doAction('task2') as Future<Integer>

        Integer result1 = future1.get()
        Integer result2 = future2.get()

        long end = System.nanoTime()
        BigDecimal time = (end - init)/1.0E9
        log.info("tasks ended in {}ns", time)
    }

}
