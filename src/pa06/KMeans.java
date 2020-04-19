package pa06;

	import java.util.*;
	import java.util.ArrayList;
	import java.io.*;

	public class KMeans {
	    public static void main(String[] args) throws FileNotFoundException {
	        //read file and decide number of clusters
	        Scanner console = new Scanner(System.in);
	        System.out.println("What is your file name?");
	        Scanner input = new Scanner(new File(console.next()));
	        System.out.println("How many clusters do you want?");
	        int numClusters = console.nextInt();

	        //import original data
	        ArrayList<Sample> originalData = new ArrayList<>();
	        while (input.hasNext()) {
	            originalData.add(new Sample((double)input.nextInt(), (double)input.nextInt()));
	        }


	        //generate random cluster points
	        Random rand = new Random();
	        Sample[] clusterPoints = new Sample[numClusters];
	        for (int i = 0; i < numClusters; i++) {
	            //do sth. for repeated sample points
	            clusterPoints[i] = originalData.remove(rand.nextInt(originalData.size()));
	        }


	        //add deleted data back to the original data
	        for(int i = 0; i < numClusters; i++){
	            originalData.add(clusterPoints[i]);
	        }
	    }
}
