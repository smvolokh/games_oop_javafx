package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {

    @Test
    void positionTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C1);
    }

    @Test
    void copyTest() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Figure copyOfBishopBlack = bishopBlack.copy(Cell.A2);
        assertThat(copyOfBishopBlack.position()).isEqualTo(Cell.A2);
    }

    @Test
    void wayTestIfIncorrectMove() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        assertThrows(ImpossibleMoveException.class,
                () -> bishopBlack.way(Cell.G1)
        );
    }

    @Test
    void wayTestIfCorrectMove() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.G5);
        assertThat(way).isEqualTo(new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }
}
