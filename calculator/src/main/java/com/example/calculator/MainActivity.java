package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 简易计算器
 * 整数运算
 * 复数运算
 * 可以进行简单的计算
 * 开平方根，加减乘除等等
 *
 * @author shiqifei
 */

public class MainActivity extends AppCompatActivity {

    StringBuilder input = new StringBuilder();
    @BindView(R.id.tv_input)
    TextView tv_input;
    @BindView(R.id.bt_cleanAll)
    Button bt_cleanAll;
    @BindView(R.id.bt_ride)
    Button bt_ride;
    @BindView(R.id.bt_except)
    Button bt_except;
    @BindView(R.id.bt_clean)
    Button bt_clean;
    @BindView(R.id.bt_7)
    Button bt_7;
    @BindView(R.id.bt_8)
    Button bt_8;
    @BindView(R.id.bt_9)
    Button bt_9;
    @BindView(R.id.bt_plus)
    Button bt_plus;
    @BindView(R.id.bt_4)
    Button bt_4;
    @BindView(R.id.bt_5)
    Button bt_5;
    @BindView(R.id.bt_6)
    Button bt_6;
    @BindView(R.id.bt_subtract)
    Button bt_subtract;
    @BindView(R.id.bt_1)
    Button bt_1;
    @BindView(R.id.bt_2)
    Button bt_2;
    @BindView(R.id.bt_3)
    Button bt_3;
    @BindView(R.id.bt_radical)
    Button bt_radical;
    @BindView(R.id.bt_0)
    Button bt_0;
    @BindView(R.id.bt_spot)
    Button bt_spot;
    @BindView(R.id.bt_equal)
    Button bt_equal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    @OnClick({R.id.bt_cleanAll, R.id.bt_ride, R.id.bt_except, R.id.bt_clean, R.id.bt_7, R.id.bt_8, R.id.bt_9, R.id.bt_plus, R.id.bt_4, R.id.bt_5, R.id.bt_6, R.id.bt_subtract, R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_radical, R.id.bt_0, R.id.bt_spot, R.id.bt_equal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_1:
                input = input.append("1");
                tv_input.setText(input);
                break;

            case R.id.bt_2:
                input = input.append("2");
                tv_input.setText(input);
                break;

            case R.id.bt_3:
                input = input.append("3");
                tv_input.setText(input);
                break;

            case R.id.bt_4:
                input = input.append("4");
                tv_input.setText(input);
                break;

            case R.id.bt_5:
                input = input.append("5");
                tv_input.setText(input);
                break;

            case R.id.bt_6:
                input = input.append("6");
                tv_input.setText(input);
                break;

            case R.id.bt_7:
                input = input.append("7");
                tv_input.setText(input);
                break;

            case R.id.bt_8:
                input = input.append("8");
                tv_input.setText(input);
                break;

            case R.id.bt_9:
                input = input.append("9");
                tv_input.setText(input);
                break;

            case R.id.bt_0:
                input = input.append("0");
                tv_input.setText(input);
                break;
            //加
            case R.id.bt_plus:
                //有没有数字
                input = isString(input);
                input = input.append("+");
                //判断是否已有一个运算符
                input = isReplace(input);
                tv_input.setText(input);
                break;

            //减
            case R.id.bt_subtract:
                //有没有数字
                input = isString(input);
                input = input.append("-");
                //判断是否已有一个运算符
                input = isReplace(input);
                tv_input.setText(input);
                break;

            //乘
            case R.id.bt_ride:
                //有没有数字
                input = isString(input);
                input = input.append("×");
                //判断是否已有一个运算符
                input = isReplace(input);
                tv_input.setText(input);
                break;

            //除
            case R.id.bt_except:
                //有没有数字
                input = isString(input);
                input = input.append("÷");
                //判断是否已有一个运算符
                input = isReplace(input);
                tv_input.setText(input);
                break;

            //开根号
            case R.id.bt_radical:

                //1、将原字符串替换为结果字符串
                input.replace(0,input.length()+1,squareRoot(input));
                System.out.println("inputReplace======"+input);
               //判断是否为整数
                if (isInteger(input.toString())){
                    tv_input.setText(input.substring(0,input.indexOf(".")));
                    break;
                }
                tv_input.setText(input);
                break;

            //小数点
            case R.id.bt_spot:
                input = input.append(".");
                tv_input.setText(input);
                break;

            //删除一个
            case R.id.bt_clean:
                if (input.length() != 0) {
                    input = input.delete(input.length()-1,input.length());
                    tv_input.setText(input);
                }
                break;

            //删除所有
            case R.id.bt_cleanAll:
                if(input.length() != 0){
                    input = input.delete(0,input.length());
                    tv_input.setText(input);
                }
                break;

            /**
             *  等于
             *
             * 1、判断是否进行了运算，若没有运算直接输出原来的值。（根据有没有运算符判断）
             * 2、判断是否为整数之间的运算，若是就返回整数，若不是返回复数
             *
             * */
            case R.id.bt_equal:
                //运算符下表
                int op = 0;
                //获取文本框内容
                StringBuilder serb = new StringBuilder(tv_input.getText());
                //运算符下表
                op = isOperators(serb);
                //1、判断是否进行了运算
                if (op != -1){
                    //运算
                    String result = Float.toString(getResult(op, serb));
                    //2、对返回的结果进行处理
                    if (isInteger(result)){
                        result = result.substring(0,result.indexOf("."));
                    }
                    tv_input.setText(serb+"="+result);
                }else{
                    tv_input.setText(serb);
                }
                break;
        }
    }



