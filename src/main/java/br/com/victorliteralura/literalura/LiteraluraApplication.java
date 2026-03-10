package br.com.victorliteralura.literalura;

import br.com.victorliteralura.literalura.principal.Principal;
import br.com.victorliteralura.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(livroRepository);
        principal.exibeMenu();
    }

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }
}
