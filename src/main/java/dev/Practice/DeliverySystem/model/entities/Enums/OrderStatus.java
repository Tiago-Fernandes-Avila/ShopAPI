package dev.Practice.DeliverySystem.model.entities.Enums;


//Essa forma de enumeração é boa quando a minha api é critica e precisa de de usar especificamente valores ordinais quando 
// tem comunicações com ferramentas externas que esperam valores numericos tirando isso eu vou usar Strings no db com 
//o @Enumerated(EnumType.STRING) mas já fica de aprendizado. 

public enum OrderStatus {
    WAITING_PAYMENT(0),
    PAID(1),
    SHIPPED(2),
    DELIVERED(3),
    CANCELED(4);

    private int  code;
    

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code){
        for (OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Order Status Code!");
    }
    

}
