/*
 * 官网地站:http://www.mob.com
 * 技术支持QQ: 4006852216
 * 官方微信:ShareSDK   （如果发布新版本的话，我们将会第一时间通过微信将版本更新内容推送给您。如果使用过程中有任何问题，也可以通过微信与我们取得联系，我们将会在24小时内给予回复）
 *
 * Copyright (c) 2013年 mob.com. All rights reserved.
 */

package cn.sharesdk.demo.tpl;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;

/**
 * 快捷分享项目现在添加为不同的平台添加不同分享内容的方法。
 *本类用于演示如何区别Twitter的分享内容和其他平台分享内容。
 *本类会在{@link DemoPage#showShare(boolean, String)}方法
 *中被调用。
 *http://wiki.mob.com/Android_%E5%BF%AB%E6%8D%B7%E5%88%86%E4%BA%AB#.E4.B8.BA.E4.B8.8D.E5.90.8C.E5.B9.B3.E5.8F.B0.E5.AE.9A.E4.B9.89.E5.B7.AE.E5.88.AB.E5.8C.96.E5.88.86.E4.BA.AB.E5.86.85.E5.AE.B9
 */
public class ShareContentCustomizeDemo implements ShareContentCustomizeCallback {

	public void onShare(Platform platform, ShareParams paramsToShare) {

		String text = platform.getContext().getString(R.string.share_title);
		if ("WechatMoments".equals(platform.getName())) {
			// 改写twitter分享内容中的text字段，否则会超长，
			// 因为twitter会将图片地址当作文本的一部分去计算长度
			text += platform.getContext().getString(R.string.share_to_wechatmoment);
			paramsToShare.setText(text);
		}else if("SinaWeibo".equals(platform.getName())){
			text += platform.getContext().getString(R.string.share_to_sina);
			paramsToShare.setText(text);			
		}else if("TencentWeibo".equals(platform.getName())){
			text += platform.getContext().getString(R.string.share_to_tencent);
			paramsToShare.setText(text);			
		}else if("ShortMessage".equals(platform.getName())){
			text += platform.getContext().getString(R.string.share_to_sms);
			paramsToShare.setText(text);
			
		}
	}

}
