import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Поехали!
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("Укажите месяц");
                int month = scanner.nextInt();
                if (!monthIsValid(month)) {
                    System.out.println("Ошибка.Введенное число должно быть в диапазоне [0-12] ");
                } else {
                    System.out.println("Укажите день");
                    int day = scanner.nextInt();
                    if (!dayIsValid(day)) {
                        System.out.println("Ошибка.Введенное число должно быть в диапазоне [0-30] ");
                    } else {
                        System.out.println("Укажите колличество шагов");
                        int steppes = scanner.nextInt();
                        if (steppes < 0) {
                            System.out.println("Ошибка.Колличество шагов не может быть отрицательным. ");

                        } else {
                            stepTracker.saveSteps(month, day, steppes);
                        }
                    }
                }
            }// обаботка разных случаев
            else if (userInput == 2) {
                System.out.println("Укажите месяц");
                int month = scanner.nextInt();
                if (!monthIsValid(month)) {
                    System.out.println("Ошибка.Введенное число должно быть в диапазоне [0-12] ");
                } else {
                    stepTracker.printDaysInfoByMonth(month);
                    int amountSteppes = stepTracker.amountSteppes(month);

                    System.out.println("Общее количество шагов за месяц: " + amountSteppes);
                    System.out.println("Максимальное пройденное количество шагов в месяце " + stepTracker.maxamountSteppes(month));
                    System.out.println("Среднее количество шагов " + stepTracker.averageamounthSteppes(month));
                    float convertStepsToDistance = Converter.calculateDistanceFromSteppes(amountSteppes);
                    System.out.println("Пройденная дистанция " + convertStepsToDistance + " км ");
                    float convertCaloriesFromSteppes = Converter.calculateCaloriesFromSteppes(amountSteppes);
                    System.out.println("Количество сожжённых килокалорий " + convertCaloriesFromSteppes);
                    System.out.println("Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого " + stepTracker.bestSeries(month));
                }
            } else if (userInput == 3) {
                System.out.println("Введите целевое колличество шагов ");
                int goalSteppes = scanner.nextInt();
                if (goalSteppes >= 0) {
                    stepTracker.setTargetStepNumber(goalSteppes);
                    System.out.println("Значение успешно заменено на " + goalSteppes);
                } else {
                    System.out.println("Ошибка! Число должно быть положительным");
                }

            } else if (userInput == 4) {
                break;
            }
            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static boolean monthIsValid(int month) {
        return month >= 0 && month < 12;
    }

    private static boolean dayIsValid(int day) {
        return day >= 0 && day < 30;
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
    }
}