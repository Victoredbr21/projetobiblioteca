package br.com.victorliteralura.literalura.api;

import br.com.victorliteralura.literalura.model.ResultadoBusca;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    private final String baseUrl = "https://gutendex.com/books/";
    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public ResultadoBusca buscarLivros(String termoBusca) {
        String endereco = baseUrl + "?search=" + termoBusca.replace(" ", "%20");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(response.body(), ResultadoBusca.class);
        } catch (IOException | InterruptedException e) {
            System.err.println("⛔ Erro na requisição: " + e.getMessage());
        }
        return null;
    }
}
