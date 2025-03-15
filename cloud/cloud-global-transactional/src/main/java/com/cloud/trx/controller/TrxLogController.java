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
import javax.transaction.Transactional;
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


	@GlobalTransactional(name = "testGlobalTransactional", rollbackFor = Exception.class)
	@PostMapping("/testGlobalTransactional")
	public List<TrxLogEntity> testGlobalTransactional() {
		// a->b->c: c执行失败, abc一起回滚; 插入0条
		return getTrxLogEntities();
	}

	@Transactional
	@PostMapping("/testTransactional")
	public List<TrxLogEntity> testTransactional() {
		// a->b->c: c执行失败, ac回滚 b没有回滚; 插入1条
		return getTrxLogEntities();
	}

	private List<TrxLogEntity> getTrxLogEntities() {
		String uid = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		TrxLogEntity entity = new TrxLogEntity();
		entity.setUid(uid);
		trxLogService.save(entity);
		ApiResult<Boolean> res1 = remoteTrxLogService.part2(uid);
		log.info(JSON.toJSONString(res1));
		ApiResult<Boolean> res2 = remoteTrxLogService.part3(uid);
		log.info("==========" + JSON.toJSONString(res2));
		return trxLogService.lambdaQuery().eq(TrxLogEntity::getUid, uid).list();
	}

	@GlobalTransactional
	@PostMapping("/part2")
	public ApiResult<Boolean> part2(@RequestParam("uid") String uid) {
		TrxLogEntity entity = new TrxLogEntity();
		entity.setUid(uid);
		return ApiResult.success(trxLogService.save(entity));
	}

	@GlobalTransactional
	@PostMapping("/part3")
	public ApiResult<Boolean> part3(@RequestParam("uid") String uid) {
		TrxLogEntity entity = new TrxLogEntity();
		entity.setUid(uid);
		log.info(uid);
		throw new RuntimeException("测试,第三步抛出异常; 参数: " + uid);
	}

	@GlobalTransactional
	@PostMapping("/testGlobal")
	public List<TrxLogEntity> testGlobal() {
		// a->b->c: c执行失败, abc一起回滚; 插入0条
		String uid = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		TrxLogEntity entity = new TrxLogEntity();
		entity.setUid(uid);
		trxLogService.save(entity);
		ApiResult<Boolean> res1 = remoteTrxLogService.part2_with_transactional(uid);
		log.info(JSON.toJSONString(res1));
		ApiResult<Boolean> res2 = remoteTrxLogService.part3_with_transactional(uid);
		log.info("==========" + JSON.toJSONString(res2));
		return trxLogService.lambdaQuery().eq(TrxLogEntity::getUid, uid).list();
	}


	@Transactional
	@PostMapping("/part2_with_transactional")
	public ApiResult<Boolean> part2_with_transactional(@RequestParam("uid") String uid) {
		TrxLogEntity entity = new TrxLogEntity();
		entity.setUid(uid);
		return ApiResult.success(trxLogService.save(entity));
	}

	@Transactional
	@PostMapping("/part3_with_transactional")
	public ApiResult<Boolean> part3_with_transactional(@RequestParam("uid") String uid) {
		TrxLogEntity entity = new TrxLogEntity();
		entity.setUid(uid);
		log.info(uid);
		throw new RuntimeException("测试,第三步抛出异常; 参数: " + uid);
	}
}
