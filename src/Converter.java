public class Converter {
    double stepLengthKm = 0.00075;
    int oneStep = 50;

    public double convertKcal(int steps){
        return steps*oneStep/1000;
    }

    public double totalStepsPerMonths(int steps){
        return steps*stepLengthKm;
    }

}
