package Enviorment;

import main.GamePanel;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Lightning {
    GamePanel gp;
    BufferedImage darknessFilter;
    public Lightning(GamePanel gp, int circlesize){
        this.gp=gp;
        darknessFilter=new BufferedImage(gp.screenWidth,gp.screenHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2=(Graphics2D) darknessFilter.getGraphics();
        Area screenArea=new Area(new Rectangle2D.Double(0,0,gp.screenWidth,gp.screenHeight));
        int centerX=gp.player.screenX+gp.tileSize/2;
        int centerY=gp.player.screenY+gp.tileSize/2;
        double x=centerX-(circlesize/2);
        double y=centerY-(circlesize/2);
        Shape circleShape=new Ellipse2D.Double(x,y,circlesize,circlesize);
        Area lightArea=new Area(circleShape);
        screenArea.subtract(lightArea);

        Color[] color=new Color[12];
        float fraction[]=new float[12];

        color[0]=new Color(0,0,0.1f,0.1f);
        color[1]=new Color(0,0,0.1f,0.42f);
        color[2]=new Color(0,0,0.1f,0.52f);
        color[3]=new Color(0,0,0.1f,0.61f);
        color[4]=new Color(0,0,0.1f,0.69f);
        color[5]=new Color(0,0,0.1f,0.76f);
        color[6]=new Color(0,0,0.1f,0.82f);
        color[7]=new Color(0,0,0.1f,0.87f );
        color[8]=new Color(0,0,0.1f,0.91f);
        color[9]=new Color(0,0,0.1f,0.94f);
        color[10]=new Color(0,0,0.1f,0.96f);
        color[11]=new Color(0,0,0.1f,0.98f);

        fraction[0]=0f;
        fraction[1]=0.4f;
        fraction[2]=0.5f;
        fraction[3]=0.6f;
        fraction[4]=0.65f;
        fraction[5]=0.7f;
        fraction[6]=0.75f;
        fraction[7]=0.8f;
        fraction[8]=0.85f;
        fraction[9]=0.9f;
        fraction[10]=0.96f;
        fraction[11]=1f;

        RadialGradientPaint gPaint=new RadialGradientPaint(centerX,centerY,(circlesize/2),fraction,color);
        g2.setPaint(gPaint);
        g2.fill(lightArea);

        g2.fill(screenArea);
        g2.dispose();

    }
    public void draw(Graphics2D g2){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.80f));
        g2.drawImage(darknessFilter,0,0,null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    }
}
