package com.aquilaeternus.backend.image;

import com.aquilaeternus.backend.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.theokanning.openai.image.Image;

import java.util.List;


@RestController
@RequestMapping(path="/api/v1/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public ResponseEntity<List<Image>> getImage(@RequestParam String prompt, @RequestParam String size) {
        return new ResponseEntity<List<Image>>(imageService.getImage(prompt, size), HttpStatus.OK);
    }
}
