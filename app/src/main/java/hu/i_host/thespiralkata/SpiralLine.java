package hu.i_host.thespiralkata;

public class SpiralLine {

    private int mStartX;
    private int mStartY;
    private int mLength;

    public SpiralLine() {
        init();
    }

    int getStartX() {
        return mStartX;
    }

    int getStartY() {
        return mStartY;
    }

    int getLength() {
        return mLength;
    }

    void down(int[][] matrix) {
        int i = 0;

        for (; i < mLength; i++) {
            matrix[mStartY + i][mStartX] = 0;
        }

        // -1 because of the loop variable
        setLastXY(mStartX, mStartY + (i - 1));
    }

    void up(int[][] matrix) {
        int i = 0;

        for (;i < mLength; i++) {
            matrix[mStartY - i][mStartX] = 0;
        }

        // -1 because of the loop variable
        setLastXY(mStartX, mStartY - (i - 1));
    }

    void left(int[][] matrix) {
        int i = 0;

        for (; i < mLength; i++) {
            matrix[mStartY][mStartX - i] = 0;
        }

        // -1 because of the loop variable
        setLastXY(mStartX - (i - 1), mStartY);
    }

    void right(int[][] matrix) {
        int i = 0;

        for (; i < mLength; i++) {
            matrix[mStartY][mStartX + i] = 0;
        }

        // -1 because of the loop variable
        setLastXY(mStartX + (i - 1), mStartY);
    }

    private void setLastXY(int x, int y) {
        mStartX = x;
        mStartY = y;
    }

    void setLength(int length) {
        mLength = length;
    }

    void init() {
        mStartX = 0;
        mStartY = 1;
        mLength = 0;
    }
}
