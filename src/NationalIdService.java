@Service
public class NationalIdService extends GovernmentService {

    public NationalIdService(TrackingService trackingService) {
        super(trackingService);
    }

    @Override
    protected boolean isEligible(Citizen citizen, ServiceRequest request) {
        return citizen.getAge() >= 16 && !citizen.hasNationalId();
    }

    @Override
    protected ServiceResult processService(ServiceRequest request, Citizen citizen) {
        return new ServiceResult("National ID Issued");
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.NATIONAL_ID;
    }
}
