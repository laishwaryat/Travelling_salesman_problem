
import java.util.ArrayList;
import java.util.Collections;

public class Path{

    private ArrayList<City> tour = new ArrayList<City>();
    private float distance = 0;
 
    public Path(){
        for (int i = 0; i < CityMap.path_len(); i++) {
            tour.add(null);
        }
    }

    @SuppressWarnings("unchecked")
	public Path(ArrayList<City> tour){
        this.tour = (ArrayList<City>) tour.clone();
    }
    public ArrayList<City> getTour(){
        return tour;
    }
    public void generateTour() {
       
        for (int i= 0; i < CityMap.path_len(); i++) {
          setCity(i, CityMap.getCity(i));
        }
        Collections.shuffle(tour);
    }

    public City getCity(int i) {
        return tour.get(i);
    }

    public void setCity(int i, City c) {
        tour.set(i, c);
        distance = 0;
    }
    public float tourDistance(){
        if (distance == 0) {
            float d = 0;
            for (int i=0; i < tourSize(); i++) {
                
                City from = getCity(i);
                
                City to;
                
                if(i+1 < tourSize()){
                    to = getCity(i+1);
                }
                else{
                	to = getCity(0);
                }
               
                d += from.distanceTo(to);
            }
            distance = d;
        }
        return distance;
    }

    // Get number of cities on our tour
    public int tourSize() {
        return tour.size();
    }
    
    @Override
    public String toString() {
        String tour = "";
        for (int i = 0; i < tourSize()-1; i++) {
            tour += getCity(i)+" ";
        }
	tour += getCity(tourSize()-1);
        return tour;
    }
}






