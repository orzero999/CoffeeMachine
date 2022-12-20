import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserPanel extends JFrame {
    static DrinkOutlet drinkOutlet;
    static Screen screen;
    static MoneyOutlet moneyOutlet;

    // cash = [10원 개수, 50원 개수, 100원 개수, 500원 개수, 1000원 개수, 총 투입 금액]
    ArrayList<Integer> cash = new ArrayList<>();

    // 메인 메서드
    public static void main(String[] args) {
        new UserPanel();
    }

    public UserPanel() throws HeadlessException {
        setTitle("커피자판기");
        showUserPanel();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 450);
        setVisible(true);
    }

    void showUserPanel() {
        // 음료 버튼, 음료 배출구
        JPanel leftPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel drinkPanel = new JPanel();
        drinkPanel.setLayout(new BoxLayout(drinkPanel, BoxLayout.Y_AXIS));
        JLabel[] drinkType = {new JLabel("고급커피"), new JLabel("특수커피"), new JLabel("일반커피"), new JLabel("우리차")};
        for ( JLabel label : drinkType) {
            label.setPreferredSize(new Dimension(50, 30));
        }


        // 고급커피 버튼 추가
        JPanel classyCoffeePanel = new JPanel();
        DrinkButton[] classyCoffeeButtons = {new ClassyCoffeeButton("밀크커피"), new ClassyCoffeeButton("설탕커피"), new ClassyCoffeeButton("블랙커피")};

        classyCoffeeButtons[0].setRecipe(100, 20, 20, 20, 0, 0);
        classyCoffeeButtons[1].setRecipe(100, 20, 0, 20, 0, 0);
        classyCoffeeButtons[2].setRecipe(100, 20, 0, 0, 0, 0);

        // 이벤트 리스너 추가 - 컨트롤러에 입력 전달
        for ( DrinkButton classyBtn : classyCoffeeButtons ) {
            classyBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (cash.size() > 0) {
                        Controller.getUserInput(classyBtn, cash);
                        screen.area.append("선택음료: " + classyBtn.getName() + "\n");
                    } else {
                        screen.area.setText("먼저 돈을 투입해주세요\n");
                    }
                }
            });
        }

        classyCoffeePanel.add(drinkType[0]);
        classyCoffeePanel.add(classyCoffeeButtons[0]); // 고급 밀크커피
        classyCoffeePanel.add(classyCoffeeButtons[1]); // 고급 설탕커피
        classyCoffeePanel.add(classyCoffeeButtons[2]); // 고급 블랙커피


        // 특수커피 버튼 추가
        JPanel specialCoffeePanel = new JPanel();
        DrinkButton[] specialCoffeeButtons = {new SpecialCoffeeButton("아메리카노"), new SpecialCoffeeButton("카페오레"), new SpecialCoffeeButton("디럭스")};

        specialCoffeeButtons[0].setRecipe(100, 30, 0, 0, 0, 0);
        specialCoffeeButtons[1].setRecipe(100, 20, 30, 20, 0, 0);
        specialCoffeeButtons[2].setRecipe(100, 30, 30, 30, 0, 0);

        // 이벤트 리스너 추가 - 컨트롤러에 입력 전달
        for ( DrinkButton specialBtn : specialCoffeeButtons ) {
            specialBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (cash.size() > 0) {
                        Controller.getUserInput(specialBtn, cash);
                        screen.area.append("선택음료: " + specialBtn.getName() + "\n");
                    } else {
                        screen.area.setText("먼저 돈을 투입해주세요\n");
                    }
                }
            });
        }

        specialCoffeePanel.add(drinkType[1]);
        specialCoffeePanel.add(specialCoffeeButtons[0]); // 아메리카노
        specialCoffeePanel.add(specialCoffeeButtons[1]); // 카페오레
        specialCoffeePanel.add(specialCoffeeButtons[2]); // 디럭스


        // 일반커피 버튼 추가
        JPanel plainCoffeePanel = new JPanel();
        DrinkButton[] plainCoffeeButtons = {new PlainCoffeeButton("밀크커피"), new PlainCoffeeButton("설탕커피"), new PlainCoffeeButton("블랙커피")};

        plainCoffeeButtons[0].setRecipe(100, 15, 15, 15, 0, 0);
        plainCoffeeButtons[1].setRecipe(100, 15, 0, 15, 0, 0);
        plainCoffeeButtons[2].setRecipe(100, 15, 0, 0, 0, 0);

        // 이벤트 리스너 추가 - 컨트롤러에 입력 전달
        for ( DrinkButton plainBtn : plainCoffeeButtons ) {
            plainBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (cash.size() > 0) {
                        Controller.getUserInput(plainBtn, cash);
                        screen.area.append("선택음료: " + plainBtn.getName() + "\n");
                    } else {
                        screen.area.setText("먼저 돈을 투입해주세요\n");
                    }
                }
            });
        }

        plainCoffeePanel.add(drinkType[2]);
        plainCoffeePanel.add(plainCoffeeButtons[0]); // 일반 밀크커피
        plainCoffeePanel.add(plainCoffeeButtons[1]); // 일반 설탕커피
        plainCoffeePanel.add(plainCoffeeButtons[2]); // 일반 블랙커피


        // 우리차 버튼 추가
        JPanel teaPanel = new JPanel();
        DrinkButton[] teaButtons = {new TeaButton("우유"), new TeaButton("율무차"), new TeaButton("코코아")};

        teaButtons[0].setRecipe(100, 0, 20, 20, 0, 0);
        teaButtons[1].setRecipe(100, 0, 0, 0, 20, 0);
        teaButtons[2].setRecipe(100, 0, 0, 0, 0, 30);

        // 이벤트 리스너 추가 - 컨트롤러에 입력 전달
        for ( DrinkButton teaBtn : teaButtons ) {
            teaBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (cash.size() > 0) {
                        Controller.getUserInput(teaBtn, cash);
                        screen.area.append("선택음료: " + teaBtn.getName() + "\n");
                    } else {
                        screen.area.setText("먼저 돈을 투입해주세요\n");
                    }
                }
            });
        }

        teaPanel.add(drinkType[3]);
        teaPanel.add(teaButtons[0]); // 우유
        teaPanel.add(teaButtons[1]); // 율무차
        teaPanel.add(teaButtons[2]); // 코코아

        // 패널에 등록
        drinkPanel.add(classyCoffeePanel);
        drinkPanel.add(specialCoffeePanel);
        drinkPanel.add(plainCoffeePanel);
        drinkPanel.add(teaPanel);
        leftPanel.add(drinkPanel);

        // 음료 배출구 추가
        JPanel drinkOutletPanel = new JPanel();
        drinkOutlet = new DrinkOutlet();
        drinkOutletPanel.add(drinkOutlet.area);
        leftPanel.add(drinkOutletPanel);

        // 스크린, 슬롯, 취소 버튼, 동전 반환구
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        // 스크린 추가
        JPanel screenPanel = new JPanel();
        screen = new Screen();
        screenPanel.add(screen.area);
        rightPanel.add(screenPanel);

        // 슬롯 추가
        JPanel slotPanel = new JPanel();
        slotPanel.setLayout(new BoxLayout(slotPanel, BoxLayout.Y_AXIS));
        JPanel slotsPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        JPanel insertButtonPanel = new JPanel();

        Slot[] slots = {new Slot(10), new Slot(50), new Slot(100), new Slot(500), new Slot(1000)};
        JButton insertButton = new JButton("투입");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cashSum = 0;

                for (Slot slot : slots) {
                    cashSum += slot.insertCash();
                    cash.add(Integer.parseInt(slot.slotTextField.getText()));
                    slot.slotTextField.setText("0");
                }
                // cash = [10원 개수, 50원 개수, 100원 개수, 500원 개수, 1000원 개수, 총 투입 금액]
                cash.add(cashSum);

                screen.area.setText("");
                screen.area.append("투입금액: " + cashSum + "\n");
            }
        });

        slotsPanel.add(slots[0].slotLabel); slotsPanel.add(slots[0].slotTextField);
        slotsPanel.add(slots[1].slotLabel); slotsPanel.add(slots[1].slotTextField);
        slotsPanel.add(slots[2].slotLabel); slotsPanel.add(slots[2].slotTextField);
        slotsPanel.add(slots[3].slotLabel); slotsPanel.add(slots[3].slotTextField);
        slotsPanel.add(slots[4].slotLabel); slotsPanel.add(slots[4].slotTextField);

        insertButtonPanel.add(insertButton);

        slotPanel.add(slotsPanel);
        slotPanel.add(insertButtonPanel);

        rightPanel.add(slotPanel);

        // 취소 버튼 추가
        JPanel cancelButtonPanel = new JPanel();
        JButton cancelButton = new CancelButton();
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelButton.cancel();
            }
        });
        cancelButtonPanel.add(cancelButton);
        rightPanel.add(cancelButtonPanel);


        // 현금 반환구 추가
        JPanel moneyOutletPanel = new JPanel();
        moneyOutlet = new MoneyOutlet();
        moneyOutletPanel.add(moneyOutlet.area);
        rightPanel.add(moneyOutletPanel);



        add("West", leftPanel);
        add("East", rightPanel);
    }
}

