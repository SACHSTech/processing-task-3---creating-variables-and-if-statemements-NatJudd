import processing.core.PApplet;

/**
 * description: draws a house in a randomly generated position 
 * then changes the background and house colour 
 * based on the position of the centre of the house
 * it also displays the time in hours minutes and seconds
 * which changes colour based on the position of the house
 * @author N.Judd
 */
public class Sketch extends PApplet {
  // initializes displacment variables
  float fltRandomX = 0;
  float fltRandomY = 0;

  // initializes house RGB variables
  int intColourR = 0;
  int intColourG = 0;
  int intColourB = 0;

  // time variables
  int intSec;
  int intMin;
  int intHrs;

  // initializes background RGB variables
  int intBGColourR = 0;
  int intBGColourG = 0;
  int intBGColourB = 0;

  // size of the screen
  public void settings() {
    size(900, 800);
  }

  // set up
  public void setup() {
    // barrier
    fltRandomX = random(0, 700);
    fltRandomY = random(0, 510);

    // the RGB of the background and house
    if ((fltRandomX <= 700 / 3) && (fltRandomY <= 510 / 2)) {
      // black
      intBGColourR = 0;
      intBGColourG = 0;
      intBGColourB = 0;
      // white
      intColourR = 255;
      intColourB = 255;
      intColourG = 255;
    } 
    else if ((fltRandomX >= (700 / 3) * 2) && (fltRandomY <= 510 / 2)) {
      // white
      intBGColourR = 255;
      intBGColourG = 255;
      intBGColourB = 255;
      // black
      intColourR = 0;
      intColourG = 0;
      intColourB = 0;
    } 
    else if ((fltRandomX <= (700 / 3) * 2) && (fltRandomX >= 700 / 3) && (fltRandomY <= 510 / 2)) {
      // gray
      intBGColourR = 128;
      intBGColourG = 135;
      intBGColourB = 128;
      // blue
      intColourR = 0;
      intColourG = 0;
      intColourB = 255;
    }
    else if ((fltRandomX >= (700 / 3) * 2) && (fltRandomY >= 510 / 2)) {
      // red
      intBGColourR = 200;
      intBGColourG = 0;
      intBGColourB = 0;
      // green
      intColourR = 0;
      intColourG = 255;
      intColourB = 0;
    }
    else  if ((fltRandomX <= 700 / 3) && (fltRandomY >= 510 / 2)) {
      // purple
      intBGColourR = 80;
      intBGColourG = 40;
      intBGColourB = 125;
      // red
      intColourR = 255;
      intColourG = 0;
      intColourB = 0;
    }   
    else {
      // cyan
      intBGColourR = 0;
      intBGColourG = 200;
      intBGColourB = 200;
      // yellow
      intColourR = 255;
      intColourG = 255;
      intColourB = 0;
      }
    }

  // called repeatedly 

  // draws time and house
  public void draw() {
    // displays background
    background(intBGColourR, intBGColourG, intBGColourB);

    // calculates time
    intSec = second();
    intMin = minute();
    intHrs = hour();
        
    // prints time
    text(intHrs + " : " + intMin + " : " + intSec, 5, 15);

    // house base and ceiling
    stroke(intColourR, intColourG, intColourB);
    strokeWeight(2);
    line(25 + fltRandomX, 115 + fltRandomY, 175 + fltRandomX, 115 + fltRandomY);
    line(25 + fltRandomX, 265 + fltRandomY, 175 + fltRandomX, 265 + fltRandomY);

    // house walls
    line(25 + fltRandomX, 115 + fltRandomY, 25 + fltRandomX, 265 + fltRandomY);
    line(175 + fltRandomX, 115 + fltRandomY, 175 + fltRandomX, 265 + fltRandomY);

    // house roof
    fill(intColourR, intColourG, intColourB);
    triangle(25 + fltRandomX, 115 + fltRandomY, 175 + fltRandomX, 115 + fltRandomY, 100 + fltRandomX, 25 + fltRandomY);

    // house door
    line(75 + fltRandomX, 265 + fltRandomY, 75 + fltRandomX, 190 + fltRandomY);
    line(125 + fltRandomX, 265 + fltRandomY, 125 + fltRandomX, 190 + fltRandomY);
    line(75 + fltRandomX, 190 + fltRandomY, 125 + fltRandomX, 190 + fltRandomY);

    // house doorknob
    fill(intColourR, intColourG, intColourB);
    ellipse(112 + fltRandomX, 225 + fltRandomY, 10, 10);

    // grid
    // line(300, 0, 300, 800);
    // line(600, 0, 600, 800);
    // line(0, 400, 900, 400);
  }
}