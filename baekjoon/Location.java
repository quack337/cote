package baekjoon;
import java.util.Objects;

public class Location {
    int 행, 열, 거리;

    public Location(int 행, int 열, int 거리) {
        this.행 = 행;
        this.열 = 열;
        this.거리 = 거리;
    }

    @Override
    public int hashCode() {
        return Objects.hash(열, 행);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Location p = (Location) obj;
        return 열 == p.열 && 행 == p.행;
    }
}