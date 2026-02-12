import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {
    private List<ServiceApplication> applications = new ArrayList<>();

    public void addApplication(ServiceApplication app) {
        applications.add(app);
        System.out.println("Application added: " + app.getApplicationId());
    }

    public ServiceApplication findApplication(String applicationId) throws Exception {
        for (ServiceApplication app : applications) {
            if (app.getApplicationId().equals(applicationId)) {
                return app;
            }
        }
        throw new Exception("Application not found!");
    }

    public void approveApplication(String applicationId) {
        try {
            ServiceApplication app = findApplication(applicationId);
            app.approve();
            System.out.println("Application approved: " + applicationId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayAllApplications() {
        System.out.println("All Applications:");
        for (ServiceApplication app : applications) {
            System.out.println(app);
        }
    }
}
