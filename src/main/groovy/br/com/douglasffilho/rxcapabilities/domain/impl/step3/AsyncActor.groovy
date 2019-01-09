package br.com.douglasffilho.rxcapabilities.domain.impl.step3

import br.com.douglasffilho.rxcapabilities.domain.Action
import br.com.douglasffilho.rxcapabilities.domain.Actor
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component

import java.util.concurrent.CompletableFuture

@Slf4j
@Component
@Profile("step3")
class AsyncActor implements Actor<CompletableFuture<Integer>> {

    @Autowired
    private Action action

    @Async
    @Override
    CompletableFuture<Integer> doAction(String actionName) {
        long init = System.nanoTime()

        log.info("Initiated proccess {}", actionName)
        Thread.sleep(1000)
        Integer result = action.doAction() as Integer

        long end = System.nanoTime()
        BigDecimal time = (end - init)/1.0E9
        log.info("task {} ended in {}s", actionName, time)

        CompletableFuture.completedFuture(result)
    }

}
