package br.com.douglasffilho.rxcapabilities.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
class TaskExecutorConfig {

    @Value('${task-executor.core-pool-size}')
    private Integer corePoolSize

    @Value('${task-executor.max-pool-size}')
    private Integer maxPoolSize

    @Value('${task-executor.queue-capacity}')
    private Integer queueCapacity

    @Bean(name = "taskExecutor")
    ThreadPoolTaskExecutor taskExecutor() {
        new ThreadPoolTaskExecutor(corePoolSize: corePoolSize, maxPoolSize: maxPoolSize, queueCapacity: queueCapacity)
    }

}
