package pa06;

import java.util.ArrayList;

/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of Samples (the one's closest to that sample point, ideally).
 * @author presenting
 *
 */
public class Cluster {
    private Sample clusterPoint;
    private ArrayList<Sample> samples;
    private double avgX;
    private double avgY;
    private Sample newPoint;

    public Cluster(Sample clusterPoint, ArrayList<Sample> samples){
        this.clusterPoint = clusterPoint;
        this.samples = samples;
    }

    //public void setNewCluster(){


    public Sample getNewCluster(){
        for (int i = 0; i < samples.size(); i++){
            this.avgX += samples.get(i).getX();
            this.avgY += samples.get(i).getY();
            //this.avgX /= this.samples.size();
            //this.avgY /= this.samples.size();
        }
        this.newPoint = new Sample(this.avgX / this.samples.size(), this.avgY / this.samples.size());
        return this.newPoint;
    }

    public String toString(){
        String result = "Cluster point: " + this.clusterPoint.toString() + " samples: ";
        for (Sample sample : samples) {
            result += sample.toString();
        }
        return result;
    }
}

