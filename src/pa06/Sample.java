package pa06;

/**
 * A Sample represents a vector of doubles to be used in a clustering algorithm...
 * @author presenting
 *
 */

public class Sample {
    double x;
    double y;

    public Sample(/*double[] values*/ double x, double y) {
  /*this.sample = new ArrayList<Double>(;
  for (int i=0; i<values.length; i++) {
   sample.add(values[i]);
  }*/
        this.x = x;
        this.y = y;
    }

    public double getDistance(Sample other){
        return Math.sqrt(Math.pow(other.getX()-this.x, 2) + Math.pow(other.getY()-this.y, 2));
    }

    /*public boolean isEqual(Object other){
     if (other instanceof Sample) {
      other = (Sample) other;
     }
     return (this.x == other.getX() && this.y == other.getY());
    }
   */
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public String toString(){
        return "(" + this. x + ", " + this.y + ") ";
    }


 /*public static void main(String[] args) throws IOException {
  System.out.println("testing for the Sample class.");

  while(input1.ready()){
   input1.readLine();
  }
  double[] p1 = {1d, 2d, 3.14, 2.71};
  double[] p2 = {0.1, 1.1, 2.1, 3.1};
  Sample s1 = new Sample(p1);
  Sample s2 = new Sample(p2);
  System.out.println("s1="+s1);
  System.out.println("s2="+s2);

 }*/

}
