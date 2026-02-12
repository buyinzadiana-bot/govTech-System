public abstract class GovernmentService {

    protected final TrackingService trackingService;

    protected GovernmentService(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    public final ServiceResult handle(Citizen citizen) {
        validateCitizen(citizen);

        if (!isEligible(citizen)) {
            throw new IllegalStateException("Citizen not eligible");
        }

        ServiceResult result = processService(citizen);

        if (trackingService != null) {
            trackingService.log(result);
        } else {
            System.out.println("LOG: " + result);
        }

        return result;
    }

    protected void validateCitizen(Citizen citizen) {
        if (citizen == null || citizen.getNationalId() == null) {
            throw new IllegalArgumentException("Invalid citizen");
        }
    }

    protected abstract boolean isEligible(Citizen citizen);

    protected abstract ServiceResult processService(Citizen citizen);

    public abstract ServiceType getServiceType();

    public abstract double getFee();
}
