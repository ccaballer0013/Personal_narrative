import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    String[][] countries = {{"Russia", "Canada", "China", "Brazil"},
                            {"India", "China", "United States", "Indonesia"},
                            {"Switzerland", "Norway", "Iceland", "Ireland"},
                            {"France", "Spain", "United States", "Italy"}};

    String[][] description = {{"Russia: largest land-mass of 6.602 m²", "Canada: land-mass of 3.855 m²", "China: land-mass of 3.705 m²", "Brazil: land-mass of 3.286 m²"},
                            {"India: largest population of 1.429 billion people", "China: population of 1.411 billion people", "United States: population of 334.9 million people", "Indonesia: population of 277.5 million people"},
                            {"Switzerland: safest country", "Norway: safe country", "Iceland: safe country", "Ireland: safe country"},
                            {"France: most visitors of 90.9 million yearly", "Spain: 18.9 million visitors yearly", "United States: 66.5 million visitors yearly", "Italy: 57.25 million visitors yearly"}};

    ImageFilter[][] countryImages = {
      { new ImageFilter("russia.jpg"), new ImageFilter("canada.jpg"), new ImageFilter("china.jpg"), new ImageFilter("brazil.jpg") },
      { new ImageFilter("india.jpg"), new ImageFilter("china.jpg"), new ImageFilter("us.jpg"), new ImageFilter("indonesia.jpg") },
      { new ImageFilter("switzerland.jpg"), new ImageFilter("norway.jpg"), new ImageFilter("iceland.jpg"), new ImageFilter("ireland.jpg") },
      { new ImageFilter("france.jpg"), new ImageFilter("spain.jpg"), new ImageFilter("us.jpg"), new ImageFilter("italy.jpg") }
    };

    // MyStory object
    MyStory scene = new MyStory(countries, countryImages, description);
    
    // Call drawScene
    scene.drawScene();
    
    // Play scene in Theater
    Theater.playScenes(scene);




    

    
    
  }
}