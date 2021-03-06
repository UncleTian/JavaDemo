package com.art2cat.dev.concurrency.concurrency_in_practice.avoiding_liveness_hazards;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;


/**
 * CooperatingDeadlock
 * <p/>
 * Lock-ordering deadlock between cooperating objects
 *
 * @author Brian Goetz and Tim Peierls
 */
public class CooperatingDeadlock {
    
    // Warning: deadlock-prone!
    class Taxi {
        
        private final Dispatcher dispatcher;
        
        private Point location, destination;
        
        public Taxi(Dispatcher dispatcher) {
            this.dispatcher = dispatcher;
        }
        
        public synchronized Point getLocation() {
            return location;
        }
        
        public synchronized void setLocation(Point location) {
            this.location = location;
            if (location.equals(destination)) {
                dispatcher.notifyAvailable(this);
            }
        }
        
        public synchronized Point getDestination() {
            return destination;
        }
        
        public synchronized void setDestination(Point destination) {
            this.destination = destination;
        }
    }
    
    class Dispatcher {
        
        
        private final Set<Taxi> taxis;
        
        private final Set<Taxi> availableTaxis;
        
        public Dispatcher() {
            taxis = new HashSet<Taxi>();
            availableTaxis = new HashSet<Taxi>();
        }
        
        public synchronized void notifyAvailable(Taxi taxi) {
            availableTaxis.add(taxi);
        }
        
        public synchronized Image getImage() {
            Image image = new Image();
            for (Taxi t : taxis) {
                image.drawMarker(t.getLocation());
            }
            return image;
        }
    }
    
    class Image {
        
        public void drawMarker(Point p) {
        }
    }
}
