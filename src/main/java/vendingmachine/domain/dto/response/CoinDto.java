package vendingmachine.domain.dto.response;

public class CoinDto {
    private String name;
    private int cnt;

    public CoinDto(String koreanName, int cnt) {
        this.name = koreanName;
        this.cnt = cnt;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }
}
