package pliki;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BoardTest {

    private Board board;
    @BeforeEach
    public void setBoard()
    {
        List<Wspolrzedne> zywe=new ArrayList<>();
        zywe.add(new Wspolrzedne(0,0));
        zywe.add(new Wspolrzedne(0,1));
        zywe.add(new Wspolrzedne(1,2));
        zywe.add(new Wspolrzedne(2,2));
        zywe.add(new Wspolrzedne(0,3));
        zywe.add(new Wspolrzedne(2,3));
        zywe.add(new Wspolrzedne(1,4));
        zywe.add(new Wspolrzedne(2,4));
        zywe.add(new Wspolrzedne(3,4));
        board=new Board(5,7,zywe);
    }

    @Test
    public void testCount()
    {
        Assertions.assertEquals(1,board.count(0,0));
        Assertions.assertEquals(2,board.count(0,3));
        Assertions.assertEquals(5,board.count(2,3));
    }

    @Test
    public void testStan()
    {
        board.aktualizacja();
        Assertions.assertEquals(false,board.getStan(0,0));
        Assertions.assertEquals(true,board.getStan(0,3));
        Assertions.assertEquals(false,board.getStan(2,3));
        Assertions.assertEquals(true,board.getStan(2,5));
    }
}
