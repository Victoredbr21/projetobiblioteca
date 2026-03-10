package br.com.victorliteralura.literalura.principal;

import br.com.victorliteralura.literalura.api.ApiService;
import br.com.victorliteralura.literalura.entity.Livro;
import br.com.victorliteralura.literalura.model.ResultadoBusca;
import br.com.victorliteralura.literalura.repository.LivroRepository;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private final Scanner scanner = new Scanner(System.in);
    private final ApiService apiService = new ApiService();
    private final LivroRepository livroRepository;

    public Principal(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    public void exibeMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                \n===== LiterAlura =====
                1 - Buscar livro pelo título
                2 - Listar todos os livros
                3 - Listar livros por idioma
                0 - Sair
                ======================
                """);
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Digite apenas números!");
                continue;
            }

            switch (opcao) {
                case 1 -> buscarLivroPeloTitulo();
                case 2 -> listarLivros();
                case 3 -> listarPorIdioma();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("⚠️ Opção inválida!");
            }
        }
    }


    private void buscarLivroPeloTitulo() {
        System.out.print("Digite o título ou autor: ");
        String busca = scanner.nextLine();

        ResultadoBusca resultado = apiService.buscarLivros(busca);

        if (resultado == null || resultado.livros().isEmpty()) {
            System.out.println("❌ Nenhum livro encontrado!");
            return;
        }

        Livro livro = new Livro(resultado.livros().get(0));

        try {
            livroRepository.save(livro);
            System.out.println("✅ Livro salvo!\n" + livro);
        } catch (Exception e) {
            System.out.println("⚠️ Livro já cadastrado: " + livro.getTitulo());
        }
    }

    private void listarLivros() {
        livroRepository.findAll().forEach(System.out::println);
    }

    private void listarPorIdioma() {
        System.out.println("""
                Idiomas disponíveis:
                en - Inglês
                pt - Português
                fr - Francês
                es - Espanhol
                """);
        System.out.print("Digite o código do idioma: ");
        String idioma = scanner.nextLine();
        List<Livro> livros = livroRepository.findByIdioma(idioma);
        if (livros.isEmpty()) {
            System.out.println("❌ Nenhum livro encontrado nesse idioma!");
        } else {
            livros.forEach(System.out::println);
        }
    }
}
