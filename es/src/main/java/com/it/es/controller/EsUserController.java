package com.it.es.controller;

import com.it.es.config.ApiResult;
import com.it.es.dao.EsUserRepository;
import com.it.es.entity.EsUser;
import com.it.es.service.EsUserService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/EsUserController")
public class EsUserController {

    @Resource
    EsUserService esUserService;
    @Resource
    EsUserRepository esUserRepository;


    @PostMapping("/crate")
    public String crate(@RequestBody EsUser esUser) {
        EsUser result = esUserRepository.save(esUser);
        return result.toString();
    }

    @GetMapping("/findById")
    public ApiResult<EsUser> findById(@RequestParam String id) {
        EsUser record = esUserRepository.findById(id).orElseGet(null);
        return ApiResult.success(record);
    }

    @GetMapping(path = "/findByName")
    public ApiResult<List<EsUser>> findByName(String name) {
        return ApiResult.success(esUserRepository.findByName(name));
    }

    @DeleteMapping("/deleteById")
    public ApiResult<Boolean> deleteById(@RequestParam String id) {
        esUserRepository.deleteById(id);
        return ApiResult.success();
    }

    @GetMapping(path = "/update")
    public ApiResult<Boolean> update(String search) {
        esUserService.update(search);
        return ApiResult.success();
    }

    @GetMapping(path = "/page")
    public ApiResult<PageImpl<EsUser>> page(Pageable pageable, String search) {
        return ApiResult.success(esUserService.page(pageable, search));
    }

    /**
     * 滚动查询
     *
     * @param scrollId 滚动id
     * @param pageSize 分页大小
     * @return 查询结果
     */
    @GetMapping(value = "/scroll")
    public ApiResult<Map<String, Object>> scroll(String scrollId, Integer pageSize) {
        Map<String, Object> result = esUserService.scroll(scrollId, pageSize);
        return ApiResult.success(result);
    }
}
