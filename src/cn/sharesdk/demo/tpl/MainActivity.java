package cn.sharesdk.demo.tpl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.system.text.ShortMessage;
import cn.sharesdk.tencent.weibo.TencentWeibo;
import cn.sharesdk.wechat.moments.WechatMoments;

/** 中文注释
 * ShareSDK 官网地址 ： http://www.mob.com </br>
 *1、这是用2.41版本的sharesdk，一定注意  </br>
 *2、如果要咨询客服，请加企业QQ 4006852216 </br>
 *3、咨询客服时，请把问题描述清楚，最好附带错误信息截图 </br>
 *4、一般问题，集成文档中都有，请先看看集成文档；减少客服压力，多谢合作  ^_^</br></br></br>
 *
 *The password of demokey.keystore is 123456
 **ShareSDK Official Website ： http://www.mob.com </br>
 *1、Be carefully, this sample use the version of 2.11 sharesdk  </br>
 *2、If you want to ask for help，please add our QQ whose number is 4006852216 </br>
 *3、Please describe detail of the question , if you have the picture of the bugs or the bugs' log ,that is better </br>
 *4、Usually, the answers of some normal questions is exist in our user guard pdf, please read it more carefully,thanks  ^_^
 *
 *@author dunmin/敦敏
 *
*/

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ShareSDK.initSDK(this);
		//初始化sharesdk,具体集成步骤请看文档：
		//http://wiki.mob.com/Android_%E5%BF%AB%E9%80%9F%E9%9B%86%E6%88%90%E6%8C%87%E5%8D%97
		
		findViewById(R.id.btn_sms).setOnClickListener(this);
		findViewById(R.id.btn_sina).setOnClickListener(this);
		findViewById(R.id.btn_tencent).setOnClickListener(this);
		findViewById(R.id.btn_wechatmoment).setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_sms://短信分享
			showShare(true, ShortMessage.NAME);
			break;
		case R.id.btn_sina://新浪分享
			showShare(true, SinaWeibo.NAME);			
			break;
		case R.id.btn_tencent://腾讯分享
			showShare(true, TencentWeibo.NAME);			
			break;			
		case R.id.btn_wechatmoment://朋友圈分享
			showShare(true, WechatMoments.NAME);			
			break;			
		default:
			break;
		}
	}
	
	//快捷分享的文档：http://wiki.mob.com/Android_%E5%BF%AB%E6%8D%B7%E5%88%86%E4%BA%AB
	private void showShare(boolean silent, String platform){
		final OnekeyShare oks = new OnekeyShare();
		oks.setNotification(R.drawable.ic_launcher, this.getString(R.string.app_name));
		//不同平台的分享参数，请看文档
		//http://wiki.mob.com/Android_%E4%B8%8D%E5%90%8C%E5%B9%B3%E5%8F%B0%E5%88%86%E4%BA%AB%E5%86%85%E5%AE%B9%E7%9A%84%E8%AF%A6%E7%BB%86%E8%AF%B4%E6%98%8E
		String text = this.getString(R.string.share_title) + "http://www.mob.com";
		oks.setTitle("share title");		
		oks.setText(text);
		//oks.setSilent(silent);
		oks.setDialogMode();
		oks.disableSSOWhenAuthorize();
		if (platform != null) {
			oks.setPlatform(platform);
		}
		// 去自定义不同平台的字段内容
		// http://wiki.mob.com/Android_%E5%BF%AB%E6%8D%B7%E5%88%86%E4%BA%AB#.E4.B8.BA.E4.B8.8D.E5.90.8C.E5.B9.B3.E5.8F.B0.E5.AE.9A.E4.B9.89.E5.B7.AE.E5.88.AB.E5.8C.96.E5.88.86.E4.BA.AB.E5.86.85.E5.AE.B9
		oks.setShareContentCustomizeCallback(new ShareContentCustomizeDemo());
		oks.show(this);
	}

}
