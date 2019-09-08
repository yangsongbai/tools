package entity;

/**
 * Unit 的主要职责:
 *
 * @ClassName Unit
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 17:46
 * @Version V1.0
 **/
public enum  Unit {
    B(0,"B"),KB(1,"KB"),MB(2,"MB"),GB(3,"GB"),TB(4,"TB"),PB(5,"PB");
    int index;
    String unit;
    Unit(int index,String unit){
        this.index =index;
        this.unit = unit;
    }

    public static String getUnit(int index) {
        return Unit.values()[index].unit;
    }
}
