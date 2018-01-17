package themejunky.com.testfallinghearts;

import android.content.Context;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MIP extends Preference {

   private ImageView imgV;
   public int mImage;
   private PreferenceActivity parent;
   private TextView textV;
   public String title;


   public MIP(Context var1) {
      super(var1);
   }

   public MIP(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   public MIP(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
   }

   public boolean isPersistent() {
      return false;
   }

   protected void onBindView(View var1) {
      super.onBindView(var1);
      this.imgV = (ImageView)var1.findViewById(R.id.recommend_image);
      this.textV = (TextView)var1.findViewById(R.id.recommend_text);
      this.imgV.setImageResource(this.mImage);
      this.textV.setText(this.title);
   }

   void setActivity(PreferenceActivity var1) {
      this.parent = var1;
   }
}
