package br.com.douglasffilho.rxcapabilities.domain.impl.step2

import br.com.douglasffilho.rxcapabilities.domain.Actor
import br.com.douglasffilho.rxcapabilities.domain.Scenario
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

import java.util.concurrent.CompletableFuture

@Slf4j
@Service
@Profile("step2")
class Step2Scenario implements Scenario {

    @Autowired
    private Actor actor

    @Override
    def play() {
        long init = System.nanoTime()
        log.info("Started tasks")

        CompletableFuture<Integer> future1 = actor.doAction('task1') as CompletableFuture<Integer>
        CompletableFuture<Integer> future2 = actor.doAction('task2') as CompletableFuture<Integer>
        CompletableFuture<Integer> future3 = actor.doAction('task3') as CompletableFuture<Integer>
        CompletableFuture<Integer> future4 = actor.doAction('task4') as CompletableFuture<Integer>

        Integer result1 = future1.get()
        Integer result2 = future2.get()
        Integer result3 = future3.get()
        Integer result4 = future4.get()

        long end = System.nanoTime()
        BigDecimal time = (end - init)/1.0E9
        log.info("tasks ended in {}ns", time)
    }

}
