# LDTS_l10gr01 - Pacman

## Game Description

Este jogo é uma implementação em java, usando o terminal lanterna, do clássico Packman, com o objetivo de percorrer um labirinto e comer todas as pastilhas do caminho, sem nunca ser atingido por um fantasma. Um jogador aumenta a sua pontuação, em 10 pontos, ao comer as pastilhas e 50 pontos ao comer uma super pastilha. A cada tentativa, o jogador possui 3 vidas e cada colisão com um fantasma diminui em 1 unidade o número de vidas ou aumenta o número de pontos dependendo se o Pacman está com poder ou não, poder este proveniente de uma super pastilha. 
O jogador ganha se conseguir comer todas as pastilhas existentes nos dois mapas enquanto o seu número de vidas é maior ou igual a 1. Se o número de vidas diminuir até 0, o jogador perde e volta ao primeiro nível, só ganhando se conseguir passar os dois mapas de seguida.

Projeto desenvolvido por Bernardo Pinto (up202108842), Eduardo Oliveira (up202108690) e João Oliveira (up202108737).

## Implemented Features

- **Menu principal:** Quando se inicia o jogo aparece o menu principal, onde é possível selecionar a opção de iniciar o jogo, consultar as regras e sair do menu.

- **Menu GameOver:** Se o jogador for atingido 3 vezes por um fantasma, perde e tem a possibilidade de desistir ou de voltar a repetir.

- **Menu GameWin:** Se o jogador comer todas as pastilhas e super pastilhas do primeiro mapa e segundo mapa enquanto as suas vidas são maiores ou iguais a 1, ganha o jogo e tem a possibilidade de melhorar o número de pontos ou de sair do jogo.

- **Menu Instruções:** Menu onde são disponibilizadas todas as regras e informações necessárias para jogar o jogo. Após ler as regras o jogador pode voltar ao menu principal para começar a jogar.

- **Sair do jogo:** A qualquer momento do programa, será possível sair do jogo carregando na letra "q".

- **Controlo do Jogador:** O jogador deve usar o teclado para jogar e os inputs do teclado são recebidos e interpretados.

- **Teclas para Jogar:** O jogador deve utilizar as 4 setas do teclado(arrow "up" para deslocar o Packman para cima, arrow "down" para deslocar o Packman para baixo, arrow "left" para deslocar o Packman para a esquerda e arrow "right" para deslocar o Packman para a direita)

- **Colisões:** As colisões entre os diferentes constituintes são analisadas:

    - o Pacman a colidir com uma pastilha ganha 10 pontos e a colidir com uma super pastilha ganha 50 pontos e um poder que o torna imortal nas colisões com monstros durante 10s.
    - o Pacman e os fantasmas a colidir com uma parede não a podem atravessar.
    - o Pacman a colidir com os fantasmas apresenta 2 situações: se tiver poder mata o monstro e ganha 100 pontos. Caso contrário, morre, volta ao seu spawn e perde 1 vida.
    - O Pacman a colidir com um gate vai para o posição do outro gate existente no mapa.

- **Pontuações:** Valores Base: 1 pastilha = 10 pontos, 1 super pastilha = 50 pontos, colisão Pacman-Monstro com poder ligado = 100 pontos.

- **Fantasmas:** O estado do monstro depende se o Pacman tem poder. Se o pacman tiver poder, os monstros mudam de cor para azul e tornam-se vulneráveis na colisão, isto é, em vez de matarem o Pacman, são comidos por este e voltam ao seu spawn. Quando o poder acabar, voltam a mudar de cor para vermelho. Todos os fantasmas têm movimentos diferentes.

- **Níveis diferentes:** O nosso jogo apresenta 2 níveis distintos em que o jogador deve passar de seguida para ganhar o jogo.

