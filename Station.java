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

    public void switchAvailable() {
        this.flag = !this.flag;
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
        if (getNext() == null || getNext() == this) {
            nextName = "none";
        } else {
            nextName = getNext().getName();
        }
        return "STATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
        ", previous station: " + prevName + ", next station: " + nextName;    
    }

    public void addNext(Station nextStation) {
        if(nextStation == null){
            this.next = null;
        }
        else {
            this.next = nextStation;
            nextStation.prev = this; 
        }
    }

    public void addPrev(Station prevStation) {
        if(prevStation == null){
            this.prev = null;
        }
        else {
            this.prev = prevStation;
            prevStation.next = this;        
        }
    }

    public void connect(Station nextStation) {
        this.addNext(nextStation);
    }

    public int tripLength(Station destination) {
        int stops = 0;
        Station current = this;
    
        while (current != null && !current.equals(destination)) {
            current = current.getNext();
            stops++;
        }
    
        if (current == null) {
            return -1;  
        }
    
        return stops;
    }

    public boolean equals(Station obj) {
        if (this.color != obj.color || this.name != obj.name) {
            return false;
        } 

        return true;
    }
}
