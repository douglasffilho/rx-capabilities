package br.com.douglasffilho.rxcapabilities.domain.impl.step1

import br.com.douglasffilho.rxcapabilities.domain.Action
import br.com.douglasffilho.rxcapabilities.domain.Actor
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Component

import java.util.concurrent.Callable
import java.util.concurrent.Future

@Slf4j
@Component
@Profile("step1")
class FutureActor implements Actor<Future<Integer>> {

    @Autowired
    private Action action

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor

    @Override
    Future<Integer> doAction(String actionName) {
        Callable<Integer> futureTask = new Callable<Integer>() {
            @Override
            Integer call() throws Exception {
                long init = System.nanoTime()

                log.info("Initiated proccess {}", actionName)
                Thread.sleep(1000)
                action.doAction() as Integer

                long end = System.nanoTime()
                BigDecimal time = (end - init)/1.0E9
                log.info("task {} ended in {}s", actionName, time)
            }
        }

        taskExecutor.submit(futureTask)
    }

}