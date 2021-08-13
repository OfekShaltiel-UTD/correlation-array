
import java.util.*;

public class Main {

  public static double correlationVar(double arrX[], double arrY[]) {
    double r = 0.0;
    double sumXY = 0.0;
    double sumX = 0.0;
    double sumY = 0.0;
    double sumX2 = 0.0;
    double sumY2 = 0.0;

    for (int i = 0; i < arrX.length; i++) {
      sumXY += arrX[i] * arrY[i];
    }
    for (int i = 0; i < arrX.length; i++) {
      sumX += arrX[i];
    }
    for (int i = 0; i < arrX.length; i++) {
      sumY += arrY[i];
    }
    for (int i = 0; i < arrX.length; i++) {
      sumX2 += arrX[i] * arrX[i];
    }
    for (int i = 0; i < arrX.length; i++) {
      sumY2 += arrY[i] * arrY[i];
    }

    r = (double) (arrX.length * sumXY - sumX * sumY)
        / Math.sqrt((arrX.length * sumX2 - Math.pow(sumX, 2)) * (arrX.length * sumY2 - Math.pow(sumY, 2)));

    return r;
  }

  public static String correlationMsg(double r) {
    if (r <= 1.0 && r >= 0.9) {
      return "Very high positive correlation";
    }
    if (r < 0.9 && r >= 0.7) {
      return "high positive correlation";
    }
    if (r < .7 && r >= 0.5) {
      return "moderate positive correlation";
    }
    if (r < .5 && r >= 0.3) {
      return "low positive correlation";
    }
    if (r < 0.3 && r > -0.3) {
      return "negligible correlation";
    }
    if (r <= -1.0 && r >= -0.9) {
      return "Very high negative correlation";
    }
    if (r < -0.9 && r >= -0.7) {
      return "high negative correlation";
    }
    if (r < -.7 && r >= -0.5) {
      return "moderate negative correlation";
    }
    if (r < -.5 && r >= -0.3) {
      return "low negative correlation";
    } else
      return "";
  }

  public static void main(String[] args) {
    double x[] = { 0, 0.15, 0.30, 0.45, 0.60, 0.75 };
    double y[] = { 0.1, 0.167, 0.216, 0.276, 0.326, 0.377 };
    
    System.out.println("r = " + correlationVar(x, y));
    System.out.println(correlationMsg(correlationVar(x, y)));
  }
}