package com.myboot.common.hashBalance;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.zip.CRC32;

/**
 * Created by a on 2017/12/4.
 */
public class ConsistentHash {
    private List<ServerNode> servers = new ArrayList<ServerNode>();//存放服务器

    public long hash(String str){
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }

    public void addServer(String serverName){
        ServerNode node = new ServerNode();
        node.setServerName(serverName);
        node.setServerHash(hash(serverName));
        servers.add(node);
        Collections.sort(servers, new ServerComparator());
    }

    public void deleteServer(String serverName){
        ServerNode node = new ServerNode();
        node.setServerName(serverName);
        servers.remove(node);
    }

    public ServerNode getServer(String cachekey){
        long keyHash = hash(cachekey);
        for(ServerNode node : servers){
            if(keyHash<=node.getServerHash()){
                return node;
            }
        }
        return servers.get(0);//如果node没有合适放置位置，放在第一台服务器上去
    }

    public void printServers(){
        for(ServerNode server : servers){
            System.out.println(server.getServerName()+"-->"+server.getServerHash());
        }
    }

    public static void main(String[] args) {
        ConsistentHash ch = new ConsistentHash();
        ch.addServer("127.0.0.1:11211");
        ch.addServer("127.0.0.1:11212");
        ch.addServer("127.0.0.2:11211");
        ch.addServer("127.0.0.2:11212");

        ch.printServers();

        ServerNode node = ch.getServer("hello");
        System.out.println("hello -->"+ch.hash("hello")+"-->"+node.getServerName()+"-->"+node.getServerHash());

        ServerNode node2 = ch.getServer("name");
        System.out.println("name -->"+ch.hash("name")+"-->"+node2.getServerName()+"-->"+node2.getServerHash());

        ServerNode node3 = ch.getServer("a");
        System.out.println("a -->"+ch.hash("a")+"-->"+node3.getServerName()+"-->"+node3.getServerHash());

        /********************删除节点*********************/
        ch.deleteServer("127.0.0.1:11212");
        ch.printServers();

        ServerNode node0 = ch.getServer("hello");
        System.out.println("hello -->"+ch.hash("hello")+"-->"+node0.getServerName()+"-->"+node0.getServerHash());

        ServerNode node02 = ch.getServer("name");
        System.out.println("name -->"+ch.hash("name")+"-->"+node02.getServerName()+"-->"+node02.getServerHash());

        ServerNode node03 = ch.getServer("a");
        System.out.println("a -->"+ch.hash("a")+"-->"+node03.getServerName()+"-->"+node03.getServerHash());

    }
}
