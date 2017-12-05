package com.myboot.common.hashBalance;

import java.util.Comparator;

/**
 * Created by a on 2017/12/4.
 */
public class ServerComparator implements Comparator<ServerNode> {


    @Override
    public int compare(ServerNode node1, ServerNode node2) {
        if(node1.getServerHash() <= node2.getServerHash()) {
            return -1;
        }else {
            return 1;
        }
    }
}
