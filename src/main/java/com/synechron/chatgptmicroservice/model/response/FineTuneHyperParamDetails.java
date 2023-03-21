package com.synechron.chatgptmicroservice.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class FineTuneHyperParamDetails implements Serializable {

    private Integer batch_size;
    private Double learning_rate_multiplier;
    private Integer n_epochs;
    private Double prompt_loss_weight;
}
