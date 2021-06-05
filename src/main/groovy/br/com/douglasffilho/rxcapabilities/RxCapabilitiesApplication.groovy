package br.com.douglasffilho.rxcapabilities

import br.com.douglasffilho.rxcapabilities.steps.StepsExecutor
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableAsync

import javax.annotation.PostConstruct

@Slf4j
@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
class RxCapabilitiesApplication {
    @Autowired
    private StepsExecutor stepsExecutor

    @Value('${test-execution-times}')
    private Integer executions

    static void main(String[] args) {
        SpringApplication.run(RxCapabilitiesApplication, args)
    }

    @PostConstruct
    def init() {
        final StepsExecutor executor = this.stepsExecutor
        BigDecimal totalTime = BigDecimal.ZERO

        this.executions.times {
            BigDecimal time = executor.playTheConcert()
            totalTime += time
        }

        BigDecimal avg = totalTime.divide(BigDecimal.valueOf(this.executions))

        log.info("TASKS AVG TIME: {}s", avg)

        System.exit(0)
    }

}

