package com.disk.service;

import com.disk.host.HostInfo;
import entity.AlarmInfo;
import entity.Disk;
import entity.PartitionDisk;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tools.DiskTools;
import tools.HostTools;
import tools.StringUtil;

import java.util.HashMap;

/**
 * DiskCheckService 的主要职责:
 *
 * @ClassName DiskCheckService
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/9/8 19:35
 * @Version V1.0
 **/
@Component
@Configurable
@EnableScheduling
public class DiskCheckService {
    private static Logger logger = Logger.getLogger(DiskCheckService.class);
    @Scheduled(cron = "*/10 * *  * * * ")
    public void checkDisk(){
        Disk disk= DiskTools.calculate(DiskTools.getDiskInfo()) ;
        HostInfo hostInfo = HostTools.getHostInfo();
        PartitionDisk[]  partitionDisks = disk.getPartitionDisks();
        HashMap<String, String> dangerDisk = new HashMap<>();
        String pattern = "#.00";
        for (int i=0;i<partitionDisks.length;i++){
            if(partitionDisks[i].getPercentRemain()<0.11){

            }
            String value = "总量: "+ StringUtil.format(pattern,partitionDisks[i].getTotalSize().getSize())+partitionDisks[i].getTotalSize().getUnit()
                    +" 剩余: "+StringUtil.format(pattern,partitionDisks[i].getRemainSize().getSize())+partitionDisks[i].getRemainSize().getUnit()
                    +" 剩余百分比: "+partitionDisks[i].getPercentRemain();
            dangerDisk.put(partitionDisks[i].getDisplayName(),value);
        }
        if (dangerDisk.isEmpty()){

        }
        AlarmInfo AlarmInfo = new AlarmInfo(hostInfo,dangerDisk);
        System.out.println(AlarmInfo);
    }
}
