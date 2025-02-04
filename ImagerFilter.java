import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String fileName) {
    super(fileName);
  }

  /*
   * Makes each pixel in an image larger according to the given grid size
   */
  public void pixelate(int gridSize) {
    
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length; row += gridSize) {
      for (int col = 0; col < pixels[0].length; col += gridSize) {
        int endRow = Math.min(row + gridSize, pixels.length);
        int endCol = Math.min(col + gridSize, pixels[0].length);
        int avgRed = 0;
        int avgGreen = 0;
        int avgBlue = 0;

        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            avgRed += pixels[regionRow][regionCol].getRed();
            avgGreen += pixels[regionRow][regionCol].getGreen();
            avgBlue += pixels[regionRow][regionCol].getBlue();
          }
        }

        int totalPixelsInRegion = (endRow - row) * (endCol - col);
        avgRed /= totalPixelsInRegion;
        avgGreen /= totalPixelsInRegion;
        avgBlue /= totalPixelsInRegion;

        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            pixels[regionRow][regionCol].setRed(avgRed);
            pixels[regionRow][regionCol].setGreen(avgGreen);
            pixels[regionRow][regionCol].setBlue(avgBlue);
          }
        }
      }
    }
  }

  /*
   * Removes the blue in each pixel of the image by iterating through each pixel
   */
   public void zeroBlue() {
    Pixel[][] temp = getImagePixels();
    for (int row = 0; row < temp.length; row++) {
      for (int col = 0; col < temp[0].length; col++) {
        Pixel currentPixel = temp[row][col];
        currentPixel.setBlue(0);
      }
    }
  }

  /*
   * Iterates through each pixel and sets is color to either green, blue, or red depending
   * on its existing color
   */
  public void colorize() {

    Pixel[][] temp = getImagePixels();
    for (int row = 0; row < temp.length; row++) {
      double average = 0;
      for (int col = 0; col < temp[0].length; col++) {
        Pixel currentPixel = temp[row][col];
        average = (currentPixel.getBlue() + currentPixel.getGreen() + currentPixel.getRed())/3;
        if (average < 85) {
          currentPixel.setRed(255);
          currentPixel.setGreen(0);
          currentPixel.setBlue(0);
        } else if (average < 170) {
          currentPixel.setGreen(255);
          currentPixel.setRed(0);
          currentPixel.setBlue(0);
        } else {
          currentPixel.setBlue(255);
          currentPixel.setGreen(0);
          currentPixel.setRed(0);
        }
      }
    }
  }

  /*
   * Iterates through each pixel and changes each to either black or white 
   * depending on how much color is already present
   */
  public void blackAndWhite() {
    Pixel[][] temp = getImagePixels();
    for (int row=0; row<temp.length; row++) {
      for (int col=0; col<temp[0].length; col++) {
        Pixel currentPixel = temp[row][col];
        int blue = currentPixel.getBlue();
        int green = currentPixel.getGreen();
        int red = currentPixel.getRed();
        double average = (blue+green+red)/3;
        if (average > (255/2)) {
          currentPixel.setBlue(255);
          currentPixel.setGreen(255);
          currentPixel.setRed(255);
        } else {
          currentPixel.setBlue(0);
          currentPixel.setGreen(0);
          currentPixel.setRed(0);
        }
      }
    }
  }

}