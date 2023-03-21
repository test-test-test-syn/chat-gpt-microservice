package com.synechron.chatgptmicroservice.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class FileResponse implements Serializable  {

    private List<FileMetaData> data;
    private String object;
}
