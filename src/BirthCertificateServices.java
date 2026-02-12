public class BirthCertificateServices {
}
@Service
public class BirthCertificateService extends GovernmentService {

    public BirthCertificateService(TrackingService trackingService) {
        super(trackingService);
    }

    @Override
    protected boolean isEligible(Citizen citizen, ServiceRequest request) {
        return citizen.getAgeInDays() <= 30;
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
