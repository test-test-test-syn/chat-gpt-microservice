package com.synechron.chatgptmicroservice.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class FileMetaData  implements Serializable {

    private String id;
    private String object;
    private Integer  bytes;
    private  Integer created;
    private String filename;
    private String purpose;
}
