package com.cloud.trx.controller;

import com.alibaba.fastjson.JSON;
import com.cloud.api.RemoteTrxLogService;
import com.cloud.base.ApiResult;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/trxLog")
public class TrxLogController {
	@Resource
	private RemoteTrxLogService remoteTrxLogService;

	@Resource
	private TrxLogService trxLogService;


	@PostMapping("/testGlobalTransactional")
	public List<TrxLogEntity> testGlobalTransactional() {
		// a->b->c: c执行失败, abc一起回滚; 插入0条
		String uid = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		try {
			trxLogService.testGlobalTransactional(uid); // 如果不是public; 异常
			// testGlobalTransactional(uid); // 如果直接调用(非bean调用), 异常
		} catch (Exception ignored) {

		}
		return trxLogService.lambdaQuery().eq(TrxLogEntity::getUid, uid).list();
	}


	@PostMapping("/part2")
	public ApiResult<Boolean> part2(@RequestParam("uid") String uid) {
		TrxLogEntity entity = new TrxLogEntity();
		entity.setUid(uid);
		return ApiResult.success(trxLogService.save(entity));
	}

	@PostMapping("/part3")
	public ApiResult<Boolean> part3(@RequestParam("uid") String uid) {
		TrxLogEntity entity = new TrxLogEntity();
		entity.setUid(uid);
		log.info(uid);
		throw new RuntimeException("测试,第三步抛出异常; 参数: " + uid);
	}
}
