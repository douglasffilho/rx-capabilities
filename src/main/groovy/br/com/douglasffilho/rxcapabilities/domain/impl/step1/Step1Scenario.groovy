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
    BigDecimal play() {
        long init = System.nanoTime()
        log.info("Started tasks")

        Future<Integer> future1 = actor.doAction('task1') as Future<Integer>
        Future<Integer> future2 = actor.doAction('task2') as Future<Integer>
        Future<Integer> future3 = actor.doAction('task3') as Future<Integer>
        Future<Integer> future4 = actor.doAction('task4') as Future<Integer>
        Future<Integer> future5 = actor.doAction('task5') as Future<Integer>
        Future<Integer> future6 = actor.doAction('task6') as Future<Integer>
        Future<Integer> future7 = actor.doAction('task7') as Future<Integer>
        Future<Integer> future8 = actor.doAction('task8') as Future<Integer>

        Integer result1 = future1.get()
        Integer result2 = future2.get()
        Integer result3 = future3.get()
        Integer result4 = future4.get()
        Integer result5 = future5.get()
        Integer result6 = future6.get()
        Integer result7 = future7.get()
        Integer result8 = future8.get()

        long end = System.nanoTime()
        BigDecimal time = (end - init)/1.0E9
        log.info("tasks ended in {}s", time)

        return time
    }

}
