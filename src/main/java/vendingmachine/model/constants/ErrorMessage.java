package vendingmachine.model.constants;

public class ErrorMessage {
    public static final String HOLDING_AMOUNT_OUT_OF_BOUNDS = "자판기 보유 금액은 0 이상이어야 합니다.";

    public static final String ITEM_PRICE_INVALID_MULTIPLE = "상품 가격은 10의 배수여야 합니다.";
    public static final String ITEM_PRICE_OUT_OF_BOUNDS = "상품 가격은 100원 이상이어야 합니다.";
    public static final String ITEM_QUANTITY_OUT_OF_BOUNDS = "상품 수량은 0 이상이어야 합니다.";

    public static final String ITEMS_TOTAL_QUANTITY_OUT_OF_BOUNDS = "판매 상품 총 수량은 1 이상이어야 합니다.";
    public static final String ITEMS_DUPLICATED_NAMES = "중복된 이름을 가진 상품을 등록할 수 없습니다.";
    public static final String ITEMS_NOT_FOUND = "해당 이름을 가진 상품을 찾을 수 없습니다.";

    public static final String INPUT_MONEY_OUT_OF_BOUNDS = "투입 금액은 0 이상이어야 합니다.";

    public static final String PURCHASE_SOLD_OUT = "상품의 수량이 0이어서 구매할 수 없습니다.";

}
