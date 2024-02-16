import java.util.*;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );


        System.out.println("________________________________________________________________________________________________________________________________________________________________");

        firstTask(transactions);System.out.println(); //1) Найти все транзакции за 2011 год и отсортировать их по сумме (по возр)
        System.out.println("________________________________________________________________________________________________________________________________________________________________");

        System.out.println();
        secondTask(transactions); System.out.println();//2) Вывести список неповторяющихся городов, в которых работают трейдеры.
        System.out.println("________________________________________________________________________________________________________________________________________________________________");

        System.out.println();
        thirdTask(transactions);System.out.println();//3) Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        System.out.println("________________________________________________________________________________________________________________________________________________________________");

        System.out.println();
        fourthTask(transactions);System.out.println();//4)Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        System.out.println("________________________________________________________________________________________________________________________________________________________________");

        System.out.println();
        fifthTask(transactions);System.out.println();//5)Выяснить, существует ли хоть один трейдер из Милана.
        System.out.println("________________________________________________________________________________________________________________________________________________________________");

        System.out.println();
        sixthTask(transactions);System.out.println();//6)Вывести суммы всех транзакций трейдеров из Кембриджа.
        System.out.println("________________________________________________________________________________________________________________________________________________________________");

        System.out.println();
        seventhTask(transactions);System.out.println();//7) Какова максимальная сумма среди всех транзакций?
        System.out.println("________________________________________________________________________________________________________________________________________________________________");

        System.out.println();
        eighthTask(transactions);System.out.println();//8) Какова Минимальная сумма среди всех транзакций?
        System.out.println("________________________________________________________________________________________________________________________________________________________________");

    }

   public static void firstTask(List<Transaction> transactions){ //1)Найти все транзакции за 2011 год и отсортировать их по сумме (по возр)
        List<Transaction> stream = transactions.stream()
                .filter(transaction -> transaction.getYear()==2011)
                .sorted((o1, o2) -> o1.getValue()-o2.getValue())
                .toList();
       System.out.println("Ответ на Задачу №1. все транзакции за 2011 год по возрастанию: ");
        stream.forEach(System.out::print);
   }

    public static void secondTask(List<Transaction> transactions){ // 2)Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> stream = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity()+" ")
                .distinct()
                .toList();

        System.out.print("Ответ на Задачу №2. Список не повторяющихся городов - ");
        stream.forEach(System.out::print);
    }

    public static void thirdTask(List<Transaction> transactions){ //3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Transaction> stream = transactions.stream()
                .filter(s->(s.getTrader().getCity()).equals("Cambridge"))
                .sorted(Comparator.comparing(e -> e.getTrader().getName()))
                .toList();

        System.out.println("Ответ на Задачу №3. Работники из Кэмбриджа по возрастанию ");
        stream.forEach(System.out::print);
    }

    public static void fourthTask(List<Transaction> transactions){ //4)Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        List<String> stream = transactions.stream()
                .map(transaction -> transaction.getTrader().getName()+" ")
                .sorted()
                .toList();

        System.out.println("Ответ на Задачу №4. Имена работников в алфавитном порядке");
        stream.forEach(System.out::print);
    }

    public static void fifthTask(List<Transaction> transactions){ //5)Выяснить, существует ли хоть один трейдер из Милана.
        boolean stream = transactions.stream()
                .anyMatch(s->(s.getTrader().getCity()).equals("Milan"));

        System.out.println("Ответ на Задачу №5. Cуществует ли хоть один трейдер из Милана - "+stream);
    }

    public static void sixthTask(List<Transaction> transactions){ //6)Вывести суммы всех транзакций трейдеров из Кембриджа.
        int stream = transactions.stream()
                .filter(s->(s.getTrader().getCity()).equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                        .sum();

        System.out.println("Ответ на Задачу №6. Вывести суммы всех транзакций трейдеров из Кембриджа. - "+stream);
    }

    public static void seventhTask(List<Transaction> transactions){ //7) Какова максимальная сумма среди всех транзакций?
        OptionalInt stream = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max();

        System.out.println("Ответ на Задачу №7. Максимальная сумма среди всех транзакций. - "+stream);
    }

    public static void eighthTask(List<Transaction> transactions){ //7) Какова Минимальная сумма среди всех транзакций?
        OptionalInt stream = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min();

        System.out.println("Ответ на Задачу №8. Минимальная сумма среди всех транзакций. - "+stream);
    }
}
