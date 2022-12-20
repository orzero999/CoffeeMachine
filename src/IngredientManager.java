public class IngredientManager {
    //requiredIngredient(int coffee, int cream, int sugar, int yulmu, int cocoa)
    static void getIngredient(int[] requiredIngredient) {
        CoffeeHolder.coffeeAmount -= requiredIngredient[0];
        CreamHolder.creamAmount -= requiredIngredient[1];
        SugarHolder.sugarAmount -= requiredIngredient[2];
        YulmuHolder.yulmuAmount -= requiredIngredient[3];
        CocoaHolder.cocoaAmount -= requiredIngredient[4];

        // 데이터매니저의 재고 정보 업데이트
        DataManager.updateStockInformation(1, CoffeeHolder.coffeeAmount);
        DataManager.updateStockInformation(2, CreamHolder.creamAmount);
        DataManager.updateStockInformation(3, SugarHolder.sugarAmount);
        DataManager.updateStockInformation(4, YulmuHolder.yulmuAmount);
        DataManager.updateStockInformation(5, CocoaHolder.cocoaAmount);

        System.out.println("제조 후 남은 커피 양: " + CoffeeHolder.coffeeAmount);
        System.out.println("제조 후 남은 크림 양: " + CreamHolder.creamAmount);
        System.out.println("제조 후 남은 설탕 양: " + SugarHolder.sugarAmount);
        System.out.println("제조 후 남은 율무차 양: " + YulmuHolder.yulmuAmount);
        System.out.println("제조 후 남은 코코아 양: " + CocoaHolder.cocoaAmount);
    }
}

class IngredientHolder {

}

class CoffeeHolder extends IngredientHolder {
    static int coffeeAmount = 1000; // 단위는 gram
}

class CreamHolder extends IngredientHolder {
    static int creamAmount = 1000; // 단위는 gram
}

class SugarHolder extends IngredientHolder {
    static int sugarAmount = 1000; // 단위는 gram
}

class YulmuHolder extends IngredientHolder {
    static int yulmuAmount = 1000; // 단위는 gram
}

class CocoaHolder extends IngredientHolder {
    static int cocoaAmount = 1000; // 단위는 gram
}