class CancelButton extends JButton {
    public CancelButton() {
        setText("취소");
        setPreferredSize(new Dimension(60, 30));
    }
    static void cancel() {
    }
}

class DrinkButton extends JButton {
    String name;
    int price;
    int water, coffee, cream, sugar, yulmu, cocoa;
    int[] recipe = {water, coffee, cream, sugar, yulmu, cocoa};

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setRecipe(int water, int coffee, int cream, int sugar, int yulmu, int cocoa) {
        recipe[0] = water;
        recipe[1] = coffee;
        recipe[2] = cream;
        recipe[3] = sugar;
        recipe[4] = yulmu;
        recipe[5] = cocoa;
    }

    public int[] getRecipe() {
        return recipe;
    }
}

// 고급커피
class ClassyCoffeeButton extends DrinkButton {
    public ClassyCoffeeButton(String name) {
        this.name = name;
        this.price = 500;

        setText("<html><body style = 'text-align: center;'>"+name+"<br>"+price+"원</body></html>");
        setPreferredSize(new Dimension(100, 40));
    }
}

// 특수커피
class SpecialCoffeeButton extends DrinkButton {
    public SpecialCoffeeButton(String name) {
        this.name = name;
        this.price = 500;

        setText("<html><body style = 'text-align: center;'>"+name+"<br>"+price+"원</body></html>");
        setPreferredSize(new Dimension(100, 40));
    }
}

