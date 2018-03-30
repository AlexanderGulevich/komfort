package basisFx.domainModel.mapper;

public class EmployeesDataMapper {
    private static EmployeesDataMapper ourInstance = new EmployeesDataMapper();

    public static EmployeesDataMapper getInstance() {
        return ourInstance;
    }

    private EmployeesDataMapper() {
    }
}
