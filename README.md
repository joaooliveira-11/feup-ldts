## project-l10gr01

Este jogo é uma implementação em java, usando o terminal lanterna, do clássico Packman, com o objetivo de percorrer um labirinto e comer todas as pastilhas do caminho, sem nunca ser atingido por um fantasma. Um jogador aumenta a sua pontuação, em 10 pontos, ao comer as pastilhas, em 50 pontos ao comer uma super pastilha. A cada tentativa, o jogador possui 3 vidas e cada colisão com um fantasma diminui em 1 unidade o número de vidas. O jogador ganha se conseguir comer todas as pastilhas existentes no mapa enquanto o seu número de vidas é maior ou igual a 1. Se o número de vidas diminuir até 0, o jogador perde e volta a repetir o nível, só podendo avançar quando concluir com sucesso o nível atual.

Projeto desenvolvido por *Bernardo Pinto* (up20210842), *Eduardo Oliveira* (up202108690) e *João Oliveira* (up202108737).


### Funcionalidades planeadas:

- **Menu principal:** Quando se inicia o jogo aparece o menu principal, onde é possível selecionar a letra "S" para iniciar o jogo e a letra "I" para ver as instruções do jogo.

- **Menu Instruções:** Menu onde são disponibilizadas todas as regras e informações necessárias para jogar o jogo.

- **Menu Game Over:** Se o jogador for atingido 3 vezes por um fantasma, perde e o jogo termina. No terminal aparece a sua pontução e o nível em que ficou.

- **Após perder nível:** Se o jogador perder o nível volta a repetir o nível, tendo a possibilidade de desistir.

- **Sair do jogo:** A qualquer momento do programa, será possível sair do jogo carregando na letra "q".

- **Controlo do Jogador:** O jogador deve usar o teclado para jogar e os inputs do teclado são recebidos e interpretados.

- **Teclas para Jogar:** O jogador deve utilizar as 4 setas do teclado(arrow "up" para deslocar o Packman para cima, arrow "down" para deslocar o Packman para baixo, arrow "left" para deslocar o Packman para a esquerda e arrow "right" para deslocar o Packman para a direita)

- **Colisões:** As colisões entre os diferentes constituintes são analisadas (Ex: o jogador e os fantasmas a coidir com uma parede não a podem atravessar; o jogador a colidir com um fantasma levará a uma redução do número de vidas)

- **Pontuações:** Valores Base: 1 pastilha = 10 pontos, 1 super pastilha = 50 pontos.

- **Fantasmas:** O movimento de cada fantasma é influênciado pelo movimento do pacman. Todos os fantasmas têm movimentos diferentes.

- **Níveis:** Quando um jogador come todas as pastilhas sem perder o jogo, passa para um novo nível, que apresenta um novo mapa e as vidas restantes do nível anterior.

### Planeamento da construção dos mapas:

- **Objetivo:** Temos como objetivo construir 2 níveis em que cada nível difere apenas na organização dos diferentes constituintes, isto é, estrutura universal das paredes, posição das super pastilhas e o número de vidas que o jogador apresenta no segundo mapa são as vidas restantes do primeiro.


- **Construção do mapa:** Para construirmos os mapas vamos utilizar um método de leitura de ficheiro em que cada linha vai representar uma linha do terminal e cada caracter vai representar uma coluna dessa linha.À medida que lemos os caracteres, com o auxilio de dois contadores, um para as linhas e outro para as colunas dessa linha, juntamente com a utilização do "TextGraphics" vamos preencher o terminal com as paredes, pastilhas, super pastilhas e os fantasmas.

    - Exemplo1 : " ################### " - Primeira linha do mapa, constituida apenas por paredes, representando uma borda.

    - Exemplo2 : " #cccc    G    cccc# " - Linha constituida por paredes, pastilhas e fantasmas.


- **Constituintes do mapa:**

    [#] - Representa uma parede, sendo pintada de azul escuro.

    [c] - Representa uma pastilha, sendo pintada de amarelo.

    [s] - Representa uma super pastilha, sendo pintada de amarelo escuro.

    [A] - Representa um fantasma vermelho.

    [B] - Representa um fantasma azul claro.

    [C] - Representa um fantasma rosa.

    [D] - Representa um fantasma laranja.


### Mapa 1 real:
![Packman_mapa1](docs/Packman_mapa1.png)

### Mapa 1 PREVIEW using lanterna: