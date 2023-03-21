package com.synechron.chatgptmicroservice.restcontroller;

import com.synechron.chatgptmicroservice.model.request.*;
import com.synechron.chatgptmicroservice.model.response.*;
import com.synechron.chatgptmicroservice.service.OpenAIClientService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1")
public class OpenAIClientController {

    private final OpenAIClientService openAIClientService;

    @GetMapping("/")
    public String home() {
        return "Suceess";
    }


    @PostMapping(value = "/chat", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseModel chat(HttpServletRequest request, @RequestBody ChatRequest chatRequest) {
        String requestId = UUID.randomUUID().toString();
        log.info("requestId {}, ip {}, send a message : {}", requestId, request.getRemoteHost(), chatRequest.getQuestion());
        if (!StringUtils.hasText(chatRequest.getQuestion())) {
            return ResponseModel.fail("message can not be blank");
        }
        try {
            ChatGPTResponse chatGPTResponse = openAIClientService.chat(chatRequest);
//            String responseMessage = chatGPTResponse.getChoices().get(0).getMessage().getContent();
            log.info("requestId {}, ip {}, get a reply : {}", requestId, request.getRemoteHost(), chatGPTResponse);
            return ResponseModel.success(chatGPTResponse);
        } catch (Exception ex) {
            log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), ex);
            return new ResponseModel(500, "error", ex.getMessage());
        }
    }

    @PostMapping(value = "/generateImage", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseModel chat(HttpServletRequest request, @RequestBody ChatGPTImageRequest chatGPTImageRequest) {
        String requestId = UUID.randomUUID().toString();
        log.info("requestId {}, ip {}, send a generate image request : {}", requestId, request.getRemoteHost(), chatGPTImageRequest);
        if (!StringUtils.hasText(chatGPTImageRequest.getPrompt())) {
            return ResponseModel.fail("prompt can not be blank");
        }
        try {
            ChatGPTImageResponse chatGPTImageResponse = openAIClientService.generateImage(chatGPTImageRequest);
            log.info("requestId {}, ip {}, get a reply : {}", requestId, request.getRemoteHost(), chatGPTImageResponse);
            return ResponseModel.success(chatGPTImageResponse);
        } catch (Exception ex) {
            log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), ex);
            return new ResponseModel(500, "error", ex.getMessage());
        }


//        return openAIClientService.generateImage(chatGPTImageRequest);
    }

    @PostMapping(value = "/transcription", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseModel<ChatGPTTranscriptionResponse> createTranscription(HttpServletRequest request, @ModelAttribute TranscriptionRequest transcriptionRequest) {
        String requestId = UUID.randomUUID().toString();

        try {
            ChatGPTTranscriptionResponse chatGPTTranscriptionResponse = openAIClientService.createTranscription(transcriptionRequest);
            return ResponseModel.success(chatGPTTranscriptionResponse);
        } catch (Exception ex) {
            log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), ex);
            return new ResponseModel(500, "error", ex.getMessage());
        }
    }


    @PostMapping(value = "/uploadfilee", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseModel<FileMetaData> uploadFile(HttpServletRequest request, @ModelAttribute FileRequest fileRequest) {
        String requestId = UUID.randomUUID().toString();

        try {
            FileMetaData fileMetaData = openAIClientService.uploadFile(fileRequest);
            return ResponseModel.success(fileMetaData);
        } catch (Exception ex) {
            log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), ex);
            return new ResponseModel(500, "error", ex.getMessage());
        }
    }


    @GetMapping("/fetchListOfFiles")
    public ResponseModel<FileResponse> getFiles() {
        try {
            FileResponse fileResponse = openAIClientService.getFiles();
            return ResponseModel.success(fileResponse);
        } catch (Exception ex) {
            //log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), ex);
            return new ResponseModel(500, "error", ex.getMessage());
        }
    }

    @PostMapping(value = "/createFineTune", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseModel<FineTuneResponse> createFineTune(HttpServletRequest request, @RequestBody FineTuneRequest fineTuneRequest) {
        //System.out.println("training file==> " + fineTuneRequest.getTraining_file() );
        //fineTuneRequest.setTraining_file("file-nkpKNZIWtv0nDdmnYiSq1KbM");
        String requestId = UUID.randomUUID().toString();

        try {
            FineTuneResponse fineTuneResponse = openAIClientService.createFineTune(fineTuneRequest);
            return ResponseModel.success(fineTuneResponse);
        } catch (Exception ex) {
            log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), ex);
            return new ResponseModel(500, "error", ex.getMessage());
        }
    }

    @PostMapping(value = "/createCompletion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseModel createCompletion(HttpServletRequest request, @RequestBody ChatRequest chatRequest) {
//        String requestId = UUID.randomUUID().toString();
//        log.info("requestId {}, ip {}, send a message : {}", requestId, request.getRemoteHost(), chatRequest.getQuestion());
//        if (!StringUtils.hasText(chatRequest.getQuestion())) {
//            return ResponseModel.fail("message can not be blank");
//        }
        try {
            ChatGPTResponse chatGPTResponse = openAIClientService.createCompletion(chatRequest);
//            String responseMessage = chatGPTResponse.getChoices().get(0).getMessage().getContent();
//            log.info("requestId {}, ip {}, get a reply : {}", requestId, request.getRemoteHost(), chatGPTResponse);
            return ResponseModel.success(chatGPTResponse);
        } catch (Exception ex) {
//            log.error("requestId {}, ip {}, error", requestId, request.getRemoteHost(), ex);
            return new ResponseModel(500, "error", ex.getMessage());
        }
    }
}
