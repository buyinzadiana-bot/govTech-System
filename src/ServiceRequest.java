public class ServiceRequest {

    private ServiceType serviceType;

    public ServiceRequest(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
