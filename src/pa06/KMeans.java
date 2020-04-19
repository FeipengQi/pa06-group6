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
				originalData.add(new Sample((double) input.nextInt(), (double) input.nextInt()));
			}


			//generate random cluster points
			Random rand = new Random();
			Sample[] clusterPoints = new Sample[numClusters];
			for (int i = 0; i < numClusters; i++) {
				//do sth. for repeated sample points
				clusterPoints[i] = originalData.remove(rand.nextInt(originalData.size()));
			}


			//add deleted data back to the original data
			for (int i = 0; i < numClusters; i++) {
				originalData.add(clusterPoints[i]);
			}

			//divide into clusters
			//build array list for each cluster point
			ArrayList[] clusters = new ArrayList[numClusters];
			for (int i = 0; i < numClusters; i++) {
				clusters[i] = new ArrayList<Sample>();
			}

			//repeat 100 times
			for (int i = 0; i < 500; i++) {
				//input samples into each cluster
				for (Sample data : originalData) {
					double minDistance = data.getDistance(clusterPoints[0]);
					int index = 0;
					//find the closest points
					for (int k = 1; k < numClusters; k++) {
						if (data.getDistance(clusterPoints[k]) < minDistance) {
							minDistance = data.getDistance(clusterPoints[k]);
							index = k;
						}
					}
					clusters[index].add(data);
				}
				//replace each old cluster point with new avg point
				for (int h = 0; h < clusterPoints.length; h++) {
					Cluster cluster = new Cluster(clusterPoints[h], clusters[h]);
					clusterPoints[h] = cluster.getNewCluster();
				}
			}

			//print our final cluster points
			for (int i = 0; i < clusterPoints.length; i++) {
				System.out.println("Final Cluster Point " + (i + 1) + ": " + clusterPoints[i].toString());
			}
		}
	}
