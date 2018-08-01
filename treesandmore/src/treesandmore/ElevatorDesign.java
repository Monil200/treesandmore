package treesandmore;
import java.util.*;


class Elevator {
    int direction; // 1=up, 0 = not moving, -1 = down
    int floorsMoved;
    boolean isMoving;
    ArrayList<Integer> destinations = new ArrayList<Integer>();
    int current;
    Elevator(int initial) {
        current = initial; 
    }
}
class Request {
    int destination;
    int direction;
    boolean isCompleted;
    Request(int dest, int direc) {
        destination = dest;
        direction = direc;
        isCompleted = false;
    }
    
}
public class ElevatorDesign {
    Elevator e[];
    ArrayList<Request> r[];
    ArrayList<Request> up, down;
    ElevatorDesign(int elevatorCount, int storeys) {
        e = new Elevator[elevatorCount];
        r = new ArrayList[storeys]; // number of floors in bldg
        for(int i=0;i<storeys;i++) {
            r[i] = new ArrayList<Request>();
        }
    }
    
    public void setElevatorStartStates(int starts[]) {
        if (starts.length != e.length) {
            return;
        }
        for(int i=0;i<starts.length;i++) {
            e[i] = new Elevator(starts[i]);
        }
    }
    
    public void recieveRequests(int up[], int down[]) {
        for(int i=0;i<up.length;i++) {
            if ((up[i] > r.length && up[i] < 0) || (up[i] == -1)) {
                continue;
            }
            r[i].add(new Request(up[i], 1));
        }
        for(int i=0;i<down.length;i++) {
            if ((down[i] > r.length && down[i] < 0) || (down[i] == -1)) {
                continue;
            }
            r[i].add(new Request(down[i], -1));
        }
    }
    
    public void showAllRequests() {
        for(int i=0;i<r.length;i++) {
            Iterator<Request> it = r[i].iterator();
            System.out.println("Printing requests from floor:" + i);
            while(it.hasNext()) {
                Request temp = it.next();
                System.out.println("\t dest:" + temp.destination + " direction:" + temp.direction + " isComplete:" + temp.isCompleted);
            }
        }
    }
    
    public void showAllElevators() {
        for(int i=0;i<e.length;i++) {
            Iterator<Integer> it = e[i].destinations.iterator();
            System.out.println("Printing destinations for elevator:" + i + " current stop state:" + e[i].current);
            while(it.hasNext()) {
                System.out.println("\t dest:" + it.next());
            }
        }
    }
    
    public void serveRequests() {
        // phase 1 - check if there is request form a particular floor and elevator is already there
        for(int i=0;i<r.length;i++) {
            ArrayList<Request> thisFloorRequests = r[i];
            Iterator<Request> it = thisFloorRequests.iterator();
            while(it.hasNext()) {
                Request thisR = it.next();
                for(int j=0;j<e.length;j++) {
                    if (e[j].current == i && e[j].isMoving == false && !thisR.isCompleted) {
                        thisR.isCompleted = true;
                        e[j].destinations.add(thisR.destination);
//                        e[j].isMoving = true; // check if other request in same direction can be served;
                        checkSimilarRequests(e[j], i, thisR.direction);
                        Iterator<Integer> dests = e[j].destinations.iterator();
                        int currNew = (thisR.direction == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                        while(dests.hasNext()) {
                            if (thisR.direction == 1) {
                                currNew = Math.max(e[i].current, dests.next());
                            } else {
                                currNew = Math.min(e[i].current, dests.next());
                            }
                        }
                        e[i].current = currNew;
                        j--; // this elevator can serve new requests after its final state in determined
                    }
                }
            }
        }
    }
    
    public void checkSimilarRequests(Elevator e, int start, int direction) {
        if (direction == 1) {
            for(int i = start+1;i<r.length;i++) {
                ArrayList<Request> thisFloorRequests = r[i];
                Iterator<Request> it = thisFloorRequests.iterator();
                while(it.hasNext()) {
                    Request thisR = it.next();
                    if (!thisR.isCompleted && thisR.direction == direction) {
                        thisR.isCompleted = true;
                        e.destinations.add(thisR.destination);
                    }
                }
            }
        } else {
            for(int i = start-1;i>=0;i--) {
                ArrayList<Request> thisFloorRequests = r[i];
                Iterator<Request> it = thisFloorRequests.iterator();
                while(it.hasNext()) {
                    Request thisR = it.next();
                    if (!thisR.isCompleted && thisR.direction == direction) {
                        thisR.isCompleted = true;
                        e.destinations.add(thisR.destination);
                    }
                }
            }
        }
    }
    
    public void serverequestsPhase2() {
        for(int i=0;i<r.length;i++) {
            ArrayList<Request> thisFloorRequests = r[i];
            Iterator<Request> it = thisFloorRequests.iterator();
            while(it.hasNext()) {
                Request thisR = it.next();
                if (!thisR.isCompleted) { // serving request which doesnt have any elevator in its current floor
                    int minDistance = Integer.MAX_VALUE;
                    Elevator thisE = null;
                    for(int j=0;j<e.length;j++) {
                        if (Math.abs(thisR.destination - e[j].current) < minDistance) {
                            minDistance = Math.abs(thisR.destination - e[j].current);
                            thisE = e[j];
                        }
                    }
                    thisE.destinations.add(thisR.destination);
                    thisR.isCompleted = true;
                    checkSimilarRequests(thisE, i,thisR.direction);
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ElevatorDesign obj = new ElevatorDesign(4,10); // 4 elevators, 10 storey bldg
        int starts[] = {0,8,1,6};
        obj.setElevatorStartStates(starts);
        int up[] =   {5,-1,-1,-1,9,-1,-1,9,-1,-1};
        int down[] = {-1,0,-1,-1,0,-1,-1,2,-1,-1};
        obj.recieveRequests(up, down);
        
        obj.serveRequests();
        obj.serverequestsPhase2();
        obj.showAllRequests();
        obj.showAllElevators();
    }

}
