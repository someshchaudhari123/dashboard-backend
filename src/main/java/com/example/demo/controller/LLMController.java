//// src/main/java/com/example/demo/controller/LLMController.java
//package com.example.demo.controller;
//
//import com.theokanning.openai.completion.CompletionRequest;
//import com.theokanning.openai.service.OpenAiService;
//import org.springframework.web.bind.annotation.*;
//import com.theokanning.openai.service.OpenAiService;
//import java.time.Duration;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/llm")
//@CrossOrigin(origins = "http://localhost:3000")
//public class LLMController {
//
//    private final OpenAiService openAiService;
//
//    public LLMController() {
//        // ⚠️ Store API Key in ENV, not hardcoded
//        String apiKey = System.getenv("OPENAI_API_KEY");
//        this.openAiService = new OpenAiService(apiKey, Duration.ofSeconds(30));
//    }
//
//    @PostMapping("/ask")
//    public String askLLM(@RequestBody Map<String, String> request) {
//        String question = request.get("prompt");
//
//        CompletionRequest completion = CompletionRequest.builder()
//                .model("gpt-3.5-turbo-instruct")
//                .prompt(question)
//                .maxTokens(150)
//                .temperature(0.7)
//                .build();
//
//        return openAiService.createCompletion(completion).getChoices().get(0).getText();
//    }
//}
