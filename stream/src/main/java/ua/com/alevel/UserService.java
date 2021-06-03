package ua.com.alevel;

import java.math.BigDecimal;

public class UserService {

    public void buy(User from, User to, BigDecimal sum) {

        Balance balance = from.getBalance().orElseThrow(() -> new RuntimeException("дурак!"));
        BigDecimal price = balance.getPrice().orElse(new BigDecimal("100"));







        if (from.getBalance().isPresent() && to.getBalance().isPresent()) {

        }


//        if (from.getBalance().getPrice() != null && to.getBalance().getPrice() != null) {
//            System.out.println("from.getBalance().getPrice() = " + from.getBalance().getPrice());
//            BigDecimal subtract = from.getBalance().getPrice().subtract(sum);
//            to.getBalance().getPrice().add(subtract);
//        }
//
//        Balance balanceFrom = from.getBalance();
//        Balance balanceTo = to.getBalance();
//
//        if (balanceFrom != null && balanceTo != null) {
//            BigDecimal sumFrom = balanceFrom.getPrice();
//            BigDecimal sumTo = balanceTo.getPrice();
//            if (sumFrom != null && sumTo != null) {
//                System.out.println("calculate");
//            } else {
//                System.out.println("not calculate");
//            }
//        } else {
//            System.out.println("not calculate");
//        }
    }
}
