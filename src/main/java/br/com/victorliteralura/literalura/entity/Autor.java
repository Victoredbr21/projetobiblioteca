package br.com.victorliteralura.literalura.entity;

import br.com.victorliteralura.literalura.model.DadosAutor;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Livro> livros;

    public Autor() {}

    public Autor(DadosAutor dados) {
        this.nome = dados.nome();
        this.anoNascimento = dados.anoNascimento();
        this.anoFalecimento = dados.anoFalecimento();
    }

    public Long getId() { return id; }
    public String getNome() { return nome; }
    public Integer getAnoNascimento() { return anoNascimento; }
    public Integer getAnoFalecimento() { return anoFalecimento; }
    public void setLivros(List<Livro> livros) { this.livros = livros; }

    @Override
    public String toString() {
        return """
                ===== AUTOR =====
                Nome: %s
                Nascimento: %s
                Falecimento: %s
                """.formatted(
                nome,
                anoNascimento != null ? anoNascimento : "Desconhecido",
                anoFalecimento != null ? anoFalecimento : "Ainda vivo/Desconhecido"
        );
    }
}
