package ru.pir.test.kafka.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Parameters {

    @SerializedName("allowed")
    private String allowed;

}
