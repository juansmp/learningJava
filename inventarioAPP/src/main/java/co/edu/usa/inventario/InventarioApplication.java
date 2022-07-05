package co.edu.usa.inventario;


import co.edu.usa.inventario.model.controller.ControladorProducto;
import co.edu.usa.inventario.model.repositories.RepositorioProducto;
import co.edu.usa.inventario.view.Vista; //ok
import org.springframework.beans.factory.annotation.Autowired; //ok
import org.springframework.boot.ApplicationRunner; //ok
import org.springframework.boot.SpringApplication; //ok
import org.springframework.boot.autoconfigure.SpringBootApplication; //ok
import org.springframework.boot.builder.SpringApplicationBuilder; //ok
import org.springframework.context.ConfigurableApplicationContext; //ok
import org.springframework.context.annotation.Bean; //ok



@SpringBootApplication
public class InventarioApplication {

    @Autowired
    RepositorioProducto repositorio;

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(InventarioApplication.class);
        builder.headless(false);
        ConfigurableApplicationContext context = builder.run(args);
    }

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            Vista vista = new Vista();
            ControladorProducto controlador = new ControladorProducto(repositorio, vista);

        };
    }

}
