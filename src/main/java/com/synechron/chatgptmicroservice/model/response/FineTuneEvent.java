package com.synechron.chatgptmicroservice.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class FineTuneEvent implements Serializable {
    private String object;
    private String created_at;
    private String level;
    private String message;

}
