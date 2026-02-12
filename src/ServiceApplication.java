public class ServiceApplication {
    public enum Status { PENDING, APPROVED, REJECTED }

    private String applicationId;
    private Citizen citizen;
    private GovernmentService service;
    private Status status;

    public ServiceApplication(String applicationId, Citizen citizen, GovernmentService service) {
        this.applicationId = applicationId;
        this.citizen = citizen;
        this.service = service;
        this.status = Status.PENDING;
    }

    public String getApplicationId() { return applicationId; }
    public Citizen getCitizen() { return citizen; }
    public GovernmentService getService() { return service; }
    public Status getStatus() { return status; }

    public void approve() throws Exception {
        if (status == Status.APPROVED)
            throw new Exception("Application already approved!");
        status = Status.APPROVED;
    }

    public void reject() throws Exception {
        if (status == Status.REJECTED)
            throw new Exception("Application already rejected!");
        status = Status.REJECTED;
    }

    @Override
    public String toString() {
        return "ApplicationID: " + applicationId + ", Citizen: " + citizen +
                ", Service: " + service.getServiceName() + ", Status: " + status;
    }
}
