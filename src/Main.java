import java.util.*;

public class Main {
    private static final List<String> lastFiveCalculations = new LinkedList<>();
    private static Double lastResult;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        while(true){
            menu();
            choice = scanner.nextInt();
            if(choice == 1){
                System.out.print("Nhập a: ");
                double a = input();
                System.out.print("Nhập b: ");
                double b = input();
                calculationForm();
                choice = scanner.nextInt();
                Operation operation = Operation.getOperationFromValue(choice);
                switch (operation) {
                    case SUM:
                        sum(a,b);
                        break;
                    case MINUS:
                        minus(a,b);
                        break;
                    case MULTIPLY:
                        multiply(a,b);
                        break;
                    case DIVIDE:
                        divide(a,b);
                        break;
                    case MODULE:
                        module(a,b);
                        break;
                    case POW:
                        pow(a,b);
                        break;
                    case SQRT:
                        sqrt(a,b);
                        break;
                }
            }
            else if (choice == 2) {
                if(lastFiveCalculations.isEmpty()) System.out.println("Bạn chưa thực hiện phép tính nào");
                else lastFiveCalculations.forEach(System.out::println);
            }
            else {
                break;
            }
        }
    }
    private static void menu(){
        System.out.println("Menu ");
        System.out.println("1. Thực hiện phép tính");
        System.out.println("2. Xem 5 phép toán gần nhất");
        System.out.println("3. Thoát");
        System.out.print("Lựa chọn: ");
    }
    private static void calculationForm(){
        System.out.println("Chọn phép toán ");
        for (Operation operation : Operation.values()){
            System.out.println(operation.getValue() + ". "+operation.getDescription());
        }
        System.out.print("Lựa chọn: ");
    }
    private static double input(){
        double x;
        System.out.println("Sử dụng kết quả phép toán trước? (y/n)");
        String choice = scanner.next();
        if (choice.equals("y")) {
            if(lastResult != null) {
                x = lastResult;
                System.out.println(x);
            }
            else {
                System.out.println("Bạn chưa thực hiện phép tính nào");
                System.out.print("Nhập lại: ");
                x = scanner.nextDouble();
            }
        }
        else{
            System.out.print("Nhập: ");
            x = scanner.nextDouble();
        }
        return x;
    }
    private static void addToLastFiveCalculationList(String s){
        if (lastFiveCalculations.size() == 5) lastFiveCalculations.remove(0);
        lastFiveCalculations.add(s);
    }
    private static void sum(double a, double b){
        lastResult = a+b;
        addToLastFiveCalculationList(String.format("%.2f + %.2f = %.2f", a, b, a + b));
        System.out.println(lastResult);
    }
    private static void minus(double a,double b){
        lastResult = a-b;
        addToLastFiveCalculationList(String.format("%.2f - %.2f = %.2f", a, b, a - b));
        System.out.println(lastResult);
    }
    private static void divide(double a,double b){
        if(Double.compare(b,0.0 ) == 0) {
            System.out.println("Không thể thực hiện phép chia cho 0");
            return;
        }
        lastResult = a/b;
        addToLastFiveCalculationList(String.format("%.2f / %.2f = %.2f", a, b, a / b));
        System.out.println(lastResult);
    }
    private static void multiply(double a, double b){
        lastResult = a*b;
        addToLastFiveCalculationList(String.format("%.2f * %.2f = %.2f", a, b, a * b));
        System.out.println(lastResult);
    }
    private static void module(double a, double b){
        if (a != (int) a || b != (int) b) {
            System.out.println("Không thể lấy dư vì a,b không phải số nguyên");
            return;
        }
        lastResult = a%b;
        addToLastFiveCalculationList(String.format("%d %% %d = %d", (int)a, (int)b, (int)a % (int)b));
        System.out.println(lastResult);
    }
    private static void pow(double a, double b){
        lastResult = Math.pow(a,b);
        addToLastFiveCalculationList(String.format("%.2f ^ %.2f = %.2f", a, b, Math.pow(a,b)));
        System.out.println(lastResult);
    }
    private static void sqrt(double a,double b){
        System.out.printf("Căn bậc 2 của %.2f : %.2f",a,Math.sqrt(a));
        System.out.println();
        System.out.printf("Căn bậc 2 của %.2f : %.2f",b,Math.sqrt(b));
        System.out.println();
        lastResult = Math.sqrt(b);
        addToLastFiveCalculationList(String.format("Căn bậc 2 của %.2f : %.2f",a,Math.sqrt(a)));
        addToLastFiveCalculationList(String.format("Căn bậc 2 của %.2f : %.2f",b,Math.sqrt(b)));
    }
}