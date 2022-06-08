package entities;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.geometry.Point;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.simulation.entity.Agent;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.simulation.SimulationWorld;

public class officer extends Agent {
    protected String name;
    protected int xPos;
    protected int yPos;
    protected boolean onpatrol;

    private SimulationWorld world;


    public officer(String name, int xPos, int yPos, SimulationWorld world) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        this.world = world;

    }

    public void patrolto(Point p){
        //patrol a specific location
            if(this.onpatrol){
                return;
            }else {
                this.onpatrol = true;
                //int Pos1 x
                //int Pos2 y
                double distance = this.getPosition().getDistance(p) + 1;
                
                if (distance > 1) {
                    turn(p);
                }
                this.onpatrol = false;
            }



    }
    public void standardpatrolroute(boolean keepPosition){
        //travels to all corners
        this.onpatrol = true;
        int height = this.world.getHeight();
        int width = this.world.getWidth();
        Point corner1 = new Point(0,0);
        Point corner2 = new Point(0,height);
        Point corner3 = new Point(width,height);
        Point corner4 = new Point(width,0);

        if(corner1.getX()==this.xPos&& corner1.getY()==this.yPos ){
        }else{
            turn(corner1);
        }
        
        turn(corner2);
        turn(corner3);
        turn(corner4);
        if(keepPosition){
            turn(new Point(this.xPos, this.yPos));
        }else{
            turn(corner1);
        }

        this.onpatrol = false;
    }

    @Override
    public void pluginUpdate() {

    }
}
