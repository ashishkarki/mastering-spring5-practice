package com.karkia.spring5.practice.business;

import com.karkia.spring5.practice.MyLogger;
import com.karkia.spring5.practice.beans.Data;
import com.karkia.spring5.practice.beans.User;
import com.karkia.spring5.practice.data.DataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService, MyLogger {
    //  @Autowired // simple field injection
    private DataService dataService;

    public BusinessServiceImpl() {}

    @Autowired // constructor injection
    public BusinessServiceImpl(DataService dataService) {
        super();
        this.dataService = dataService;
        myLogger.trace("Autowiring by type from bean name 'businessServiceImpl' via\n" +
                "constructor to bean named 'dataServiceImpl'");
    }

    public long calculateSum(User user) {
        long sum = 0;
        for (Data data : dataService.retrieveData(user)) {
            sum += data.getValue();
        }
        return sum;
    }

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
}
