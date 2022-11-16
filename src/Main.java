import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Основной цикл приложения-считывание команд и вызов соответсвующий методов основного цикла приложения StepTracker
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();





        while (userInput != 0){
            //Обработка разных случаев
            if(userInput == 1){
                //Спросить за какой день вы хотите ввести шаги
                System.out.println("Выберите номер дня с 1 до 30");
                int userDay = scanner.nextInt();
                System.out.println("Выберите месяц: 0 - Январь, 11 - Декабрь");
                int userMonth = scanner.nextInt();

                //Введите количество шагов за этот день
                System.out.println("Введите количество шагов за этот день");
                int userStep = scanner.nextInt();
                //Количество пройденных шагов по дням в следующем
                if(userStep>=0){
                    stepTracker.saveUserStepInDay(userMonth, userDay,userStep);
                    System.out.println("Сохранено");
                }else{
                    System.out.println("Введите корректное число");
                }
                double kkcal = converter.getkkcal(stepTracker, userMonth);
                double totalSteps = converter.totalStepsPerMonths(stepTracker, userMonth);
            }else if (userInput == 2) {
                System.out.println("Выберите месяц: 0 - Январь, 11 - Декабрь");
                int userMonth = scanner.nextInt();
                System.out.println("Количество пройденных шагов по дням ");
                stepTracker.stepPerDat(userMonth);
                System.out.println("Общее количество шагов за месяц: " + stepTracker.saveUserStepMonth(userMonth));// общее количество шагов за месяц
                System.out.println("Средняя количество шагов за месяц: " + stepTracker.averageNumberOfSteps(userMonth));
                System.out.println("Максимальное количество шагов в месяце: " + stepTracker.maxStepMonth(userMonth));
                System.out.println("Пройденная дистанция (в км) "+ String.format("%.2f", converter.totalStepsPerMonths(stepTracker, userMonth)));
                System.out.println("Количество сожженных килокалорий: " + converter.getkkcal(stepTracker, userMonth));


                System.out.println("Лучшая серия: " +stepTracker.getBestDaysSeries(userMonth));

            }else if (userInput == 3){
                System.out.println("Введите новый цель по количеству шагов в месяц");
                int userStepDay = scanner.nextInt();
                stepTracker.goalStepsDay(userStepDay);


            }else{
                System.out.println("Извините, такой команды нет. Попробуйте еще раз");
            }
            printMenu(); //печатаем меню еще раз перед завершением действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");

    }

    private static void printMenu(){
        System.out.println("Какое действие хотите выполнить?");
        System.out.println("1. Ввести количество шагов за день");
        System.out.println("2. Напечатать статистику за месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("0. Выход из приложения");
    }

}