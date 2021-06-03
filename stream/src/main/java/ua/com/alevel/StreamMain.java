package ua.com.alevel;

import java.math.BigDecimal;
import java.util.Optional;

public class StreamMain {

    public static void main(String[] args) {
        System.out.println("StreamMain.main");

        User from = new User();
        Optional<Balance> balance = Optional.of(new Balance());
        Optional<BigDecimal> bigDecimal = Optional.of(new BigDecimal("100"));
        balance.get().setPrice(bigDecimal);
        from.setBalance(balance);
//        Balance balance = new Balance();
//        from.setBalance(balance);
        User to = new User();
//        to.setBalance(balance);

        UserService userService = new UserService();
        userService.buy(from, to, new BigDecimal("100.00"));



//        StreamApi streamApi = new StreamApi();
//        streamApi.createStream();
//        streamApi.streamProcess();

//        ISum iSum = new ISumImpl();
//        int sum = iSum.sum(6, 9);
//        System.out.println("sum = " + sum);
//
//        ISum iSum1 = new ISum() {
//            @Override
//            public int sum(int a, int b) {
//                return 0;
//            }
//        };
//
//        ISum iSum2 = (int a, int b) -> {
//            return a + b;
//        };
//
//        ISum iSum3 = (a, b) -> {
//            return a + b;
//        };
//
//        ISum iSum4 = (a, b) -> a + b;
//
//        ISum iSum5 = Integer::sum;
//
//        IPrint iPrint = (s) -> System.out.println(s);
    }
}
