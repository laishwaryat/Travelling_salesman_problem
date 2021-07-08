
import java.util.*;

import java.io.*;

public class Main {

    // Calculate the acceptance probability
    

    public static void main(String[] args) {
    	long startTime = System.nanoTime();
        // Create and add our cities
    	
Scanner s=new Scanner(System.in);
    	City city;
    	
    	File file = new File(s.nextLine());
    	s.close();
        try {

            Scanner sc = new Scanner(file);
            String type=sc.nextLine();
            int num=sc.nextInt();
        	float[][] dist=new float[num][num];
        	for(int i=0;i<num;i++) {
        		float a=sc.nextFloat();
        		float b=sc.nextFloat();
        		  city = new City(a,b,i);
        	     CityMap.addCity(city);
        		
        	}
        	for(int i=0;i<num;i++) {
        		for(int j=0;j<num;j++) {
            		dist[i][j]=sc.nextFloat();
            	
            	}
            		
        	}
        	CityMap.dist=dist;
        	 if(num>=200)
        	SA.simulateSA(50000,0.0000002);
        	 else
        		 SA.simulateSA(50000,0.0000001);
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        

    	
    	
        }
    	long endTime=System.nanoTime();
    	//System.out.println(endTime-startTime);
        }
}