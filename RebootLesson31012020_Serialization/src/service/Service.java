package service;

import java.util.Date;
import java.util.List;
import annotation.*;

public interface Service {
    @Cache(cacheType = CacheType.IN_MEMORY)
    List<String> doHardWork(String s, Integer i);
}
