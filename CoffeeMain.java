package coffee;

import java.util.Scanner;

public class CoffeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("커피머신으로 만들 수 있는 메뉴가 몇개나 되나요??");
        int n = scanner.nextInt();

        String [] coffeeName = new String[n];
        int [] coffeePrice = new int[n];
        int maxOrder = 3;
        int a = 0;
        String [] menuOrder = new String [maxOrder];
        int totalPrice = 0;

        for (int i = 0; i < coffeePrice.length; i++) {
            System.out.println("커피이름을 적어라");
            coffeeName[i] = scanner.next();
            System.out.println("커피 가격을 적어라");
            coffeePrice[i] = scanner.nextInt();
        }

        while (true){
            System.out.println("1번: 메뉴판 보기, 2번: 주문하기, 3번: 결제하기");
            int option = scanner.nextInt();

            if (option == 1){
                System.out.println("메뉴판을 보여 드리겠습니다.");
                for (int i = 0; i < coffeePrice.length; i++) {
                    System.out.println(coffeeName[i] + ": " + coffeePrice[i] + "원");
                }
                } else if ( option == 2) {
                System.out.println("메뉴는 최대 3개까지 주문가능합니다.");
                System.out.println("무엇을 주문하겠습니까? (1번: 주문, 2번: 주문완료)");
                    int order = scanner.nextInt();
                   while (true){
                       if (order == 1){
                           if (a < maxOrder){
                               System.out.println("메뉴를 고르세요.");
                               menuOrder[a] = scanner.next();
                               a++;
                               break;
                           } else {
                               System.out.println("더이상 메뉴를 추가할 수 없습니다.");
                               break;
                           }
                       }else if(order == 2){
                           System.out.println("주문이 완료되었습니다.");
                           for (String s : menuOrder) {
                               System.out.println(s);
                           }
                           break;
                       } else{
                           System.out.println("메뉴에 없습니다.");
                       }
                   }
            } else if (option == 3) {
                totalPrice = 0;
                for (String orderedItem : menuOrder) {
                    if (orderedItem != null) { // null 값 방지
                        for (int i = 0; i < coffeeName.length; i++) {
                            if (orderedItem.equals(coffeeName[i])) {
                                totalPrice += coffeePrice[i];

                            }
                        }
                    }
                }
                System.out.println("결제할 금액은: " + totalPrice + "원");
                break;
            } else {
                System.out.println("잘못골랐습니다.");

            }

        }
        }
    }


