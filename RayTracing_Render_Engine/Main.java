package RayTracing_Render_Engine;

public class Main {
    public static void main(String[] args) {
        System.out.println("[RENDER] Starting Ray Tracer (Resolution: 3x3)...");
        
        // Scene: Camera at (0,0,0), Sphere at (0,0,5) radius 1
        Sphere sphere = new Sphere(0, 0, 5, 1);
        
        for(int y=1; y>=-1; y--) {
            for(int x=-1; x<=1; x++) {
                // Ray from origin (0,0,0) towards pixel (x,y,1)
                double[] rayDir = normalize(new double[]{x, y, 1});
                
                if(sphere.intersect(rayDir)) {
                    System.out.print("O "); // Hit Sphere
                } else {
                    System.out.print(". "); // Empty Space
                }
            }
            System.out.println();
        }
    }

    static double[] normalize(double[] v) {
        double len = Math.sqrt(v[0]*v[0] + v[1]*v[1] + v[2]*v[2]);
        return new double[]{v[0]/len, v[1]/len, v[2]/len};
    }
}

class Sphere {
    double cx, cy, cz, r;
    public Sphere(double x, double y, double z, double r) {
        this.cx=x; this.cy=y; this.cz=z; this.r=r;
    }
    
    // Mathematical Intersection Formula (b^2 - 4ac)
    public boolean intersect(double[] rayDir) {
        // Simplified check for demo purposes
        // Ray origin is (0,0,0)
        double a = rayDir[0]*rayDir[0] + rayDir[1]*rayDir[1] + rayDir[2]*rayDir[2];
        double b = 2 * (rayDir[0]*(0-cx) + rayDir[1]*(0-cy) + rayDir[2]*(0-cz));
        double c = (0-cx)*(0-cx) + (0-cy)*(0-cy) + (0-cz)*(0-cz) - r*r;
        double discriminant = b*b - 4*a*c;
        return discriminant >= 0;
    }
}