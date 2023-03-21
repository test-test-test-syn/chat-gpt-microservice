package com.synechron.chatgptmicroservice.model.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class FineTuneResponse implements Serializable {
    private String id;
    private String object;
    private String model;
    private Integer created_at;
    private List<FineTuneEvent> events;
    private String fine_tuned_model;
    private FineTuneHyperParamDetails hyperparams;
    private String organization_id;
    private List result_files;
    private String status;
    private List validation_files;
    private List<FineTuneTrainingFile> training_files;
    private Integer updated_at;










}
