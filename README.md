# 🤖 Chat IA com Spring Boot + OpenRouter

Este projeto é um chatbot simples integrado à API do [OpenRouter](https://openrouter.ai), utilizando Spring Boot, Feign Client e configuração segura com variáveis de ambiente.

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Cloud OpenFeign
- Maven
- OpenRouter (GPT-3.5, etc.)
- GitHub Actions (com Secrets)

## ⚙️ Como funciona

A aplicação expõe uma API REST para que o usuário envie perguntas sobre <b>energia solar</b> e receba respostas do modelo de linguagem GPT-3.5-turbo hospedado via OpenRouter.

## 📁 Estrutura

- `application.yml`: configurações da aplicação.
- `OpenRouterConfig.java`: configura o interceptor do Feign para injetar a API key.
- `OpenRouterClient.java`: interface do Feign Client que chama o endpoint `/chat/completions`.
- `ChatController.java`: recebe requisições do usuário e encaminha ao OpenRouter.

## 🔐 Configuração de ambiente

A chave da API do OpenRouter é armazenada com segurança em uma variável de ambiente chamada `OPENROUTER_API_KEY`.

### GitHub Actions

1. Vá até `Settings > Secrets > Actions`.
2. Adicione um novo secret:
   - **Name**: `OPENROUTER_API_KEY`
   - **Value**: sua chave da API do OpenRouter (`sk-or-...`)

OBS: Registre-se no site OpenRouter e gere uma API-key. É gratuito.

### Localmente (Linux/macOS)

```bash
export OPENROUTER_API_KEY=sk-or-sua-chave-aqui
./mvnw spring-boot:run
```

### Localmente (Windows)
```bash
set OPENROUTER_API_KEY=sk-or-sua-chave-aqui
mvn spring-boot:run
```

## 💬 Exemplo de requisição
- Endpoint: POST/chat
- Corpo JSON:
```bash
"Qual a importância da energia solar?"

curl -X POST http://localhost:8080/api/chat \
     -H "Content-Type: application/json" \
     -d "\"Qual a importância da energia solar?\""
```
- Exemplo de resposta:
```bash
"A energia solar é importante porque reduz os custos com energia elétrica e é uma fonte limpa e renovável."
```

## 📝 Licença
Este projeto é open-source e pode ser usado livremente para fins educacionais e comerciais.

