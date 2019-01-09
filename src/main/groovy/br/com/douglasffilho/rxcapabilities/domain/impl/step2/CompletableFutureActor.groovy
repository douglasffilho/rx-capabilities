package br.com.douglasffilho.rxcapabilities.domain.impl.step2

import br.com.douglasffilho.rxcapabilities.domain.Action
import br.com.douglasffilho.rxcapabilities.domain.Actor
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Component

import java.util.concurrent.CompletableFuture

@Slf4j
@Component
@Profile("step2")
class CompletableFutureActor implements Actor<CompletableFuture<Integer>> {

    @Autowired
    private Action action

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor

    private Integer doAsyncAction(String actionName) {
        long init = System.nanoTime()

        log.info("Initiated proccess {}", actionName)
        Thread.sleep(1000)
        Integer result = action.doAction() as Integer

        long end = System.nanoTime()
        BigDecimal time = (end - init)/1.0E9
        log.info("task {} ended in {}s", actionName, time)

        result
    }

    @Override
    CompletableFuture<Integer> doAction(String actionName) {
        CompletableFuture.supplyAsync( {doAsyncAction(actionName)}, taskExecutor)
    }
}
