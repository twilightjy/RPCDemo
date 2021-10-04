package cn.service;

import pojo.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MyPersonService extends Remote {

    List<Person> findAll() throws RemoteException;

}
