package SimpleStart;

import java.awt.*;

public class Drops {
    private float _x;
    private float _y;
    private Image image;

    Drops(float x, float y, Image img){
        _x = x;
        _y = y;
        image = img;
    }

    public void SetY(float y){
        _y = y;
    }

    public void SetX(float x){
        _x = x;
    }
    public Image GetImage(){
        return image;
    }
    public float GetX(){
        return _x;
    }

    public float GetY(){
        return _y;
    }
}
