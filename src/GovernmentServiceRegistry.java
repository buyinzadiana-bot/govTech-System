@Service
public class GovernmentServiceRegistry {

    private final Map<ServiceType, GovernmentService> services;

    public GovernmentServiceRegistry(List<GovernmentService> serviceList) {
        this.services = serviceList.stream()
                .collect(Collectors.toMap(
                        GovernmentService::getServiceType,
                        Function.identity()
                ));
    }

    public ServiceResult handle(
            ServiceType type,
            ServiceRequest request,
            Citizen citizen) {

        return services.get(type).handle(request, citizen);
    }
}
