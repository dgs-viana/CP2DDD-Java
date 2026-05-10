# CP2DDD-Java - Sistema E-Commerce

## Integrantes

- Felipe Viana - RM 565341
- Felipe Bonilha – RM: 562356
- Joan Ferreira  – RM : 562913
- Levi de Jesus – RM : 563279

## Sobre o projeto

Este projeto foi desenvolvido para a CP2 da disciplina de Domain Driven Design.

O sistema se chama **E-Commerce** e simula uma operação simples de logística para entregas de um e-commerce. A ideia é permitir que a empresa consiga cadastrar entregadores, criar entregas, atribuir uma entrega para um entregador disponível e atualizar o status do pedido.

O foco principal do projeto é aplicar conceitos de Programação Orientada a Objetos em Java, como herança, interface, classe abstrata, encapsulamento, sobrescrita e sobrecarga de métodos.

## Funcionalidades do sistema

O sistema permite:

- Cadastrar entregadores;
- Criar entregas;
- Listar entregadores cadastrados;
- Listar entregas criadas;
- Atribuir uma entrega para um entregador;
- Atualizar o status de uma entrega;
- Calcular o tempo estimado da entrega de acordo com o tipo de veículo.

## Tipos de entregadores

O sistema possui três tipos de entregadores:

- Entregador de moto;
- Entregador de bicicleta;
- Entregador de carro.

Cada tipo de entregador possui uma forma diferente de calcular o tempo estimado da entrega, considerando uma velocidade média diferente para cada veículo.

## Conceitos de Programação Orientada a Objetos utilizados

### Classe abstrata

Foi criada a classe abstrata `Entregador`.

Ela representa uma base para todos os tipos de entregadores do sistema. Nela ficam informações comuns como id, nome, telefone e disponibilidade.

A classe foi criada como abstrata porque não faz muito sentido cadastrar apenas um entregador genérico. No sistema, o entregador precisa ser de algum tipo específico, como moto, bicicleta ou carro.

### Herança

A herança foi usada nas classes:

- `EntregadorMoto`
- `EntregadorBicicleta`
- `EntregadorCarro`

Essas classes herdam da classe `Entregador`, reaproveitando seus atributos e métodos.

Com isso, evitamos repetir código e deixamos a estrutura do projeto mais organizada.

### Interface

Foi criada a interface `CalculavelEntrega`.

Ela define o método `calcularTempoEntrega(double distanciaKm)`, que deve ser implementado pelos entregadores.

A interface foi usada porque todos os tipos de entregadores precisam calcular o tempo estimado da entrega, mas cada um faz isso de uma forma diferente.

### Encapsulamento

O encapsulamento foi aplicado usando atributos privados nas classes e métodos públicos para acessar ou alterar esses valores.

Por exemplo, na classe `Entregador`, os atributos `id`, `nome`, `telefone` e `disponivel` são privados. Para acessar essas informações, foram criados métodos como `getId()`, `getNome()`, `getTelefone()` e `isDisponivel()`.

Isso ajuda a proteger os dados das classes e deixa o código mais organizado.

### Sobrescrita

A sobrescrita acontece no método `calcularTempoEntrega`.

Cada classe de entregador implementa esse método de acordo com sua própria regra:

- Moto considera uma velocidade média maior;
- Bicicleta considera uma velocidade média menor;
- Carro considera uma velocidade intermediária.

Com isso, o mesmo método pode ter comportamentos diferentes dependendo do tipo de entregador.

### Sobrecarga

A sobrecarga aparece na classe `Entrega`, no método `atualizarStatus`.

Existem duas versões desse método:

    atualizarStatus(StatusEntrega novoStatus)

e

    atualizarStatus(StatusEntrega novoStatus, String observacao)

A primeira versão atualiza apenas o status da entrega.

A segunda versão atualiza o status e também registra uma observação.

Isso deixa o sistema mais flexível, porque em alguns casos basta mudar o status, mas em outros pode ser útil registrar uma observação, como "cliente ausente" ou "entrega realizada na portaria".

## Status da entrega

O status da entrega foi representado usando um `enum` chamado `StatusEntrega`.

Os status possíveis são:

- `PENDENTE`
- `EM_ROTA`
- `ENTREGUE`
- `CANCELADA`

Isso ajuda a evitar erros no código, porque o status só pode receber valores já definidos.

## Estrutura do projeto

    CP2DDD-Java/
    ├── Main.java
    ├── Entrega.java
    ├── Entregador.java
    ├── EntregadorMoto.java
    ├── EntregadorBicicleta.java
    ├── EntregadorCarro.java
    ├── CalculavelEntrega.java
    ├── StatusEntrega.java
    └── README.md

## Como executar

Para executar o projeto, é necessário ter o Java instalado.

No terminal, dentro da pasta onde estão os arquivos `.java`, execute:

    javac *.java

Depois execute a classe principal:

    java Main

O sistema será aberto no terminal com um menu interativo.

## Menu do sistema

O menu possui as seguintes opções:

    ===== SISTEMA E-COMMERCE =====
    1 - Cadastrar entregador
    2 - Criar entrega
    3 - Listar entregadores
    4 - Listar entregas
    5 - Atribuir entrega a entregador
    6 - Atualizar status da entrega
    0 - Sair

## Explicação resumida do funcionamento

Primeiro, o usuário pode cadastrar um entregador escolhendo o tipo de veículo: moto, bicicleta ou carro.

Depois, o usuário pode criar uma entrega informando o endereço de destino e a distância em quilômetros.

Em seguida, o sistema permite atribuir uma entrega para um entregador disponível. Quando isso acontece, o status da entrega passa para `EM_ROTA` e o entregador fica indisponível.

Também é possível atualizar o status da entrega para `PENDENTE`, `EM_ROTA`, `ENTREGUE` ou `CANCELADA`.

Quando uma entrega é marcada como `ENTREGUE` ou `CANCELADA`, o entregador volta a ficar disponível.


## Conclusão

Com essa modelagem, o sistema fica organizado e fácil de entender.

A separação entre classe abstrata, interface, classes específicas de entregadores e classe de entrega ajuda a aplicar os conceitos de Programação Orientada a Objetos e também facilita futuras melhorias no projeto.

Caso fosse necessário adicionar novos tipos de entregadores no futuro, como van, caminhão ou patinete, bastaria criar uma nova classe herdando de `Entregador` e implementar sua própria regra de cálculo de tempo.
