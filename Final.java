package 第4次作业;

import java.util.Scanner;

class Mistake extends Exception {
    public Mistake(String mistake) {
        super(mistake);
    }
}

class Number {
    private String Operate;
    private double front;
    private double behind;

    public void shu() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你要使用的运算方法对应的符号:+，-，*，/");
            System.out.println("温馨提醒:不能除以0哦");
            this.Operate = scanner.next();
            System.out.println("请输入四则运算符号前的数字");
            this.front = scanner.nextDouble();
            System.out.println("请输入四则运算符号后的数字");
            this.behind = scanner.nextDouble();
            if (this.front >= 9.223372036854776E15 - 1 || this.behind <= -9.223372036854776E15) {
                throw new Mistake("啊这，为什么要输入这么大的数字啊？");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public String getOperate() {
        return this.Operate;
    }

    public double getFront() {
        return this.front;
    }

    public double getBehind() {
        return this.behind;
    }
}

public class Final {
    public static void main(String[] args) {
        Calculate();
    }


    public static void Calculate() {
        try {
            Number w = new Number();
            w.shu();
            String z = w.getOperate();
            double x = w.getFront();
            double y = w.getBehind();

            switch (z) {
                case "+":
                    double a = x + y;
                    a = (double) Math.round(a * 1000) / 1000;
                    if (a >= 9.223372036854776E15 - 1 || a <= -9.223372036854776E15) {
                        throw new Mistake("是在下无能，数据过大请阁下另请高明");
                    }
                    System.out.println("加法运算的结果为(保留到小数点后三位,有效数字后的0省略)" + a);

                    break;
                case "-":
                    double b = x - y;
                    b = (double) Math.round(b * 1000) / 1000;
                    if (b >= 9.223372036854776E15 - 1 || b <= -9.223372036854776E15) {
                        throw new Mistake("是在下无能，数据过大请阁下另请高明");
                    }
                    System.out.println("减法运算的结果为(保留到小数点后三位,有效数字后的0省略)" + b);

                    break;
                case "*":
                    double c = x * y;
                    c = (double) Math.round(c * 1000) / 1000;
                    if (c>=9.223372036854776E15-1||c<=-9.223372036854776E15){
                        throw new Mistake("是在下无能，数据过大请阁下另请高明");
                    }
                    System.out.println("乘法运算的结果为(保留到小数点后三位,有效数字后的0省略)" + c);

                    break;
                case "/":

                    double temp = x / y;
                    if (y == 0) {
                        System.out.println("都说了不要除以0了，乖听话");
                        System.exit(0);
                    }
                    temp = (double) Math.round(temp * 1000) / 1000;
                    if (temp>=9.223372036854776E15-1||temp<=-9.223372036854776E15){
                        throw new Mistake("是在下无能，数据过大请阁下另请高明");
                    }
                    System.out.println("除法运算的结果为(保留到小数点后三位,有效数字后的0省略)" + temp);

                    break;
                default:
                    System.out.println("选择符号时要输入符合要求的值啊,再试一次吧");
                    break;
            }
        } catch (Exception f) {
            System.out.println(f);
        }
    }
}