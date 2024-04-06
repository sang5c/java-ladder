package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @DisplayName("좌 우 모두 이동 가능한 Point는 생성할 수 없다")
    @Test
    void invalidPoint() {
        assertThatThrownBy(() -> new Point(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Point는 좌 우 이동 가능 여부를 가진다")
    @ParameterizedTest(name = "좌 이동: {0}, 우 이동: {1})")
    @CsvSource(value = {"true,false", "false,true", "false,false"})
    void create(boolean left, boolean right) {
        Point point = new Point(left, right);

        assertThat(point.canMoveLeft()).isEqualTo(left);
        assertThat(point.canMoveRight()).isEqualTo(right);
    }

}
