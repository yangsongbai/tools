package entity;

/**
 * Size 的主要职责:
 *
 * @ClassName Size
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 17:39
 * @Version V1.0
 **/
public class Size {
    private double size;
    private String unit;

    public Size() {
    }

    public Size(double size, String unit) {
        this.size = size;
        this.unit = unit;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Size{" +
                "size=" + size +
                ", unit='" + unit + '\'' +
                '}';
    }
}
