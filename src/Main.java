public class Main {

    public static void main(String[] args) {

        Citizen citizen = new Citizen("12345", 20, true);

        GovernmentService birthService = new BirthCertificateService();
        GovernmentService drivingService = new DrivingTestService();

        ServiceApplication app1 =
                new ServiceApplication(citizen, drivingService);

        ApplicationManager manager = new ApplicationManager();
        manager.addApplication(app1);

        manager.approveApplication(app1.getApplicationId());

        manager.displayApplications();

        System.out.println("Total Revenue: " +
                manager.calculateRevenue());
    }
}
