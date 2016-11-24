package lv.div.jarproject;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import gmap.polyline.LatLng;
import gmap.polyline.PolyUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for sample application.
 */
public class PolylineTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PolylineTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PolylineTest.class );
    }

    /**
     * Rigourous Test :-)
     */
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
	


	
}
