package com.zzs.temporaryutil.utils;

public class ConnectorStatus {


        // 桩状态
        public final static int STATUS_ZY = 1; // 充电 1
        public final static int STATUS_KX = 2; // 空闲 2
        public final static int STATUS_GZ = 3; // 故障 3
        public final static int STATUS_LX = 4; // 离线 4
        public final static int STATUS_JX = 5; // 就绪，已连接电缆 5
        public final static int STATUS_YY = 6; // 预约 6
        public final static int STATUS_FD = 7; //放电

        public ConnectorStatus() {
        }

        public static int getChargePoleStatus(boolean comm, boolean error, boolean charge, boolean ready,boolean full, double current) {
            if(full){
                return 1;
            }else if (!comm) {
                return 4;
            } else if (error) {
                return 3;
            } else if (charge) {
                return current < 0.0D ? 7 : 1;
            } else {
                return ready ? 5 : 2;
            }
        }


}
