package main.enums;

/**
 * Category
 * @author DPain
 *
 */
public enum Category {
    // 8 Categories
    MONDAY(0),
    TUESDAY(1),
    WEDNESDAY(2),
    THURSDAY(3),
    FRIDAY(4),
    SATURDAY(5),
    SUNDAY(6),
    OTHER(7),
    UPCOMING(8);

    private final int param;

    Category(int param) {
        this.param = param;
    }

    public int getParam() {
        return param;
    }
}