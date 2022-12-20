import java.util.Arrays;

public class DataManager {
    // 순서대로 물, 커피, 크림, 설탕, 율무, 코코아, 컵의 재고량
    static int[] stockInformation = {34000, 1000, 1000, 1000, 1000, 1000, 350};

    static boolean checkInput(int[] recipe) {
        System.out.println("상품 제조 전 stockInformation: " + Arrays.toString(stockInformation));
        if (stockInformation[0] > recipe[0]
            && stockInformation[1] > recipe[1]
            && stockInformation[2] > recipe[2]
            && stockInformation[3] > recipe[3]
            && stockInformation[4] > recipe[4]
            && stockInformation[5] > recipe[5]
            && stockInformation[6] > 1
        ) return true;
        else return false;
    }

    // 재고 정보 업데이트
    static void updateStockInformation(int index, int input) {
        stockInformation[index] = input;
    }
}