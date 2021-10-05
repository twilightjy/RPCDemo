package cn.service;

import pojo.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/*
所需的业务接口定义
 */
public interface MyPersonService extends Remote {

    List<Person> findAll() throws RemoteException;

}
