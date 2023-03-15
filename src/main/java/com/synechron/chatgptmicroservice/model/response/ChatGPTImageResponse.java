package com.synechron.chatgptmicroservice.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class ChatGPTImageResponse implements Serializable {

    private Integer created;

    private List<ImageUrl> data;

}
