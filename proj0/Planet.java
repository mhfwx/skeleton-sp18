import java.lang.Math;

public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G=6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;

    }
    public double calcDistance(Planet p){
        return Math.sqrt(Math.pow((this.xxPos-p.xxPos), 2)+Math.pow((this.yyPos-p.yyPos), 2));
    }

    public double calcForceExertedBy(Planet p){
        double dissq = Math.pow(this.calcDistance(p),2);
        return G*p.mass*this.mass/dissq;
    }

    public double calcForceExertedByX(Planet p){
        double F = this.calcForceExertedBy(p);
        double dis = this.calcDistance(p);
        return (F*(p.xxPos-this.xxPos))/dis;
    }

    public double calcForceExertedByY(Planet p){
        double F = this.calcForceExertedBy(p);
        double dis = this.calcDistance(p);
        return (F*(p.yyPos-this.yyPos))/dis;
    }

    public double calcNetForceExertedByX(Planet args[]){
        double result = 0;
        for (int i=0;i<args.length;i++){
            if (this.equals(args[i])){
                continue;
            }
          result += this.calcForceExertedByX(args[i]);

        }
        return result;

    }
    public double calcNetForceExertedByY(Planet args[]){
        double result = 0;
        for (int i=0;i<args.length;i++){
            if (this.equals(args[i])){
                continue;
            }
            result += this.calcForceExertedByY(args[i]);

        }
        return result;

    }

    public void update(double time, double xF, double yF){
        double aX = xF/this.mass;
        double aY = yF/this.mass;
        this.xxVel += aX*time;
        this.yyVel += aY*time;
        this.xxPos += this.xxVel*time;
        this.yyPos += this.yyVel*time;
    }
    public void draw() {
        StdDraw.picture(xxPos,yyPos,imgFileName);
    }

}
