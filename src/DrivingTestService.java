public class DrivingTestService extends GovernmentService {

    @Override
    protected boolean isEligible(Citizen citizen) {
        return citizen.getAge() >= 18 && citizen.hasLearnersPermit();
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.DRIVING_TEST;
    }

    @Override
    public double getFee() {
        return 25.0;
    }
}
