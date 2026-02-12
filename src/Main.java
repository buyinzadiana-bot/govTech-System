public class Main {

    public static void main(String[] args) {

        // 1️⃣ Create shared helper (audit system)
        AuditService auditService = new AuditService();

        // 2️⃣ Create government services (departments)
        GovernmentService birthService =
                new BirthCertificateService(auditService);

        GovernmentService drivingService =
                new DrivingTestService(auditService);

        GovernmentService nationalIdService =
                new NationalIdService(auditService);

        // 3️⃣ Put all services into a list
        List<GovernmentService> services = List.of(
                birthService,
                drivingService,
                nationalIdService
        );

        // 4️⃣ Create the registry (front desk)
        GovernmentServiceRegistry registry =
                new GovernmentServiceRegistry(services);

        // 5️⃣ Create a citizen
        Citizen citizen = new Citizen(
                "123456789",
                18,
                false,   // hasNationalId
                true     // hasLearnersPermit
        );

        // 6️⃣ Create a request
        ServiceRequest request =
                new ServiceRequest(ServiceType.DRIVING_TEST);

        // 7️⃣ Ask the registry to handle it
        ServiceResult result =
                registry.handle(
                        ServiceType.DRIVING_TEST,
                        request,
                        citizen
                );

        // 8️⃣ Print the result
        System.out.println(result.getMessage());
    }
}
