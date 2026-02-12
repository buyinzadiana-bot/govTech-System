import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {

    private List<ServiceApplication> applications = new ArrayList<>();

    public void addApplication(ServiceApplication app) {
        applications.add(app);
    }

    public void approveApplication(String id) {
        for (ServiceApplication app : applications) {
            if (app.getApplicationId().equals(id)) {
                app.approve();
                return;
            }
        }
        throw new IllegalArgumentException("Application not found");
    }

    public void displayApplications() {
        for (ServiceApplication app : applications) {
            System.out.println(app);
        }
    }

    public double calculateRevenue() {
        double total = 0;
        for (ServiceApplication app : applications) {
            if (app.getStatus() == ServiceStatus.APPROVED) {
                total += app.getFee();
            }
        }
        return total;
    }
}
