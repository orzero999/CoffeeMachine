import java.util.ArrayList;
import java.util.Arrays;

public class MoneyManager {
    static int[] change;
    static boolean checkMoney(ArrayList<Integer> cash, int price) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        // 금액이 충분한 경우
        if (cash.get(5) >= price) {
            change = calChange(cash.get(5) - price);
            if (checkChange(change)) {
                return true;
            } else {
                return false;
            }

        } else { // 금액이 모자란 경우
            return false;
        }
    }


    static int[] calChange(int input) {
        int[] change = new int[5];
        change[4] = input / 1000;
        change[3] = input % 1000 / 500;
        change[2] = input % 1000 % 500 / 100;
        change[1] = input % 1000 % 500 % 100 / 50;
        change[0] = input % 1000 % 500 % 100 % 50 / 10;
        return change;
    }

    static boolean checkChange(int[] change) {
        for (int i = 0; i < 5; i++) {
            if (MoneyStack.holdingMoney[i] < change[i]) {
                return false;
            }
        }
        return true;
    }

    static void returnChange(int[] change) {
        decreaseStack(change[0], change[1], change[2], change[3], change[4]);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        UserPanel.moneyOutlet.area.setText(String.format("10원:  %d개\n50원:  %d개\n100원: %d개\n500원: %d개\n1000원: %d개", change[0], change[1], change[2], change[3], change[4]));
    }

    static void increaseStack(int w10, int w50, int w100, int w500, int w1000) {
        MoneyStack.holdingMoney[0] += w10;
        MoneyStack.holdingMoney[1] += w50;
        MoneyStack.holdingMoney[2] += w100;
        MoneyStack.holdingMoney[3] += w500;
        MoneyStack.holdingMoney[4] += w1000;
        System.out.println("투입 후 MoneyStack: " + Arrays.toString(MoneyStack.holdingMoney));
    }

    static void decreaseStack(int w10, int w50, int w100, int w500, int w1000) {
        MoneyStack.holdingMoney[0] -= w10;
        MoneyStack.holdingMoney[1] -= w50;
        MoneyStack.holdingMoney[2] -= w100;
        MoneyStack.holdingMoney[3] -= w500;
        MoneyStack.holdingMoney[4] -= w1000;
        System.out.println("반환 후 MoneyStack: " + Arrays.toString(MoneyStack.holdingMoney));
    }
}

class MoneyStack {
    // 각각 보유하고 있는 10원, 50원, 100원, 500원, 1000원의 개수
    static int[] holdingMoney = {100, 100, 100, 100, 100};
}