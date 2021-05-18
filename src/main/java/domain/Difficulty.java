package domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class Difficulty extends BasicEntity{
    private String difficultyName;


        public Difficulty(int id, String difficultyName) {
            super(id);
            this.difficultyName = difficultyName;
        }
}
