import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

  private static final String TOPZERA = "TOPZERA";

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {
    BufferedImage imagemOriginal = ImageIO.read(inputStream);
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original para a nova imagem em memória
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // configurar a fonte
    Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);
    // escrever uma frase na nova imagem
    graphics.drawString(TOPZERA, largura / 3, novaAltura - 100);
    // escrever a imagem nova em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
  }
}
