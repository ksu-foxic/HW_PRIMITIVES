import java.util.Scanner;

public class Main {

    public static int taxEarningMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else return 0;
    }

    public static int taxEarnings(int earnings) {
        int tax = earnings * 6 / 100;
        return tax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int spendings = 0;
        int earnings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите её номер: или end");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            int operation = Integer.parseInt(input);

            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода: ");
                    String moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода: ");
                    String spendStr = scanner.nextLine();
                    int spend = Integer.parseInt(spendStr);
                    spendings += spend;
                    break;
                case 3:
                    int x = taxEarningMinusSpendings(earnings, spendings);
                    int y = taxEarnings(earnings);

                    if (x < y) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + x + "рублей");
                        System.out.println("Налог на другой системе: " + y + "рублей");
                        System.out.println("Экономия: " + (y - x) + "рублей");
                    } else if (x > y) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + y + "рублей");
                        System.out.println("Налог на другой системе: " + x + "рублей");
                        System.out.println("Экономия: " + (x - y) + "рублей");
                    } else System.out.println("Можете выбрать любую систему налогообложения");
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }
}
