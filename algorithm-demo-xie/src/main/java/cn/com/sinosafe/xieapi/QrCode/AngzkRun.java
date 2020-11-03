package cn.com.sinosafe.xieapi.QrCode;

import cn.com.sinosafe.xiecommon.qrcodeutils.GraphicsUtils;

/**
   * @Description //测试启动类
   * @Author xiehanchun
   * @Date 2020/3/26 14:17
   * @Param
   * @return
   */
public class AngzkRun {

    /**
     * 注: png 格式图片可能会导致 出现黑色背景.
     *
     * @param args main
     */
    public static void main(String[] args) {
        // 获取Resource下 images 的目录
        String folderPath = GraphicsUtils.class.getResource("/images").getPath();
//        String spuName = "澳洲风味小麦白啤（APA）";
        String linkUrl = "https://proxytest.sinosafe.com.cn/haxb-h5-common-uat/agent-h5-uat/#/home/xbAgencyDetailClient";
//        String logoPath = folderPath + "/132.jpg";
        String backgroundUrl = folderPath + "/123.jpg";
//        String spuPicUrl = folderPath + "/item.jpg";
//        String memberPrice = "会员福利￥66.80";
//        String price = "直购价￥88.90";

        System.out.println(folderPath);
//        GraphicsUtils.createPosterByRedTemplate(linkUrl, false, null, backgroundUrl, null,
//                null, null, null);
    }

}
