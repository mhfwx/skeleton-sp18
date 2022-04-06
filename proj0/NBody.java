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
            String img = "images/"+in.readString();
            Planet newPlanet = new Planet(xP, yP, xV, yV, m, img);
            output[i++] = newPlanet;
            }


        return output;

    }
    public static void main(String[] args){
        double time = 0;

        // Collecting All Needed Input
        double T = Double.valueOf(args[0]), dt = Double.valueOf(args[1]);
        String filename = args[2];
        Planet[] bodies = readPlanets(filename);

        int numOfBodies = bodies.length;

        StdDraw.enableDoubleBuffering();
        double radius = readRadius(filename);
        StdDraw.setScale(- radius, radius);


        while(time < T) {
            // create xForces and yForces arrays
            double[] xForces = new double[numOfBodies];
            double[] yForces = new double[numOfBodies];

            // calculate the net x and y forces for each body, store them respectively
            for(int i = 0; i < numOfBodies; i++) {
                Planet curBody = bodies[i];
                double curForceX = 0, curForceY = 0;
                for(int j = 0; j < numOfBodies; j++) {
                    if(j != i) {
                        curForceX += curBody.calcForceExertedByX(bodies[j]);
                        curForceY += curBody.calcForceExertedByY(bodies[j]);
                    }

                }
                xForces[i] = curForceX;
                yForces[i] = curForceY;
            }

            // update each body's position, velocity and acceleration
            for(int i = 0; i < numOfBodies; i++) bodies[i].update(dt, xForces[i], yForces[i]);


            // Draw the background image.
            StdDraw.picture(1, 1, "images/starfield.jpg", radius * 2, radius * 2);

            // Draw all of the Bodies
            for(Planet body : bodies) body.draw();

            // show the offscreen buffer
            StdDraw.show();

            // pause the animation for 10 ms
            StdDraw.pause(10);

            // increase time by dt
            time += dt;

        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }



    }
}
