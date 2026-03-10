# Frontend Test Automation Framework - Java + Serenity BDD

Projeto de exemplo para portfolio com automacao de testes frontend usando Java, Selenium WebDriver e Serenity BDD com features em Gherkin.

## Objetivo

Demonstrar um framework de UI automation com estrutura BDD, massa de dados externa, tags de execucao e pipeline de CI para uso como repositorio de referencia profissional.

## Stack

- Java 17
- Maven
- Serenity BDD
- Cucumber
- Selenium WebDriver
- AssertJ
- GitHub Actions

## Features descritas

### Authentication

Arquivo: `src/test/resources/features/authentication/practice_login.feature`

Cobertura:
- login com credenciais validas
- validacao de erro para senha invalida

Tags:
- `@ui`
- `@auth`
- `@smoke`
- `@regression`
- `@negative`

### Forms

Arquivo: `src/test/resources/features/forms/web_form_submission.feature`

Cobertura:
- preenchimento de formulario web
- selecao de dropdown
- marcacao de checkbox
- submissao com validacao da mensagem final

Tags:
- `@ui`
- `@forms`
- `@smoke`
- `@regression`

## Massa de dados

Os dados de teste ficam em `src/test/resources/test-data`.

- `login-data.json`
- `web-form-data.json`

Essa abordagem facilita manutencao, reuso e expansao para mais cenarios sem acoplar valores diretamente nas steps.

## Estrutura

```text
src
|-- test
|   |-- java
|   |   `-- com.melqui.portfolio.ui
|   |       |-- data
|   |       |-- pages
|   |       |-- runners
|   |       `-- steps
|   `-- resources
|       |-- features
|       `-- test-data
`-- .github
    `-- workflows
```

## Como executar

Executar toda a suite:

```bash
mvn clean verify
```

Executar apenas cenarios smoke:

```bash
mvn clean verify -Dcucumber.filter.tags="@smoke"
```

Executar apenas cenarios negativos:

```bash
mvn clean verify -Dcucumber.filter.tags="@negative"
```

O relatorio HTML do Serenity fica em `target/site/serenity`.

## CI

O workflow do GitHub Actions esta em `.github/workflows/ui-tests.yml`.

Ele:
- instala Java 17
- prepara o Chrome
- executa `mvn clean verify`
- publica os artefatos do Serenity e dos relatorios de teste

Tambem e possivel disparar manualmente o workflow com filtro por tags.

## Sites publicos utilizados

- `https://practicetestautomation.com/practice-test-login/`
- `https://www.selenium.dev/selenium/web/web-form.html`

## Observacoes

- O projeto roda com Chrome em modo headless.
- A primeira execucao pode baixar binarios do navegador ou driver.
- Como os cenarios usam sites publicos, eventual instabilidade externa pode impactar a execucao.
