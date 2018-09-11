//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    Main tictactoe;
    AddFuntional newfunc;

    public MainTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.tictactoe = new Main();
    }

    @Test
    public void init_equals() throws Exception {
        this.tictactoe = new Main();

        for(int i = 0; i < this.tictactoe.sign.length; ++i) {
            for(int j = 0; j < this.tictactoe.sign.length; ++j) {
                Assert.assertEquals("Обнаружена col " + i + "; row " + j + "; занята!", this.tictactoe.EMPTY, this.tictactoe.sign[i][j]);
            }
        }

    }

    @Test
    public void init_NotEquals() throws Exception {
        this.tictactoe = new Main();

        int i;
        int j;
        for(i = 0; i < this.tictactoe.sign.length; ++i) {
            for(j = 0; j < this.tictactoe.sign.length; ++j) {
                this.tictactoe.sign[i][j] = this.tictactoe.PlayerX;
            }
        }

        for(i = 0; i < this.tictactoe.sign.length; ++i) {
            for(j = 0; j < this.tictactoe.sign.length; ++j) {
                Assert.assertNotEquals("Найдена свободная ячейка: строка " + i + "; колонка " + j, this.tictactoe.EMPTY, this.tictactoe.sign[i][j]);
            }
        }

    }

    @Test
    public void markFirstPlayer_true() throws Exception {
        this.tictactoe = new Main();
        this.tictactoe.sign[1][4] = this.tictactoe.PlayerX;
        Assert.assertTrue("Не удалось поставить метку", this.tictactoe.markFirstPlayer(this.tictactoe.PlayerX, 1, 4));
    }

    @Test
    public void markFirstPlayer_false() throws Exception {
        this.tictactoe = new Main();
        this.tictactoe.sign[1][4] = this.tictactoe.PlayerO;
        Assert.assertFalse("Метка установлена не смотря на условие!", this.tictactoe.markFirstPlayer(this.tictactoe.PlayerX, 1, 4));
    }

    @Test
    public void markSecondPlayer_true() throws Exception {
        this.tictactoe = new Main();
        this.tictactoe.sign[2][5] = this.tictactoe.PlayerO;
        Assert.assertTrue("Не удалось поставить метку", this.tictactoe.markSecondPlayer(this.tictactoe.PlayerO, 2, 5));
    }

    @Test
    public void markSecondPlayer_false() throws Exception {
        this.tictactoe = new Main();
        this.tictactoe.sign[2][5] = this.tictactoe.PlayerX;
        Assert.assertFalse("Метка установлена не смотря на условие!", this.tictactoe.markSecondPlayer(this.tictactoe.PlayerO, 2, 5));
    }

    @Test
    public void randomCell_true() throws Exception {
        this.tictactoe = new Main();
        this.newfunc = new AddFuntional();
        this.tictactoe.randCol = 10;
        this.tictactoe.randRow = 10;
        this.tictactoe.sign[this.tictactoe.randCol][this.tictactoe.randRow] = this.tictactoe.PlayerX;
        Assert.assertTrue("Не удалось установить метку", this.newfunc.RandomCell(this.tictactoe.PlayerX));
    }

    @Test
    public void randomCell_false() throws Exception {
        this.tictactoe = new Main();
        this.newfunc = new AddFuntional();
        this.tictactoe.randCol = 10;
        this.tictactoe.randRow = 10;
        this.tictactoe.sign[this.tictactoe.randCol][this.tictactoe.randRow] = this.tictactoe.PlayerO;
        Assert.assertFalse("Метка установлена!", this.newfunc.RandomCell(this.tictactoe.PlayerX));
    }

    @Test
    public void winCell_Equals() throws Exception {
        this.tictactoe = new Main();
        this.newfunc = new AddFuntional();
        this.tictactoe.sign[2][1] = this.tictactoe.PlayerX;
        this.tictactoe.sign[2][2] = this.tictactoe.PlayerX;
        this.tictactoe.sign[2][3] = this.tictactoe.PlayerX;
        this.tictactoe.sign[2][4] = this.tictactoe.EMPTY;
        this.tictactoe.count = 4;
        Assert.assertEquals("Не найдено комбинации", 4L, (long)this.newfunc.WinCell(this.tictactoe.PlayerX));
    }

    @Test
    public void winCell_NotEquals() throws Exception {
        this.tictactoe = new Main();
        this.newfunc = new AddFuntional();
        this.tictactoe.sign[2][1] = this.tictactoe.PlayerX;
        this.tictactoe.sign[2][2] = this.tictactoe.PlayerX;
        this.tictactoe.count = 2;
        Assert.assertNotEquals("Комбинация найдена!", 4L, (long)this.newfunc.WinCell(this.tictactoe.PlayerX));
    }

    @Test
    public void threeCell_Equals() throws Exception {
        this.tictactoe = new Main();
        this.tictactoe.sign[2][1] = this.tictactoe.PlayerX;
        this.tictactoe.sign[2][2] = this.tictactoe.PlayerX;
        this.tictactoe.sign[2][4] = this.tictactoe.EMPTY;
        this.tictactoe.count = 3;
        Assert.assertEquals("Не найдено комбинации", 3L, (long)this.tictactoe.ThreeCell(this.tictactoe.PlayerX));
    }

    @Test
    public void threeCell_NotEquals() throws Exception {
        this.tictactoe = new Main();
        this.tictactoe.sign[2][1] = this.tictactoe.PlayerX;
        this.tictactoe.sign[2][4] = this.tictactoe.EMPTY;
        this.tictactoe.count = 2;
        Assert.assertNotEquals("Комбинация найдена!", 3L, (long)this.tictactoe.ThreeCell(this.tictactoe.PlayerX));
    }

    @Test
    public void twoCell_Equals() throws Exception {
        this.tictactoe = new Main();
        this.tictactoe.sign[2][1] = this.tictactoe.PlayerX;
        this.tictactoe.sign[2][4] = this.tictactoe.EMPTY;
        this.tictactoe.count = 2;
        Assert.assertEquals("Не найдено комбинации", 2L, (long)this.tictactoe.TwoCell(this.tictactoe.PlayerX));
    }

    @Test
    public void twoCell_NotEquals() throws Exception {
        this.tictactoe = new Main();
        this.tictactoe.sign[2][1] = this.tictactoe.PlayerO;
        this.tictactoe.sign[2][4] = this.tictactoe.EMPTY;
        this.tictactoe.count = 0;
        Assert.assertNotEquals("Символ найден!", 2L, (long)this.tictactoe.TwoCell(this.tictactoe.PlayerX));
    }
}
