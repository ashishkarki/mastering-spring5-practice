package com.karkia.spring5.practice.data;

import com.karkia.spring5.practice.beans.Data;
import com.karkia.spring5.practice.beans.User;

import java.util.List;

public interface DataService {
  List<Data> retrieveData(User user);
}
