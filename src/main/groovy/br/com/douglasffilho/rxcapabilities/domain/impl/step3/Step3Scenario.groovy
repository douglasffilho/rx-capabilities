package br.com.douglasffilho.rxcapabilities.domain.impl.step3

import br.com.douglasffilho.rxcapabilities.domain.Actor
import br.com.douglasffilho.rxcapabilities.domain.Scenario
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

import java.util.concurrent.CompletableFuture

@Slf4j
@Service
@Profile("step3")
class Step3Scenario implements Scenario {

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
        CompletableFuture<Integer> future5 = actor.doAction('task5') as CompletableFuture<Integer>
        CompletableFuture<Integer> future6 = actor.doAction('task6') as CompletableFuture<Integer>

        Integer result1 = future1.get()
        Integer result2 = future2.get()
        Integer result3 = future3.get()
        Integer result4 = future4.get()
        Integer result5 = future5.get()
        Integer result6 = future6.get()

        long end = System.nanoTime()
        BigDecimal time = (end - init)/1.0E9
        log.info("tasks ended in {}ns", time)
    }

}
