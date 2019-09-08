package tools;

import entity.Disk;
import entity.PartitionDisk;
import entity.Size;
import entity.Unit;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.math.BigDecimal;

/**
 * Disk 的主要职责:
 *
 * @ClassName Disk
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 17:14
 * @Version V1.0
 **/
public class DiskTools {
    public static void main(String[] args) {
        System.out.println(calculate(driver()));
    }

    private static Disk calculate(Disk driver) {
        driver.setAllSize(FormatFileSize(driver.getAll().doubleValue()));
        driver.setAllCurrentSize(FormatFileSize(driver.getCurrent().doubleValue()));
        return driver;
    }

    public static Size FormatFileSize(double fileSize) {
        int unit = 0;
        //DecimalFormat df = new DecimalFormat("#.00");
        while (1024<fileSize){
            fileSize = fileSize / 1024;
            unit+=1;
        }
        return new Size(fileSize, Unit.getUnit(unit)) ;
    }

    /**
     * 获取硬盘的每个盘符
     */
    public static Disk driver(){
        // 当前文件系统类
        FileSystemView fsv = FileSystemView.getFileSystemView();
        // 列出所有windows 磁盘
        File[] fs = File.listRoots();
        // 显示磁盘卷标
        PartitionDisk []partitionDisks = new PartitionDisk[fs.length];
        String displayName = "";
        Size totalSize ;
        Size remainSize ;
        Size currentSize;
        BigDecimal all = new BigDecimal(0);
        BigDecimal remain = new BigDecimal(0);
        BigDecimal current = new BigDecimal(0);
        for (int i = 0; i < fs.length; i++) {
            displayName = fsv.getSystemDisplayName(fs[i]);
            long total = fs[i].getTotalSpace();
            long free = fs[i].getFreeSpace();
            all = all.add(new BigDecimal(total));
            remain = remain.add(new BigDecimal(free));
            current  = current.add(new BigDecimal((total-free)));

            totalSize = FormatFileSize(total);
            remainSize = FormatFileSize(free);
            currentSize = FormatFileSize((total-free));
            PartitionDisk partitionDisk = new
            PartitionDisk(displayName,totalSize,currentSize,remainSize,(double)free/total);
            partitionDisks[i] = partitionDisk;
        }
        double percent = remain.divide(all,4,BigDecimal.ROUND_DOWN).doubleValue();
        Disk disk = new Disk(all,remain,percent,current,partitionDisks);
        return disk;
    }
}
