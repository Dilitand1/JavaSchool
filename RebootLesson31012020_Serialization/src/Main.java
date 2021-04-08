import loader.Loader;
import loader.LoaderImpl;
import serializator.SerializatorImpl;
import service.Service;
import service.ServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        CacheProxy cacheProxy = new CacheProxy("cashFile");
        Service service = cacheProxy.cache(new ServiceImpl());
        Loader loader = cacheProxy.cache(new LoaderImpl());

        List<String> list = service.doHardWork("work15",15);
        //System.out.println(list);
        list = service.doHardWork("work10",10);
        list = service.doHardWork("work11",11);
        //System.out.println(list);

        CashClass cashClass = (CashClass) loader.load("cashFile");
        System.out.println(cashClass.getCashMap());
    }

    //Запустим один раз чтобы создать кэш
    void createCash(){
        Map<String,Integer> map= new HashMap<>();
        map.put("work1",1);
        map.put("work2",4);
        map.put("work3",9);
        map.put("work4",16);
        map.put("work5",25);
        CashClass cashClass = new CashClass();
        cashClass.setCashMap(map);

        SerializatorImpl serializator = new SerializatorImpl();
        try {
            serializator.serialize(cashClass,"cashFile");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
