package co.edu.usa.inventario;

import co.edu.usa.inventario.model.controller.ControladorProducto;
import co.edu.usa.inventario.model.repositories.RepositorioProducto;
import co.edu.usa.inventario.view.Vista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

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
