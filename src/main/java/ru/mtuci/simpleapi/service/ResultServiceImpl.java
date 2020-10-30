package ru.mtuci.simpleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.simpleapi.dao.ResultRepository;
import ru.mtuci.simpleapi.model.Result;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    private final ResultRepository resultRepository;

    @Autowired
    public ResultServiceImpl(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    @Override
    public Result get(Long id) {
        return resultRepository.findById(id).orElse(null);
    }

    @Override
    public List<Result> getAll() {
        return resultRepository.findAll();
    }

    @Override
    public Result save(Result product) {
        return resultRepository.save(product);
    }

    @Override
    public void delete(Long id) {
    resultRepository.delete(id);
    }
}
