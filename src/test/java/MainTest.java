import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by Jetflash on 26.05.2017.
 */
public class MainTest {

    Main tictactoe;

    @Before
    public void setUp() throws Exception {
        tictactoe = new Main();
    }

    /*По поводу тестов метода init(). Допустимы ли такие тесты или на каждую ячейку обязательно писать отдельный тест???
    Ведь в таком исполнение, как только будет найдена ячейка с ошибочным тестом, произойдёт выход иp метода теста и цикл
    не пройдет до конца все ячейки.
     */


    //Проверка работы метода инициализации игрового поля. Все ли ячейки пусты.
    @Test
    public void init_equals() throws Exception {
        tictactoe = new Main();
        for (int i = 0; i < tictactoe.sign.length; i++) {
            for (int j = 0; j < tictactoe.sign.length; j++) {
                Assert.assertEquals("Обнаружена col " + i + "; row " + j+ "; занята!", tictactoe.EMPTY, tictactoe.sign[i][j]);
            }
        }
    }
    //Проверка метода init, на условие, что ячейка может быть НЕ равна символу пустоты
    @Test
    public void init_NotEquals() throws Exception {
        tictactoe = new Main();
        //Как входные данные для теста используем символ первого игрока - крестик. Заполним им поле
        for (int i = 0; i < tictactoe.sign.length; i++) {
            for (int j = 0; j < tictactoe.sign.length; j++) {
                tictactoe.sign[i][j] = tictactoe.PlayerX;
            }
        }

        for (int i = 0; i < tictactoe.sign.length; i++) {
            for (int j = 0; j < tictactoe.sign.length; j++) {
                Assert.assertNotEquals("Найдена свободная ячейка: строка " + i + "; колонка " + j , tictactoe.EMPTY, tictactoe.sign[i][j]);
            }
        }
    }
    //Тест на корректную установку метки первым игроком
    @Test
    public void markFirstPlayer_true() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[1][4] = tictactoe.PlayerX;
        Assert.assertTrue("Не удалось поставить метку", tictactoe.markFirstPlayer(tictactoe.PlayerX, 1, 4));
    }
    //Тест на неккоретно установленную метку первым игроком
    @Test
    public void markFirstPlayer_false() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[1][4] = tictactoe.PlayerO;
        Assert.assertFalse("Метка установлена не смотря на условие!", tictactoe.markFirstPlayer(tictactoe.PlayerX, 1, 4));
    }

    //Тест на корректную установку метки вторым игроком
    @Test
    public void markSecondPlayer_true() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[2][5] = tictactoe.PlayerO;
        Assert.assertTrue("Не удалось поставить метку", tictactoe.markSecondPlayer(tictactoe.PlayerO, 2, 5));
    }
    //Тест на неккоретно установленную метку первым игроком
    @Test
    public void markSecondPlayer_false() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[2][5] = tictactoe.PlayerX;
        Assert.assertFalse("Метка установлена не смотря на условие!", tictactoe.markSecondPlayer(tictactoe.PlayerO, 2, 5));
    }


    @Test
    public void randomCell_true() throws Exception {
        tictactoe = new Main();
        tictactoe.randCol=10;
        tictactoe.randRow=10;
        tictactoe.sign[tictactoe.randCol][tictactoe.randRow] = tictactoe.PlayerX;
        Assert.assertTrue("Не удалось установить метку",tictactoe.RandomCell(tictactoe.PlayerX));
    }
    @Test
    public void randomCell_false() throws Exception {
        tictactoe = new Main();
        tictactoe.randCol=10;
        tictactoe.randRow=10;
        tictactoe.sign[tictactoe.randCol][tictactoe.randRow] = tictactoe.PlayerO;
        Assert.assertFalse("Метка установлена!",tictactoe.RandomCell(tictactoe.PlayerX));
    }

    @Test
    public void winCell_Equals() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[2][1] = tictactoe.PlayerX;
        tictactoe.sign[2][2] = tictactoe.PlayerX;
        tictactoe.sign[2][3] = tictactoe.PlayerX;
        tictactoe.sign[2][4] = tictactoe.EMPTY;
        tictactoe.count = 4;
        Assert.assertEquals("Не найдено комбинации", 4, tictactoe.WinCell(tictactoe.PlayerX));
    }
    @Test
    public void winCell_NotEquals() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[2][1] = tictactoe.PlayerX;
        tictactoe.sign[2][2] = tictactoe.PlayerX;
        tictactoe.count = 2;
        Assert.assertNotEquals("Комбинация найдена!", 4, tictactoe.WinCell(tictactoe.PlayerX));
    }

    @Test
    public void threeCell_Equals() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[2][1] = tictactoe.PlayerX;
        tictactoe.sign[2][2] = tictactoe.PlayerX;
        tictactoe.sign[2][4] = tictactoe.EMPTY;
        tictactoe.count = 3;
        Assert.assertEquals("Не найдено комбинации", 3, tictactoe.ThreeCell(tictactoe.PlayerX));
    }
    @Test
    public void threeCell_NotEquals() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[2][1] = tictactoe.PlayerX;
        tictactoe.sign[2][4] = tictactoe.EMPTY;
        tictactoe.count = 2;
        Assert.assertNotEquals("Комбинация найдена!", 3, tictactoe.ThreeCell(tictactoe.PlayerX));
    }

    @Test
    public void twoCell_Equals() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[2][1] = tictactoe.PlayerX;
        tictactoe.sign[2][4] = tictactoe.EMPTY;
        tictactoe.count = 2;
        Assert.assertEquals("Не найдено комбинации", 2, tictactoe.TwoCell(tictactoe.PlayerX));
    }
    @Test
    public void twoCell_NotEquals() throws Exception {
        tictactoe = new Main();
        tictactoe.sign[2][1] = tictactoe.PlayerO;
        tictactoe.sign[2][4] = tictactoe.EMPTY;
        tictactoe.count = 0;
        Assert.assertNotEquals("Символ найден!", 2, tictactoe.TwoCell(tictactoe.PlayerX));
    }
}