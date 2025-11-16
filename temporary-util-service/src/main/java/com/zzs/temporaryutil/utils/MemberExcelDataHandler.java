package com.zzs.temporaryutil.utils;

import cn.afterturn.easypoi.handler.impl.ExcelDataHandlerDefaultImpl;
import com.zzs.temporaryutil.entity.TChagRec;

/**
 * 自定义字段处理
 * Created by macro on 2021/10/13.
 */
public class MemberExcelDataHandler extends ExcelDataHandlerDefaultImpl<TChagRec> {

    @Override
    public Object exportHandler(TChagRec tChagRec, String name, Object value) {
        return super.exportHandler(tChagRec, name, value);
    }

    @Override
    public Object importHandler(TChagRec tChagRec, String name, Object value) {
//        if ("交易流水号".equals(name)) {
//            Integer emptyValue = RandomUtil.randomInt();
////            if(value instanceof String && StrUtil.isBlank((String) value)){
//            if (value.equals("卡账户支付")) {
//                return super.exportHandler(tChagRec, name, 1);
//            } else if (value == null) {
//                return super.exportHandler(tChagRec, name, emptyValue);
//            } else if (value == null) {
//                return super.exportHandler(tChagRec, name, emptyValue);
//            } else if (value == null) {
//                return super.exportHandler(tChagRec, name, emptyValue);
//            } else if (value == null) {
//                return super.exportHandler(tChagRec, name, emptyValue);
//            } else if (value == null) {
//                return super.exportHandler(tChagRec, name, emptyValue);
//            }
//        }
//        else if ("是否开具发票".equals(name)) {
//            // 0：未开票；1：已开票
//            Integer emptyValue = 0;
//            if (value == null) {
//                return super.exportHandler(tChagRec, name, emptyValue);
//            }
////            if(value instanceof String && StrUtil.isBlank((String) value)){
//            if (value.equals("未开票")) {
//                return super.exportHandler(tChagRec, name, emptyValue);
//            }
//
//            if (value.equals("已开票")) {
//                return super.exportHandler(tChagRec, name, 1);
//            }
//        }
//        if ("交易结束原因".equals(name)) {
//            Integer emptyValue = 0;
//            if (value == null) {
//                return super.exportHandler(tChagRec, name, emptyValue);
//            }
////            if(value instanceof String && StrUtil.isBlank((String) value)){
//            if (value.equals("卡账户支付")) {
//                return super.exportHandler(tChagRec, name, 1);
//            }
//        }
        return super.importHandler(tChagRec, name, value);
    }
}
