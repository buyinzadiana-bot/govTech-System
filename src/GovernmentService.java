package com.example.govtech.service;

import com.example.govtech.audit.AuditService;
import com.example.govtech.model.Citizen;
import com.example.govtech.model.ServiceRequest;
import com.example.govtech.model.ServiceResult;
import com.example.govtech.model.ServiceType;

public abstract class GovernmentService {

    protected final AuditService auditService;

    protected GovernmentService(AuditService auditService) {
        this.auditService = auditService;
    }

    // SERVICE WORKFLOW TEMPLATE
    public final ServiceResult processRequest(ServiceRequest request, Citizen citizen) {
        validateCitizen(citizen);

        if (!isEligible(citizen, request)) {
            throw new IllegalStateException("Citizen not eligible for this service");
        }

        ServiceResult result = processService(request, citizen);
        auditService.log(request, result);

        return result;
    }

    protected void validateCitizen(Citizen citizen) {
        if (citizen == null || citizen.getNationalId() == null) {
            throw new IllegalArgumentException("Invalid citizen");
        }
    }

    // Each service (Birth Certificate, Driving Test, National ID, etc.) fills in these steps
    protected abstract boolean isEligible(Citizen citizen, ServiceRequest request);
    protected abstract ServiceResult processService(ServiceRequest request, Citizen citizen);
    public abstract ServiceType getServiceType();
}
