/**
 * Created by y0n on 2017/4/17.
 * 1.输出控制台传递的默认参数
 */
public class JavaDay001_1 {
 
    public static void main(String[] args) {
 
        System.out.println(args);
    }
}
 
/**
 * Created by y0n on 2017/4/17.
 * 2.编程求表达式的结果
 */
public class JavaDay001_2 {
 
    public static void main(String[] args) {
        System.out.println("128 & 129 = " + (128 & 129));
        System.out.println("56 | 32 = " + (56 | 32));
        System.out.println("27 ^ 123 = " + (27 ^ 123));
    }
}
 
 
 
 
/**
 * Created by y0n on 2017/4/17.
 * 3.从键盘上输入3个数，求出这三个数字中的最大值，并将最大值输出
 */
import java.util.Scanner;
public class JavaDay001_3 {
    public static void main(String[] args) {
        System.out.println("请输入3个数：");
        Scanner scanner = new Scanner(System.in);
        int nNumA = scanner.nextInt();
        int nNumB = scanner.nextInt();
        int nNumC = scanner.nextInt();
 
        int nMax = 0;
        if (nNumA >= nNumB && nNumA >= nNumC)
        {
            nMax = nNumA;
        }
        else if (nNumB >= nNumC && nNumB >= nNumA)
        {
            nMax = nNumB;
        }
        else if (nNumC >= nNumA && nNumC >= nNumB)
        {
            nMax = nNumC;
        }
        else
        {
            System.out.println("无法比较!");
        }
        System.out.println("Max = " + nMax);
    }
}
 
 
/**
 * Created by y0n on 2017/4/17.
 * 4.编写万年历小程序
 * 输出结果：
 * 请输入年：2016
 * 请输入月：6
 * 2016年非润年
 * 2016年6月份的天数是30
 */
import com.sun.webkit.BackForwardList;
 
import java.util.Scanner;
 
public class JavaDay001_4 {
    public static void main(String[] args) {
        System.out.println("请输入年：");
        Scanner scanner = new Scanner(System.in);
        int nYear = scanner.nextInt();
        System.out.println("请输入月：");
        int nMounth = scanner.nextInt();
        int nflag = 0;
        if (nYear % 4 == 0)
        {
            if (nYear % 100 == 0)
            {
                if (nYear % 400 == 0)
                {
                    nflag = 1;
                    System.out.println(nYear + "年是润年");
                }
                else
                {
                    System.out.println(nYear + "年不是润年");
                }
            }
            else
            {
                nflag = 1;
                System.out.println(nYear + "年不是润年");
            }
        }
        else
        {
            System.out.println(nYear + "年不是润年");
        }
 
        //判断2016年月份的天数
        if (nMounth == 1
                || nMounth == 3
                || nMounth == 5
                || nMounth == 7
                || nMounth == 8
                || nMounth == 10
                || nMounth == 12 )
        {
            System.out.println(nYear + "年" + nMounth + "月份的天数是：31" );
        }
        else if (nMounth == 4
                || nMounth == 6
                || nMounth == 9
                || nMounth == 11)
        {
            System.out.println(nYear + "年" + nMounth + "月份的天数是：30" );
        }
        else
        {
            if (nflag == 0)
            {
                System.out.println(nYear + "年" + nMounth + "月份的天数是：28" );
            }
            else
            {
                System.out.println(nYear + "年" + nMounth + "月份的天数是：29" );
            }
        }
    }
}
 
 
/**
 * Created by y0n on 2017/4/17.
 * 5.从键盘输入学生学号：20161103（2016年+11期+03号）
 * 使用“/”和“%”云算符分解学生学号获得年份期数和序号
 * 并且输出：
 * 学生学号：20161103
 * 学生入学年份：2016年
 * 学生期数：11期
 * 学生序号：03号
 */
import java.util.Scanner;
 public class JavaDay001_5 {
    public static void main(String [] args)
    {
        System.out.println("请输入学生学号：");
        Scanner scanner = new Scanner(System.in);
        int nStudent = scanner.nextInt();
        int nStudentYear = nStudent / 10000;
        int nStudentTime = (nStudent / 100) % nStudentYear;
        int nStudentId = nStudent % (nStudent / 100);
        System.out.println("学生学号:" + nStudent);
        System.out.println("学生入学年份:" + nStudentYear + "年");
        System.out.println("学生期数:" + nStudentTime + "期");
        System.out.println("学生序号:" + nStudentId + "号");
    }
}
 
/**
 * Created by y0n on 2017/4/17.
 * 6.为指定成绩加分，直到分数大于等于60为止，
 * 输出加分前和加分后的成绩，并统计加分的次数
 * 输出结果：
 * 加分前成绩：55
 * 加分后成绩：60
 * 共加了5次！
 */
 
import java.util.Scanner;
public class JavaDay001_6 {
    public static void main(String [] args)
    {
        System.out.println("请指定分数：");
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        int nCount = 0;
        if (score < 60)
        {
            int temp = score;
            while (temp < 60)
            {
                temp++;
                nCount++;
            }
            System.out.println("加分前成绩：" + score);
            System.out.println("加分后成绩：" + temp);
            System.out.println("共加了" + nCount + "次!");
        }
        else
        {
            System.out.println("不用加分!");
        }
    }
}
 
/**
 * Created by y0n on 2017/4/17.
 *7.画图
 */
