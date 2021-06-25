import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChessBoard {
    private String rowsAndColumns;
    private int[][] board;

    public ChessBoard(String s) {
        rowsAndColumns= s;
    }

    public void create() {
        int row = Character.getNumericValue(rowsAndColumns.charAt(0));
        int column = Character.getNumericValue(rowsAndColumns.charAt(2));
        board = new int[row][column];
    }

    public boolean hasQueenAt(String i) {
        int row = Character.getNumericValue(i.charAt(0));
        int column = Character.getNumericValue(i.charAt(2));
        if( board[row][column]==1 ) return true;
        else {
            return false;
        }
    }

    public void putQueen(String s) throws Exception {
        int row = Character.getNumericValue(s.charAt(0));
        int column = Character.getNumericValue(s.charAt(2));
        if(board[row][column]==1) {
            throw new Exception("Queen Already exists");
        }
    }

    private boolean coordinateGivenIsDiagonal(int row, int column) {
        String string = row + "x" + column;
        findDiagonal(string);
        return true;
    }

    public int size() {
        return board.length;
    }

    public List<String> findDiagonal(String s) {
        int row = Character.getNumericValue(s.charAt(0));
        int column = Character.getNumericValue(s.charAt(2));
        List<String> newList = Stream.concat(goUpRightDiagonal(row,column).stream(),
                goDownRightDiagonal(row,column).stream())
                .collect(Collectors.toList());
        List<String> newList2 = Stream.concat(newList.stream(),
                goUpLeftDiagonal(row,column).stream())
                .collect(Collectors.toList());
        List<String> newList3 = Stream.concat(newList2.stream(),
                goDownLeftDiagonal(row,column).stream())
                .collect(Collectors.toList());
        return newList3;
    }

    private List<String> goUpRightDiagonal(int row, int column) {
        List<String> list= new ArrayList<>();
        while(row<= board.length && column<= board.length) {
            row--;
            column++;
            if(row>=0&& row<= board.length && column<=board.length) {
                    String string = row + "xgoUpRight" + column;
                    list.add(string);
            }
        }
        return list;
    }

    private List<String> goUpLeftDiagonal(int row, int column) {
        List<String> list= new ArrayList<>();
        while(row<= board.length && column<=board.length) {
            row--;
            column--;
            if(row>=0&& column>=0&& row<= board.length && column<=board.length ) {
                String string = row + "xgoUpLeft" + column;
                list.add(string);
            }
        }
        return list;
    }

    private List<String> goDownRightDiagonal(int row, int column) {
        List<String> list= new ArrayList<>();
        while(row< board.length && column< board.length) {
            row++;
            column++;
            String string = row + "xgoDownRight" + column;
            list.add(string);

        }
        return list;
    }

    private List<String> goDownLeftDiagonal(int row, int column) {
        List<String> list= new ArrayList<>();
        while(row<= board.length && column<= board.length) {
            row++;
            column--;
            if(row>=0&& column>=0 && row<= board.length && column<=board.length ) {
                String string = row + "xgoDownLeft" + column;
                list.add(string);
            }
        }
        return list;

    }

    public int[][] get() {
        return board;
    }
}
