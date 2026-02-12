import java.util.UUID;

public class ServiceApplication {

    private String applicationId;
    private Citizen citizen;
    private GovernmentService service;
    private ServiceStatus status;

    public ServiceApplication(Citizen citizen, GovernmentService service) {
        this.applicationId = UUID.randomUUID().toString();
        this.citizen = citizen;
        this.service = service;
        this.status = ServiceStatus.PENDING;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public GovernmentService getService() {
        return service;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void approve() {
        if (status != ServiceStatus.PENDING) {
            throw new IllegalStateException("Cannot approve again");
        }
        status = ServiceStatus.APPROVED;
    }

    public double getFee() {
        return service.getFee();
    }

    @Override
    public String toString() {
        return applicationId + " | " +
                service.getServiceType() + " | " +
                status;
    }
}
