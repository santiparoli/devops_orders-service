package uy.edu.ort.devops.ordersserviceexample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import uy.edu.ort.devops.ordersserviceexample.logic.OrdersLogic;

@SpringBootApplication
public class OrdersServiceExampleApplication {
	private static Logger logger = LoggerFactory.getLogger(OrdersServiceExampleApplication.class);

	public static void main(String[] args) {
		OrdersLogic.setPaymentsServiceUrl(args[0]);
		logger.info("Payments Service url: "+args[0]);

		OrdersLogic.setShippingServiceUrl(args[1]);
		logger.info("Shipping Service url: "+args[1]);

		OrdersLogic.setProductsServiceUrl(args[2]);
		logger.info("Products Service url: "+args[2]);

		SpringApplication.run(OrdersServiceExampleApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
