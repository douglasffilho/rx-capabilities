package br.com.douglasffilho.rxcapabilities.domain.impl.step4

import br.com.douglasffilho.rxcapabilities.domain.Actor
import br.com.douglasffilho.rxcapabilities.domain.Scenario
import groovy.util.logging.Slf4j
import io.reactivex.Observable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

import java.util.concurrent.CompletableFuture

@Slf4j
@Service
@Profile("step4")
class Step4Scenario implements Scenario {

    @Autowired
    private Actor actor

    @Override
    def play() {
        long init = System.nanoTime()
        log.info("Started tasks")

        List<Observable<Integer>> obs = [] as ArrayList

        Observable<Integer> obs1 = actor.doAction('task1') as Observable<Integer>
        obs.add(obs1)
        Observable<Integer> obs2 = actor.doAction('task2') as Observable<Integer>
        obs.add(obs2)
        Observable<Integer> obs3 = actor.doAction('task3') as Observable<Integer>
        obs.add(obs3)
        Observable<Integer> obs4 = actor.doAction('task4') as Observable<Integer>
        obs.add(obs4)
        Observable<Integer> obs5 = actor.doAction('task5') as Observable<Integer>
        obs.add(obs5)
        Observable<Integer> obs6 = actor.doAction('task6') as Observable<Integer>
        obs.add(obs6)
        Observable<Integer> obs7 = actor.doAction('task7') as Observable<Integer>
        obs.add(obs7)
        Observable<Integer> obs8 = actor.doAction('task8') as Observable<Integer>
        obs.add(obs8)

        Observable<Integer> observable = Observable.merge(obs)
        observable.blockingLast()

        long end = System.nanoTime()
        BigDecimal time = (end - init)/1.0E9
        log.info("tasks ended in {}ns", time)
    }

}
