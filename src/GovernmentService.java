
//Parent (GovernmentService)
//  |
//  |-- trackingService() [fixed steps]
//        |
//        |-- isEligible()  <-- child decides
//        |-- processService() <-- child decides
//        |-- getServiceType() <-- child decides


public abstract class GovernmentService {
    protected final TrackingService trackingService;
    protected GovernmentService(TrackingService trackingService){
        this.trackingService = trackingService;

    }

//    SERVICE WORKFLOW TEMPLATE
    public final ServiceResult processRequest(ServiceRequest request, Citizen citizen){
      validateCitizen(citizen);

      if (!isEligible (citizen, request)) {
          throw new IllegalStateException("Citizen not eligible for the service");

        }
      ServiceResult result = processService(request, citizen);
      trackingService.log(request, result);
      return result;

    }
    protected void ValidateCitizen(Citizen citizen){
        if (citizen == null || citizen.getNationalId() == null){
            throw new IllegalArgumentException("Invalid citizen");
        }
    }

    // Each service (Birth Certificate, Driving Test, etc.) fills in these steps

    protected abstract boolean isEligible(Citizen citizen, ServiceRequest request);
    protected abstract ServiceResult processService (ServiceRequest request, Citizen citizen);
    public abstract ServiceType getServiceType();

}
