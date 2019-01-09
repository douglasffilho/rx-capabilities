package br.com.douglasffilho.rxcapabilities.domain.impl.step4

import br.com.douglasffilho.rxcapabilities.domain.Action
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile("step4")
class ObservableAction implements Action<Integer> {

    @Override
    Integer doAction() {
        10
    }

}
