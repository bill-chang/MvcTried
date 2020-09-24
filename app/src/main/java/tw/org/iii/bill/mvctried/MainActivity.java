package tw.org.iii.bill.mvctried;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {

    private Model mModel;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mModel=new Model();
        mModel.addObserver(this);
        mButton1=findViewById(R.id.bt1);
        mButton2=findViewById(R.id.bt2);
        mButton3=findViewById(R.id.bt3);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt1:
                mModel.setValueAtIndex(0);
                break;
            case R.id.bt2:
                mModel.setValueAtIndex(1);
                break;
            case R.id.bt3:
                mModel.setValueAtIndex(2);
                break;
        }
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        mButton1.setText("count:"+mModel.getValueAtIndex(0));
        mButton2.setText("count:"+mModel.getValueAtIndex(1));
        mButton3.setText("count:"+mModel.getValueAtIndex(2));

    }
}