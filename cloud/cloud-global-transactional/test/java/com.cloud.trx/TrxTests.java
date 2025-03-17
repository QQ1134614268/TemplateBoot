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
}
