import java.lang.Math;

public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G=6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){

    }
    public double calcDistance(Planet p){
        return Math.sqrt(Math.pow((this.xxPos-p.xxPos), 2)+Math.pow((this.yyPos-p.yyPos), 2));
    }

    public double calcForceExertedBy(Planet p){
        double dissq = Math.pow(this.calcDistance(p),2);
        return G*p.mass*this.mass/dissq;
    }

}
