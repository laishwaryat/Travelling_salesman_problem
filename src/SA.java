import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SA {
	public static void simulateSA(double initTemp, double coolingRate) throws FileNotFoundException{
			// double initTemp = 50000;
	        //double coolingRate = 0.0000002;
	        Path tour = new Path();
	        tour.generateTour();
	        Path best = new Path(tour.getTour());    
	        while (initTemp > 1) {
	            Path tour1 = new Path(tour.getTour());

	            int i1 = (int) (tour1.tourSize() * Math.random());
	            int i2 = (int) (tour1.tourSize() * Math.random());
	            City c1 = tour1.getCity(i1);
	            City c2 = tour1.getCity(i2);

	            tour1.setCity(i2, c1);
	            tour1.setCity(i1, c2);
	         
	            float ce = -tour.tourDistance();
	            float ce1 = -tour1.tourDistance();
   
	            if (probability((int)ce,(int) ce1, initTemp) > Math.random()) {
	            	tour = new Path(tour1.getTour());
	            }       if (tour.tourDistance() < best.tourDistance()) {
	                best = new Path(tour.getTour());
	            }
	            initTemp =initTemp*(1-coolingRate);
	        }

	        //System.out.println("TSP distance: " + best.tourDistance());
	        PrintStream o = new PrintStream(new File("output")); 
	        
	        // Assign o to output stream 
	        System.setOut(o);
	        System.out.println(best);
	}
	
	public static double probability( int a,int b, double t) {
        
        return 1/(1+ Math.exp((a - b) / t));
    }

}
