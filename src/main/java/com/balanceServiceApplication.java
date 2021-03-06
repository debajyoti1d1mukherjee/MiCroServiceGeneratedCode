

package com;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
public class balanceServiceApplication {
    public static void main(String[] args){
		SpringApplication.run(balanceServiceApplication.class, args);
		}
}

	
	
@RestController
class balanceRestController {

	public balanceRestController(){}

   @RequestMapping(value="/{id}", method = RequestMethod.GET,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "fallbackOperation",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})
    public Response getbalance(@PathVariable("id") String id) {
		  Response resp = new Response();
		  System.out.println("Service Invoked---------+++++-----------------");
	      return resp;
    }
	
	public Response fallbackOperation(String str){
		   Response resp = new Response();
			System.out.println("Fallback Service Invoked--------------------------");
	      	return resp;
	   }

}	

