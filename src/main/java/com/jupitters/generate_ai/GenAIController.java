package com.jupitters.generate_ai;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenAIController {
    private final ChatService chatService;
    private final ImageService imageService;

    @GetMapping("/ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("/ask-ai-options")
    public String getResponseOptions(@RequestParam String prompt){
        return chatService.getResponseOptions(prompt);
    }

//    @GetMapping("/generate-image")
//    public void generateImage(HttpServletResponse response, @RequestParam String prompt) throws IOException {
//        ImageResponse image = imageService.generateImage(prompt);
//
//        String url = Objects.requireNonNull(image.getResult()).getOutput().getUrl();
//
//        response.sendRedirect(url);
//    }

    @GetMapping("/generate-image")
    public List<String> generateImage(HttpServletResponse response,
                                      @RequestParam String prompt,
                                      @RequestParam(defaultValue = "hd") String quality,
                                      @RequestParam(defaultValue = "1") int n,
                                      @RequestParam(defaultValue = "1024") int width,
                                      @RequestParam(defaultValue = "1024") int height) throws IOException {
        ImageResponse images = imageService.generateImage(prompt, quality, n, width, height);

        return images.getResults()
                .stream()
                .map(result -> result.getOutput().getUrl())
                .toList();
    }

    public List<String> recipeCreator(){
        return List.of();
    }
}
