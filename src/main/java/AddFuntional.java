public class AddFuntional implements AddFunctionalInterface {

    public boolean RandomCell(String figure) {
        return Main.sign[Main.randCol][Main.randRow].equals(figure);
    }


    public int WinCell(String figure) {
        return Main.count;
    }
}
