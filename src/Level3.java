import java.util.*;
public class Level3 {
    public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        System.out.print("表中还没有数据，请先录入数据哦！\n请输入您要添加信息的学生个数：");
        int m=input.nextInt();
        String[][] s = new String[2][100];
        int x=1;
        while(x==1){
            System.out.println("请问您需要进行什么操作呢？\n本系统只提供四种操作哦！\n增加---删除---查询---更改");
            String i = input.next();
            if(i.equals("增加")){
                add(s,m);
            }else if(i.equals("删除")){
                m=delete(s,m);
            }else if(i.equals("查询")){
                cheak(s,m);
            }else if(i.equals("更改")){
                change(s,m);
            }else{
                System.out.println("不好意思，还没有提供您输入的服务呢。");
            }
            System.out.println("您是否需要继续操作呢？【yes/no】");
            String j= input.next();
            if(j.equals("yes")){
                continue;
            }else{
                System.out.println("感谢您的使用！");
                break;
            }
        }
    }
    public static void add(String s[][],int m){
        Scanner input=new Scanner(System.in);
        for(int j=1;j<=m;j++){
            System.out.println("请输入学生学号：");
            String name=input.next();
            for(int i=0;i<m;i++){
                if(s[0][i]==null){
                    s[0][i]=name;
                    break;
                }else{
                    continue;
                }
            }
            System.out.println("请输入学生姓名：");
            String num=input.next();
            for(int i=0;i<m;i++){
                if(s[1][i]==null){
                    s[1][i]=num;
                    break;
                }else{
                    continue;
                }
            }
        }
        System.out.println("输入完毕！");
        System.out.println("是否需要按学号排序输出呢？【yes/no】");
        String choose=input.next();
        if(choose.equals("yes")){
            int bubbling[]=new int[m];
            for(int t=0;t<m;t++){                       //将学号转换为int型
                bubbling[t]=Integer.parseInt(s[0][t]);
            }
            for(int t=1;t<m;t++){                       //冒泡法
                for(int y=0;y<m-t;y++){
                    if(bubbling[y]>bubbling[y+1]){
                        int a=bubbling[y];
                        bubbling[y]=bubbling[y+1];
                        bubbling[y+1]=a;
                    }
                }
            }
            for(int t=0;t<m;t++){
                for(int y=0;y<m;y++){
                    if((Integer.parseInt(s[0][y]))==bubbling[t]){
                        System.out.println("学号："+s[0][y]+"-->姓名:"+s[1][y]);
                        break;
                    }
                }
            }
        }else{
            for(int i=0;i<m;i++){
                System.out.println("学号："+s[0][i]+"-->姓名:"+s[1][i]);
            }
        }
    }
    public static int delete(String s[][],int m){
        Scanner input=new Scanner(System.in);
        int n=m;
        int x;
        int j;
        while(n>0){
            x=n;
            System.out.println("需要删除的学号：");
            String num=input.next();
            System.out.println("num="+num);
            for(j=0;j<n;j++){
                if(s[0][j].equals(num)){            //找到num
                    for(int k=j;k<=n-2;k++){
                        s[0][k]=s[0][k+1];          //把需要删除记录的后边的记录往前面移一格
                        s[1][k]=s[1][k+1];
                    }
                    n-=1;                           //数组长度-1
                    System.out.println("删除成功！");
                }
                if(n!=x){
                    s[0][n]=null;
                    s[1][n]=null;
                    break;
                }
            }
            if(j==m){
                System.out.println("不好意思，您需要删除的数据不存在。");
            }
            System.out.println("是否继续删除数据？【yes/no】");
            String answer=input.next();
            if(answer.equals("yes")){
                continue;
            }else{
                break;
            }
        }
        System.out.println("删除后的信息为：");
        int bubbling[]=new int[n];
        for(int t=0;t<n;t++){                       //将学号转换为int型
            bubbling[t]=Integer.parseInt(s[0][t]);
        }
        for(int t=1;t<n;t++){                       //冒泡法
            for(int y=0;y<n-t;y++){
                if(bubbling[y]>bubbling[y+1]){
                    int a=bubbling[y];
                    bubbling[y]=bubbling[y+1];
                    bubbling[y+1]=a;
                }
            }
        }
        for(int t=0;t<n;t++){
            for(int y=0;y<n;y++){
                if((Integer.parseInt(s[0][y]))==bubbling[t]){
                    System.out.println("学号："+s[0][y]+"-->姓名:"+s[1][y]);
                    break;
                }
            }
        }
        m=n;
        return m;
    }
    public static void cheak(String s[][],int m){
        Scanner input = new Scanner(System.in);
        int k=1;
        int i;
        while(k==1){
            System.out.println("请输入您要查找的学生学号：");
            String num=input.next();
            for(i=0;i<m;i++){
                if(s[0][i].equals(num)){
                    System.out.println("学号："+s[0][i]+'\t'+"姓名："+s[1][i]);
                    break;
                }
            }
            if(i==m){
                System.out.println("对不起，没有找到您需要的信息啊。");
            }
            System.out.print("您还要继续查找吗？【yes/no】");
            String choose=input.next();
            if(choose.equals("yes")){
                k=1;
            }else{
                k=0;
            }
        }
    }
    public static void change(String s[][],int m){
        Scanner input=new Scanner(System.in);
        int k=1;
        while(k==1){
            System.out.println("请输入您要修改的原学生学号：");
            String num= input.next();
            for(int i=0;i<m;i++){
                if(s[0][i].equals(num)){
                    System.out.println("请问您要更改学生姓名还是学号呢？");
                    String style= input.next();
                    if(style.equals("学号")){
                        System.out.println("请输入新的学号：");
                        s[0][i]=input.next();
                        break;
                    }else if(style.equals("姓名")){
                        System.out.println("请输入新的姓名：");
                        s[1][i]=input.next();
                        System.out.println("修改成功！\n该学生的信息为：学号："+s[0][i]+"-->姓名:"+s[1][i]);
                        break;
                    }else{
                        System.out.println("请选择修改姓名或者学号哦！");
                        break;
                    }
                }
            }
            System.out.println("是否继续修改？【yes/no】");
            String choose=input.next();
            if(choose.equals("yes")){
                k=1;
            }else{
                k=0;
            }
        }
        System.out.println("修改后的信息为：");
        int bubbling[]=new int[m];
        for(int t=0;t<m;t++){                       //将学号转换为int型
            bubbling[t]=Integer.parseInt(s[0][t]);
        }
        for(int t=1;t<m;t++){                       //冒泡法
            for(int y=0;y<m-t;y++){
                if(bubbling[y]>bubbling[y+1]){
                    int a=bubbling[y];
                    bubbling[y]=bubbling[y+1];
                    bubbling[y+1]=a;
                }
            }
        }
        for(int t=0;t<m;t++){
            for(int y=0;y<m;y++){
                if((Integer.parseInt(s[0][y]))==bubbling[t]){
                    System.out.println("学号："+s[0][y]+"-->姓名:"+s[1][y]);
                    break;
                }
            }
        }
    }
}