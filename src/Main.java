public class Main {
    public static void main(String[] args) {

        Citizen john = new Citizen("C001", "John Doe", 30);
        Citizen jane = new Citizen("C002", "Jane Smith", 25);

        GovernmentService birthService = new BirthCertificateService();
        GovernmentService drivingService = new DrivingTestService();

        ServiceApplication app1 = new ServiceApplication("A001", john, birthService);
        ServiceApplication app2 = new ServiceApplication("A002", jane, drivingService);

        ApplicationManager manager = new ApplicationManager();

        manager.addApplication(app1);
        manager.addApplication(app2);

        manager.displayAllApplications();

        manager.approveApplication("A001");
        manager.approveApplication("A002");

        manager.displayAllApplications();
    }
}
