package com.karkia.spring5.practice.data;

import com.karkia.spring5.practice.MyLogger;
import com.karkia.spring5.practice.beans.Data;
import com.karkia.spring5.practice.beans.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class DataServiceImpl implements DataService, MyLogger {

  public DataServiceImpl() {
    myLogger.trace("creating DataServiceImpl bean");
  }

  public List<Data> retrieveData(User user) {
    return Arrays.asList(new Data(10), new Data(20));
  }
}
