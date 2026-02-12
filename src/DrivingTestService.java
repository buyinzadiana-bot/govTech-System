public class DrivingTestService extends GovernmentService {

    public DrivingTestService() {
        super("Driving Test Service", 50.0);
    }

    @Override
    public void performService() {
        System.out.println("Processing Driving Test...");
    }
}
