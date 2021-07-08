public class City {
    float x;
    int index;
    float y;
    float dist;
    // Constructs a randomly placed city
    public City(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    
    // Constructs a city at chosen x, y location
    public City(float x, float y,int index){
        this.x = x;
        this.y = y;
        this.index=index;
    }
    
    // Gets city's x coordinate
    public float getX(){
        return this.x;
    }
    
    // Gets city's y coordinate
    public float getY(){
        return this.y;
    }
    
    // Gets the distance to given city
    public float distanceTo(City city){
        return CityMap.dist[this.index][city.index];
    }
    
    public void set_dist(float dist) {
    	this.dist=dist;
    }
    @Override
    public String toString(){
        return Integer.toString(this.index);
    }
}