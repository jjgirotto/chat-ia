package com.example.chat.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.chat.config.OpenRouterConfig;
import com.example.chat.dto.ChatRequestDto;
import com.example.chat.dto.ChatResponseDto;

@FeignClient(name = "openRouterClient", url = "https://openrouter.ai/api/v1/chat/completions", configuration = OpenRouterConfig.class)
public interface OpenRouterClient {

    @PostMapping
    ChatResponseDto sendAnswer(@RequestBody ChatRequestDto question);
}
