package themejunky.com.testfallinghearts;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

import org.anddev.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.anddev.andengine.opengl.texture.source.BaseTextureAtlasSource;

public class BitmapTextureAtlasSource extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource
{
    private Bitmap mBitmap;
 
    public BitmapTextureAtlasSource(Bitmap pBitmap) {
        super(0,0);
        this.mBitmap = pBitmap.copy(Config.ARGB_8888, false);
    }
 
    @Override
    public int getWidth() {
        return mBitmap.getWidth();
    }
 
    @Override
    public int getHeight() {
        return mBitmap.getHeight();
    }
 
    @Override
    public BitmapTextureAtlasSource clone() {
        return new BitmapTextureAtlasSource(Bitmap.createBitmap(mBitmap));
    }
		@Override
	public IBitmapTextureAtlasSource deepCopy() {
			// TODO Auto-generated method stub
			return null;
	}

		@Override
		public Bitmap onLoadBitmap(Config pBitmapConfig) {
			// TODO Auto-generated method stub
			return mBitmap;
		}
}