public enum Operation {
    SUM(1,"Tổng"),
    MINUS(2,"Hiệu"),
    MULTIPLY(3,"Tích"),
    DIVIDE(4,"Thương"),
    MODULE(5,"Lấy dư"),
    POW(6,"Lũy thừa"),
    SQRT(7,"Căn bậc 2");

    private int choice;
    private String description;

    Operation(int choice, String description){
        this.choice = choice;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getChoice() {
        return choice;
    }

    public static Operation getOperationFromChoice(int value){
        for (Operation operation : Operation.values()){
            if (operation.getChoice() == value) return operation;
        }
        throw new IllegalArgumentException("Phép toán không hợp lệ");
    }
}
