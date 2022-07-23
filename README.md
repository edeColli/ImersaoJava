# Semana de imersão Java da Alura

Criando uma API para ser consumida por um front-end

Objetivo inicial era consumir alguma API que nos retornassem um nome/título e uma imagem.
Posteriormente, criamos uma API para ser consumida pelo primeiro projeto que também nos retornava um nome e imagem.
Nessa API, usamos mongoDB para fazer o prceso de CRUD, para inserir, remover e obter as informações das linguagens mais populares.

Desafios cumpridos:

. Consumir uma API, obtendo os dados e listando no terminal.

. Refatoração de código usando abstração de classes.

. Implementado nova classe Interface com métodos extras.

. Criar um novo Extrator de conteúdo para o json retornado pelo mongoDb.

. Frontend, fonte em uso modificada para o limite de largura da imagem.

. Frontend, nome do autor incluído no sticker.

. CRUD, completo.

	\languages - GET: Retorna a lista de linguagens
  
	\languages - POST: Inclui o conteúdo na lista de linguagens
  
	\languages-remove?id=1 - GET: Usando o verbo GET, remove a linguagem pelo id.
  
. Status do Request alterado para 201, quando um recurso é criado.

. Ainda usamos o PostMan para facilitar os testes com a nossa API.

Aula bem produtiva.

Foi interessante usar o MongoDb pela primeira vez e perceber as facilidades incríveis.

Ainda falta a Aula5, bora!!!!

## Imagens do projeto:


![image](https://user-images.githubusercontent.com/72364037/180598340-90d20dcf-48dc-4c24-9fbe-a9ac82c76f66.png)



Stacks utilizadas:

https://start.spring.io/

https://cloud.mongodb.com
