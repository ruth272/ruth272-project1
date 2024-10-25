import java.util.List;
import java.util.ArrayList;

public class Station {    
    protected String color;
    protected String name;   
    protected boolean flag;
    protected Station prev;
    protected Station next;

    public Station(String color, String name) {
        this.color = color;
        this.name = name;
        this.flag = true;
        this.prev = null;
        this.next = null;        
    }
    

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isAvailable() {
        return flag;
    }

    public boolean switchAvailable() {
        return this.flag = !this.flag;
    }

    public Station getNext() {
        return next;
    }

    public Station getPrev() {
        return prev;
    }

    public String toString() {
        String prevName;
        String nextName;

        if (getPrev() == null) {
            prevName = "none";
        } else {
            prevName = getPrev().getName();
        }
        if (getNext() == null ) {
            nextName = "none";
        } else {
            nextName = getNext().getName();
        }
        return "STATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
        ", previous station: " + prevName + ", next station: " + nextName;    
    }

    public void addNext(Station nextStation) {
        if(nextStation == null){
            nextStation = null;
        }
        else {
            this.next = nextStation;
            nextStation.prev = this; 
        }
    }

    public void addPrev(Station prevStation) {
        if(prevStation == null){
            prevStation = null;
        }
        else {
            this.prev = prevStation;
            prevStation.next = this;        
        }
    }

    public void connect(Station nextStation) {
        this.addNext(nextStation);
        nextStation.addPrev(this);
        /*if (nextStation != null) {
            this.next = nextStation;
            nextStation.prev = this;
        }*/
    }

    public int tripLength(Station destination) {
        int stops = 0;
        Station current = this;

        if (current.equals(destination)) {
            return stops;
        }

        ArrayList <Station> visited = new ArrayList<>();
        return tripLengthRecurse(destination, stops, current, visited);
    }

    public int tripLengthRecurse(Station destination, int stops, Station current, ArrayList <Station> visited) {
        if (current == null) {
            return -1;
        }
        
        if (current.equals(destination)) {
            return stops;
        }
    
        if (visited.contains(current)) {
            return -1;
        }

        visited.add(current);

        if (current.getNext() != null) {
            int trip = tripLengthRecurse(destination, stops + 1, current.getNext(), visited);
            if (trip != -1) {
                return trip;
            }
        }

        if(current instanceof TransferStation){
            String desColor = destination.getColor();
            TransferStation transfer = (TransferStation) current;
            for(int i=0; i < transfer.otherStations.size(); i++){
                Station now = transfer.otherStations.get(i);
                if(now.getColor() == desColor){
                    int trip = tripLengthRecurse(destination, stops + 1, now, visited);
                    if(trip != -1) {
                        return trip;
                    }
                }
            }
        }
        
        return -1;
    }

    public boolean equals(Station obj) {
        if (this.color != obj.color || this.name != obj.name) {
            return false;
        } 
        return true;
    }
}
