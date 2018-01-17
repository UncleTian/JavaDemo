package com.art2cat.dev.concurrency.concurrency_in_practice.avoiding_liveness_hazards;

/**
 * LeftRightDeadlock
 *
 * Simple lock-ordering deadlock
 *
 * @author Brian Goetz and Tim Peierls
 */
public class LeftRightDeadlock {
    
    private final Object left = new Object();
    private final Object right = new Object();
    
    public void leftRight() {
        synchronized (left) {
            synchronized (right) {
                doSomething();
            }
        }
    }
    
    public void rightLeft() {
        synchronized (right) {
            synchronized (left) {
                doSomethingElse();
            }
        }
    }
    
    void doSomething() {
        System.out.println("do some thing");
    }
    
    void doSomethingElse() {
    }
}
