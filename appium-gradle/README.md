# Projeto Appium com Gradle

Este é um projeto de exemplo que demonstra como configurar e executar testes de automação de aplicativos móveis usando o Appium com o Gradle como gerenciador de dependências.

## Executando o Projeto

1. Clone este repositório para sua máquina local:

```bash
      git clone https://github.com/seu-usuario/appium-maven.git
```

2. Navegue até o diretório do projeto:

```bash
      cd appium-gradle
```

3. Execute os testes de automação usando o seguinte comando Gradle:

```bash
     gradle test
```

## Estrutura do Projeto
O projeto segue uma estrutura de diretório típica do Gradle, com os principais diretórios e arquivos a seguir:

- src/test/java: Contém os testes de automação do projeto.
- src/test/resources: Contém o APK ultilizado nos testes.
- build.gradle: O arquivo de configuração do Gradle que define as dependências e as configurações do projeto.

## Personalizando os Testes
Você pode personalizar os testes editando os arquivos de teste localizados em src/test/java. Certifique-se de configurar as capacidades desejadas para seu aplicativo móvel e dispositivo em seu código de teste.