    /**
     * 计算
     * 点击等号后调用此方法
     * 对输入的数字进行+ - * / 运算
     */

    private float getResult(int op, StringBuilder result) {

        //获取运算符之前的数字
        String first = result.substring(0, op);
        //获取运算符之后的数字
        String end = result.substring(op + 1, result.length());
        //根据运算符的不同进行计算
        if (result.substring(op, op + 1).equals("+")) {
            return Float.parseFloat(first) + Float.parseFloat(end);
        } else if (result.substring(op, op + 1).equals("-")) {
            return Float.parseFloat(first) - Float.parseFloat(end);
        } else if (result.substring(op, op + 1).equals("×")) {
            return Float.parseFloat(first) * Float.parseFloat(end);
        } else {
            return Float.parseFloat(first) / Float.parseFloat(end);
        }
    }

    /**
     * 判断有误进行运算操作
     * 判断有误运算符
     * 有返回下表     没有返回-1
     */
    public int isOperators(StringBuilder stb) {
        String[] b = {"+", "-", "×", "÷"};
        //循环判断是哪个运算符  v
        for (int i = 0; i < b.length; i++) {
            if (stb.indexOf(b[i]) != -1) {
                return stb.indexOf(b[i]);
            }
        }
        return -1;
    }


    /**
     * 判断是否为整数
     * 只解决了针对2.0的类型 2.00的尚未解决
     */

    public static boolean isInteger(String str) {

        return str.endsWith(".0");
    }

    /**
     * squareRoot 开平方根
     * 对根号前一个数进行开平方根操作
     * 需解决问题：1、对未输入时的开根     " "
     * 2、已输入数字进行开根  三种情况 2   2*4  2*
     */

    public String squareRoot(StringBuilder stb) {
        int index = 0;
        //1、查看是否为空或空字符串
        stb = isString(stb);
        if (!stb.equals("0")) {
            //判断是否有运算符
            index = isOperators(stb);
            if (index != -1) {
                //判断运算符后是否有数字
                if (index + 1 != stb.length()) {
                    return stb.substring(0, index + 1) + Math.sqrt(Double.parseDouble(stb.substring(index + 1, stb.length())));
                }


                return String.valueOf(stb.append("0"));
            }

            return String.valueOf(Math.sqrt(Double.parseDouble(String.valueOf(stb))));
        }
        return stb.toString();
    }


    /**
     * 对直接输入运算符或根号问题进行处理
     * 输入根号，运算符时
     * 若前面没有数字就在他们前面添加一个0
     */
    public StringBuilder isString(StringBuilder stb) {
        if (stb != null && stb.length() != 0) {//*  1* 1
            return stb;
        }
        System.out.println("修改后==========");
        return stb.insert(0, "0");
    }

    /**
     * 点击运算符后操作
     * 判断是否已有一个运算符
     * 没有：直接返回     有 ：新替换旧
     */
    public StringBuilder isReplace(StringBuilder stb) {  //0*  1**

        //判断是否有两个运算符
        boolean a = specialCharacters(stb.substring(stb.length() - 1));
        boolean b = specialCharacters(stb.substring(stb.length() - 2, stb.length() - 1));
        if (a && b) {
            stb.deleteCharAt(stb.length() - 2);
            return stb;
        }
        return stb;
    }


    /**
     * 判断字符串中是否有特殊字符
     * 有返回true 没有false
     * ÷×/-
     */
    public boolean specialCharacters(String str) {
        String regEx = "[ ×÷+-]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

}

