@Service
public class DrivingTestService extends GovernmentService {

    public DrivingTestService(TrackingService trackingService) {
        super(trackingService);
    }

    @Override
    protected boolean isEligible(Citizen citizen, ServiceRequest request) {
        return citizen.getAge() >= 18 && citizen.hasLearnersPermit();
    }

    @Override
    protected ServiceResult processService(ServiceRequest request, Citizen citizen) {
        return new ServiceResult("Driving Test Scheduled");
    }

    @Override
    public ServiceType getServiceType() {
        return ServiceType.DRIVING_TEST;
    }
}