public class JavaDay001_7 {
    public static void main(String [] args){
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (i == 0 && j == 3)
                {
                    System.out.print("*");
                }
                else if(i == 1 && j < 5 && j > 1)
                {
                    System.out.print("*");
                }
                else if(i == 2 && j < 6 && j > 0)
                {
                    System.out.print("*");
                }
                else if (i == 3)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
 
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if(i == 0 && j < 6 && j > 0)
                {
                    System.out.print("*");
                }
                else if (i == 1 && j < 5 && j > 1)
                {
                    System.out.print("*");
                }
                else if (i == 2 && j ==3)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
 
 
 
/**
 * Created by y0n on 2017/4/17.
 * 8.键盘输入五位数字的会员卡号：38503
 * 使用“/”和“%”运算符分解获得的会员卡每一位上的数字
 * 将每一位数字求和
 */
import java.util.BitSet;
import java.util.Scanner;
public class JavaDay001_8 {
    public static void main(String []args)
    {
        System.out.println("请输入五位数会员卡号：");
        Scanner scanner = new Scanner(System.in);
        int nVIPCard = scanner.nextInt();
        int nW = nVIPCard / 10000;
        int nQ = (nVIPCard / 1000) % 10;
        int nB = (nVIPCard / 100) % 10;
        int nS = (nVIPCard / 10) % 10;
        int nG = nVIPCard % 10;
 
        System.out.println("会员卡号：" + nVIPCard);
        System.out.println("万位数：" + nW
                + " 千位数：" + nQ
                + " 百位数：" + nB
                + " 十位数：" + nS
                + " 个位数：" + nG);
        System.out.println("会员卡号" + nVIPCard
                + "每位的总和为："
                + (nW + nQ + nB + nS + nG));
    }
}
 
 
/**
 * Created by y0n on 2017/4/17.
 * 9.编写万年历程序
 */
 
import java.util.Scanner;
public class JavaDay001_9 {
    static String CaculateWeekDay(int y,int m,int d)
    {
        if(m==1)
        {
            m = 13;
            y--;
        }
        if(m==2)
        {
            m=14;
            y--;
        }
        int week=(d+2*m+3*(m+1)/5+y+y/4-y/100+y/400)%7;
        String weekstr = null;
        switch(week)
        {
            case 0: weekstr="星期一"; break;
            case 1: weekstr="星期二"; break;
            case 2: weekstr="星期三"; break;
            case 3: weekstr="星期四"; break;
            case 4: weekstr="星期五"; break;
            case 5: weekstr="星期六"; break;
            case 6: weekstr="星期日"; break;
        }
        return weekstr;
    }
 
    public static void main(String [] args)
    {
        int [][] day = new int[5][7];
        System.out.print("请选择年份：");
        Scanner scanner = new Scanner(System.in);
        int nYear = scanner.nextInt();
        System.out.print("请选择月份：");
        int nMounth = scanner.nextInt();
 
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
        int bflag = 0;
        String strWeek = CaculateWeekDay(nYear, nMounth, 1);
        if (strWeek.equals("星期一"))
        {
            day[0][1] = 1;
        }
        if (strWeek.equals("星期二"))
        {
            day[0][2] = 1;
        }
        if (strWeek.equals("星期三"))
        {
            day[0][3] = 1;
        }
        if (strWeek.equals("星期四"))
        {
            day[0][4] = 1;
        }
        if (strWeek.equals("星期五"))
        {
            day[0][5] = 1;
        }
        if (strWeek.equals("星期六"))
        {
            day[0][6] = 1;
            bflag = 1;
        }
        if (strWeek.equals("星期日"))
        {
            day[0][0] = 1;
        }
 
        if (nMounth == 1 ||
                nMounth == 3 ||
                nMounth == 5 ||
                nMounth == 7 ||
                nMounth == 8 ||
                nMounth == 10 ||
                nMounth == 12)
        {
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    if (day[i][j] == 1)
                    {
                        for (int m = 0; m < 31; m++)
                        {
                            System.out.print(day[i][j] + m + "\t\t");
                            if ((j + m + 1) % 7 == 0)
                            {
                                System.out.println();
                            }
                        }
                    }
                    else
                    {
                        System.out.print("\t\t");
                    }
                }
 
            }
        }
        else if (nMounth == 4 ||
                nMounth == 6 ||
                nMounth == 9 ||
                nMounth == 11)
        {
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    if (day[i][j] == 1)
                    {
                        for (int m = 0; m < 30; m++)
                        {
                            System.out.print(day[i][j] + m + "\t\t");
                            if ((j + m + 1) % 7 == 0)
                            {
                                System.out.println();
                            }
                        }
                    }
                    else
                    {
                        System.out.print("\t\t");
                    }
                }
 
            }
        }
        else
        {
            if ((nYear % 4 == 0 || nYear % 400 == 0) && nYear % 100 != 0)
            {
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 7; j++)
                    {
                        if (day[i][j] == 1)
                        {
                            for (int m = 0; m < 29; m++)
                            {
                                System.out.print(day[i][j] + m + "\t\t");
                                if ((j + m + 1) % 7 == 0)
                                {
                                    System.out.println();
                                }
                            }
                        }
                        else
                        {
                            System.out.print("\t\t");
                        }
                    }
                }
            }
            else
            {
                for (int i = 0; i < 5; i++)
                {
                    for (int j = 0; j < 7; j++)
                    {
                        if (day[i][j] == 1)
                        {
                            for (int m = 0; m < 28; m++)
                            {
                                System.out.print(day[i][j] + m + "\t\t");
                                if ((j + m + 1) % 7 == 0)
                                {
                                    System.out.println();
                                }
                            }
                        }
                        else
                        {
                            System.out.print("\t\t");
                        }
                    }
 
                }
            }
        }
    }
}
