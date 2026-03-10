package br.com.victorliteralura.literalura.principal;

import br.com.victorliteralura.literalura.API.ApiService;
import br.com.victorliteralura.literalura.model.DadosLivro;
import br.com.victorliteralura.literalura.model.ResultadoBusca;
import java.util.Scanner;

public class Principal {

    private final Scanner scanner = new Scanner(System.in);
    private final ApiService apiService = new ApiService();

    public void exibeMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                    \n===== LiterAlura =====
                    1 - Buscar livro pelo título
                    0 - Sair
                    ======================
                    """);

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> buscarLivroPeloTitulo();
                case 0 -> System.out.println("Encerrando o programa...");
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

        resultado.livros().stream()
                .limit(5)
                .forEach(l -> System.out.println(
                        "\n📖 " + l.titulo() +
                                "\n✍️  " + l.autores().stream().map(a -> a.nome()).findFirst().orElse("Desconhecido") +
                                "\n🌐 " + l.idiomas() +
                                "\n⬇️  Downloads: " + l.downloads()
                ));
    }
}
