# Polyline functions for Google Maps
The library contains some useful utils for encoding Polylines for Google Maps, checking point into the circle, etc.

The code is working according to the real Globe form - Geoid (https://en.wikipedia.org/wiki/Geoid) not a sphere!

For sample usage, see PolylineTest.java:

```java
    public void testApp()
    {
        
        final int numberOfPoints = 8; // Octagon

        // CENTER = Riga, Peldu iela
        final int radiusInMeters = 50;
        final double latitude = 56.946345;
        final double longitude = 24.108515;

        final List < LatLng > latLngs = PolyUtil.prepareCircleFromRadius(new LatLng(latitude, longitude), radiusInMeters, numberOfPoints);

        final String encode = PolyUtil.encode(latLngs);
        System.out.println("Encoded Polyline for Google Map = "+encode);

        String staticMapImageUrl = "https://maps.googleapis.com/maps/api/staticmap?size=400x400&center=%s,%s&zoom=16&path=fillcolor:0x00000033|color:0xFF0000|enc:%s";

        System.out.println("URL of static image = "+String.format(staticMapImageUrl, latitude, longitude, encode));

        // Contains location test:
	// "Is LatLng(56.946412, 24.108729) inside the circle?"
        assertTrue(PolyUtil.containsLocation(new LatLng(56.946412, 24.108729), latLngs, true)); // Should be TRUE
        
	// "Is LatLng(56.94693, 24.108316) inside the circle?"
	assertFalse(PolyUtil.containsLocation(new LatLng(56.94693, 24.108316), latLngs, true)); // Should be FALSE
		
    }
```

**Commands**:

Build JAR: `mvn clean package`

**Hot to use your new library**:

Newly created library may be used directly, placed into maven repository, if needed, or used from GitHub like this:


1) Add **jitpack.io** repository to your POM file:
```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
```

2) Add dependency to POM:

```xml
        <dependency>
            <groupId>com.github.divlv</groupId> <!-- Your GitHub login (divlv) -->
            <artifactId>gmappolyline</artifactId> <!-- Your GitHub repo name (of library) -->
            <version>1.0</version> <!-- GitHub lib release version -->
        </dependency>
```

3) Enjoy!
