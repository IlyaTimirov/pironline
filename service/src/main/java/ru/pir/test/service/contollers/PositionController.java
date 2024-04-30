package ru.pir.test.service.contollers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pir.test.service.dto.PositionHistoryDto;
import ru.pir.test.service.services.PositionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/position/history/")
public class PositionController {

    private final PositionService positionService;

    @GetMapping("/employee/{id}")
    public ResponseEntity<PositionHistoryDto> getEmployee(@PathVariable Long id){
        return new ResponseEntity<>(positionService.getEmployeeId(id), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<PositionHistoryDto>> getAll(@RequestParam(required = false, defaultValue = "5")  int sizePage, @RequestParam(required = false, defaultValue = "0") int pageNumber) {
        Pageable pageRequest = PageRequest.of(pageNumber, sizePage);
        return new ResponseEntity<>(positionService.fetch(pageRequest), HttpStatus.OK);
    }
}
