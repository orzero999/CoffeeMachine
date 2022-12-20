public class CupManager {
    static void getCup() {
        CupStack.cupCount -= 1;
        DataManager.updateStockInformation(6, CupStack.cupCount);
        UserPanel.drinkOutlet.area.setText("""
            음료 배출구
                \\    /
                 \\_/
            """);
        System.out.println("제조 후 컵 보유량: " + CupStack.cupCount);
    }
}

class CupStack {
    static int cupCount = 350;
}