- **Construção dos níveis:** Construímos os 2 níveis através de leitura de ficheiro com os diversos constituintes:

    - [#] - Representa uma parede, sendo pintada de azul escuro.
      [c] - Representa uma pastilha, sendo pintada de amarelo.
      [G] - Representa um "Gate".
      [s] - Representa uma super pastilha, sendo pintada de amarelo escuro.
      [A] - Representa um fantasma.
      [B] - Representa um fantasma.
      [C] - Representa um fantasma.
      [D] - Representa um fantasma.

- **Músicas:** O nosso jogo apresenta músicas para colisão Pacman-pastilha, Pacman- super pastilha, Pacman - monstro sem poder e Pacman - monstro com poder.

- **Fontes:** O nosso jogo apresenta fontes para a criação do Pacman, pastilhas, super pastilhas e dos monstros.

## Planned Features

Gostaríamos de ter implementado um highscore que era atualizado após uma vitória do jogador e de ter melhorado o movimento dos monstros.
No entanto, adicionamos algumas funcionalidades que não estavam planeadas e de resto, todas as funcionalidades planeadas foram implementadas.

## Design

### Architectural Pattern - Model-View-Controller (MVC)
#### Problem in Context:
A arquitetura é um dos pontos mais importantes no desenvolvimento de um projeto como este. É a base a partir da qual o projeto será desenvolvido. 
Implementamos este design pattern para que as três componentes model, view, controller fossem independentes, delegando responsabilidades e para manter uma boa estrutura e organização de código.

#### The Pattern:
Este design pattern, **Architectural Pattern**, mais em concreto o Model-View-Controller(MVC), é um "architectural pattern" usado para desenvolver user interfaces, dividindo a aplicação em 3 partes o Model, o Controller e o View.

#### Implementation:
 - "The model only represents the data", isto é, com o uso deste pattern temos classes cujo objetivo é guardar a data e estas classes são manipuladas pelo "Controller".
 - "The view displays the model data, and sends user actions to the controller", isto é, com o uso deste pattern temos classes que são responsáveis por mostrar no ecrã os dados das classes que guardam dados.
 - "The controller provides model data to the view, and interprets user actions", isto é, com o uso deste pattern temos classes que vão controlar o jogo interpretando as ações do utilizador.

![MVC](docs/images/MVC.png) 

#### Consequences:
- O uso deste pattern, permite termos o código organizado e respeitando ao máximo  o "Single Responsibility Principle".
- Permite um processo de desenvolvimento mais rápido, dado que os constituintes do grupo podem trabalhar em diferentes componentes, nomeadamente, um na componente visual e outro na componente de controlar.
- Permite que as modificações em certos constituintes não afetem todo o modelo.


### Game Loop Pattern
#### Problem in Context:
Ao desenvolver este projeto, era necessário termos um loop durante a gameplay do utilizador para processar user input sem bloquear, atualizar o estado do jogo e renderizar o jogo.

#### The Pattern:
Para resolvermos este problema, usamos o **Game Loop Pattern**. Um loop de jogo é executado continuamente durante o jogo. A cada volta do loop, processa os inputs do utilizador sem bloquear, atualiza o estado do jogo e renderiza o jogo. Rastreia também a passagem do tempo para controlar o "rate" do jogo e cada iteração do loop é conhecida como "frame".

#### Implementation:

<p align="center" justify="center">
  <img src="docs/images/Loop.png"/>
</p>

#### Consequences:
-Simplicidade do código e atualização organizada.
-O jogo não se atualiza demasiado depressa. Com uma taxa de atualização constante não é possível que máquinas melhores corram o jogo mais rapidamente.
-Power-friendly. Como só atualizamos o jogo a um passo constante, tiramos muita carga do CPU.

### State Pattern
#### Problem in Context:
Sendo o nosso jogo constituido por vários estados de jogo e vários estados do menu, era necessário escolher um pattern que permitisse ajudar na gestão destes estados.

#### The Pattern:
O **State Pattern** é um "behavioral design pattern" que permite que um objeto altere o seu comportamento quando o seu estado interno muda. Este pattern é usado para criar objetos que possuem um número finito de estados e cujo comportamento muda com base no estado atual.

#### Implementation:
Os estados estão divididos tal como na arquitetura mvc, existindo estados do jogo e estados do menu, permitindo ao jogo e os seus constituintes de alterar o comportamente de forma simples e eficiente.
Assim, o Game encontra-se subdividido em diferentes estados para haver uma melhor organização entre o que apresentar no ecrã.

<p align="center" justify="center">
  <img src="docs/UMLs/StateUML.png"/>
</p>

Seguem-se as implementações das várias classes:
- [State](../src/main/java/com.aor.hero/states/State.java)
- [GameState](../src/main/java/com.aor.hero/states/GameState.java)
- [GameWinState](../src/main/java/com.aor.hero/states/GameWinState.java)
- [GameOverState](../src/main/java/com.aor.hero/states/GameOverState.java)
- [InstructionsState](../src/main/java/com.aor.hero/states/InstructionsState.java)
- [MenuState](../src/main/java/com.aor.hero/states/MenuState.java)

#### Consequences:
- Torna as transições de estado explícitas.
- Torna mais fácil adicionar novos estados ou transições porque podemos criar novas implementações das interfaces de estado.
- Mais classes.

### Factory Method Pattern
#### Problem in Context:
O mapa ou arena do nosso jogo é constituído por vários elementos (paredes, pacman, fantasmas, moedas, super moedas, etc.). Visto isto, decidimos utilizar um mapa loader que lê de um ficheiro e insere na sua super classe (mapa builder) o elemento necessário.
Esta implementação permite inserir apenas os elementos necessários e gerar mapas de diferentes formas.

#### The Pattern:
O **Factory Method** é um "creational pattern" que define uma interface ou uma classe abstrata para criação de um objeto, mas deixa que as subclasses decidam que classe instanciar, ou seja, as subclasses são responsáveis por criar a instância da classe.

#### Implementation:
Na criação do nosso mapa, implementámos um ArenaBuilder como classe abstrata que "sabe" como construir o mapa, porém apenas as suas subclasses fornecem as componentes necessárias para o mapa.
A subclasse LoaderArenaBuilder é capaz de ler os vários níveis (no nosso projeto temos 2 níveis) de ficheiros diferentes e construir o mapa.

<p align="center" justify="center">
  <img src="docs/UMLs/FactoryUML.png"/>
</p>

Seguem-se as implementações das duas classes:
- [ArenaBuilder](../src/main/java/com.aor.hero/model/game/arena/ArenaBuilder.java)
- [LoaderArenaBuilder](../src/main/java/com.aor.hero/model/game/arena/LoaderArenaBuilder.java)

#### Consequences:
- A criação de um objeto dentro de uma classe com o Factory Method é sempre mais flexível do que criar o objeto diretamente.
- Elimina a necessidade de vincular classes específicas da aplicação no código.
- Os clienetes têm de criar uma subclasse da classe Creator para criar um objeto concreto. Isto pode ser tido como uma desvantagem.

### Facade Pattern
#### Problem in Context:
Procurando implementar um código estruturado e fácil de alterar, tentámos fazê-lo da forma mais geral possível.Para esse efeito, implementámos uma interface nomeada GUI. 

#### The Pattern:
O **Facade Pattern** fornece uma interface simplificada para um sistema complexo de classes.

#### Implementation:

<p align="center" justify="center">
  <img src="docs/UMLs/FacadeUML.png"/>
</p>

#### Consequences:
- Simplifica a iteração entre a classe principal (Game) com os objetos de outras classes.
- Promove testabilidade e capacidade de substituição.

### Command Pattern
#### Problem in Context: 
Dependendo do estado atual do jogo, diferentes inputs do teclado devem executar diferentes ações.

#### The Pattern:
Com este propósito, usámos o **Command Design Pattern** que encapsula a informação necessária para executar uma ação ou servir de trigger para uma ocorrência posterior.

#### Implementation:
Através de um comando concreto e definido previamente, é possível definir a movimentação do pacman, sair do jogo e optar por um determinado menu.

<p align="center" justify="center">
  <img src="docs/UMLs/CommandUML.png"/>
</p>

Seguem-se as implementações das várias classes:
- [Controller](../src/main/java/com.aor.hero/controller/Controller.java)
- [PacmanController](../src/main/java/com.aor.hero/controller/game/PacmanController.java)
- [GameOverController](../src/main/java/com.aor.hero/controller/menu/GameOverController.java)
- [GameWinController](../src/main/java/com.aor.hero/controller/menu/GameWinController.java)
- [InstructionsController](../src/main/java/com.aor.hero/controller/menu/InstructionsController.java)
- [MenuController](../src/main/java/com.aor.hero/controller/menu/MenuController.java)

#### Consequences:
- Facilita a adição de novas ações de uma forma abstrata.
- Torna a aplicação mais interativa.

## Code Smells e Refactoring 

### Large Class
A classe LanternaGUI e GUI contém vários métodos e linhas de código. Tendo em conta que são classes principais do jogo, achamos que não se justificava dividi-las noutras classes.

### Duplicate Code


### Refused Bequest
Devido ao uso de interfaces e classes abstratas, que simplificaram o nosso código, houve uma subida do **Refused bequest** smell. Isto leva a que algumas subclasses herdem métodos que não serão definidos nem usados. Por exemplo, as classes GameWinController e GameOverController.

### Long Parameter List
Para desenhar todos os elementos do mapa através da leitura de um ficheiro .txt, usámos o método drawCharacter que é passado com 4 parâmetros.


## Self-evaluation

O trabalho foi dividido por todos os constituintes do grupo e todos contribuimos com o nosso melhor.

- Bernardo Pinto: 33.3%
- Eduardo Oliveira: 33.3%
- João Oliveira: 33.3%



