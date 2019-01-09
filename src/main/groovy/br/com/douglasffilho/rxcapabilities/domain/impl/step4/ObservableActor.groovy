package br.com.douglasffilho.rxcapabilities.domain.impl.step4

import br.com.douglasffilho.rxcapabilities.domain.Action
import br.com.douglasffilho.rxcapabilities.domain.Actor
import groovy.util.logging.Slf4j
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import org.springframework.stereotype.Component

@Slf4j
@Component
@Profile("step4")
class ObservableActor implements Actor<Observable<Integer>> {

    @Autowired
    private Action action

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor

    @Override
    Observable<Integer> doAction(String actionName) {
        Observable.<Integer>create({
            long init = System.nanoTime()

            log.info("Initiated proccess {}", actionName)
            Thread.sleep(1000)
            Integer result = action.doAction() as Integer

            long end = System.nanoTime()
            BigDecimal time = (end - init)/1.0E9
            log.info("task {} ended in {}s", actionName, time)

            it.onNext(result)
            it.onComplete()
        }).subscribeOn(Schedulers.from(taskExecutor))
    }

}
