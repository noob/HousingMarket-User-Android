package saoyisao;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by hulonghua on 2017/5/9.
 */
public class MApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZXingLibrary.initDisplayOpinion(this);
    }
}
