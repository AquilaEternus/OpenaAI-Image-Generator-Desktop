# OpenAI Image Generator Desktop

A simple desktop GUI tool written in Electron js for generating images using OpenAI's DALL-E image generator. Uses a Spring Boot REST API to access OpenAI's image generating API through TheoKanning's openai-gpt3-java maven plugin.

Note: To run the Sping Boot backend locally, change the "openai-apikey" environment variable in file "application.properties" to a valid OpenAI API key.

### Running within development environment / Node with Electron

_npm start_

#### Start Up

![Startup Image](https://res.cloudinary.com/hi1f6rvdx/image/upload/v1676931922/openai-img-gen-startup_2_np2ac1.png "Start Up")

#### After Generating Prompt

![Alt text](https://res.cloudinary.com/hi1f6rvdx/image/upload/v1676931930/openai-img-gen-image_3_vem1cs.png "After Generating Prompt")
