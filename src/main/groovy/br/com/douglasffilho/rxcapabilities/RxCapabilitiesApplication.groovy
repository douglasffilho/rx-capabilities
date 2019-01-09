package br.com.douglasffilho.rxcapabilities

import br.com.douglasffilho.rxcapabilities.steps.StepsExecutor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.AdviceMode
import org.springframework.scheduling.annotation.EnableAsync

import javax.annotation.PostConstruct

@EnableAsync(proxyTargetClass = true)
@SpringBootApplication
class RxCapabilitiesApplication {

	@Autowired
	private StepsExecutor stepsExecutor

	static void main(String[] args) {
		SpringApplication.run(RxCapabilitiesApplication, args)
	}

	@PostConstruct
	def init() {
		stepsExecutor.playTheConcert()
	}

}

