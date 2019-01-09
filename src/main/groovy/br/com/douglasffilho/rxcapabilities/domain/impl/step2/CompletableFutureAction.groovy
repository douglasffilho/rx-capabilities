package br.com.douglasffilho.rxcapabilities.domain.impl.step2

import br.com.douglasffilho.rxcapabilities.domain.Action
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("step2")
class CompletableFutureAction implements Action<Integer> {

    @Override
    Integer doAction() {
        10
    }

}
