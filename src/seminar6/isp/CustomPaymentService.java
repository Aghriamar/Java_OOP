package seminar6.isp;

public class CustomPaymentService extends BasePaymentService implements PayableCreditCard, PayableWebMoney {
    @Override
    public void payWebMoney(int amount) {
        System.out.printf("Custom service pay by web money %d\n", amount);
    }

    @Override
    public void payCreditCard(int amount) {
        System.out.printf("Custom service pay by credit card %d\n", amount);
    }
}
