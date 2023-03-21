package com.synechron.chatgptmicroservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FineTuneRequest implements Serializable {
    private String training_file;
    private String model;
}