// 일반커피
class PlainCoffeeButton extends DrinkButton {
    public PlainCoffeeButton(String name) {
        this.name = name;
        this.price = 300;

        setText("<html><body style = 'text-align: center;'>"+name+"<br>"+price+"원</body></html>");
        setPreferredSize(new Dimension(100, 40));
    }
}

// 우리차
class TeaButton extends DrinkButton {
    public TeaButton(String name) {
        this.name = name;
        this.price = 300;

        setText("<html><body style = 'text-align: center;'>"+name+"<br>"+price+"원</body></html>");
        setPreferredSize(new Dimension(100, 40));
    }
}

class Screen {
    JTextArea area;

    public Screen() {
        area = new JTextArea(4, 20);
        area.setText("");
        area.setEditable(false);
    }
}

class MoneyOutlet{
    JTextArea area;

    public MoneyOutlet() {
        area = new JTextArea(4, 20);
        area.setText("10원: \n50원: \n100원: \n500원: \n1000원: ");
        area.setEditable(false);
    }
}

class Slot {
    int moneyUnit, inputCash;
    JLabel slotLabel;
    JTextField slotTextField;

    public Slot(int moneyUnit) {
        this.moneyUnit = moneyUnit;
        slotLabel = new JLabel(Integer.toString(moneyUnit));
        slotTextField = new JTextField("0");
    }

    int insertCash(){
        inputCash = Integer.parseInt(slotLabel.getText()) * Integer.parseInt(slotTextField.getText());
        return inputCash;
    }

}

class DrinkOutlet {
    JTextArea area;

    public DrinkOutlet() {
        area = new JTextArea(4, 20);
        area.setText("음료 배출구");
        area.setEditable(false);
    }
}

