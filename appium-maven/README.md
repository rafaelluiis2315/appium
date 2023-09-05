# Projeto Appium com Maven

Este é um projeto de exemplo que demonstra como configurar e executar testes de automação de aplicativos móveis usando o Appium com o Maven como gerenciador de dependências.

## Executando o Projeto

1. Clone este repositório para sua máquina local:

```bash
      git clone https://github.com/seu-usuario/appium-maven.git
```

2. Navegue até o diretório do projeto:

```bash
      cd appium-maven
```

3. Instale as dependências do Maven:

```bash
      mvn clean install
```

4. Execute os testes de automação usando o seguinte comando:

```bash
      mvn test
```

## Estrutura do Projeto
O projeto segue uma estrutura de diretório típica do Maven, com os principais diretórios e arquivos a seguir:

- src/main/test: Contém os testes de automação do projeto.
- src/main/resources: Contém o APK ultilizado nos testes.
- pom.xml: O arquivo de configuração do Maven que define as dependências e as configurações do projeto.

## Personalizando os Testes
Você pode personalizar os testes editando os arquivos de teste localizados em src/main/test. Certifique-se de configurar as capacidades desejadas para seu aplicativo móvel e dispositivo em seu código de teste.
