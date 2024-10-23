import java.util.List;
import java.util.ArrayList;

public class EndStation extends Station {
    
    public EndStation (String color, String name) {
        super(color,name);
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
        return "ENDSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + nextName;
    }

    public void makeEnd() {
        if (prev == null) {
            prev = next; 
        }
        if(next == null) {
            next = prev;
        }
    }

}
    
