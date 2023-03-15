package com.synechron.chatgptmicroservice.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ChatGPTTranscriptionResponse implements Serializable {

    private String textQuery;
    private ChatGPTResponse chatGPTResponse;


}
