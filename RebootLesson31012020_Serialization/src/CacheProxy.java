import loader.Loader;
import loader.LoaderImpl;
import service.Service;
import service.ServiceImpl;

import java.lang.reflect.Proxy;
import java.util.List;

public class CacheProxy {
    private String pathToFile;
    private Loader loader = null;

    CacheProxy(){
    }
    CacheProxy(String pathToFile){
        this.pathToFile = pathToFile;
    }
    Service cache(ServiceImpl service){
        return (Service)Proxy.newProxyInstance(ServiceImpl.class.getClassLoader(),new Class[]{Service.class},new Handler(service,pathToFile));
    }
    Loader cache(LoaderImpl loader){
        return (Loader)Proxy.newProxyInstance(LoaderImpl.class.getClassLoader(),new Class[]{Loader.class},new Handler(loader));
    }
}
