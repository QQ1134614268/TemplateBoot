package com.cloud.trx;

import com.cloud.trx.controller.TrxLogController;
import com.cloud.trx.controller.TrxLogEntity;
import com.cloud.trx.controller.TrxLogService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TrxTests {

	@Resource
	TrxLogController trxLogController;

	@Resource
	private TrxLogService trxLogService;

	@Test
	void test01() {
		List<TrxLogEntity> res = trxLogController.testGlobalTransactional();
		assertEquals(0, res.size());
	}

	@Test
	void test02() {
		List<TrxLogEntity> res = trxLogController.testTransactional();
		assertEquals(2, res.size());
	}

	@Test
	void testGlobal() {
		List<TrxLogEntity> res = trxLogController.testGlobal();
		assertEquals(1, res.size());
	}

	@Test
	void part3() {
		String uid = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		try {
			trxLogController.part3(uid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 抛出异常, 不加transactional 也会回滚
		Long count = trxLogService.lambdaQuery().eq(TrxLogEntity::getUid, uid).count();
		assertEquals(0, count);
	}

	@Test
	void part3_with_transactional() {
		String uid = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		try {
			trxLogController.part3_with_transactional(uid);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// 抛出异常,
		Long count = trxLogService.lambdaQuery().eq(TrxLogEntity::getUid, uid).count();
		assertEquals(0, count);
	}

}
