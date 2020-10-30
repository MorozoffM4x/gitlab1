package ru.mtuci.simpleapi.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.simpleapi.model.Result;
import ru.mtuci.simpleapi.service.ResultService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = ResultController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ResultController {
    public static final String REST_URL = "/api/v1/results";

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }
    @GetMapping(value = "/{id}")
    public Result get(@PathVariable("id") Long id) {
        log.info("get " + id);
        return resultService.get(id);
    }
    @GetMapping
    public List<Result> getAll() {
            log.info("getAll");
        return resultService.getAll();
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result save(@RequestBody Result result) {
        log.info("save " + result);
        return resultService.save(result);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete  " + id);
        resultService.delete(id);
    }

}
