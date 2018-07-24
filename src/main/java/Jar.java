import java.util.Random;

public class Jar {
  
  private String item;
  private int maxNum;
  private int fillLevel;

  public Jar(String item, int maxNum) {
    this.item = item;
    this.maxNum = maxNum;
    fill();
  }
  
  public void fill() {
    fillLevel = new Random().nextInt(maxNum) + 1;
  }
  
  public String getItem() {
    return item;
  }
  
  public int getMaxItems() {
    return maxNum;
  }
  
  public int getFillLevel() {
    return fillLevel;
  }

}