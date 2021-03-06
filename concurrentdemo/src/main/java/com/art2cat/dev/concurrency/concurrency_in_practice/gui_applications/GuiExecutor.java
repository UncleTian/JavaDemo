package com.art2cat.dev.concurrency.concurrency_in_practice.gui_applications;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * GuiExecutor
 * <p/>
 * Executor built atop SwingUtilities
 *
 * @author Brian Goetz and Tim Peierls
 */
public class GuiExecutor extends AbstractExecutorService {
    
    // Singletons have a private constructor and a public factory
    private static final GuiExecutor instance = new GuiExecutor();
    
    private GuiExecutor() {
    }
    
    public static GuiExecutor instance() {
        return instance;
    }
    
    @Override
    public void execute(Runnable r) {
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        } else {
            SwingUtilities.invokeLater(r);
        }
    }
    
    @Override
    public void shutdown() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean isShutdown() {
        return false;
    }
    
    @Override
    public boolean isTerminated() {
        return false;
    }
}
