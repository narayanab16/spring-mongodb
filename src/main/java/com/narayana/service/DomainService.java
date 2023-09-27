package com.narayana.service;

import com.narayana.model.Domain;
import com.narayana.model.Result;
import com.narayana.repo.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DomainService {
    @Autowired
    private DomainRepository domainRepository;

    public List<Result> findAllAggByDomain() {
        return domainRepository.findAllAggByDomain();
    }
    public List<Domain> findAggByNarayanaDomain() {
        return domainRepository.findNarayanaDomain();
    }
    public List<Domain> findAggByDomain(String domainName) {
        return domainRepository.findByDomain(domainName);
    }

    public Boolean saveOrUpdate(List<Domain> domainList) {
        List<Domain> list = domainRepository.saveAll(domainList);
        if(list.size() > 0)
            return true;
        else
            return false;
    }
}
