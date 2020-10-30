package ru.mtuci.simpleapi.service;

import ru.mtuci.simpleapi.model.Result;

import java.util.List;

public interface ResultService {

    Result get(Long id);

    List<Result> getAll();

    Result save(Result result);

    void delete(Long id);
}
