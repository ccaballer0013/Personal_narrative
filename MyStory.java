import org.code.theater.*;
import org.code.media.*;

import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  // Instance Variables
  private String[][] countries;
  private ImageFilter[][] variable2;
  private String[][] description;
  
  // Constructor
  public MyStory(String[][] countries, ImageFilter[][] variable2, String[][] description) {
    this.countries = countries;
    this.variable2 = variable2;
    this.description = description;
  }

  // Calls all the parts of your animation, in order
  public void drawScene() {
    largestCountries();
    largestPopulation();
    safestCountries();
    mostVisitedCountries();

    topFour("st");
    numCountries("I");
  }


  /*
   * Displays images of the largest countries by land mass and applies a pixelate filter to each
   */
  public void largestCountries() {
    // clear the scene / draw background
    clear("gray");
    // Set any style (text size, font, font style, fill color)
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    // Draw text and images, play sounds
    drawText("Largest Countries", 45, 35);
    ImageFilter russia = new ImageFilter("russia.jpg");
    drawImage(russia, 20, 40, 170);
    ImageFilter canada = new ImageFilter("canada.jpg");
    drawImage(canada, 210, 40, 170);
    ImageFilter china = new ImageFilter("china.jpg");
    drawImage(china, 20, 220, 170);
    ImageFilter brazil = new ImageFilter("brazil.jpg");
    drawImage(brazil, 210, 220, 170);
    
    pause(1);
    playSound("bloop_x.wav");
    russia.pixelate(8);
    drawImage(russia, 20, 40, 170);
    canada.pixelate(8);
    drawImage(canada, 210, 40, 170);
    china.pixelate(8);
    drawImage(china, 20, 220, 170);
    brazil.pixelate(8);
    drawImage(brazil, 210, 220, 170);
    
    // Pause before transitioning
    pause(1);
  }

  /*
   * Displays images of the largest countries by population and applies a filter to each
   * pixel that removes all blue
   */
  public void largestPopulation() {
    // clear the scene / draw background
    clear("brown");
    // Set any style (text size, font, font style, fill color)
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    // Draw text and images, play sounds
    drawText("Largest Population", 45, 35);
    ImageFilter india = new ImageFilter("india.jpg");
    drawImage(india, 20, 40, 170);
    ImageFilter china = new ImageFilter("china.jpg");
    drawImage(china, 210, 40, 170);
    ImageFilter us = new ImageFilter("us.jpg");
    drawImage(us, 20, 220, 170);
    ImageFilter indonesia = new ImageFilter("indonesia.jpg");
    drawImage(indonesia, 210, 220, 170);
    
    pause(1);
    playSound("bloop_x.wav");
    india.zeroBlue();
    drawImage(india, 20, 40, 170);
    china.zeroBlue();
    drawImage(china, 210, 40, 170);
    us.zeroBlue();
    drawImage(us, 20, 220, 170);
    indonesia.zeroBlue();
    drawImage(indonesia, 210, 220, 170);
    
    // Pause before transitioning
    pause(1);
  }

  /*
   * Iterates through the countries array and applies filter if the iteration is on the
   * first row or if it begins with "Switzerland"
   */
  public void safestCountries() {
    // clear the scene / draw background
    clear("green");
    // Set any style (text size, font, font style, fill color)
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    // Draw text and images, play sounds
    int index = 0;
    String a = "";
    for (int row=0; row<countries.length; row++) {
      for (int col=0; col<countries[0].length; col++) {
        index++;
        a = countries[row][col];
        if (index<2 || a.equals("Switzerland")) {
          drawText("Safest Countries", 50, 35);
          ImageFilter switzerland = new ImageFilter("switzerland.jpg");
          drawImage(switzerland, 20, 40, 170);
          ImageFilter norway = new ImageFilter("norway.jpg");
          drawImage(norway, 210, 40, 170);
          ImageFilter iceland = new ImageFilter("iceland.jpg");
          drawImage(iceland, 20, 220, 170);
          ImageFilter ireland = new ImageFilter("ireland.jpg");
          drawImage(ireland, 210, 220, 170);
          
          pause(1);
          playSound("bloop_x.wav");
          switzerland.colorize();
          drawImage(switzerland, 20, 40, 170);
          norway.colorize();
          drawImage(norway, 210, 40, 170);
          iceland.colorize();
          drawImage(iceland, 20, 220, 170);
          ireland.colorize();
          drawImage(ireland, 210, 220, 170);
        }
      }
    }
    
    // Pause before transitioning
    pause(1);
  }
  
  /*
   * Iterates through the description array to display each element that 
   * contains the given word or phrase given as an argument
   */
  public void mostVisitedCountries() {
    // clear the scene / draw background
    clear("black");
    // Set any style (text size, font, font style, fill color)
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    // Draw text and images, play sounds
    drawText("Most Visited", 80, 35);
    ImageFilter france = new ImageFilter("france.jpg");
    drawImage(france, 20, 40, 170);
    ImageFilter spain = new ImageFilter("spain.jpg");
    drawImage(spain, 210, 40, 170);
    ImageFilter us = new ImageFilter("us.jpg");
    drawImage(us, 20, 220, 170);
    ImageFilter italy = new ImageFilter("italy.jpg");
    drawImage(italy, 210, 220, 170);
    
    pause(1);
    playSound("bloop_x.wav");
    france.blackAndWhite();
    drawImage(france, 20, 40, 170);
    spain.blackAndWhite();
    drawImage(spain, 210, 40, 170);
    us.blackAndWhite();
    drawImage(us, 20, 220, 170);
    italy.blackAndWhite();
    drawImage(italy, 210, 220, 170);
    
    // Pause before transitioning
    pause(1);
  }

  /*
   * Iterates through the description array to display each element that 
   * contains the given word or phrase given as an argument
   */
  public void topFour(String targetWord) {
    // clear the scene / draw background
    clear("purple");
    // Set any style (text size, font, font style, fill color)
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    // Draw text and images, play sounds
    drawText("Top Four Countries", 45, 35);
    pause(1);
    playSound("bloop_x.wav");
    int count = 0;
    int y = 100;
    setTextHeight(14);
    for (int row=0; row<description.length; row++) {
      for (int col=0; col<description[0].length; col++) {
        String current = description[row][col];
        if (current.indexOf(targetWord) != -1) {
          drawText(current, 10, y);
          y += 30;
        }
      }
    }
    // Pause before transitioning
    pause(3);
  }
  
  /*
   * Iterates through the countries array to display the amount
   * of featured countries that begin with a given letter
   */
  public void numCountries(String targetLetter) {
    // clear the scene / draw background
    clear("blue");
    // Set any style (text size, font, font style, fill color)
    setTextHeight(18);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    // Draw text and images, play sounds
    String text = "Featured Countries Starting With " + targetLetter;
    drawText(text, 20, 35);
    pause(1);
    playSound("bloop_x.wav");
    int result = 0;
    for (int row=0; row<countries.length; row++) {
      for (int col=0; col<countries[0].length; col++) {
        String currentPhrase = countries[row][col];
        int location = currentPhrase.indexOf(targetLetter);

        if (location != -1) {
          result++;
        }
      }
    }
    
    String end = "";
    if (result == 0) {
      end = "Zero";
    } else if (result == 1) {
      end = "One";
    } else if (result == 2) {
      end = "Two";
    } else if (result == 3) {
      end = "Three";
    } else if (result == 4) {
      end = "Four";
    } else if (result == 5) {
      end = "Five";
    }
    setTextHeight(50);
    drawText(end, 150, 200);
  }
}
