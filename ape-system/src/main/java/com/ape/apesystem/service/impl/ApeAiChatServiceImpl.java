package com.ape.apesystem.service.impl;

import com.ape.apesystem.service.ApeAiChatService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
public class ApeAiChatServiceImpl implements ApeAiChatService {


    private final String apiKey = "sk-3cf1a701c20c4340ba5bbd4ea49d4c46";
    private final String apiUrl = "https://api.deepseek.com/chat/completions";
    private final String modelName = "deepseek-chat";
    private final WebClient webClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ApeAiChatServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @Override
    public String getFixedAnswer(String question) {
        return "你好";
    }

    @Override
    public String getAnswer(String question) {
        log.info("向 DeepSeek 发送问题: {}", question);

        Map<String, Object> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", question);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", modelName);
        requestBody.put("messages", Collections.singletonList(message));

        try {
            String response = webClient.post()
                    .uri(apiUrl)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(Mono.just(requestBody), Map.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            log.info("从 DeepSeek 收到响应: {}", response);
            JsonNode rootNode = objectMapper.readTree(response);
            String answer = rootNode.path("choices").get(0).path("message").path("content").asText();

            log.info("提取的答案: {}", answer);
            return answer;

        } catch (Exception e) {
            log.error("调用 DeepSeek API 时出错", e);
            return "抱歉，处理您的请求时遇到错误。";
        }
    }
}