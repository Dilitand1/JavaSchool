package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceImpl implements Service{

    @Override
    public List<String> doHardWork(String s, Integer i) {
        List<String> list = new ArrayList<>(1);
        list.add(s);
        list.add(String.valueOf(i*i));
        return list;
    }
}
