package gmap.polyline;

import java.util.ArrayList;

/**
 * Created by dima on 19-Apr-16.
 */
public class Track {

    private ArrayList<Trackpoint> trackpoints = new ArrayList<Trackpoint>();

    public ArrayList<Trackpoint> getTrackpoints() {
        return this.trackpoints;
    }

    public void setTrackpoints(ArrayList<Trackpoint> trackpoints) {
        this.trackpoints = trackpoints;
    }

    public void addTrackpoint(Trackpoint trkpt) {
        this.trackpoints.add(trkpt);
    }
}
