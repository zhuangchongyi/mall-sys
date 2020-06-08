package com.ruoyi.project.mall.controller;

import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.mall.domain.MallGoodsImage;
import com.ruoyi.project.mall.service.IMallGoodsImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 商品图片Controller
 * 
 * @author zhuangcy
 * @date 2020-05-19
 */
@RestController
@RequestMapping("/mall/image")
public class MallGoodsImageController extends BaseController
{
    @Autowired
    private IMallGoodsImageService mallGoodsImageService;

    /**
     * 查询商品图片列表
     */
    @GetMapping("/list/{goodsId}")
    public AjaxResult list(@PathVariable Long goodsId)
    {
        List<MallGoodsImage> list = mallGoodsImageService.findGoodsImageByGoodsId(goodsId);
        return AjaxResult.success(list);
    }

    /**
     * 添加商品明细图片
     * @param file
     * @param goodsImage
     * @return
     * @throws IOException
     */
    @PreAuthorize("@ss.hasPermi('mall:goods:edit')")
    @Log(title = "添加商品明细图片", businessType = BusinessType.INSERT)
    @PostMapping("/uploadGoodsImage")
    public AjaxResult uploadGoodsImage(@RequestParam("file") MultipartFile file,MallGoodsImage goodsImage) throws IOException {
        if (!file.isEmpty()) {
            String url = FileUploadUtils.upload(RuoYiConfig.getGoodsPath(), file);
            goodsImage.setUrl(url);
            goodsImage.setImageName(file.getOriginalFilename());
            int row = mallGoodsImageService.insertMallGoodsImage(goodsImage);
            System.out.println(goodsImage);
            if (row != 0){
                AjaxResult ajax = AjaxResult.success();
                ajax.put("url", url);
                ajax.put("imageId", goodsImage.getImageId());
                return ajax;
            } else {
                FileUploadUtils.deleteFile(url);
            }
        }
        return AjaxResult.error("上传图片异常，请联系管理员");
    }

    /**
     * 删除商品图片
     * @param goodsImage
     * @return
     */
    @PreAuthorize("@ss.hasPermi('mall:goods:edit')")
    @Log(title = "删除商品图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/deleteGoodsImage")
    public AjaxResult deleteGoodsImage(MallGoodsImage goodsImage) {
        boolean flag = FileUploadUtils.deleteFile(goodsImage.getUrl());
        System.err.println(flag);
        int row = mallGoodsImageService.deleteMallGoodsImageById(goodsImage.getImageId());
        if(row != 0){
            return AjaxResult.success("删除成功");
        }
        return AjaxResult.error("删除失败");
    }
}
