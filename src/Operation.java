public enum Operation {
    SUM(1,"Tổng"),
    MINUS(2,"Hiệu"),
    MULTIPLY(3,"Tích"),
    DIVIDE(4,"Thương"),
    MODULE(5,"Lấy dư"),
    POW(6,"Lũy thừa"),
    SQRT(7,"Căn bậc 2");

    private int value;
    private String description;

    Operation(int value, String description){
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public static Operation getOperationFromValue(int value){
        for (Operation operation : Operation.values()){
            if (operation.getValue() == value) return operation;
        }
        throw new IllegalArgumentException("Phép toán không hợp lệ");
    }
}
