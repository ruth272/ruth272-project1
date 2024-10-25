import java.util.List;
import java.util.ArrayList;

public class TransferStation extends Station {
    public ArrayList<Station> otherStations;

    public TransferStation (String color, String name) {
        super(color,name);
        this.otherStations = new ArrayList<>();
    }

    public void addTransferStationNext(Station station) {
        /*this.otherStations.add(station);
        station.addNext(this);*/
        this.otherStations.add(station);
        if (station.getPrev() == null /*|| !station.prev.equals(this*/) {
            station.prev = this;
        }
    }
    
    public void addTransferStationPrev(Station station) {
        /*this.otherStations.add(station);
        station.addPrev(this);*/
        this.otherStations.add(station);
        if (station.getNext() == null /*!station.next.equals(this)*/) {
            station.next = this;
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
            nextName = "none";
        } else {
            nextName = getNext().getName();
        }
        String list = "TRANSFERSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
        ", previous station: " + prevName + ", next station: " + nextName + "\n" +"\t" +"Transfers:" + " " + "\n";
        for(int i=0; i<otherStations.size(); i++){
            list += "\t" + otherStations.get(i).toString() + "\n";
            /*if(i==0) {
                return "TRANSFERSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + nextName + "\n" +"\t" +"Transfers:" + " " + "\n";
            }
            if(i==1) {
                return "\t" + "STATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + nextName + "\n";
            }
            else if(i==2) {
                return "\t" + "ENDSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + nextName + "\n";
            }
            else if(i==3) {
                return "\t" + "TRANSFERSTATION " + getName() + ": " + getColor() + " line, in service: " + isAvailable() + 
               ", previous station: " + prevName + ", next station: " + nextName + "\n";
            }*/
        }
        return list;
    }

}
