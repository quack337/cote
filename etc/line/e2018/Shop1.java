package line.e2018;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Shop {
    int x, y;
    String name;
    int coupon;

    int distanceFromUser;
    static int userX, userY;

    public Shop(int x, int y, String name, int coupon) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.coupon = coupon;
        calcDistanceFromUser();
    }

    public static void setUserPosition(int userX, int userY) {
        Shop.userX = userX;
        Shop.userY = userY;
    }

    public void calcDistanceFromUser() {
        int t = (userX - x) * (userX - x) + (userY - y) * (userY - y);
        t = (int)Math.sqrt(t);
        this.distanceFromUser = (t / 100) * 100; // 백 미만 절삭
    }

    public int getDistanceFromUser() {
        return distanceFromUser;
    }

    public int getCouponCount() {
        return coupon;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d %d %s %d", x, y, name, coupon);
    }
}

class ShopComparator implements Comparator<Shop> {
    @Override
    public int compare(Shop s1, Shop s2) {
        int r = s1.getDistanceFromUser() - s2.getDistanceFromUser();
        if (r != 0) return r; // 오름차순
        r = s1.getCouponCount() - s2.getCouponCount();
        if (r != 0) return -r; // 내림차순
        return s1.getName().compareTo(s2.getName()); // 오름차순
    }
}

public class Shop1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int userX = scanner.nextInt();
            int userY = scanner.nextInt();
            int count = scanner.nextInt();
            Shop.setUserPosition(userX, userY);
            Shop[] a = new Shop[count];
            for (int i = 0; i < a.length; ++i) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String name = scanner.next();
                int coupon = scanner.nextInt();
                a[i] = new Shop(x, y, name, coupon);
            }
            Arrays.sort(a, new ShopComparator());
            for (Shop shop : a)
                System.out.println(shop);
        }
    }
}
