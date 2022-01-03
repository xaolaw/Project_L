package agh.ics.oop;

class InfinityMap extends AbstractWorldMap{
    int grassWidth;
    int grassHeight;
    public InfinityMap(int height, int width, double jungleRatio, int startEnergy, int plantEnergy){
        this.height=height;
        this.plantEnergy=plantEnergy;
        this.grassHeight=height;
        this.grassWidth=width;
        this.width=width;
        this.startEnergy=startEnergy;
        int x1 = (this.width-((int) (width*jungleRatio)))/2;
        int y1 = (this.height-((int) (height*jungleRatio)))/2;
        this.jungleLower=new Vector2d(x1,y1);
        this.jungeleUpper=new Vector2d(this.width- x1-1,this.height-y1-1);
        this.sawanna=0;
        this.jungle=0;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.precedes(new Vector2d(width,height)) && position.follows(new Vector2d(0,0)) && !isOccupied(position);
    }
    @Override
    public Vector2d forceInBounds(Vector2d position) {
        return position;
    }
    @Override
    public Vector2d borderDown() {
        return null;
    }
    @Override
    public Vector2d borderUP() {
        return null;
    }
}
