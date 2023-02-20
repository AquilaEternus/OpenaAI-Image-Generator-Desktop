package com.aquilaeternus.backend.image;

import com.aquilaeternus.backend.exception.ApiRequestException;
import com.aquilaeternus.backend.exception.ImageRequestException;
import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class ImageService {
    private final Environment env;

    @Autowired
    public ImageService(Environment env) {
        this.env = env;
    }

    public List<Image> getImage(String prompt, String size) {
        if (prompt.length() < 1 || prompt == null) {
            System.out.println("prompt is invalid");
            throw new ApiRequestException("Prompt is invalid.");
        }
        if (size.length() < 1 ||
                size == null ||
                !(size.equals("256x256") || size.equals("512x512") || size.equals("1024x1024"))){
            throw new ApiRequestException("Size is invalid.");
        }

        try {
            OpenAiService service = new OpenAiService(env.getProperty("openai-apikey"));
            CreateImageRequest imageRequest = CreateImageRequest.builder()
                    .prompt(prompt)
                    .n(1)
                    .size(size)
                    .build();
            return service.createImage(imageRequest).getData();
        } catch (RuntimeException e) {
            throw new ImageRequestException("Request to OpenAI were unavailable. Please try again.");
        }
    }
}
