public class Converter {

public static float calculateDistanceFromSteppes(int steppes) {
    return (float) steppes * 75/100000;
}
public static float calculateCaloriesFromSteppes(int steppes) {

    return (float) steppes * 50/1000;
}
}
