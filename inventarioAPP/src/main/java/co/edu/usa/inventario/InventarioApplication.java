package co.edu.usa.inventario;


import co.edu.usa.inventario.model.controller.Controlador;
import co.edu.usa.inventario.view.Vista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import co.edu.usa.inventario.model.repositories.RepositorioProducto;

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
            Controlador controlador = new Controlador(repositorio, vista);

        };
    }

}
