package com.jupitters.generate_ai;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService{
    private final OpenAiImageModel openAiImageModel;

    public ImageResponse generateImage(String prompt){
        return openAiImageModel.call(
                new ImagePrompt(prompt,
                        OpenAiImageOptions.builder()
                                .quality("hd")
                                .N(4)
                                .height(1024)
                                .width(1024)
                                .build())
        );
    }
}
