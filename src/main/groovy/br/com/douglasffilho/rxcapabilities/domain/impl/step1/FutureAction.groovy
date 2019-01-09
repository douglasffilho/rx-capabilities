package br.com.douglasffilho.rxcapabilities.domain.impl.step1

import br.com.douglasffilho.rxcapabilities.domain.Action
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("step1")
class FutureAction implements Action<Integer> {

    @Override
    Integer doAction() {
        10
    }

}
