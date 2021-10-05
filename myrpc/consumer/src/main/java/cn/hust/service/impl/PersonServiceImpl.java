package cn.hust.service.impl;

import cn.hust.service.PersonService;
import cn.service.MyPersonService;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import pojo.Person;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;
/*
通过zk获取provider的路径，利用rmi进行远程调用，实现rpc
 */
public class PersonServiceImpl implements PersonService {
    @Override
    public List<Person> show() {
        try {
            //创建zk
            ZooKeeper zooKeeper = new ZooKeeper("47.98.134.66:2181", 100000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("zk connected !");
                }
            });
            //从zk获取provider的信息
            byte[] data = zooKeeper.getData("/rpc/provider", false, null);
            MyPersonService myPersonService = (MyPersonService)Naming.lookup(new String(data));
            //进行远程调用获取provider的相应具体实现,consumer本地不具体实现，只有接口定义
            return myPersonService.findAll();
        } catch (IOException | InterruptedException | KeeperException | NotBoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
