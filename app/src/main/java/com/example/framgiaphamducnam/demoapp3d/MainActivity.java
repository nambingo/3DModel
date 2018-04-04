package com.example.framgiaphamducnam.demoapp3d;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import com.example.framgiaphamducnam.demoapp3d.services.ExampleSceneLoader;
import com.example.framgiaphamducnam.demoapp3d.services.SceneLoader;
import com.example.framgiaphamducnam.demoapp3d.util.Utils;
import com.example.framgiaphamducnam.demoapp3d.view.ModelSurfaceView;
import java.io.File;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity {

    private float[] backgroundColor = new float[]{1.0f, 1.0f, 1.0f, 1.0f};
    private SceneLoader scene;
    private Handler handler;
    private String paramAssetDir;
    private String paramAssetFilename;
    private String paramFilename;
    private boolean immersiveMode = true;
    ModelSurfaceView gLView;
    private float[] mEyePoint = {0, 6, 0};

    //@BindView(R.id.btn1)
    //Button btn1;
    //
    //@BindView(R.id.btn2)
    //Button btn2;
    //
    //@BindView(R.id.btn3)
    //Button btn3;
    //
    //@BindView(R.id.btn4)
    //Button btn4;
    //
    //@BindView(R.id.btn5)
    //Button btn5;
    //
    //@BindView(R.id.btn6)
    //Button btn6;
    //
    //@BindView(R.id.btnClear)
    //Button btnClear;
    boolean isClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);
        ButterKnife.bind(this);
        gLView = findViewById(R.id.glView);
        gLView = new ModelSurfaceView(this);
        setContentView(gLView);
        paramAssetDir = "models";
        paramAssetFilename = "baby.obj";
        paramFilename = null;
        if (paramFilename == null && paramAssetFilename == null) {
            scene = new ExampleSceneLoader(this);
        } else {
            scene = new SceneLoader(this);
        }
        scene.init();
        scene.stopLight();
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setGravity(Gravity.CENTER_VERTICAL);

        Button handBtn = new Button(this);
        Button headBtn = new Button(this);
        Button resetBtn = new Button(this);
        setBackround(handBtn, "Left");
        setBackround(headBtn, "Head");
        setBackround(resetBtn, "Reset");

        ll.addView(handBtn);
        ll.addView(headBtn);
        ll.addView(resetBtn);


        this.addContentView(ll,new
                ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.FILL_PARENT));
        handBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isClick){
                    isClick = true;
                }else {
                    isClick = false;
                }
                scene.leftClickListener(isClick);
            }
        });
        headBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isClick){
                    isClick = true;
                }else {
                    isClick = false;
                }
                scene.headClickListener(isClick);
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scene.resetClickListener();
            }
        });
        //zoomOut.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        if (!isClick){
        //            isClick = true;
        //        }else {
        //            isClick = false;
        //        }
        //        scene.tay2(isClick);
        //    }
        //});
        Utils.printTouchCapabilities(getPackageManager());

    }

    private void setBackround(Button button, String text){
        //final int sdk = android.os.Build.VERSION.SDK_INT;
        //if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
        //    button.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.bg_setup_button) );
        //} else {
        //    button.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_setup_button));
        //}
        button.setText(text);
        button.setAllCaps(false);

    }
    
    //@OnClick({R.id.btn1})
    //public void onClick(){
    //
    //}
    

    //@Optional
    //@OnClick({ R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btnClear })
    //public void onClick(View view) {
    //    switch (view.getId()) {
    //        case R.id.btn1:
    //            if (scene.getCamera()== null){
    //                Log.e("MainActivity", "onClick:  -----> NULL");
    //            }else {
    //                Log.e("MainActivity", "onClick:  -----> NOT NULL");
    //            }
    //            //scene.translate();
    //            break;
    //        case R.id.btn2:
    //            scene.zoomIn();
    //            break;
    //        case R.id.btn3:
    //            break;
    //        case R.id.btn4:
    //            break;
    //        case R.id.btn5:
    //            break;
    //        case R.id.btn6:
    //            break;
    //        case R.id.btnClear:
    //            break;
    //    }
    //}

    public float[] getBackgroundColor(){
        return backgroundColor;
    }

    public SceneLoader getScene() {
        return scene;
    }

    public File getParamFile() {
        return getParamFilename() != null ? new File(getParamFilename()) : null;
    }

    public String getParamAssetDir() {
        return paramAssetDir;
    }

    public String getParamAssetFilename() {
        return paramAssetFilename;
    }

    public String getParamFilename() {
        return paramFilename;
    }

    public ModelSurfaceView getgLView() {
        return gLView;
    }
}
