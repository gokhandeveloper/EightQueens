import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EightQueensTest {

    private static ChessBoard chessBoard;

    @BeforeEach
    public void setup () {
        chessBoard = new ChessBoard("7x7");
        chessBoard.create();
    }
    @Test
    public void chessBoardMustBe64() {
        Assertions.assertEquals(7, chessBoard.size());
    }

    @Test
    public void canPutOneQueenAtRow0Column0() throws Exception {
        chessBoard.putQueen("0x0");
        Assertions.assertTrue(chessBoard.hasQueenAt("0x0"));
    }

    @Test
    public void canNotPutOneQueenAtRow0Column0IfAlreadyExists() throws Exception {
        chessBoard.putQueen("0x0");
        Assertions.assertThrows(Exception.class, () -> {
            chessBoard.putQueen("0x0");
        });
    }

    @Test
    public void cannotPutMultipleQueensInTheSameRow() throws Exception {
        chessBoard.putQueen("0x0");
        Assertions.assertThrows(Exception.class, () -> {
            chessBoard.putQueen("0x2");
        });
    }
    @Test
    public void cannotPutMultipleQueensInTheSameColumn() throws Exception{
        chessBoard.putQueen("0x0");
        Assertions.assertThrows(Exception.class, () -> {
            chessBoard.putQueen("1x0");
        });
    }
    @Test
    public void findDiagonalCoordinatesOfAGivenArrayCoordinate() throws Exception{
        Assertions.assertEquals(9,chessBoard.findDiagonal("2x1").size());
        Assertions.assertEquals(7,chessBoard.findDiagonal("7x7").size());
        Assertions.assertEquals(13,chessBoard.findDiagonal("3x3").size());
        Assertions.assertEquals(13,chessBoard.findDiagonal("3x4").size());
        Assertions.assertEquals(7,chessBoard.findDiagonal("0x0").size());
        Assertions.assertEquals(7,chessBoard.findDiagonal("7x0").size());
        Assertions.assertEquals(7,chessBoard.findDiagonal("0x7").size());
    }
}
