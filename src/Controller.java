import java.util.ArrayList;

public class Controller {
    // 사용자가 선택한 옵션과 투입한 금액을 받아옴
    static void getUserInput(DrinkButton selection, ArrayList<Integer> cash) {
        Thread ctrlThread = new Thread(() -> {
            try {
                System.out.println("주문 프로세스 시작");
                MoneyManager.increaseStack(cash.get(0), cash.get(1), cash.get(2), cash.get(3), cash.get(4));
                // 상품 주문 가능
                if(MoneyManager.checkMoney(cash, selection.getPrice()) && DataManager.checkInput(selection.getRecipe())) {
                    Thread.sleep(2000);
                    Manufacture.registerInput(selection.getRecipe());
                    MoneyManager.returnChange(MoneyManager.change);
                    UserPanel.screen.area.setText("음료와 거스름돈을 받아가세요");
                }
                // 재고 부족 -> 상품 주문 불가능
                else if (MoneyManager.checkMoney(cash, selection.getPrice()) && !DataManager.checkInput(selection.getRecipe())) {
                    System.out.println("재고가 부족합니다");
                    UserPanel.screen.area.setText("상품 품절\n투입한 돈을 받아가세요");
                    int[] input = {cash.get(0), cash.get(1), cash.get(2), cash.get(3), cash.get(4)};
                    MoneyManager.returnChange(input); // 투입한 금액 반환
                }
                // 금액 부족 -> 상품 주문 불가능
                else if (!MoneyManager.checkMoney(cash, selection.getPrice()) && DataManager.checkInput(selection.getRecipe())) {
                    System.out.println("금액 또는 거스름돈이 부족합니다");
                    UserPanel.screen.area.setText("금액 또는 거스름돈 부족\n투입한 돈을 받아가세요");
                    int[] input = {cash.get(0), cash.get(1), cash.get(2), cash.get(3), cash.get(4)};
                    MoneyManager.returnChange(input); // 투입한 금액 반환
                }
                // 재고&금액 부족 -> 상품 주문 불가능
                else {
                    System.out.println("재고 및 금액 또는 거스름돈이 부족합니다");
                    UserPanel.screen.area.setText("상품 품절\n금액 또는 거스름돈 부족\n투입한 돈을 받아가세요");
                    int[] input = {cash.get(0), cash.get(1), cash.get(2), cash.get(3), cash.get(4)};
                    MoneyManager.returnChange(input); // 투입한 금액 반환
                }
                Thread.sleep(5000);

                // 새로 상품을 받을 준비
                UserPanel.screen.area.setText("");
                UserPanel.drinkOutlet.area.setText("음료 배출구");
                UserPanel.moneyOutlet.area.setText("10원: \n50원: \n100원: \n500원: \n1000원: ");
            } catch (InterruptedException e) {
            }
        });
        ctrlThread.start();

    }
}
