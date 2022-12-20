import java.util.Arrays;

//selection = {int water, int coffee, int cream, int sugar, int yulmu, int cocoa}
public class Manufacture {
    static void registerInput(int[] selection) {
        try {
            CupManager.getCup();
            Thread.sleep(1000);
            WaterManager.getWater(selection[0]);
            Thread.sleep(1000);
            IngredientManager.getIngredient(Arrays.copyOfRange(selection, 1, 6));
            Thread.sleep(3000);
            releaseDrink();
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }

    static void releaseDrink() {
        UserPanel.drinkOutlet.area.setText("""
            음료 배출구
                \\__/
                 \\_/
            """);
    }
}
