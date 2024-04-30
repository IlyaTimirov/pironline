package ru.pir.test.service.consumers;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.pir.test.kafka.models.Consts;
import ru.pir.test.service.models.kafka.EmployeeCE;
import ru.pir.test.service.services.EmployeeService;

@Service
@RequiredArgsConstructor
public class ServiceConsumers {
    private final Gson gson;

    private final EmployeeService employeeService;
    @KafkaListener(topics = "apps.public.employees", groupId = "pir")
    public void listenEmployee(String data){
        var event = gson.fromJson(data, EmployeeCE.class);
        if(Consts.UPDATE.equals(event.getPayload().getOp())) {
            employeeService.updateAndSave(event.getPayload());
        } else if(Consts.CREATE.equals(event.getPayload().getOp())) {
            employeeService.save(event.getPayload());
        }
    }
}
