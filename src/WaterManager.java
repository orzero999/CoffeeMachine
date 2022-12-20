public class WaterManager {
    static void getWater(int requiredWater) {
        WaterContainer.amount -= requiredWater;

        // 데이터매니저의 재고 정보 업데이트
        DataManager.updateStockInformation(0, WaterContainer.amount);
        System.out.println("제조 후 남은 물의 양: " + WaterContainer.amount);
    }
}

class CoilHeater {
    void heat() {
    }
    void checkTemperature() {
    }
}

class WaterContainer {
    static int amount = 34000;
    int temperature;
}
