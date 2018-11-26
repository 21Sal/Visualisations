int[][] grid;
int w = 100;
int h = 100;

void setup() {
  size(500, 500);
  frameRate(10);
  noStroke();
  grid = new int[w][h];
  for (int i = 0; i  < w; i++) {
    for (int j = 0; j < h; j++) {
      grid[i][j] = int(random(5));
    }
  }
}

void draw() {
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

void renderGrid(int[][] grid) {
  for (int i = 0; i < w; i++) {
    for (int j = 0; j < h; j++) {
      fill(grid[i][j]*h);
      rect(i*500/w, j*500/h, 10, 10);
    }
  }
}
