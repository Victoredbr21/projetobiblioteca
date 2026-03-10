package br.com.victorliteralura.literalura.entity;

import br.com.victorliteralura.literalura.model.DadosLivro;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;
    private String autor;
    private String idioma;
    private Integer downloads;

    public Livro() {}

    public Livro(DadosLivro dados) {
        this.titulo = dados.titulo();
        this.autor = dados.autores().isEmpty() ? "Desconhecido"
                : dados.autores().get(0).nome();
        this.idioma = dados.idiomas().isEmpty() ? "Desconhecido"
                : dados.idiomas().get(0);
        this.downloads = dados.downloads();
    }

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIdioma() { return idioma; }
    public Integer getDownloads() { return downloads; }

    @Override
    public String toString() {
        return """
                ===== LIVRO =====
                Título: %s
                Autor: %s
                Idioma: %s
                Downloads: %d
                """.formatted(titulo, autor, idioma, downloads);
    }
}
