package com.jupitters.generate_ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatModel chatModel;

    public String getResponse(String prompt) {
        return chatModel.call(prompt);
    }

    public String getResponseOptions(String prompt) {
        ChatResponse response = chatModel.call(
                new Prompt(
                        "Generate the names of 5 famous pirates",
                        OpenAiChatOptions.builder()
                                .model("gpt-4-o")
                                .temperature(0.4)
                                .build()
                )
        );

        return response.getResult().getOutput().toString();
    }
}
