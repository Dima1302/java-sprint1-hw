public class StepTracker {
    MonthData[] months;
    int targetStepNumber = 10_000;

    public StepTracker() {
        months = new MonthData[12];
        for (int i = 0; i < months.length; i++) {
            months[i] = new MonthData();

        }
    }

    public class MonthData {
        int[] days = new int[30];// Заполните класс самостоятельно

        public MonthData() {
            for (int i = 0; i < days.length; i++) {
                days[i] = 0;

            }
        }
    }

    public void saveSteps(int month, int day, int stepps) {
        MonthData month1 = months[month];
        month1.days[day] = stepps;
    }

    public void setTargetStepNumber(int steppes) {
        targetStepNumber = steppes;
    }

    public void printDaysInfoByMonth(int monthNumber) {
        MonthData month = months[monthNumber];
        for (int i = 0; i < month.days.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(i + " день:" + month.days[i]);
        }
        System.out.println();
    }

    public int amountSteppes(int monthNumber) {
        int total = 0;
        MonthData month = months[monthNumber];
        for (int i = 0; i < month.days.length; i++) {
            total += month.days[i];

        }
        return total;
    }

    public int maxamountSteppes(int monthNumber) {
        int maxtotal = 0;
        MonthData month = months[monthNumber];
        for (int i = 0; i < month.days.length; i++) {
            if(maxtotal < month.days[i]) {
                maxtotal = month.days[i];
            }
        }
        return maxtotal;
    }

    public float averageamounthSteppes(int monthNumber) {
        float sum = 0.0f;
        MonthData month = months[monthNumber];
        for (int i = 0; i < month.days.length; i++) {
            sum += month.days[i];
        }
        return sum/month.days.length;
    }
    public int bestSeries(int monthNumber) {
        int currentSeries = 0;
        int maxSeries = 0;
            MonthData month = months[monthNumber];
            for (int i = 0; i < month.days.length; i ++){
                if ( month.days[i] >= targetStepNumber) {
                    currentSeries ++;
                } else  {
                    if (currentSeries > maxSeries) {
                        maxSeries = currentSeries;
                    }
                    currentSeries = 0;
                }
        }
            if (currentSeries > maxSeries) {
                maxSeries = currentSeries;
            }
        return maxSeries;
    }
}

