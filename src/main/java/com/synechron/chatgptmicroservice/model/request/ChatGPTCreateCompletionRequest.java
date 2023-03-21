package com.synechron.chatgptmicroservice.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTCreateCompletionRequest implements Serializable {

    private String model;
    private String prompt;
    private Integer max_tokens;
    private Double temperature;
    private String stop;

}
