package vendingmachine.view.constants;

import java.util.regex.Pattern;

public class InputFormat {
    public static final String ITEMS_DELIMITER = ";";
    public static final String ITEM_PROPERTY_DELIMITER = ",";
    public static final Pattern ITEM_PATTERN = Pattern.compile("^(\\[)(([ㄱ-ㅎ|가-힣a-zA-Z0-9]+),\\d+,\\d+)(])$");
}
