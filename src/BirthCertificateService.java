package com.example.govtech.service;

import com.example.govtech.audit.AuditService;
import com.example.govtech.model.Citizen;
import com.example.govtech.model.ServiceRequest;
import com.example.govtech.model.ServiceResult;
import com.example.govtech.model.ServiceType;
import org.springframework.stereotype.Service;

@Service
public class BirthCertificateService extends GovernmentService {

    public BirthCertificateService(AuditService auditService) {
        super(auditService);
    }

    @Override
    protected boolean isEligible(Citizen citizen, ServiceRequest request) {
        return citizen.getAge() <= 30;
    }

    @Override
    protected ServiceResult processService(ServiceRequest request, Citizen citizen) {
        return new ServiceResult("Birth Certificate Issued");
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.BIRTH_CERTIFICATE;
    }
}
