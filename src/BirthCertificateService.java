public class BirthCertificateService extends GovernmentService {

    public BirthCertificateService() {
        super("Birth Certificate Service", 10.0);
    }

    @Override
    public void performService() {
        System.out.println("Processing Birth Certificate...");
    }
}
