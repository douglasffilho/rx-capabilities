package br.com.douglasffilho.rxcapabilities.steps

import br.com.douglasffilho.rxcapabilities.domain.Scenario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StepsExecutor {

    @Autowired
    private Scenario scenario

    BigDecimal playTheConcert() {
        return scenario.play()
    }

}
