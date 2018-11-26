import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class BubbleSortSketch extends PApplet {

int[][] grid;
int w = 100;
int h = 100;

public void setup() {
  
  frameRate(10);
  noStroke();
  grid = new int[w][h];
  for (int i = 0; i  < w; i++) {
    for (int j = 0; j < h; j++) {
      grid[i][j] = PApplet.parseInt(random(5));
    }
  }
}

public void draw() {
  ellipse(mouseX, mouseY, 20, 20);
  background(0);
  renderGrid(grid);

  for (int i = 0; i < w-1; i++) {
    for (int j = 0; j < h; j++) {
      if (grid[i][j] > grid[(i+1)%w][j%h]) {
        int temp = grid[i][j];
        grid[i][j] = grid[(i+1)%w][j%h];
        grid[(i+1)%w][j%h] = temp;
      }
    }
  }
}

public void renderGrid(int[][] grid) {
  for (int i = 0; i < w; i++) {
    for (int j = 0; j < h; j++) {
      fill(grid[i][j]*h);
      rect(i*500/w, j*500/h, 10, 10);
    }
  }
}

  public void settings() {  size(500, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "BubbleSortSketch" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
