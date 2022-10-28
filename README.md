# Indice

* [Introdução](#introdução)
* [O que é Quarkus?](#o-que-é-quarkus)
* [O que é GraalVM?](#o-que-é-graalvm)
* [O que é Docker?](#o-que-é-docker)
* [Para testar as Rotas da API](#para-testar-as-rotas-da-api)
* [Ambiente de Desenvolvimento Integrado (IDE)](#ambiente-de-desenvolvimento-integrado-ide)
* [GraphQl](#graphql)
* [Começando](#começando)
* [Rodando o Projeto em Ambiente de Desenvolvimento](#rodando-o-projeto-em-ambiente-de-desenvolvimento)
* [Mãos à Obra](#mãos-à-obra)

# Introdução
Nosso BackEnd está sendo construído utilizando a linguagem de programação **Java**, framework **Quarkus**, banco de dados **MySql** e a linguagem de consultas **GraphQl** .

Antes de começar o desenvolvimento, será necessário preparar o ambiente de desenvolvimento para suportar o Java com Quarkus.
-----

O que é Quarkus?
=============
----
Um framework java open source desenvolvido pela Red Hat e lançado no final de 2018. Foi desenvolvido sob medida para o **GraalVM** e OpenJDK HotSpot, com a promessa de ter um startup muito rápido e pouco gasto de memória de footprint, sendo assim um framework ótimo para cloud, microservices e também serverless.

O Quarkus foi desenvolvido para ser um framework completo, trazendo bibliotecas muito utilizadas atualmente, como Eclipse MicroProfile, Apache Kafka, RESTEasy (JAX-RE), Hibernate ORM (JPA), Spring, Infinispan, Camel e muitos outros. Além disso o Quarkus é muito amigável a quem já utiliza o SpringBoot que é o Framework de java mais utilizado atualmente no mercado.

O **Quarkus** é *Container First*, ou seja, prepara e otimiza a aplicação para rodar em containers.

[Documentação do quarkus](https://quarkus.io)

O que é GraalVM?
=============
----

**GraalVM** é um Java VM e JDK baseado em HotSpot/OpenJDK, implementado em Java. Ele suporta linguagens de programação e modos de execução adicionais, como compilação antecipada de aplicativos Java para inicialização rápida e baixo consumo de memória. Traduzindo, é um **"JDK boladasso**" que acelera o tempo de build e execução da aplicação.

Antes de iniciar o desenvolvimento será necessário realizar a instalação da GraalVM e adição dela no **JAVA_HOME** do Windows pelas variáveis de ambiente.

[Site da GraalVM](https://www.graalvm.org)

Quanto à instalação, se vira aí que eu não vou dar tudo de mão beijada não.

O que é Docker?
=============
----
Além da GraalVM será necessário instalar o **Docker**.
Docker é um conjunto de produtos de plataforma como serviço que usam virtualização de nível de sistema operacional para entregar software em pacotes chamados contêineres. Os contêineres são isolados uns dos outros e agrupam seus próprios softwares, bibliotecas e arquivos de configuração.

[Site do Docker](https://www.docker.com)

O Docker é meio chatinho de fazer a instalação, necessita do WSL no Windows para realizar a virtualização, etc... Então vou deixar um vídeo que ensina o passo a passo de instalação e configuração.

[Vídeo da instalação](https://www.youtube.com/watch?v=sYsIoWtS5LY)

Para testar as Rotas da API
=============
----
Para realizar os testes da API eu aconselho que utilizem o software [Postman](https://www.postman.com), pois já fizemos uma documentação contendo todas as rotas, exemplos e como utilizá-las, assim você poderá importar para seu postman, outro software é o [Insomnia](https://insomnia.rest/download), porém nossa documentação tem erro de compatibilidade e não funcionam no Insomnia, caso queira utilizar terá que refazer todas as rotas por conta própria.

Ambiente de Desenvolvimento Integrado (IDE)
=============
----
Recomendo utilizar o **IntelliJ IDE** para programar com o Quarkus, pois o IntelliJ é mais leve que o Eclipse (E o Docker vai consumir bastante memória RAM, então já pega o ovo pq o pc vai fritar), além disso o Intellij possui um plugin para trabalhar com o Quarkus, o que acaba acelerando e facilitando o desenvolvimento. Outra opção mais leve que o Eclipse é o Visual Studio Code, mas já deixo a dica, o Intellij funciona melhor que o VS Code quando o assunto é Java.

[IntelliJ IDE Community Edition](https://www.jetbrains.com/idea/download/#section=windows)

GraphQl
=============
----
GraphQL é uma linguagem de consulta e ambiente de execução voltada a servidores para as interfaces de programação de aplicações (APIs) cuja prioridade é fornecer exatamente os dados que os clientes solicitam e nada além.

O GraphQL foi desenvolvido para tornar as APIs mais rápidas, flexíveis e intuitivas para os desenvolvedores. Ainda é possível implantá-lo em um ambiente de desenvolvimento integrado (IDE) conhecido como GraphiQL. Como alternativa à arquitetura REST, o GraphQL permite aos desenvolvedores construir solicitações que extraem os dados de várias fontes em uma única chamada de API.

Além disso, o GraphQL proporciona aos profissionais responsáveis pela manutenção das APIs flexibilidade para adicionar ou preterir campos, sem afetar as consultas existentes. Os desenvolvedores podem criar APIs com o método que quiserem, pois a especificação do GraphQL assegura que elas funcionem de maneira previsível para os clientes.

Começando:
=============
----
Após instalar, configurar e testar todo esse ambiente de desenvolvimento, sugiro que você tente fazer alguns projetos simples em Quarkus, lendo a documentação, procurando repositórios no GitHub ou em vídeos no Youtube. Será melhor se familiarizar um pouco com o Quarkus e principalmente com o ORM Hibernate antes de prosseguir com o projeto.

Com tudo pronto? Então podemos prosseguir.
Clone o repositório do projeto que está no do GitHub.

[Link do Repositório](https://github.com/TorugoMarega/levelup-graphql-api-quarkus)

No projeto há uma pasta DOC onde está páginas HTML, a página principal é a **index.html**, é como se fosse um site contendo a documentação do código (todos os pacotes, classes, métodos e atributos de cada classe e o que cada um faz).

Ao longo do código você vai perceber vários comentários, eles e o Google serão seus melhores amigos durante essa jornada.

No projeto você encontrará o arquivo **pom.xml**, nele estão todas as dependências e bibliotecas que utilizamos no projeto. A Cada alteração que você fizer neste arquivo, deverá atualizar no Maven.

Outro arquivo importante é o **application.properties**, nele estão configurações relacionadas ao banco de dados e autenticação. Caso tenha problemas altere o arquivo de acordo com o banco de dados que será criado no container do Docker, ou apenas remova, o Quarkus irá criar automaticamente um container no Docker e atribuirá a porta, usuário e senha sem a necessidade de especificá-la.

Rodando o Projeto em Ambiente de Desenvolvimento
=============
----
Você já deve ter percebido que diferentemente de uma aplicação padrão Java ou Spring não existe explicitamente um método **Main**, ou seja, apertar no start da sua IDE não vai fazer rodar a aplicação.
O Quarkus traz o Maven Wrapper (mvnw), tirando a necessidade de possuir o Maven instalado no seu computador, além disso ele também despreza a necessidade de possuir os serviços de banco de dados instalado em sua máquina, por se tratar de um framework *Container First*, ele baixa tudo que é necessário em imagêns de container, cria e configura o container automaticamente no Docker.

Para rodar a aplicação será necessário abrir o Docker, em seguida abra o terminal de sua preferência (Prompt de comando, PowerShell...) na pasta raiz do projeto e digite o comando:

```
./mvnw quarkus:dev
 ```

Aguarde até que a aplicação inicie, ela realizará a conexão com o banco de dados no Docker e o Hirbernate irá criar todas as tabelas no banco de dados. Aguarde até que apareça no console o print do Hibernate criando as tabelas.

Algo como isso aparecerá no seu terminal:

```
Hibernate:
    select
        user0_.id as id1_9_,
        user0_.birthdate as birthdat2_9_,
        user0_.classe as classe3_9_,
        user0_.college_id as college16_9_,
        user0_.color_hex as color_he4_9_,
        user0_.cpf as cpf5_9_,
        user0_.creation_date as creation6_9_,
        user0_.deleted as deleted7_9_,
        user0_.email as email8_9_,
        user0_.name as name9_9_,
        user0_.password_hash as passwor10_9_,
        user0_.profile_avatar as profile11_9_,
        user0_.profile_picture as profile12_9_,
        user0_.role as role13_9_,
        user0_.userMood as usermoo14_9_,
        user0_.username as usernam15_9_
    from
        user user0_
```

Você poderá realizar os testes no Postman, faça o download da [**coleção de rotas**](https://downgit.github.io/#/home?url=https:%2F%2Fgithub.com%2FTorugoMarega%2Flevelup-graphql-api-quarkus%2Fblob%2FColecao_Postman%2Flevelup-graphql.postman_collection.json) e importe para o seu postman, nesta coleção estão todas as rotas criadas até o momento e separadas por pastas. Dentro de cada pasta principal há outras 2 pastas, **Query e Mutation**. A pasta **Query** se refere a requisições que não alteram o banco de dados, apenas retornam dados. Já a pasta **Mutation** se refere a requisições que manipulam banco de dados, como: criar um registro novo ou atualizar um existente. Na pasta "Teste de conexão" há uma rota para testar a conexão com a API, rode e verifique se está tudo funcionando corretamente, se tudo estiver certo será retornada uma mensagem "Conexão Estabelecida!".

Mãos à Obra
=============
----
Agora com o ambiente de desenvolvimento pronto, conhecimentos básicos sobre o quarkus, graphql, hibernate, e tudo funcionando conforme o esperado, é hora de trabalhar e dar continuidade ao sistema *Level UP*, no mais, desejo boa sorte e **muito café**, como já disse anteriormente, o Google e nossa documentação serão seus melhores amigos neste momento.

