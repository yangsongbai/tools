package entity;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Disk 的主要职责:
 *
 * @ClassName Disk
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 17:16
 * @Version V1.0
 **/
public class Disk {
  private Size allSize;
  private Size allCurrentSize;
  private Size allRemainSize;
  private double allRemainPercent;
  private BigDecimal all = new BigDecimal(0);
  private BigDecimal remain = new BigDecimal(0);
  private BigDecimal current = new BigDecimal(0);
  private PartitionDisk [] partitionDisks;

    public Disk(PartitionDisk[] partitionDisks) {
        this.partitionDisks = partitionDisks;
    }

    public Disk(BigDecimal all, BigDecimal remain, PartitionDisk[] partitionDisks) {
        this.all = all;
        this.remain = remain;
        this.partitionDisks = partitionDisks;
    }

    public Disk(BigDecimal all, BigDecimal remain,double allRemainPercent,  BigDecimal current,PartitionDisk[] partitionDisks) {
        this.allRemainPercent = allRemainPercent;
        this.all = all;
        this.remain = remain;
        this.partitionDisks = partitionDisks;
        this.current = current;
    }

    public Disk(Size allSize, Size allCurrentSize, double allRemainPercent,PartitionDisk[] partitionDisks) {
        this.allSize = allSize;
        this.allCurrentSize = allCurrentSize;
        this.allRemainPercent = allRemainPercent;

        this.partitionDisks = partitionDisks;
    }

    public Disk() {
    }

    public BigDecimal getAll() {
        return all;
    }

    public void setAll(BigDecimal all) {
        this.all = all;
    }

    public BigDecimal getRemain() {
        return remain;
    }

    public void setRemain(BigDecimal remain) {
        this.remain = remain;
    }

    public Size getAllSize() {
        return allSize;
    }

    public void setAllSize(Size allSize) {
        this.allSize = allSize;
    }

    public Size getAllCurrentSize() {
        return allCurrentSize;
    }

    public void setAllCurrentSize(Size allCurrentSize) {
        this.allCurrentSize = allCurrentSize;
    }


    public double getAllRemainPercent() {
        return allRemainPercent;
    }

    public void setAllRemainPercent(double allRemainPercent) {
        this.allRemainPercent = allRemainPercent;
    }

    public PartitionDisk[] getPartitionDisks() {
        return partitionDisks;
    }

    public void setPartitionDisks(PartitionDisk[] partitionDisks) {
        this.partitionDisks = partitionDisks;
    }

    public Size getAllRemainSize() {
        return allRemainSize;
    }

    public void setAllRemainSize(Size allRemainSize) {
        this.allRemainSize = allRemainSize;
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "allSize=" + allSize +
                ", allCurrentSize=" + allCurrentSize +
                ", allRemainSize=" + allRemainSize +
                ", allRemainPercent=" + allRemainPercent +
                ", all=" + all +
                ", remain=" + remain +
                ", current=" + current +
                ", partitionDisks=" + Arrays.toString(partitionDisks) +
                '}';
    }
}
