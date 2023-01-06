package com.it.oa;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.oa.config.ApiResult;
import com.it.oa.config.constant.PayEnumKeyConf;
import com.it.oa.config.constant.FinanceRecordCategory;
import com.it.oa.config.constant.GroupCode;
import com.it.oa.config.constant.MemoType;
import com.it.oa.controller.AnnouncementController;
import com.it.oa.controller.CalendarController;
import com.it.oa.controller.OrganizationController;
import com.it.oa.controller.UserController;
import com.it.oa.controller.para.AnnoTypePara;
import com.it.oa.entity.*;
import com.it.oa.service.*;
import com.it.oa.util.BuildDataUtil;
import org.apache.shiro.SecurityUtils;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class InitTestEnvDbTest {
    @Resource
    private UserController userController;
    @Resource
    private OrganizationController organizationController;
    @Resource
    private org.apache.shiro.mgt.SecurityManager securityManager;
    @Resource
    private FinanceRecordService financeRecordService;
    @Resource
    private CustomerService customerService;
    @Resource
    private CalendarController calendarController;
    @Resource
    private AnnouncementService announcementService;
    @Resource
    private PerformanceService performanceService;
    @Resource
    private CompanyService companyService;
    @Resource
    private EnumService enumService;
    @Resource
    private PayConfigService payConfigService;
    @Resource
    private FinanceTypeService financeTypeService;
    @Resource
    private AnnouncementController announcementController;
    @Resource
    private BillService billService;

    Page<UserEntity> page = new Page<>(1, 10);

    @Resource
    UserService service;

    @BeforeEach
    void beforeTest() {
        SecurityUtils.setSecurityManager(securityManager);
    }


    @Test
    void test_1_org() {
        OrganizationEntity entity = new OrganizationEntity();
        entity.setOrgName("苏滨科技");
        organizationController.create(entity);
        for (String name : new String[]{"人事", "财务", "销售", "技术"}) {
            OrganizationEntity organizationEntity = new OrganizationEntity();
            organizationEntity.setParentId(entity.getId());
            organizationEntity.setOrgName(name + "部");
            organizationController.create(organizationEntity);
            for (String team : new String[]{"1", "2", "3"}) {
                OrganizationEntity organizationEntity2 = new OrganizationEntity();
                organizationEntity2.setOrgName(name + "部" + team + "组");
                organizationEntity2.setParentId(organizationEntity.getId());
                organizationController.create(organizationEntity2);
            }
        }
    }

    @Test
    void test_2_user() {
        Page<OrganizationEntity> page1 = new Page<>(1, 20);
        ApiResult<Page<OrganizationEntity>> result = organizationController.getPage(page1, new OrganizationEntity());

        List<OrganizationEntity> list = result.getData().getRecords();
        for (OrganizationEntity entity : list) {
            for (int i = 0; i < 3; i++) {
                String name = "测试用户_" + i * (list.indexOf(entity) + 1);
                if (!service.lambdaQuery().eq(UserEntity::getUserName, name).exists()) {
                    UserEntity userEntity = BuildDataUtil.createData(UserEntity.class);
                    userEntity.setId(null);
                    userEntity.setUserName(name);
                    userEntity.setStaffName(name);
                    userEntity.setPassword("test");
                    userEntity.setOrgId(entity.getId());
                    userController.create(userEntity);
                }
            }
        }
    }

    @Test
    void test_2_customer() {
        CustomerEntity entity;
        for (int i = 0; i < 5; i++) {
            entity = BuildDataUtil.createData(CustomerEntity.class);
            entity.setId(null);
            customerService.save(entity);
        }
    }

    @Test
    void test_3_calendar() {
        MemoEntity entity;
        for (int i = 0; i < 5; i++) {
            entity = new MemoEntity();
            entity.setContent("内容" + i);
            entity.setRemindTime(new Date());
            entity.setIsCompleted(false);
            entity.setType(MemoType.PERSONAL_REMINDER);
            calendarController.create(entity);
        }
    }

    @Test
    void test_4_AnnouncementEntity() {
        EnumEntity enumEntity = new EnumEntity();
        enumEntity.setGroupCode(GroupCode.ANNO_TYPE);
        List<EnumEntity> types = enumService.list(new QueryWrapper<>(enumEntity));
        if (types.isEmpty()) {
            AnnoTypePara annoTypePara = new AnnoTypePara();
            annoTypePara.setValue("公告");
            annoTypePara.setSort(1);
            annoTypePara.setStatus("true");
            announcementController.createAnnoType(annoTypePara);
        }
        types = enumService.list(new QueryWrapper<>(enumEntity));

        AnnouncementEntity entity;
        for (int i = 0; i < 5; i++) {
            entity = new AnnouncementEntity();
            entity.setContent("内容" + i);
            entity.setTitle("Title" + i);
            entity.setTypeId(types.get(0).getId());
            entity.setDescription("desc");
            entity.setIsOpen(true);
            announcementService.save(entity);
        }
    }

    @Test
    void test_4_PerformanceEntity() {
        PerformanceEntity entity;
        LocalDate now = LocalDate.now();
        for (int i = 0; i < 5; i++) {
            entity = new PerformanceEntity();
            entity.setCycle("月考核");
            entity.setUserId(1);
            entity.setLeaderId(1);
            entity.setScore(80.3f + i);
            entity.setAssessmentName("绩效考核名称");
            entity.setStartTime(now.minusMonths(5 - i));
            performanceService.save(entity);
        }
    }

    @Test
    void test_2_1_finance_record_type() {
        financeTypeService.remove(new QueryWrapper<>());
        Integer[] name2 = new Integer[]{1, 2, 3};
        for (String type : new String[]{FinanceRecordCategory.CATEGORY_INCOME, FinanceRecordCategory.CATEGORY_PAY}) {
            getChild(1, type, 4, 3, null);
        }
    }


    void getChild(int level, String category, int levelMax, int indexMax, List<FinanceTypeEntity> list) {
        Assertions.assertFalse(list != null && list.size() < indexMax);
        if (level > levelMax) {
            return;
        }
        List<FinanceTypeEntity> childList = new ArrayList<>();
        for (int index = 1; index <= indexMax; index++) {
            FinanceTypeEntity entity = new FinanceTypeEntity();
            entity.setCategory(category);
            entity.setLevel(level);
            entity.setType(level + "-" + index);
            if (list != null && list.size() >= index) {
                entity.setParentId(list.get(index - 1).getId());
            }
            childList.add(entity);
        }
        financeTypeService.saveBatch(childList);
        getChild(level + 1, category, levelMax, indexMax, childList);
    }

    @Test
    void test_2_finance_record() {
        financeRecordService.remove(new QueryWrapper<>());

        List<FinanceTypeEntity> types = financeTypeService.list();
        int days = 7;
        PayConfigEntity payType = payConfigService.lambdaQuery().eq(PayConfigEntity::getPayNameEn, PayEnumKeyConf.WECHAT_PAY).one();
        LocalDate from = LocalDate.now().minusDays(days);
        List<FinanceRecordEntity> list = new ArrayList<>();
        for (int i = 0; i < days; i++) {
            for (FinanceTypeEntity typeEntity : types) {
                for (int index = 0; index < 2; index++) {
                    FinanceRecordEntity entity = new FinanceRecordEntity();
                    entity.setFinanceTypeId(typeEntity.getId());
                    entity.setPayTypeId(payType.getId());
                    LocalDateTime time = LocalDateTime.of(from.plusDays(i), LocalTime.of(6 * index, 0));
                    entity.setPayTime(Date.from(time.atZone(ZoneId.systemDefault()).toInstant()));
                    // entity.setPayTime(time);
                    entity.setCreateTime(Date.from(time.atZone(ZoneId.systemDefault()).toInstant()));
                    entity.setUpdateTime(Date.from(time.atZone(ZoneId.systemDefault()).toInstant()));
                    entity.setFinanceMoney(new BigDecimal(10000 * i * Math.random()));
                    list.add(entity);
                }
            }
        }
        financeRecordService.saveBatch(list);
    }


    @Test
    void test_4_CompanyEntity() {
        CompanyEntity entity = BuildDataUtil.createData(CompanyEntity.class);
        entity.setId(1);
        companyService.save(entity);
    }

    @Test
    void test_5_BillEntity() {
        BillEntity entity = BuildDataUtil.createData(BillEntity.class);
        entity.setId(null);
        billService.save(entity);
    }

}