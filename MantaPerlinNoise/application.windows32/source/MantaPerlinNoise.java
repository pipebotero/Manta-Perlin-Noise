import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import peasy.*; 

import peasy.test.*; 
import peasy.org.apache.commons.math.*; 
import peasy.*; 
import peasy.org.apache.commons.math.geometry.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class MantaPerlinNoise extends PApplet {



int w = 640;
int h = 480;

PVector pos = new PVector(0, 0, 0);
PeasyCam cam;

int numNaves = 50;
float t= 0;
float dt = 0.001f;
float noiseX = 0.02f;
float noiseY = 0.02f;
float noiseScale = 200;

int c = color(0);

public void setup () {
  size(w, h, P3D); 
  cam = new PeasyCam(this, 600);
  cam.setMinimumDistance(100);
  cam.setMaximumDistance(1000);
}


public void draw() {
  background(0); 

 
  for (int j = 0; j<numNaves; j++){  
   for(int i =0; i<numNaves; i++) {
     
    pos = new PVector(i*5, j*5, noiseScale * noise(noiseX*i + 4*t , noiseY*j +4*t) );
    c = color (255*noise(t*i  , t*j ),0 , 255*noise(noiseX*i  , noiseY*j ));
    pushMatrix();
    translate(pos.x, pos.y, pos.z);
    fill(c);
    box(5);
    popMatrix();
  }
}

t+= dt;

}


  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MantaPerlinNoise" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
