package br.com.victorliteralura.literalura.repository;

import br.com.victorliteralura.literalura.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdioma(String idioma);
}
