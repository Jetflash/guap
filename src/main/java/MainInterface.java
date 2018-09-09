/**
 * Created by Jetflash on 25.05.2017.
 */
public interface MainInterface {


        void init();

        boolean markFirstPlayer(String figure, int col, int row);

        boolean markSecondPlayer(String figure, int col, int row);

        boolean RandomCell(String figure);

        int WinCell(String figure);

        int ThreeCell(String figure);

        int TwoCell(String figure);


}