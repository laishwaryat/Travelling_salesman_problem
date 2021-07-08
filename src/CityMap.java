

import java.util.ArrayList;

public class  CityMap{
	static float[][] dist;
    private static ArrayList<City> cityList = new ArrayList<City>();
  
    public static void addCity(City city) {
        cityList.add(city);
    }   
    public static City getCity(int index){
        return cityList.get(index);
    }
    public static float distance(City c1, City c2){
    	return dist[c1.index][c2.index];
    }
    public static int path_len(){
        return cityList.size();
    }
    
}
