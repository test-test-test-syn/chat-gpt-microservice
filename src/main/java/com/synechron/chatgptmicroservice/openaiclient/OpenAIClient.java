package com.synechron.chatgptmicroservice.openaiclient;

import com.synechron.chatgptmicroservice.model.request.*;
import com.synechron.chatgptmicroservice.model.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "openai-service",
        url = "${openai-service.urls.base-url}",
        configuration = OpenAIClientConfig.class
)
public interface OpenAIClient {

    @PostMapping(value = "${openai-service.urls.chat-url}", headers = {"Content-Type=application/json"})
    ChatGPTResponse chat(@RequestBody ChatGPTRequest chatGPTRequest);

    @PostMapping(value ="${openai-service.urls.image-url}", headers = {"Content-Type=application/json"})
    ChatGPTImageResponse generateImage(@RequestBody ChatGPTImageRequest chatGPTImageRequest);

    @PostMapping(value = "${openai-service.urls.create-transcription-url}", headers = {"Content-Type=multipart/form-data"})
    WhisperTranscriptionResponse createTranscription(@ModelAttribute WhisperTranscriptionRequest whisperTranscriptionRequest);
    @PostMapping(value ="${openai-service.urls.file-url}", headers = {"Content-Type=multipart/form-data"})
    FileMetaData uploadFile(@RequestBody FileRequest fileRequest);

    @GetMapping(value ="${openai-service.urls.file-url}")
    FileResponse getFiles();

    @PostMapping(value ="${openai-service.urls.fine-tune-url}", headers = {"Content-Type=application/json"})
    FineTuneResponse createFineTune(@RequestBody FineTuneRequest fineTuneRequest);

    @PostMapping(value = "${openai-service.urls.create-completion-url}", headers = {"Content-Type=application/json"})
    ChatGPTResponse createCompletion(@RequestBody ChatGPTCreateCompletionRequest chatGPTCreateCompletionRequest);
}
