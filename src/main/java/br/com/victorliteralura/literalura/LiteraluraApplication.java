package br.com.victorliteralura.literalura;

import br.com.victorliteralura.literalura.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.exibeMenu();
    }

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }
}
