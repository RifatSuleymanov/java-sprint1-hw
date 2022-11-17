public class StepTracker {
    MonthData[] monthToData;// объявили массив monthToData
    int ambitionStep = 10000; //Количество шагов в день по умолчанию

    public StepTracker() {   //Создали  StepTracker
        monthToData = new MonthData[12]; //Создаем массив-его элементы пока пустые
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData("nameMonth");
            monthToData[0] = new MonthData("Январь");
            monthToData[1] = new MonthData("Февраль");
            monthToData[2] = new MonthData("Март");
            monthToData[3] = new MonthData("Апрель");
            monthToData[4] = new MonthData("Май");
            monthToData[5] = new MonthData("Июнь");
            monthToData[6] = new MonthData("Июль");
            monthToData[7] = new MonthData("Август");
            monthToData[8] = new MonthData("Сентябрь");
            monthToData[9] = new MonthData("Октябрь");
            monthToData[10] = new MonthData("Ноябрь");
            monthToData[11] = new MonthData("Декабрь");
        }
    }

    int goalStepsDay(int userStepDay) {  //Метод для замены количество шагов по умолчанию
        if (userStepDay >= 0) {
            ambitionStep = userStepDay;
            System.out.println("Значение сохранено! Ваша текущая цель по количеству шагов за день: " + userStepDay);
        } else {
            System.out.println("Введите корректное число!");
        }
        return userStepDay;
    }

    void saveUserStepInDay(int userMonth, int userDay, int userStep) {
        userDay = userDay - 1;
        monthToData[userMonth].monthDay[userDay] = userStep;
    }

    void stepPerDat(int userMount) {  //Количество пройденных шагов по дням в следующем формате:

        for (int i = 0; i <= 29; i++) {
            System.out.println(i + 1 + " день: " + monthToData[userMount].monthDay[i]);
        }
    }

    int saveUserStepMonth(int userMonth) { //Общее количество шагов за месяц
        int sum = 0;
        for (int i = 0; i <= 29; i++) {
            sum = sum + monthToData[userMonth].monthDay[i];
        }
        return sum;
    }

    double averageNumberOfSteps(int userMonth) { //Средняя количество шагов за месяц
        double averageNumber = 0.0;
        averageNumber = saveUserStepMonth(userMonth) / monthToData[userMonth].monthDay.length;
        return averageNumber;
    }

    int maxStepMonth(int userMonth) {  // Максимальное количество пройденных шагов в месяц
        int max = monthToData[userMonth].monthDay[0];
        for (int i = 1; i < monthToData[userMonth].monthDay.length; i++)
            max = Math.max(max, monthToData[userMonth].monthDay[i]);
        return max;
    }

    int getBestDaysSeries(int userMount) { //Лучшая серия подряд идущих дней
        int dayCount = -1;
        int bestSeries = 0;

        for (int i = 0; i < monthToData[userMount].monthDay.length; i++) {
            if (monthToData[userMount].monthDay[i] >= ambitionStep) {
                dayCount++;
            } else {
                if (bestSeries < dayCount) {
                    bestSeries = dayCount;
                    dayCount = -1;
                }
            }
        }
        return bestSeries;
    }

    class MonthData {
        int[] monthDay;

        public MonthData(String nameMonth) {
            monthDay = new int[30];
            for (int i = 0; i < monthDay.length; i++) {
            }
        }
    }
}