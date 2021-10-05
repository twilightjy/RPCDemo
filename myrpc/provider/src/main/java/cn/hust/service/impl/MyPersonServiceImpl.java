package cn.hust.service.impl;

import cn.service.MyPersonService;
import pojo.Person;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
/*
业务接口的具体实现，放在provider，意为rpc的实际提供者
 */
public class MyPersonServiceImpl extends UnicastRemoteObject implements MyPersonService {

    public MyPersonServiceImpl() throws RemoteException{
    }

    @Override
    public List<Person> findAll() throws RemoteException {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1,"a"));
        list.add(new Person(2,"b"));
        list.add(new Person(3,"c"));
        return list;
    }
}
