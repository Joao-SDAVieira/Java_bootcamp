package curso.web.api.doc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Title - Rest API")
                        .description("API exemplo de uso Spring Boot 3 + OpenAPI")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Nome")
                                .url("http://seusite.com.br")
                                .email("seusite.com.br"))
                        .license(new License()
                                .name("Licença - Sua Empresa")
                                .url("http://seusite.com.br")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação adicional")
                        .url("http://seusite.com.br/docs"));
    }
}
