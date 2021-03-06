package core.Engine2D;

import processing.core.PApplet;
import processing.core.PVector;

import javax.swing.text.html.ObjectView;

public class Transform {

    PApplet parent;
    private PVector position;
    private float rotation;
    private PVector scale;

    private PVector velocity;
    private PVector acceleration;

    private PVector bounds;

    public Transform(){
        parent = EngineMaster.parent;
        position = new PVector(0, 0);
        rotation = 0;
        scale = new PVector(1, 1);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0, 0);
        bounds = new PVector(1, 1);
    }

    public void Update(){
        velocity.x += acceleration.x;
        velocity.y += acceleration.y;
        position.x += velocity.x;
        position.y += velocity.y;
    }

    public PVector position() { return position; }
    public float rotation() { return rotation; }
    public PVector scale() { return scale; }

    public void setPosition(PVector position) { this.position = position; }
    public void setRotation(float rotation) { this.rotation = rotation; }
    public void setScale(PVector scale) { if (!(scale.x <= 0) && !(scale.y <= 0)){this.scale = scale;} }

    public void setVelocity(PVector velocity) { this.velocity = velocity; }
    public void setAcceleration(PVector acceleration) { this.acceleration = acceleration; }

    public PVector bounds(){ return bounds; }
    public void setBounds(PVector bounds) { this.bounds = bounds; }
    public boolean inBounds(PVector pos){
        if (pos.x > position().x - bounds().x/2 && pos.x < position().x + bounds().x/2 && pos.y > position().y - bounds().y/2 && pos.y < position().y + bounds().y/2)
            return true;
        else
            return false;
    }

}
