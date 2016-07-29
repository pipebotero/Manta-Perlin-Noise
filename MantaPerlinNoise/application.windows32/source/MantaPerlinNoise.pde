import peasy.*;

int w = 640;
int h = 480;

PVector pos = new PVector(0, 0, 0);
PeasyCam cam;

int numNaves = 50;
float t= 0;
float dt = 0.001;
float noiseX = 0.02;
float noiseY = 0.02;
float noiseScale = 200;

color c = color(0);

void setup () {
  size(w, h, P3D); 
  cam = new PeasyCam(this, 600);
  cam.setMinimumDistance(100);
  cam.setMaximumDistance(1000);
}


void draw() {
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


