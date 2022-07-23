import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
/*import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;*/

public class App {
    public static void main(String[] args) throws Exception {
        // String url = "http://localhost:8080/linguagens";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoLinguagem();

        // String url = "https://alura-filmes.herokuapp.com/conteudos";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        // String url =
        // "https://api.nasa.gov/planetary/apod?//api_key=He8wnnJVSAPfT3fkS03h10C9ndBbArCWo5OV8RoV&start_date=2022-07-13&end_date=2022-07-22";

        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        // var http = new ClienteHttp();
        // String json = http.buscaDados(url);
        // List<Conteudo> conteudos = extrator.extraiConteudos(json);

        // var geradora = new GeradoraDeFigurinhas();

        /*
         * for (int i = 0; i < 10; i++) {
         * Conteudo conteudo = conteudos.get(i);
         * InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
         * String nomeArquivo = "Sticker/" + conteudo.getTitulo() + ".png";
         * geradora.cria(inputStream, nomeArquivo);
         * System.out.println(conteudo.getTitulo());
         * System.out.println();
         * }
         */

        // conexão HTTP e busca de conteúdo...
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair dados de interesse (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("\u001b[4m" + filme.get("title") + "\u001b[0m");
            System.out.println(filme.get("image"));
            System.out
                    .println("\u001b[38;5;226m\u001b[48;5;53m Classificação: " + filme.get("imDbRating")
                            + " \u001b[m");
            String sTextOut = "";
            int iStars;
            for (iStars = 0; iStars < Double.valueOf(filme.get("imDbRating")).intValue(); iStars++) {
                sTextOut += "\u2B50\u001b[m";
            }

            if (Integer.valueOf(filme.get("imDbRating").substring(filme.get("imDbRating").indexOf(".") + 1,
                    filme.get("imDbRating").length())) > 0) {
                sTextOut += " \u272E\u001b[m";
                iStars++;
            }

            for (; iStars < 10; iStars++) {
                sTextOut += " \u2730\u001b[m";
            }
            System.out.println(sTextOut);
            System.out.println();
        }
    }
}
