package br.com.douglasffilho.rxcapabilities.domain.impl.step3

import br.com.douglasffilho.rxcapabilities.domain.Action
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("step3")
class AsyncAction implements Action<Integer> {

    @Override
    Integer doAction() {
        10
    }

}
