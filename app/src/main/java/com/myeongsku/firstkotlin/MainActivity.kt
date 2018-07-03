package com.myeongsku.firstkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {
    var staticNum : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.staticNum = Random().nextInt(100) + 1;
        this.textView2.text = "Hello World!";
        this.textView.text = "0";

        this.button.setOnClickListener{
            this.whenClickButton()
        }
    }

    fun whenClickButton(){
        var inputData = this.textInputLayout.editText?.text.toString();

        this.textView.text = inputData;

        this.checkNumber(inputData.toInt());
    }

    fun checkNumber(inputNum : Int) {
        if(inputNum > 0 && inputNum <= 100){
            if(inputNum == this.staticNum){
                this.textView2.text = "정답입니다! 게임이 리셋되었습니다.";
                this.staticNum = Random().nextInt(100) + 1;
            } else if(inputNum < this.staticNum){
                this.textView2.text = "좀 더 위!!"
            } else if(inputNum > this.staticNum){
                this.textView2.text = "좀 더 아래!!"
            }

            this.textInputLayout.isErrorEnabled = false;
        } else{
            this.textView2.text = "에러!"
            this.textInputLayout.isErrorEnabled = true;
            this.textInputLayout.error = "입력 조건과 맞지 않습니다.";
        }
    }
}
