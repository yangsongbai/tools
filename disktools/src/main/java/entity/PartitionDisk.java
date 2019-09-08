package entity;

/**
 * PartDisk 的主要职责:
 *
 * @ClassName PartDisk
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 17:26
 * @Version V1.0
 **/
public class PartitionDisk {
    private String displayName;
    private Size totalSize;
    private Size currentSize;
    private Size remainSize;
    private double percentRemain;

    public PartitionDisk() {
    }

    public PartitionDisk(Size totalSize, Size currentSize, Size remainSize) {
        this.totalSize = totalSize;
        this.currentSize = currentSize;
        this.remainSize = remainSize;
    }

    public PartitionDisk(String displayName, Size totalSize, Size currentSize, Size remainSize, double percentRemain) {
        this.displayName = displayName;
        this.totalSize = totalSize;
        this.currentSize = currentSize;
        this.remainSize = remainSize;
        this.percentRemain = percentRemain;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Size getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Size totalSize) {
        this.totalSize = totalSize;
    }

    public Size getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(Size currentSize) {
        this.currentSize = currentSize;
    }

    public Size getRemainSize() {
        return remainSize;
    }

    public void setRemainSize(Size remainSize) {
        this.remainSize = remainSize;
    }

    public double getPercentRemain() {
        return percentRemain;
    }

    public void setPercentRemain(double percentRemain) {
        this.percentRemain = percentRemain;
    }

    @Override
    public String toString() {
        return "PartitionDisk{" +
                "displayName='" + displayName + '\'' +
                ", totalSize=" + totalSize +
                ", currentSize=" + currentSize +
                ", remainSize=" + remainSize +
                ", percentRemain=" + percentRemain +
                '}';
    }
}
