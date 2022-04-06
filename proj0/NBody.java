public class NBody {
    public static double readRadius(String address) {
        In in = new In(address);

        /* Every time you call a read method from the In class,
         * it reads the next thing from the file, assuming it is
         * of the specified type. */

        /* Compare the calls below to the contents of BasicInDemo_input_file.txt */

        int numberPlanets = in.readInt();
        double radius = in.readDouble();


        return radius;
    }

    public static Planet[] readPlanets(String address){
        In in = new In(address);
        int numberPlanets = in.readInt();
        double radius = in.readDouble();
        Planet[] output = new Planet [numberPlanets];
        int i = 0;
        while (i < output.length) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            //concatenation of relevant string
            String img = in.readString();
            Planet newPlanet = new Planet(xP, yP, xV, yV, m, img);
            output[i++] = newPlanet;
            }


        return output;

    }
    public static void main(String[] args){


    }
}
