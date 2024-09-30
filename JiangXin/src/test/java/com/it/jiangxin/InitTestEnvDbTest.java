package com.it.jiangxin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.config.enum1.AccountEnum;
import com.it.jiangxin.controller.ImgController;
import com.it.jiangxin.controller.UserController;
import com.it.jiangxin.entity.ImgEntity;
import com.it.jiangxin.entity.ImgInfoEntity;
import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.entity.vo.IdsPara;
import com.it.jiangxin.entity.vo.ImgDto;
import com.it.jiangxin.service.SysEnumService;
import com.it.jiangxin.util.PasswordUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.it.jiangxin.config.enum1.GroupCodeEnum.ImgType;

@SpringBootTest
public class InitTestEnvDbTest {
    @Resource
    SysEnumService sysEnumService;
    @Resource
    private UserController userController;
    @Resource
    ImgController imgController;
    @Resource
    Util util;

    @Value("${clearTestData:false}")
    private Boolean clearTestData;

    @Test
    void test_1_user() throws IOException {
        String[] names = new String[]{"admin", "test"};
        for (String name : names) {
            UserEntity user = new UserEntity();
            user.setUserName(name);
            user.setNickName(name);
            user.setPassword(PasswordUtil.desPassword(name));
            user.setAvatar(util.getUploadUrl("avtar.test.webp"));
            user.setPhone("188****1234");
            user.setStatus(AccountEnum.normal.value);
            user.setBirthDay(new Date());
            user.setCreate();
            ApiResult<Integer> res = userController.create(user);
            Assertions.assertEquals(1, res.getCode());
        }
    }

    @Test
    void test_2_imgType() {
        List<String> list = Arrays.asList("中式", "日式", "欧式");//"最火", "曾看过"
        for (String v : list) {
            SysEnumEntity enumEntity = new SysEnumEntity();
            enumEntity.setGroupCode(ImgType.getUniCode());
            enumEntity.setName(v);
            SysEnumEntity old = sysEnumService.getOne(new QueryWrapper<>(enumEntity));
            if (old == null) {
                sysEnumService.save(enumEntity);
            }
        }
    }

    @Test
    void test_2_img() throws IOException {
        List<SysEnumEntity> types = sysEnumService.lambdaQuery()
                .eq(SysEnumEntity::getGroupCode, ImgType.getUniCode())
                .list();
        for (SysEnumEntity e : types) {
            for (int i = 1; i < 4; i++) {
                ImgEntity imgEntity = new ImgEntity();
                imgEntity.setImgUrl(util.getUploadUrl("house.法式.webp"));
                imgEntity.setCreateBy(1);
                imgEntity.setUpdateBy(1);
                imgEntity.setName(String.format("%s-%s", e.getName(), i));
                imgEntity.setStyleId(e.getId());

                ArrayList<ImgInfoEntity> list = new ArrayList<>();
                for (int j = 1; j < 6; j++) {
                    ImgInfoEntity info = new ImgInfoEntity();
                    info.setImgUrl(util.getUploadUrl("house.法式.webp"));
                    info.setCreateBy(1);
                    info.setUpdateBy(1);
                    info.setDescription("这套风格借鉴了" + e.getName() + "艺术......");
                    list.add(info);
                }
                imgEntity.setChildren(list);
                imgController.create(imgEntity);
            }
        }
    }

    @Test
    void test_1_upload() throws IOException {
        String path = "avtar.test.webp";
        System.out.println(util.getUploadUrl(path));
    }

    @Test
    void testClearTestData() {
        if (!clearTestData) {
            return;
        }
        ApiResult<IPage<ImgDto>> res = imgController.getPage(Page.of(1, -1), new ImgEntity());
        List<Integer> ids = res.getData().getRecords().stream().map(ImgEntity::getId).collect(Collectors.toList());
        imgController.deleteByIds(new IdsPara(ids));
    }

}