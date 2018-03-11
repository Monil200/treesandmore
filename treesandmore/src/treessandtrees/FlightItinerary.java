package treessandtrees;
import java.util.*;
class Airport {
    String name;
    PriorityQueue<String> pq = new PriorityQueue<String>();
    int departuresFromMe;
    Airport(String n) {
        name = n;
        departuresFromMe = 0;
    }
}
public class FlightItinerary {
    
    HashMap<String, Airport> airportMap;
    FlightItinerary() {
        airportMap = new HashMap<String, Airport>();
    }
    public void addFlight(String source, String destination) {
        Airport sourceAirport = null;
        if (!airportMap.containsKey(source)) {
            airportMap.put(source, new Airport(source));
        }
        sourceAirport = airportMap.get(source);
        sourceAirport.pq.add(destination); // unidirectional edge// adjacency list
        sourceAirport.departuresFromMe++;
        airportMap.put(source, sourceAirport);
    }
    
    public void getItineraryLexicalOrder(String source) {
        if ((source == null || source.length() == 0) && !airportMap.containsKey(source)) {
            return;
        }
        if (airportMap.containsKey(source) && airportMap.get(source).departuresFromMe > 0 ) {
            System.out.println(airportMap.get(source).name + ", ");
            airportMap.get(source).departuresFromMe--;
            while(airportMap.get(source).pq.size() > 0) {
                getItineraryLexicalOrder(airportMap.get(source).pq.poll());
            }
        }
        
        
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FlightItinerary obj = new FlightItinerary();
        String it[][] = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        
        for(int i=0;i<it.length;i++) {
            obj.addFlight(it[i][0], it[i][1]);
        }
        
        Set<Map.Entry<String, Airport>> set = obj.airportMap.entrySet();
        for(Map.Entry<String, Airport> i : set) {
            System.out.print(i.getKey() + " - ");
            Iterator<String> itr = i.getValue().pq.iterator();
            while(itr.hasNext()) {
                System.out.print(itr.next() + ", ");
            }
            System.out.println();
        }
        System.out.println("Printing iterenary");
        obj.getItineraryLexicalOrder("JFK");
        
    }

}
