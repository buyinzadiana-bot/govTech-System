public abstract class GovernmentService {

    public final void processRequest(Citizen citizen) {
        validateCitizen(citizen);

        if (!isEligible(citizen)) {
            throw new IllegalStateException("Citizen not eligible");
        }
    }

    protected void validateCitizen(Citizen citizen) {
        if (citizen == null || citizen.getNationalId() == null) {
            throw new IllegalArgumentException("Invalid citizen");
        }
    }

    protected abstract boolean isEligible(Citizen citizen);
    public abstract ServiceType getServiceType();
    public abstract double getFee();
}
