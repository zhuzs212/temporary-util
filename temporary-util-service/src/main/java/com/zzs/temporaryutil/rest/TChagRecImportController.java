package com.zzs.temporaryutil.rest;

import cn.afterturn.easypoi.csv.CsvImportUtil;
import cn.afterturn.easypoi.csv.entity.CsvImportParams;
import com.zzs.temporaryutil.entity.TChagRec;
import com.zzs.temporaryutil.utils.MemberExcelDataHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 车联网订单 历史数据导入
 *
 * @author zhuzs
 * @date 2022/8/23 16:26
 */
@RestController
@RequestMapping("tChagRecImport")
@Slf4j
//@Api(value = "tChagRecImport", tags = "车联网订单 历史数据导入")
@Tag(name = "用户管理", description = "用户相关接口")
public class TChagRecImportController {


    @RequestMapping("/importCsv")
//    @ApiOperation(value = "车联网订单历史数据导入(csv文件)")
    @Operation(summary="车联网订单历史数据导入(csv文件)\"")
    public void importCsv(@RequestParam(value = "file") MultipartFile file) throws Exception {
        CsvImportParams params = new CsvImportParams();
        MemberExcelDataHandler handle = new MemberExcelDataHandler();
//        handle.setNeedHandlerFields(new String[]{"金额(元)", "商品"});
//        params.setVerifyHandler(verifyHandler);
        params.setHeadRows(1);
        params.setDataHandler(handle);

        long start = System.currentTimeMillis();
        //使用api获取到的List数据
        List<TChagRec> list = CsvImportUtil.importCsv(file.getInputStream(), TChagRec.class, params);
        long end = System.currentTimeMillis();
        log.info("解析结束，数据大小，size: {}, 耗时: {}", list.size(), end - start);

        if (!list.isEmpty()) {
            //保存数据，设置每次批量保存的条数
            log.info("开始写库操作...");
//            recService.saveBatch(list, 10000);
            list.clear();
            log.info("写库结束, 耗时: {}", end - start);
        }
    }
}
