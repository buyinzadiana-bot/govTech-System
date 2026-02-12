package com.example.govtech.service;

import com.example.govtech.audit.AuditService;
import com.example.govtech.model.Citizen;
import com.example.govtech.model.ServiceRequest;
import com.example.govtech.model.ServiceResult;
import com.example.govtech.model.ServiceType;
import org.springframework.stereotype.Service;

@Service
public class DrivingTestService extends GovernmentService {

    public DrivingTestService(AuditService auditService) {
        super(auditService);
    }

    @Override
    protected boolean isEligible(Citizen citizen, ServiceRequest request) {
        return citizen.getAge() >= 18 && citizen.hasLearnersPermit();
    }

    @Override
    protected ServiceResult processService(ServiceRequest request, Citizen citizen) {
        return new ServiceResult("Driving Test Scheduled");
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.DRIVING_TEST;
    }
}
