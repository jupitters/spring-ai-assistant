package com.jupitters.generate_ai;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GenAIController {
    private final ChatService chatService;

    public String getReseponse(String prompt){
        return chatService.getResponse(prompt);
    }
}
