import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "http://localhost:8080/linguagens";
        ExtratorDeConteudo extrator = new ExtratorDeConteudoLinguagem();

        // String url = "https://alura-filmes.herokuapp.com/conteudos";
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        // String url =
        // "https://api.nasa.gov/planetary/apod?//api_key=He8wnnJVSAPfT3fkS03h10C9ndBbArCWo5OV8RoV&start_date=2022-07-13&end_date=2022-07-22";

        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 10; i++) {
            Conteudo conteudo = conteudos.get(i);
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "Sticker/" + conteudo.getTitulo() + ".png";
            geradora.cria(inputStream, nomeArquivo);
            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
