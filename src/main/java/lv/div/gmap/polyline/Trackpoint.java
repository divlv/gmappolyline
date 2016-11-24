package gmap.polyline;

public class Trackpoint {

    private double latDouble;
    private double lonDouble;
    private double altitude;

    public Trackpoint(double lat, double lon) {
        this.latDouble = lat;
        this.lonDouble = lon;
    }

    public Trackpoint(double lat, double lon, double altitude) {
        this.latDouble = lat;
        this.lonDouble = lon;
        this.altitude = altitude;
    }

    public void setLatDouble(double latDouble) {
        this.latDouble = latDouble;
    }

    public void setLonDouble(double lonDouble) {
        this.lonDouble = lonDouble;
    }

    public double getLatDouble() {
        return latDouble;
    }

    public double getLonDouble() {
        return lonDouble;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String toString() {
        return this.latDouble + ";" + this.lonDouble;
    }

}
