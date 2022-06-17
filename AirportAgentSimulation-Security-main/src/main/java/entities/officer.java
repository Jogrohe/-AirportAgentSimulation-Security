package entities;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.geometry.Point;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Agent;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.simulation.SimulationWorld;

public class officer extends Agent {
    protected String name;
    protected int posX;
    protected int posY;
    protected int width;
    protected int height;


    private SimulationWorld world;


    public officer(String name, int posX, int posY,int width,int height, SimulationWorld world) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.world = world;
        this.width = width;
        this.height = height;

    }

    public void patrolto(Point p){
        //patrol a specific location

                double distance = this.getPosition().getDistance(p) + 1;
                
                if (distance > 1) {
                    turn(p);
                }
                this.update();

                this.world.update();




    }
    public void standardpatrolroute(boolean keepPosition){
        int height = this.world.getHeight();
        int width = this.world.getWidth();

        Point corner1 = new Point(0,0);
        Point Start = new Point(this.posX, this.posY);

        if(corner1.getX()==this.posX&& corner1.getY()==this.posY ){
        }else{
            turn(corner1);
        }
        int i=0;
        while(i<height) {
            if(i+10<height){
            turn(new Point(width,i));
            i=i+5;
            turn(new Point(width,i));
            this.update();
            turn(new Point(0,i));
            i=i+5;
            turn(new Point(0,i));
            this.update();
        }  else if(i+5<height){
            turn(new Point(width,i));
            i=i+5;
            turn(new Point(width,i));
            this.update();
            turn(new Point(0,i));
            this.update();
            }else{
            turn(new Point(width,i));
            if(keepPosition){
                turn(Start);
            }else{
                turn(corner1);
                }
                this.update();
                this.world.update();
            break;
        }
        }
    }

    @Override
    public void pluginUpdate() {

    }
}

