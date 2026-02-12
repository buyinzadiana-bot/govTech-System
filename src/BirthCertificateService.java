public class BirthCertificateService extends GovernmentService {

    @Override
    protected boolean isEligible(Citizen citizen) {
        return citizen.getAge() <= 1;
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.BIRTH_CERTIFICATE;
    }

    @Override
    public double getFee() {
        return 10.0;
    }
}
