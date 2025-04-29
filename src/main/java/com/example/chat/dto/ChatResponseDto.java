package com.example.chat.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChatResponseDto {
    private List<Choice> choices;

    public List<ChatMessage> getAnswers() {
        return choices.stream()
                .map(Choice::getMessage)
                .toList();
    }

    @Data
    public static class Choice {
        private ChatMessage message;
    }

}
