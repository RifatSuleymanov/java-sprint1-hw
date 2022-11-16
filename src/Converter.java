public class Converter {
    double stepLengthKm = 0.00075;
    int oneStep = 50;
    public double getkkcal(StepTracker stepTracker, int userMonth){
        return stepTracker.saveUserStepMonth(userMonth)*oneStep/1000;
    }
    public double totalStepsPerMonths(StepTracker stepTracker, int userMonth){
        return stepTracker.saveUserStepMonth(userMonth)*stepLengthKm;
    }

}
