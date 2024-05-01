package com.policy.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "PolicyEngineRequestLog")
public class PolicyEngineRequestLog {


    @Id
    private String id;
    private String leadId;
    private PolicyRequest requestBody;
    private PolicyResponse responseBody;
    

}
