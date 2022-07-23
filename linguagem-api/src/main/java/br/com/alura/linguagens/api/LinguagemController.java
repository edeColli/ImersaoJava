package br.com.alura.linguagens.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinguagemController {

  @Autowired
  private LinguagemRepository repositorio;

  @GetMapping("/linguagens")
  public List<Linguagem> obterLinguagens() {
    List<Linguagem> linguagens = repositorio.findAll();
    return linguagens;
  }

  @PostMapping("/linguagens")
  public ResponseEntity<String> cadastrarLinguagem(@RequestBody Linguagem linguagem) {
    repositorio.save(linguagem);
    return ResponseEntity.status(HttpStatus.CREATED).body("Linguagem cadastrada com sucesso!");
  }

  /**
   * @param id
   * @return
   */
  @GetMapping("/linguagens-remover")
  public ResponseEntity<String> removerLinguagem(String id) {
    Optional<Linguagem> linguagemOptional = repositorio.findById(id);
    if (!linguagemOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Linguagem não encontrada!");
    }
    repositorio.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body("Linguagem removida com sucesso!");
  }
}
