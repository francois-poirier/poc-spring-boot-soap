package poc.fpo.services.pocspringbootsoap.endpoint;

import com.fpo.poc_spring_boot_soap.GetEmployeeRequest;
import com.fpo.poc_spring_boot_soap.GetEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import poc.fpo.services.pocspringbootsoap.service.EmployeeService;

@Endpoint
public class EmployeeEndPoint {

    @Autowired
    private EmployeeService employeeService;


    @PayloadRoot(namespace = "http://fpo.com/poc-spring-boot-soap",
            localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployeeRequest(@RequestPayload GetEmployeeRequest request) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmp(employeeService.getEmployee(request.getName()));
        return response;
    }

}
