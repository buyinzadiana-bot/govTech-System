package com.example.govtech.audit;

import com.example.govtech.model.ServiceRequest;
import com.example.govtech.model.ServiceResult;
import org.springframework.stereotype.Service;

@Service
public class AuditService {

    public void log(ServiceRequest request, ServiceResult result) {
        System.out.println("Audit Log: " + request.getRequestDetails() + " -> " + result.getMessage());
    }
}
