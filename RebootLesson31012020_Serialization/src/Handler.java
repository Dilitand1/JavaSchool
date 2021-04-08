import annotation.Cache;
import annotation.CacheType;
import service.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import loader.*;

class Handler implements InvocationHandler {
    private Object originalObject;
    private String pathToFile = "cashFile";
    Map<String, Integer> cashMap;

    Handler(Object o) {
        this.originalObject = o;
    }

    Handler(Object o, String pathToFile) {
        this.originalObject = o;
        this.pathToFile = pathToFile;
        //грузим кэш при создании объекта
        //loadCache();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        if (originalObject instanceof Loader) {
            return invokeLoader(method, args);
        }
        if (method.getName().equals("doHardWork")) {
            System.out.println("invoke");
            System.out.println(cashMap);
            //проверяем аннотацию
            if (method.isAnnotationPresent(Cache.class)) {
                List<String> tmpList = new ArrayList<>();
                Cache cache = method.getDeclaredAnnotation(Cache.class);
                if (cache.cacheType() == CacheType.FILE) {
                    loadCache();
                }
                else {
                    if (cashMap == null) cashMap = new HashMap<String,Integer>();
                }
                //проверяем кэш
                if (cashMap.containsKey(args[0].toString())) {
                    System.out.println("нашли в кэше:");
                    tmpList.add(args[0].toString());
                    tmpList.add(cashMap.get(args[0].toString()).toString());
                    return tmpList;
                }
                //если не нашли то инвокаем и пишем в кэш
                else {
                    System.out.println("не нашли в кэше:");
                    tmpList = (List) method.invoke(originalObject, args);
                    cashMap.put(tmpList.get(0), Integer.parseInt(tmpList.get(1)));
                    //Если кэш то в файл
                    if (cache.cacheType() == CacheType.FILE) saveCashe();
                    return tmpList;
                }
            }
        }
        return null;
    }

    public void saveCashe() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(pathToFile);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            CashClass cashClass = new CashClass();
            cashClass.setCashMap(cashMap);
            objectOutputStream.writeObject(cashClass);
        } catch (IOException e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
        }
    }

    //Метод прогрузки кэша
    public void loadCache() {
        if (cashMap == null) {
            if (pathToFile == null) {
                //Если путь к файлу пустой то кэшируем походу
                cashMap = new HashMap<String, Integer>();

            } else {
                //Иначе пытаемся выгрузить кэш
                try {
                    //System.out.println("пытаемся выгрузить кэш");
                    Loader loader = new LoaderImpl();
                    CashClass cashClass = (CashClass) loader.load(pathToFile);
                    cashMap = cashClass.getCashMap();
                } catch (Exception e) {
                    //Не получилось выгрузить
                    cashMap = new HashMap<String, Integer>();
                }
            }
        }
    }

    public Object invokeLoader(Method method, Object[] args) {
        try {
            Loader loader = (Loader)originalObject;
            return method.invoke(loader,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}