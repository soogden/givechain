package givechain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@ComponentScan("givechain")
@SpringBootApplication
public class GivechainApplication {

	public static void main(String[] args) {
		SpringApplication.run(GivechainApplication.class, args);
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("charities")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/charity.*"))
				.paths(regex("/action.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Swagger API for Givechain project")
				.description("Swagger API for Givechain project")
				.version("1.0")
				.contact("Scott Ogden")
				.license("none")
				.build();
	}
}
