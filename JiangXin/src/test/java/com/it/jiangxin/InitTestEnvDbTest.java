package com.it.jiangxin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.jiangxin.config.ApiResult;
import com.it.jiangxin.controller.FileController;
import com.it.jiangxin.controller.ImgController;
import com.it.jiangxin.entity.ImgEntity;
import com.it.jiangxin.entity.SysEnumEntity;
import com.it.jiangxin.entity.UserEntity;
import com.it.jiangxin.entity.vo.IdsPara;
import com.it.jiangxin.service.EnumService;
import com.it.jiangxin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

import static com.it.jiangxin.config.enum1.GroupCodeEnum.ImgType;

@SpringBootTest
public class InitTestEnvDbTest {
    @Resource
    EnumService enumService;
    @Resource
    UserService userService;
    @Resource
    FileController fileController;
    @Resource
    ImgController imgController;

    @Value("${clearTestData:false}")
    private Boolean clearTestData;

    @Test
    void test_1_user() throws IOException {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("test");
        userEntity.setPassword("test");
        userEntity.setAvatar(getUploadUrl("avtar.test.webp"));
        LocalDate localDate = LocalDate.of(2000, 1, 1);
        userEntity.setBirthDay(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        UserEntity old = userService.lambdaQuery().eq(UserEntity::getUserName, userEntity.getUserName()).one();
        if (old != null) {
            userEntity.setId(old.getId());
        }
        userService.saveOrUpdate(userEntity);
    }

    @Test
    void test_2_imgType() {
        List<String> list = Arrays.asList("中式", "日式", "欧式");//"最火", "曾看过"
        for (String v : list) {
            SysEnumEntity enumEntity = new SysEnumEntity();
            enumEntity.setGroupCode(ImgType.getUniCode());
            // enumEntity.setUniCode(UUID.randomUUID().toString());
            enumEntity.setValue(v);
            SysEnumEntity old = enumService.getOne(new QueryWrapper<>(enumEntity));
            if (old == null) {
                enumService.save(enumEntity);
            }
        }
    }

    @Test
    void test_2_img() throws IOException {
        List<SysEnumEntity> types = enumService.lambdaQuery()
                .eq(SysEnumEntity::getGroupCode, ImgType.getUniCode())
                .list();
        for (SysEnumEntity e : types) {
            for (int i = 1; i < 4; i++) {
                String uuid = UUID.randomUUID().toString();
                ArrayList<ImgEntity> list = new ArrayList<>();
                for (int j = 1; j < 6; j++) {
                    ImgEntity imgEntity = new ImgEntity();
                    imgEntity.setImgUrl(getUploadUrl("house.法式.webp"));
                    imgEntity.setGroupUuid(uuid);
                    imgEntity.setDescription("这套风格借鉴了" + e.getValue() + "艺术......");
                    if (j == 1) { // 首页
                        imgEntity.setIsHomeImg(true);
                        imgEntity.setName(String.format("%s-%s", e.getValue(), i));
                        imgEntity.setStyleId(e.getId());
                    }
                    list.add(imgEntity);
                }
                imgController.updateAllDesign(list);
            }
        }
    }

    @Test
    void test_1_upload() throws IOException {
        String path = "avtar.test.webp";
        System.out.println(getUploadUrl(path));
    }

    @Test
    void testClearTestData() {
        if (!clearTestData) {
            return;
        }
        ApiResult<Page<ImgEntity>> res = imgController.getPage(Page.of(1, -1), new ImgEntity());
        List<Integer> ids = res.getData().getRecords().stream().map(ImgEntity::getId).collect(Collectors.toList());
        imgController.deleteByIds(new IdsPara(ids));
    }

    private String getUploadUrl(String path) throws IOException {
        org.springframework.core.io.Resource resource = new ClassPathResource(path);
        MultipartFile multipartFile = new MockMultipartFile("file", path, MediaType.TEXT_PLAIN_VALUE, resource.getInputStream());
        ApiResult<String> res = fileController.upload(multipartFile);
        if (res.isError()) {
            throw new RuntimeException(res.getMessage());
        }
        return res.getData();
    }
}