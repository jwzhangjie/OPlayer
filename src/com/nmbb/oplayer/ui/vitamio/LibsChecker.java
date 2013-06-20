package com.nmbb.oplayer.ui.vitamio;

import io.vov.vitamio.Vitamio;
import android.app.Activity;
import android.content.Intent;

public final class LibsChecker {
	public static final String FROM_ME = "fromVitamioInitActivity";
	//检查是否有底层库
	public static final boolean checkVitamioLibs(Activity ctx, int msgID) {
		if ((!Vitamio.isInitialized(ctx)) && (!ctx.getIntent().getBooleanExtra("fromVitamioInitActivity", false))) {
			Intent i = new Intent();
			i.setClassName(ctx.getPackageName(), "com.nmbb.oplayer.ui.vitamio.InitActivity");//io.vov.vitamio.activity.InitActivity
			i.putExtras(ctx.getIntent());
			i.setData(ctx.getIntent().getData());
			i.putExtra("package", ctx.getPackageName());
			i.putExtra("className", ctx.getClass().getName());
			i.putExtra("EXTRA_MSG", msgID);
			ctx.startActivity(i);
			ctx.finish();
			return false;
		}
		return true;
	}
}
