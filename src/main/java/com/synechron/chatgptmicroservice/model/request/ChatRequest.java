package com.synechron.chatgptmicroservice.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ChatRequest implements Serializable {
    private String question;
    @JsonProperty("fine_tune_model")
    private String model;
}
