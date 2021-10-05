package cn.hust;

import cn.hust.service.impl.MyPersonServiceImpl;
import cn.service.MyPersonService;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ProviderRun {
    public static void main(String[] args) {
        try {
            //rmi注册表
            MyPersonService myPersonService = new MyPersonServiceImpl();
            LocateRegistry.createRegistry(8989);
            String url = "rmi://localhost:8989/myPersonService";
            //根据指定url找到myPersonService
            Naming.bind(url,myPersonService);
            //System.out.println("rmi launch successfully !");
            //创建zk
            ZooKeeper zooKeeper = new ZooKeeper("47.98.134.66:2181", 100000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("zk connected !");
                }
            });
            //发布信息。把实际实现的调用路径存放到zk
            zooKeeper.create("/rpc/provider",url.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            //System.out.println("registered successfully !");

        } catch (AlreadyBoundException | InterruptedException | KeeperException | IOException e) {
            e.printStackTrace();
        }
    }
}
