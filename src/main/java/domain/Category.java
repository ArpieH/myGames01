package domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder

public class Category extends BasicEntity {
    private String categoryName;

    public Category(int anInt, String categoryName) {
        this.categoryName = categoryName;
    }
}
