package vendingmachine.constant;

public class ErrorMessage {
    // 자판기 설정, 금액 관련 오류
    public static final String INVALID_MACHINE_MONEY = "0 이상의 숫자로만 입력하여 주십시오.";
    public static final String INVALID_NUMBER_TYPE = "숫자로만 입력하여 주십시오.";
    public static final String INVALID_MONEY_UNIT = "10으로 나누어떨어지는 숫자로만 입력하여 주십시오.";

    // 상품 등록 관련 오류
    public static final String INVALID_PRODUCT_NAME = "상품명은 특수문자, 공백 없이 온전한 한글로만 입력하여 주십시오.";
    public static final String INVALID_PRODUCT_PRICE = "상품의 가격은 100원 이상의 금액으로만 설정 가능합니다.";
    public static final String INVALID_PRODUCT_DATA_FORM = "상품명(한글만 가능. 공백/특수문자 X), 가격(숫자), 수량(숫자)은 쉼표로, 개별 상품은 대괄호([])로 묶어 세미콜론(;)으로 구분하여 입력하여 주십시오.";
}
