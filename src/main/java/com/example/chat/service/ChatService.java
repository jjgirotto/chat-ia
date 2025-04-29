package com.example.chat.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.chat.client.OpenRouterClient;
import com.example.chat.dto.ChatMessage;
import com.example.chat.dto.ChatRequestDto;
import com.example.chat.dto.ChatResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final OpenRouterClient client;

    public String chat(String question) {
        String contentSystem = "Você é um assistente especializado em energia solar e está aqui para ajudar com informações sobre instalação, vistoria, documentação e manutenção de sistemas fotovoltaicos. Responda de forma concisa e direta e caso saia do contexto, peça para o cliente reformular. A instalação quando chegar na etapa correspondente será enviada uma notificação para que o cliente possa agendar nos horários disponíveis, tem que aguardar chegarna etapa de instalação. Na vistoria, o cliente deve confirmar e enviar fotos após a realização da vistoria. Nas documentações, o cliente receberá instruções sobre qual documentação enviar. Para assinatura digital, explique como assinar pelo gov.br e também os requisitos (conta ouro/prata) para assinatura física explique que tem que imprimir e assinar físico.";
        ChatMessage messageSystem = new ChatMessage("system", contentSystem);
        ChatMessage messageUser = new ChatMessage("user", question);
        ChatRequestDto requestDto = new ChatRequestDto("openai/gpt-3.5-turbo", List.of(messageSystem, messageUser));
        ChatResponseDto responseDto = client.sendAnswer(requestDto);
        return responseDto.getAnswers().get(0).getContent();
    }
}
