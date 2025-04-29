package com.example.chat.dto;

import java.util.List;

import lombok.Data;

@Data
public class ChatResponseDto {
    private List<ChatMessage> answers;

}
