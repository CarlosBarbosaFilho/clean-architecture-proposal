package br.com.cbgomes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableFeignClients
@EnableSwagger2
@SpringBootApplication(scanBasePackages = ["br.com.cbgomes"])
class CleanArchitectureProposal
fun main(args: Array<String>) {

    runApplication<CleanArchitectureProposal>(*args)
}
