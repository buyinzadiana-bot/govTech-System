package com.example.govtech.service;

import com.example.govtech.model.Citizen;
import com.example.govtech.model.ServiceRequest;
import com.example.govtech.model.ServiceResult;
import com.example.govtech.model.ServiceType;
import org.springframework.stereotype.Service;

@Service
public class NationalIdService extends GovernmentService {

    public NationalIdService(AuditService auditService) {
        super(auditService);
    }

    @Override
    protected boolean isEligible(Citizen citizen, ServiceRequest request) {
        return citizen.getAge() >= 16 && !citizen.hasNationalId();
    }

    @Override
    protected ServiceResult processService(ServiceRequest request, Citizen citizen) {
        return new ServiceResult("National ID Issued");
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.NATIONAL_ID;
    }
}
