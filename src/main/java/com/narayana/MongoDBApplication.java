package com.narayana;

import com.narayana.model.Domain;
import com.narayana.model.Result;
import com.narayana.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class MongoDBApplication implements CommandLineRunner {
    @Autowired
    private DomainService domainService;

    public static void main(String[] args) {
        SpringApplication.run(MongoDBApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Domain> docsList = new ArrayList<>();
        Domain doc = null;
        for (int i = 1; i <= 30; i++) {
            if(i <=10) {
                doc = new Domain(i + "", "www.narayana.com", "godaddy");
            }
            if(i > 10 && i <= 20) {
                doc = new Domain(i + "", "www.basetty.com", "symantec");
            }
            if(i > 20) {
                doc = new Domain(i + "", "www.basetty-"+i+".com", "DigitalOcean");
            }
            docsList.add(doc);
        }
        Boolean status = domainService.saveOrUpdate(docsList);
        if(status)
            System.out.println(" Bulk save - success");
        else
            System.out.println(" Bulk save - failed");
    }
    @GetMapping(value = "/narayana")
    public List<Domain> findAggByNarayanaDomain() {
        return domainService.findAggByNarayanaDomain();
    }

    @GetMapping(value = "/findByDomain/{domain}")
    public List<Domain> findAggByDomain(@PathVariable String domain) {
        return domainService.findAggByDomain(domain);
    }

    @GetMapping(value = "aggregateResultByDomain")
    public List<Result> findAllAggByDomain() {
        return domainService.findAllAggByDomain();
    }


}