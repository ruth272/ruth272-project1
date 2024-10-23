import java.util.List;
import java.util.ArrayList;

public class TransferStation extends Station {
    public List<Station> otherStations;

    public TransferStation (String color, String name) {
        super(color,name);
        this.otherStations = new ArrayList<>();
    }

    public void addTransferStationNext(Station station) {
        otherStations.add(station);
        station.addNext(this); 
    }
    
    public void addTransferStationPrev(Station station) {
        otherStations.add(station);
        station.addPrev(this); 
    }

    public void otherStations(Station station) {
        if (!otherStations.contains(station)) {
            otherStations.add(station);
            station.addNext(this); 
        } 
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
            nextName = "none" + "\n" +"\t" +"Transfers:" + " " + "\n";
        } else {
            nextName = getNext().getName();
        }
        for(int i=0; i<otherStations.size(); i++){
            /*if( i==0) {
                return "TRANSFERSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + nextName + "\n";
            }*/
            if(i==1) {
                return "\t" + "STATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + prevName + "\n";
            }
            else if(i==2) {
                return "\t" + "ENDSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + prevName + "\n";
            }
            else if(i==3) {
                return "\t" + "TRANSFERSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + prevName + "\n";
            }
        }
        return "TRANSFERSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + prevName + "\n";
    }

}
