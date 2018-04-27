package com.art2cat.dev.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import org.junit.Test;

/**
 * com.art2cat.dev.nio
 *
 * @author art2c
 * @date 4/12/2018
 */
public class SelectorTest {
    
    
    @Test
    public void testSelector() throws IOException {
    
        SocketChannel socketChannel = SocketChannel.open();
        Selector selector = Selector.open();
    
        socketChannel.configureBlocking(false);
        
//        SelectionKey key = socketChannel.register(selector, SelectionKey.OP_READ);
        
        while (true) {
            
            int readyChannels = selector.select();
    
            if (readyChannels == 0) {
                continue;
            }
            
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
            
            while (keyIterator.hasNext()) {
                
                SelectionKey key = keyIterator.next();
                
                if (key.isAcceptable()) {
                    // a connection was accepted by a ServerSocketChannel.
                    
                } else if (key.isConnectable()) {
                    // a connection was established with a remote server.
                    
                } else if (key.isReadable()) {
                    // a channel is ready for reading
                    
                } else if (key.isWritable()) {
                    // a channel is ready for writing
                }
                
                keyIterator.remove();
            }
        }
    }
}
