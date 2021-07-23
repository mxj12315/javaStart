

## 前奏

### java的运行机制
java编译器将java文件编译为字节码（没有彻底编译，未生成机器指令），jvm将字节码文件编译为对应平台的机器指令，从而实现运行和跨平台




### jvm和jrm
jre = jvm + 各种基础类库 + java类库（比如String/System类）


### path
告诉操作系统去哪里找命令
`%JAVA_HOME%/bin` 其中`JAVA_HOME`指已有的`JAVA_HOME`所配置的路径


### 验证jdk命令
javac -version
```powershell
javac 1.8.0_271
```
### 验证jre命令
java -version
```powershell
java version "1.8.0_271"
Java(TM) SE Runtime Environment (build 1.8.0_271-b09)
Java HotSpot(TM) 64-Bit Server VM (build 25.271-b09, mixed mode)
```
### CLASSPATH
告诉jre去哪里找class文件，如果不配置，默认去当前目录中查找




### java程序的基本结构
源程序以`.java`结尾
类：class，在同一个类中`public`修饰的类只能有一个，称为主类
主类类名必须与文件名相同




### 编译命令
javac -d <目录> 源文件

- 其中-d指定生成“字节码文件”放到指定位置
- 源文件中有几个类就生成几个`.class`文件





### 编码问题
`javac -encoding utf-8  -d . className`
## 流程控制
### switch
```java
switch(byte|short|int|String|Enum){
    case 表达式1:
        // 语句
        break;
}
```
## java传参机制
只是值传递，传递的是副本，不会改变值本身
传递参数是基本数据类型，原始的数据不会改变
传递参数是引用类型，原始的值不会改变，但是内存地址对应的内容会发生改变
```java
package com.minsusu;


/**
 * 函数的参数
 *  1、基本类型
 *  2、引用类型
 */
public class FunctionTest {
    public static void main(String[] args){
        // 传递参数是基本数据类型，原始的数据不会改变
        int a = 3;
        int b = 4;
        exchange(a,b);
        System.out.println("a的值:"+a);  // a的值:3
        System.out.println("b的值:"+b);  // b的值:4

        // 传递参数是引用类型，原始的值不会改变，但是内存地址对应的内容会发生改变
        Person person =new Person();
        person.name = "马云";
        exchange(person);
        System.out.println(person.name);  //内容发生改变=>王健林
        System.out.println(person);  //  地址值不会改变Person@1b6d3586
    }

    /**
     * 交换两个数字的位置
     * @param a  第一个数字
     * @param b  第二个数字
     */
    public static void exchange(int a, int b){
        int tmp = a;
        a = b;
        b = tmp;

    }


    public static void exchange(Person person){
        person.name = "王健林";
        person = null;
    }
}


class Person {
    String name;
}
```


### java中的变量
成员变量（在类中定义）：分为类变量（有static）和实例变量（没有static）

- 不需要初始化，系统默认有初始值，数值型初始化0，布尔型初始化为false，引用型初始化为null
```java
package com.minsusu;

public class Variable2 {
    int a;  // 实例变量
    static int b;  // 类变量
    public static void main(String[] args) {
        // 访问实例变量
        Variable2 v = new Variable2();
        System.out.println("实例变量a:"+v.a);  // 实例变量a:0


        // 访问类变量
        System.out.println("类变量b:"+b);  // 类变量b:0

    }
}
```
局部变量（在方法中定义）：形式参数，普通变量，代码块中的局部变量

- 必须显示的指定为初始值，然后才能使用，否则编译报错
```java
package com.minsusu;

public class variable {
    public static void main(String[] args) {
        int a ;  // 局部变量,必须指定初始值，才能使用
        System.out.println(a);
    }
}


out
java: 可能尚未初始化变量a
```
## java三四五
三种类型：类、接口、枚举
四个修饰符：`private|protected|public`、`final`、`static`、`abstract`
五大成员：成员变量、方法、构造器  、初始化代码块、内部类
## java修饰符
| **修饰符** | **顶层类/接口** | **成员属性** | **方法** | **构造器** | **初始化块** | **成员内部类** | **局部成员** | **备注** |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| public | √ | √ | √ | √ |  | √ |  |  |
| protected |  | √ | √ | √ |  | √ |  |  |
| 包访问控制符 | √ | √ | √ | √ | ○ | √ | ○ |  |
| private |  | √ | √ | √ |  | √ |  |  |
| abstract | √ |  | √ |  |  | √ |  |  |
| final | √ | √ | √ |  |  | √ | √ |  |
| static |  | √ | √ |  | √ | √ |  |  |
| strictfp | √ |  | √ |  |  | √ |  | 严格浮点数 |
| synchronized |  |  | √ |  |  |  |  | 线程同步 |
| native |  |  | √ |  |  |  |  | 原生C/C++ |
| transient |  | √ |  |  |  |  |  | 序列化 |
| volatile |  | √   |  |  |  |  |  | 线程同步，让其他线程立即知道修改 |

## 面向对象
### 定义类
```java
[修饰符] class 类名{
    // 成员变量
    // 方法
    // 构造器 
    // 初始化代码块
    // 内部类
}
```
类的修饰符：有且仅有`public`、`final`(或者`abstract`)。`final`和`abstract`互斥，只能有一个；
类名首字母大写，多个单词第一个字母大写
### 定义成员变量
```java
[修饰符] 类型 变量名 [= 初始值] 
```
### 定义方法
```java
[修饰符] 返回值类型 方法名（形参列表）{
	// 各种语句。定义变量、流程控制、赋值语句输出语句
}
```
### 定义构造器
```java
[修饰符] 类名（形参列表）{
	// 各种语句。定义变量、流程控制、赋值语句输出语句
}
```
### java封装

- 隐藏：隐藏的内部实现细节
- 暴露：将一些操作界面暴露出来，通过暴露出来的界面操作对象，不会破坏对象内部

要求：合理的隐藏、合理的暴露
#### 访问控制符
| **权限** | **private** | **缺省** | **protected** | **public** |
| :---: | :---: | :---: | :---: | :---: |
| 当前类 | √ | √ | √ | √ |
| 同一个包 | × | √ | √ | √ |
| 子类 | × | × | √ | √ |
| 任意 | × | × | × | √ |

使用原则：

- 成员变量（实例变量）：通常使用private修饰，为了隐藏细节
- 为成员变量提供对应的public修饰的getXxx方法个setXxx方法，给外部对数据进行控制
- 需要暴露的方法，通常使用public修饰
- 如果一个方法希望被子类重写，一般用protected修饰
### java继承
java单继承；
如果没有写父类，默认继续Object类；
继承的作用，实现代码的复用
```java
[修饰符] clas 类名 extends父类{
}
```
#### 重写override
子类发现父类的方法不适用时，就要对方法进行重写
重写的口诀

- 2同：方法名相同，参数列表相同
- 2小：返回值类型相同或更小，声明抛出的异常相同或更小
- 1大：访问权限相同或更大



在重写的方法上方加上`@override` ，报错时会提醒：`方法不会覆盖或实现超类型的方法`


#### super限定
限定父类的定义的实例变量或者实例方法

- super.父类定义的实例变量
- super.父类定义的实例方法（参数）
#### 子类构造器调用父类构造器
子类构造器一定调用父类的构造器一次，有且仅有一次
父类如果写了带参数的构造器，那么必须写上无参数构造器

- 子类没有显示的调用父类的构造器，系统会默认调用父类的无参数构造器
- 子类构造器第一行显示的使用super调用父类的构造器

super调用一定是调用父类的构造器
this调用的是当前类的构造器
super和this不可能同时出现
**注意**：如果父类没有无参构造器，子类必须显示的调用（使用super调用）父类指定的构造器


### java多态
多态：同一个类的多个实例，在执行同一个方法，呈现出多种行为特征
向上转型：int>long    子类>父类   自动转换
向下转型：long>int    父类>子类   强制转换
   只能在父子继承关系的类中强制转换，否则会报类型转换错误异常，不兼容的类型
   如果编译类型具有继承关系，被转变量类型不是要转换的目标类型就会报类型转换异常，classcastException


变量类型

- 编译时类型：申明变量是指定的类型（编译阶段）
- 运行时类型：该变量时机所引用的类型（实际类型）



条件

- 要有继承；
- 要有重写；
- 父类引用指向子类对象。





#### `instanceof`
只有在具有继承关系的类中才能进行判断
```java
      String str= "kfmkm";
        System.out.println(str instanceof Integer);


out：
	不兼容的类型: java.lang.String无法转换为java.lang.Integer
```
### 初始化块


```java
[修饰符] {
	各种语句
}
```
修饰符只能有一个`static`，有`static`的称为类初始化块，无`static`的称为实例初始化块
#### 类初始化块
作用：负责对类执行初始化
何时执行：当程序第一次主动使用该类时，系统会为该类分配内存空间、并执行初始化，调用类的初始化块
执行次数：只执行一次


在类变量定义时指定的初始值，是“假象”
指定的类初始值，编译之后会被还原到类初始化代码块中的一条赋值语句；
类初始化代码块和初始化类变量谁在前谁在后？
顺序以源代码中的顺序相同
```java
public class StaticInitTest {
    // 类初始化变量1
    static String name  = "王思聪";

    // 类初始化代码块
    static {
        name = "房祖名";
        name1 = "张学友";
    }

    // 类初始化变量2
    static String name1 = "刘德华";

}



/******************************编译还原后等同于*****************************************/


public class StaticInitTest {
    // 定义类变量
    static String name;
     static String name1;

    // 类初始化代码块,变量赋值语句顺序与源代码中的顺序相同
    static {
        name = "王思聪";
        name = "房祖名";
        
        name1 = "张学友";
        name1 = "刘德华";
    }

}
```


#### 实例初始化块
类被编译后，实例初始化块会消失，实力初始化的所有代码会被还原到每一个构造器的开始
作用：将多个构造器开始前面部分提取到实例初始化块中
何时执行：只要程序调用构造器创建对象时，程序都会执行初始化代码块中的代码
执行次数：调用构造器时 


定义的实例变量指定的初始值，是“假象”
编译后将会还原到所有构造器代码之前


实例代码块和初始化实例变量谁在前谁在后？
由源代码中的顺序决定
```java
public class InitTest {
    // 定义实例变量,编译时会还原到构造器中的一条赋值语句
    int age1 = 30;

    // 实力初始化代码块，编译时会被还原到每一个构造器中
    {
        System.out.println("实例初始化块");
        age = 5 ;
        age1 = 10 ;
    }

    // 定义实例变量,编译时会还原到构造器中的一条赋值语句
    int age = 20;

    public InitTest(){
        System.out.println("无参数构造器");
    }


    public InitTest(String name){
        System.out.println("有参数构造器："+name);
    }
}

/*************************编译还原后等同于**************************/

public class InitTest {
   // 定义实例变量
    int age1;
    int age;

    public InitTest(){
        // 还原部分start
        age1 = 30;
        System.out.println("实例初始化块");
        age = 5 ;
        age1 = 10 ;
        age = 20;
        // 还原部分end
        System.out.println("无参数构造器");
    }


    public InitTest(String name){
       // 还原部分start
        age1 = 30;
        System.out.println("实例初始化块");
        age = 5 ;
        age1 = 10 ;
        age = 20;
        // 还原部分end
        System.out.println("有参数构造器："+name);
    }
}
```
**结论**
初始化任何类之前，一定先从Object开始初始化，依次初始化它的所有祖先类，最后才到自己类的初始化。
创建任何对象之前，一定先从Object构造器开始执行，执行它的所有祖先类的构造器，最后才到自己的构造器。


## 包装类
8种基本数据类型
int  char long byte double float  boolean short 
对应表

| **数据类型名称** | **占用字节** | **默认值** | **封装器** |
| :---: | :---: | :---: | :---: |
| byte(字节型) | 1 | 0 | Byte |
| short(短整型) | 2 | 0 | Short |
| int(整型) | 4 | 0 | Integer |
| long(长整型) | 8 | 0L | Long |
| float(浮点型) | 4 | 0.0f | Float |
| double(双精度浮点型) | 8 | 0.0 | Double |
| char(字符型) | 2 | 'u0000' | Charcte |
| boolean | 1 | false | Boolean |

**long类型如果不加L会自动转型为int，如果超出int取值范围则会报错**
### 自动装箱
基本数据类型的值可以自动当成包装类的实例使用
### 自动拆箱
包装类的实例可以当做基本类型的值使用


建议
做项目时候，通常使用包装类来申明变量，因为包装类可以当做基本数据类型使用，并且可以复赋值为null


#### 包装类.parseXxx()
不同包装类之间的转换，包装类.parseXxx()
java.lang.NumberFormatException:要转换的数字不合法，出现异常数字格式异常


#### 包装类型缓冲
```powershell
package com.minsusu;

/**
 * 包装类的缓冲
 */
public class PackageingBuffer {
    public static void main(String[] args) {
        Integer i = 20;   // -128~127范围内会有缓冲
        Integer j = 20;

        Integer k = 200;  // 不在-128~127范围内不会有缓冲
        Integer l = 200;

        System.out.println(i==j);   //true
        System.out.println(k==l);  //false
    }
}
```
### 变量类型转换
在JAVA中，基本类型(除了boolean外)可以自动转换的，转换形式为：byte,short,char – int --long–float–double这就是自动转换的顺序了，其中byte,short,char在运算时是自动转换为int型的，而int与long运算时自动转换为long型。从上可知，float与double运算时是自动转换为double再进行计算的，int与float运算时先转换为float再运算。也就是说，表述范围小的可以自动转换为表述范围大的，(表述范围不是指类型的大小)其次，如果你要得到某一类型的数值时，也可以通过强制转换来实现。

## 两个要被重写的方法
### toString()方法
程序打印对象，或者把对象转换为字符串时，实际上用的是该对象的toString方法
如果类本身没有toString方法，则会调用父类的toString方法
Object类所提供的toSting方法返回：`类名@hashCode返回值`
```java
/**
* Apple类
*/
public class Apple {
    String color;
    double weight;

    public Apple(){

    }

    public Apple(String color, double weight){
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "Apple:[color="+this.color+",weight="+this.weight+"]";
    }
}


/**
* toStringOverride 类
*/

public class toStringOverride {
    public static void main(String[] args) {
        Apple apple1 = new Apple("红色",3.2);
        Apple apple2 = new Apple("白色",2.2);
        Apple apple3 = new Apple("绿色",5.0);

        System.out.println(apple1);  //Apple:[color=红色,weight=3.2]
        System.out.println(apple2);  //Apple:[color=白色,weight=2.2]
        System.out.println(apple3);  //Apple:[color=绿色,weight=5.0]
    }
}
```
对象转为String
```java
 String str = apple1 +"";  // 拼接""
 System.out.println(str);
```
### equals()方法
因为`==`是判断内存地址是否相等，equals是根据业务需要来指定两个对象相等




## static修饰符

- static修饰的是类变量，没有static修饰的是成员变量
- 局部变量不属于类成员，不能使用static修饰
- static不能修饰外部类，外部类不属于任何类
- static可以修饰成员：成员变量、放过、初始化块、内部类
- static修饰构造器无任何意义，因为构造器属于实例使用
- static方法属于类方法，不能调用实例方法





### 单例模式
永远创建出的实例都是同一个
```java
package min.singleinstance;


/**
 * 单利模式
 */
public class InstanceTest {
    private static  InstanceTest s;

    /**
     * 隐藏的构造器
     */
    private InstanceTest(){}

    public static InstanceTest instance(){
        // s 为null 则创建实例
        if(s==null){
            s = new InstanceTest();
        }

        return s;
    }
}

/******************************入口*******************************/

package min.singleinstance;

public class InstanceMain {
    public static void main(String[] args) {
        InstanceTest i1 = InstanceTest.instance();
        InstanceTest i2 = InstanceTest.instance();
        System.out.println(i1 == i2); //true
    }
}
```
## final修饰符
可以修饰任何变量、方法、类
final与abstract互斥，不能同时出现
### final修饰的变量
final修饰的变量被赋值后，不能重新再赋值
final修饰的变量必须赋值，且只能赋值一次

- 非final修饰的变量，可以不指定初始值，系统默认分配
- final修饰的成员变量，必须显示指定初始值
### final修饰的**成员变量**
 final修饰的**成员变量**可以存在的三个位置，本质都是在构造器中：

- 定义时指定初始值
- 实例初始化块
- 每个构造器都需要显示的指定初始值



### final修饰的**类变量**
 final修饰的**类变量**可以存在的两个位置，本质都是在类初始化块中，实例的初始化块中能够访问final类变量，但不能修改：

- 定义时指定初始值
- 类的初始化块中



### final修饰的局部**变量**
 final修饰的**局部变量，**基本数据类型和引用类型，不能被重新赋值：

- 定义时指定初始值或者不指定初始值，但是使用时必须指定初始值
- 引用类型对象内部数据可以改变



final修饰的变量例子
```java
package min.finaltest;

/**
 * final修饰符
 */
public class FinalTest {

    // 成员变量
    final String name;
    final  int age = 18;
    final boolean sex;
    // 类变量
    final  static int number;
    final  static String fastName = "范冰冰";

    {
        name ="马化腾";
    }

    static {
        number = 125;
        // fastName = "李冰冰";  // 错误不能再赋值
    }

    public FinalTest(){
        sex = true;
    }

    public FinalTest(String li){
        sex =false;
        System.out.println(li);
        System.out.println("类的fastName"+fastName);
    }

    public void  test(){
        // sex = true;  // 不允许在成员方法中给final修饰的成员变量赋值
    }
}




/*********************************************************************/


package min.finaltest;

public class FinalMain {
    public static void main(String[] args) {
        FinalTest finalTest =new FinalTest("刘强东");
    }
}

```
### final宏替换
条件

- 变量有final修饰
- 声明变量时就指定了初始值
- 变量初始值可以在编译时就确定下来（初始值的表达式中没有变量、方法调用等）

这个变量会消失，所有出现该变量的地方，在编译时就会被替换诶该变量的值


final修饰宏替换例子
```java
package min.hong;

public class HongTest {
    public static void main(String[] args) {
        final int a = 12;
        System.out.println(a);

        // 上面的代码等同于，final修饰的变量在编译时会被替换
        System.out.println(12);

        // 不使用final修饰

        String str1 = "min";
        String str2 = "xingjing";
        String str3 = str1 + str2 ;
        String str4 = "min" + "xingjing";
        System.out.println(str3 == str4);  //false

        // 不使用final修饰
        final String _str1 = "min";
        final String _str2 = "xingjing";
        String _str3 = _str1 + _str2 ;  // final修饰的变量给定初始值编译时会被宏替换，等同于 String _str4 = "min" + "xingjing";
        String _str4 = "min" + "xingjing";
        System.out.println(_str3 == _str4);  //true

    }
}

```
final修饰的例子
```java
package min.hong;

public class HongTest1 {
    public static void main(String[] args) {
        // 以下代码 0个变量，1个对象
        final String str1 = "wo";
        final String str2 = str1 + "ai";
        final String str3 = str2 + "zhong";
        System.out.println(str3);
        // 完全等同于System.out.println("woaizhong");
    }
}
```
### final修饰的方法
修饰的方法不允许被子类重写；
final修饰的方法可以被重载，也可以被子类调用
【备注】private修饰的方法已经隐藏到该类的内部，子类无法访问，因此无法重写
final修饰private的方法是多余的！


### final修饰的类
final修饰的类不能被继承
jdk中有的final修饰的类，比如String、math、System类
Object一定不是final修饰的！


## abstract修饰符
半抽象的类
abstract只能修饰两个东西：类和方法
abstract与final互斥，不能同时出现


### 抽象类的得与失

- 得：得到一个新的功能，抽象类可以有抽象方法
- 失：抽象类不能用来创建对象
```java
public abstract ClassName {
	// 类体，与普通类相同
    // 抽象方法
}
```
### 抽象方法
只有方法签名，没有方法体
```java
public abstract void move();  // 抽象方法
```
### 抽象类的作用

- 抽象类的作用是用来派生子类，如果不派生子类就是去其意义
- 定义变量，只能用它的子类的实例：向上转型
- 调用类方法和类变量
```java
package min.AbstractTest1;

/**
 * 抽象类
 */
public abstract class AbstractT {
    static int age;

    public static void main(String[] args) {
        System.out.println("main方法");
    }

    public AbstractT() {
    }

    /**
     * 抽象方法
     */
    public abstract void test();

    public static void getName(){
        // 方法体
        System.out.println("抽象方法的getName");
    }
}

/*******************************************************/
package min.AbstractTest1;

public class AbstractT1 {
    public static void main(String[] args) {
        // 抽象类调用类方法
        AbstractT.getName();
        // 抽象类调用类变量
        System.out.println( AbstractT.age);
        // AbstractT s = new AbstractT();  // 错误的，不能创建实例
    }
}


```
### 抽象类派生的子类
子类要么重写父类的所有抽象方法，要么子类也是抽象类
```java
package min.AbstractTest1;

/**
 * 抽象类，动物
 */
public abstract class AbstractAnimal {
  public abstract void movie();
}
```
```java
package min.AbstractTest1;

/**
 * 鸟类，继承抽象类动物
 */
public  class AbstractBird extends AbstractAnimal{

    @Override
    public void movie() {
        System.out.println("鸟儿在天上飞");
    }
}

```


```java
package min.AbstractTest1;

/**
 * 狗类，继承抽象类动物
 */
public  class AbstractDog extends AbstractAnimal{
   @Override
    public void movie(){
       System.out.println("狗在地上跑");
    }
}

```
```java
package min.AbstractTest1;

public class AbstractT4 {
    public static void main(String[] args) {
       // 使用父类型接收子类的引用,向上转型
        AbstractAnimal animal1 = new AbstractBird();
        AbstractAnimal animal2 = new AbstractDog();
        // 多态
        animal1.movie();  // 鸟儿在天上飞
        animal2.movie();  // 狗在地上跑
    }
}

```


## 接口interface

- 接口相当于是一种彻底抽象的类，支持多继承
- 接口体现的是一种规范，要暴露出来供大家遵守的规范
- 写或不写都有public修饰，一般都省略不写
### 语法
```java
[修饰符] interface 接口名 extends 父接口1，父接口2，…… {
	// 成员变量：只有常量，总是默认添加public static final修饰，通常不写
    // 抽象方法、（java8后）类方法、默认方法（default修饰）（抽象方法添加方法体）
    // 内部类
}

修饰符：public
命名规则：与类名相同，一般用形容词，后面一般都是able结尾
默认方法本质是实例方法
```
接口例子
```java
package min.jiekou;

public interface Jk {
    // 系统会默认添加上普public static final
    int AGE = 18;

    // 抽象方法，系统会默认添加上普public abstract
    void test();

    // java8之后可以有main方法
    public static void main(String[] args) {
        System.out.println("接口中的main方法");
    }

    // 类方法 前面默认添加public
    static void test(String name){
        System.out.println(name);
    }

    // 实例方法，需要在前面添加default，抵消了系统默认添加的public abstract
    default void run(){
        System.out.println("这是接口中的实例方法");
    }
}

```
### 接口的作用

- 定义变量，只能用实现的类的实例来赋值
- 派生实现类
- 调用类方法和类变量



### 实现接口语法
语法
```java
[修饰符] class ClassName extends 父类 implements 父接口1，父接口2，…… {
    // 五大成员
}
```
推论：

- 子类要么重写接口中所有的抽象方法，要么子类也只能是抽象的
- 重写接口中的方法只能用public修饰
```java
package min.jiekou2;

public interface Moveable {
    void run();
}

```
```java
package min.jiekou2;

/**
 * 动物接口
 */
public interface Eatable{
    void eat();
}

```
```java
package min.jiekou2;

public class Dog implements Eatable, Moveable{
    @Override
    public void eat(){
        System.out.println("狗吃东西");
    }

    @Override
    public void run(){
        System.out.println("狗在跑");
    }

    public void test(){
        System.out.println("Dog的test方法");
    }
    public static void main(String[] args) {
        // 向上转型
        Eatable dog =new Dog();
        dog.eat();
        if (dog instanceof Dog){
            Dog d = (Dog) dog;
            d.run();
        }




    }
}

```


### java9接口中新增的private方法
由于接口中的default方法属于实例方法，多个实例方法很有可能出现“公共方法”，这个“公共方法”就应该抽取到公共的工具方法中，而公共方法又需要对外部隐藏起来，使用private修饰


接口private方法的本质，工具方法。为接口中多个default方法（实例方法）提供的支持
功能：如果在接口中定义了private方法，那么接口中必然有一个default方法，否则失去意义
```java
package min.jiekou4;

public interface JKTest {
    /* 改造前
    default void run(){
        int a = 10;

        // 重复的代码
        System.out.println(123);
    }


    default void eat(){
        String name = "马化腾";

        // 重复代码
        System.out.println(123);
    }
    */

    // 改造后
    default void run() {
        int a = 10;
        System.out.println(a);
        go();
    }


    default void eat() {
        String name = "马化腾";
        System.out.println(name);
        go();
    }

    private void go(){
        // 公共代码
        System.out.println("我是private修饰的公共代码");
    }

     static void main(String[] args) {

    }

}

```
```java
package min.jiekou4;
/**
* 实现JKTest接口
*/
public class JKImplement implements JKTest{
    public static void main(String[] args) {
        JKTest jkTest =new JKImplement();
        jkTest.run();
        jkTest.eat();
    }

}

```
## 内部类（寄生类）
在类内部定义的类，称为内部类，包含内部类的类称为外部类（宿主类）
### 内部类与顶级类区别

- 内部类多部分修饰符：private（在顶级类中访问）、static（属于顶级类成员）、protected（能被顶级类的实例访问）
- 非static修饰的内部类，不能有static修饰的成员，除非使用final修饰为常量
- 内部类可以直接访问顶级类的私有成员，但是static修饰的内部类不能访问顶级类的非静态成员



```java
package com.neiBuLei;

import java.util.Date;

public class Outner {
    private double price  = 10.0;
    // 非静态内部类
    class Inner{
        private double price = 20.0;
        // 可以访问外部类的私有成员
        public  void t() {
            // 局部变量
            double price = 30.0;
            System.out.println("局部变量的price："+price);
            System.out.println("当前类的price："+this.price);
            System.out.println("外部类的price："+ Outner.this.price);
        }

        /* 非静态内部类中不能有静态成员，除非声明为常量
        public static int a = 10;
        static {
            String name = "张学友";
        }

        public static void test(){}
        */

        // 合法的声明
        public static final int age = 18;

    }

    // 静态内部类
    static class Inner1{
        private int num;
        public static  void test(){}
    }

    public static void main(String[] args) {
        // 错误，Inner类属于非静态，static方法中无法访问非静态成员
        //Outner outner = new Inner();
        Outner outner =new Outner();
        outner.go();

        // 正确，静态方法可以直接访问静态成员
        Inner1 inner1 = new Inner1();

    }


    public void go(){
        // 合法的，非静态方法访问非静态成员
        Inner inner =new Inner();
        inner.t();
    }
}

```
### 内部类存在的意义
某个类的实例必须依附于某一个类而存在，需要使用内部类
提供更好的封装，将内部类使用private或protected等修饰
内部类编译的文件名：外部类文件名$内部类文件名


### 内部类的使用
#### 在外部类内部使用内部类

- 在外部类的内部使用非静态内部类，与普通类相同；
- 在外部类的内部使用静态内部类，与普通类相同
#### 在外部类外部使用内部类
外部类外部使用静态内部类

1. 声明变量

外部类.静态内部类  变量名

2. 创建对象

new 外部类.静态内部类.静态内部类构造器(参数)

3. 调用方法和访问类变量

外部类.静态内部类.类变量
外部类.静态内部类.类方法（参数），要注意内部类的构造方法

4. 派生子类

extends 外部类.静态内部类


外部类外部使用非静态内部类

1. 声明变量
外部类.非静态内部类  变量名
1. 创建对象

new 外部类().new 内部类()

3. 调用类变量(常量)

外部类.内部类.类常量

4. 派生子类

extends 外部类.非静态内部类
重点在于构造器的第一行，一定是一下语法：宿主.super(参数)

代码
```java
package com.neiBuLei2;

import org.jetbrains.annotations.Contract;

public class Out {
    // 成员变量
    int age = 18;
    String firstName ="张三";
    //  类变量
    static boolean isFlag =true;
    static long money =100L;
    // 非静态内部类
    class In1{
        // 非静态内部类的成员变量
        String In1FistName = "非静态内部类";
        double price = 23.6;

        // 非静态内部类的类变量,需要使用final修饰
        static final char hz = '中';


        // 非静态内部类的成员方法
        public  int sum(int a, int b){
            return a + b ;
        }

        /**
         * 重写toString
         * @return
         */
        @Override
        public String toString() {
            return "In1{" +
                    "In1FistName='" + In1FistName + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    // 静态内部类
    static class In2 {
        // 静态内部类的类变量
        static int number = 12;
        // 静态内部类成员变量
        int[] arr = new int[]{1,2,3};


        // 静态内部类的类方法
        public  static String name(String firstName, String lastName){
            return firstName + lastName;
        }

        // 静态内部类的成员方法
        public int array(int[] arr){
            return arr[0];
        }

        /**
         * 重写toString
         * @return
         */
        @Override
        public String toString(){
            return "In2[number="+number+"]";
        }

    }

    public void desc(){
        // 在外部类的内部使用非静态内部类，与普通类相同
        In1 in1 = new In1();
        // 在外部类的内部使用静态内部类，与普通类相同
        In2 in2 = new In2();
    }
}

```


```java
package com.neiBuLei2;

public class Nbl {
    public static void main(String[] args) {
        // 1、在外部类以外使用静态内部类
        // 定义变量
        Out.In2 in;
        // 使用静态内部类的类变量
        int number = Out.In2.number;
        // 使用静态内部类的类方法
        String fullName = Out.In2.name("min","xingjing");
        System.out.println("静态内部类的类变量number："+number);
        System.out.println("静态内部类的类方法name："+fullName);

        // 使用静态内部类的成员变量
        Out.In2 in2 = new Out.In2();  // 创建实例
        int[] arr = in2.arr;  // 调用静态内部类的成员变量
        int item = in2.array(arr);  // 调用静态内部类的成员方法
        String toStr = in2.toString();  // 调用静态内部类的成员方法toString()
        System.out.println("静态内部类的实例变量arr："+arr);
        System.out.println("静态内部类的实例变量array："+item);
        System.out.println("静态内部类的实例变量toString："+toStr);

        System.out.println("/***************************************/");
        // 2、在外部类以外使用非静态内部类
        // a 调用非静态内部类的成员方法
        // 声明变量
        Out.In1 in1;
        Out out;
        out = new Out();
        in1 =out.new In1();// 创建实例
        // 获取非静态内部类的成员变量
        String in1str = in1.In1FistName; // 获取非静态内部类的成员变量
        double price = in1.price; // 获取非静态内部类的成员变量
        // 调用非静态内部类的成员方法
        int result = in1.sum(1,6);
        // b 获取非静态内部类的静态常量
        char ch = Out.In1.hz;

        System.out.println("非静态内部类的成员变量In1FistName："+in1str);
        System.out.println("非静态内部类的成员变量price："+price);
        System.out.println("非静态内部类的成员方法sum："+result);
        System.out.println("非静态内部类的类变量："+ch);




    }
}

```


```java
package com.neiBuLei2;

/**
 * 继承静态内部类
 */
public class Nbl2 extends Out.In2 {
    // 构造函数默认会调用super()的无参数构造
    public void getFullName(){}

    public Nbl2(){
        // 下面是默认隐藏的
        super();
    }

    public static void main(String[] args) {

    }
}

```


```java
package com.neiBuLei2;

public class Nbl3 extends Out.In1{
    public Nbl3() {
        // 宿主.super（）
        new Out().super();
    }


    // 传递一个参数，类型为内部类的宿主
    public Nbl3(Out out) {
        // 宿主.super（）
        out.super();
    }

    public static void main(String[] args) {

    }
}

```


### 局部内部类
很少使用，内部类放入方法中，使用范围小
局部内部类的静态变量只能使用final修饰
编译命名：外部类$N局部内部类类名


### 匿名内部类
没有类名，非常常用，尤其是Android
匿名内部类只能用一次，定义时要立即创建对象（所以不能是抽象类）

#### 语法
```java
new 父类构造器(参数) | 接口()
{
	//类体，五大成员，但是构造器不行，关键不知道类名，无法写
    //通常来说类体部分只实现抽象方法
}
```
#### 匿名内部类特点

- 匿名内部类必须要显示继承父类或者实现接口，不能同时实现多个接口，也不能继承父类时并实现接口，二者选其一
- 匿名内部类不能是抽象类，因此必须实现抽象类或者接口中所有方法
- 匿名内部类的类文件：宿主类名$N.class
- 匿名内部类在创建时创建一个匿名内部类，同时创建一个父类（抽象的）的匿名子类的匿名实例



```java
package com.neiBuLei3;

/**
 * Animal抽象类
 */
public abstract class   Animal {
    public abstract void run();
    public abstract void eat();
    public  void jump(){
        System.out.println("动物能跳跃");
    };

    public Animal(){

    }
    public Animal(String name){
        System.out.println(name);
    }

}

```
```java
package com.neiBuLei3;

/**
 * Plant接口
 */
public interface Plant {
    // 植物有颜色
    void color();
    // 植物有高度
    double height();
}

```
```java
package com.neiBuLei3;

public class Go {
    public static void main(String[] args) {
        // 1、使用抽象类创建创建匿名内部类，默认要么继承一个父类，要么继承一个借口
        // 向上转型，animal编译类型是Animal,运行时是Animal匿名子类的实例
        Animal animal =new Animal("小狗") {
            // 匿名内部类的类体
            @Override
            public void run() {
                System.out.println("动物都能跑");
            }

            @Override
            public void eat() {
                System.out.println("动物都会吃东西");
            }

            @Override
            public void jump() {
                super.jump();
                System.out.println("跳的很高");
            }

            // 自定义的方法
            public void test(){
                System.out.println("匿名内部类的自定义test方法");
            }
        };

        animal.run();
        animal.eat();
        animal.jump();
        // 无法调用自定义的匿名内部类的方法
        // 编译期间类型是Animal类型，没有test方法；
        // 无法强制转换类型，因为内有类名，无法写 （类型）animal
        // animal.test();

        // 2、使用接口类创建创建匿名内部类
        // 向上转型，animal编译类型是Animal,运行时是Animal匿名子类的实例
        Plant plant =new Plant() {
            @Override
            public void color() {
                System.out.println("颜色是绿色的");
            }

            @Override
            public double height() {
                return 0;
            }
        };

        plant.color();
        System.out.println(plant.height());;

    }
}

```
## Lambda表达式
### 函数式接口
只有一个抽象方法的接口
使用注解`@FunctionalInterface`，出现两个抽象方法时，可以报错提示
本质是函数是接口的匿名内部类只保留抽象方法的参数列表和方法体

### Lambda表达式特殊形式
可以省略参数的类型；
如果只有一个参数时可以省略小括号，如果`{}`中只有一条代码，可以省略`{}`；
如果`{}`中只有一条代码，可以省略`{}`；
如果返回语句只有一条，可以省略`return`
```java
package com.neiBuLei4;

/**
 * Plant函数式接口，只有一个抽象方法的接口@FunctionalInterface
 */
@FunctionalInterface
public interface Plant {
    // 植物有颜色
    void color();


    // 静态方法
    static int sum(int a ,int b){
        return a+b;
    }

    default void test1(){
        System.out.println("HelloPlant");
    }
}

```
```java
package com.neiBuLei4;

/**
 * 使用函数式接口创建匿名内部类、lambda表达式
 */
public class Go {
    public static void main(String[] args) {

        // 1 普通写法
        Plant p = new Plant() {
            @Override
            public void color() {
                System.out.println("函数式接口");
            }
        };
        p.color();


        // 2 Lambda简化写法
        Plant p1 = () ->{
            System.out.println("使用了Lambda表达式");
        };
        p1.color();
    }
}

```
### Lambda表达式的进一步简化
只有在方法体中有一条代码是才可以使用；
本质是进一步的省略，完全省略了形参列表和箭头

#### 引用方法
(参数列表)->某个类.某个方法(参数列表);
// 简写后
某个类::某个方法
```java
package com.LambdaFn;


/**
 * 函数式接口Fn
 */
@FunctionalInterface
public interface Fn {
    int getLenght(String str);
}

/**************************/

package com.LambdaFn;
/**
* 引用方法
*/
public class Lambda1 {
    public static void main(String[] args) {
        // 简化的Lambda表达式
        Fn fn = str -> str.length();
        int length = fn.getLenght("zhang");
        System.out.println(length);

        //  进一步简化的Lambda表达式  某个类::某个方法
        Fn fn1 = String::length;
        System.out.println(fn1.getLenght("MINXINGJING"));

    }
}

```
#### 引用实例方法
(参数1，其他参数)-> 参数1.某个方法(其他参数)；
// 简化后
参数1的类型::某个方法
```java
package com.LambdaFn;

@FunctionalInterface
public interface Fn1 {
    String cover(String str, int star, int end);
}

/*************************************/;
package com.LambdaFn;

/**
 * 引用实例方法
 */
public class Lambda2 {
    public static void main(String[] args) {
        // 简化的Lambda表达式
        Fn1 fn1 = (str,star,end) -> str.substring(star,end);
        String st = fn1.cover("MINXINGJING",1,3);
        System.out.println(st);

        //  进一步简化的Lambda表达式  参数1的类型::某个方法
        Fn1 _fn1 = String::substring;
        System.out.println(_fn1.cover("MINXINGJING",1,3));

    }
}

```
#### 引用特定对象的实例方法
(参数列表)-> 某个对象.某个方法(参数列表)
// 简化后
某个对象::某个方法
```java
package com.LambdaFn;

@FunctionalInterface
public interface Fn2 {
    String convert(int star, int end);
}
/**************************************/;

package com.LambdaFn;

/**
 * 引用特定对象的实例方法
 */
public class Lambda3 {
    public static void main(String[] args) {
        // 简化的Lambda表达式
        Fn2 fn2 = (star,end) -> "MINXINGJING".substring(star,end);
        String st = fn2.convert(1,6);
        System.out.println(st);

        //  进一步简化的Lambda表达式  某个对象::某个方法
        Fn2 _fn2 = "MINXINGJING"::substring;
        System.out.println(_fn2.convert(1,6));

    }
}

```
#### 构造器引用
(参数列表) -> new 构造器(参数表)；
// 简化后 
类名::new
```java
package com.LambdaFn;

import java.util.Date;

@FunctionalInterface
public interface Fn3 {
    // 获取指定的时间
    Date getTime(int a, int b, int c);
}
/*******************/;

package com.LambdaFn;

import java.util.Date;

/**
 * 构造器引用
 */
public class Lambda4 {
    public static void main(String[] args) {
        // 简化的Lambda表达式
        Fn3 fn3 = (year, month, day) -> new Date(year, month, day);
        Date date = fn3.getTime(116, 7, 1);
        System.out.println(date);  // Mon Aug 01 00:00:00 CST 2016

        //  进一步简化的Lambda表达式  类名::new
        Fn3 _fn3 = Date::new;
        System.out.println(_fn3.getTime(116, 7, 1));  // Mon Aug 01 00:00:00 CST 2016

    }
}

```
## 枚举
枚举是实例数量已经固定的类，开发者不能随便的创建实例，枚举无法创建实例；
推论：枚举很方便的实现实例的单例模式
举例：星期、季节、性别、七种颜色
### 语法
```java
[public] abstract|final enum 枚举名字{
	// 第一行列出所有的实例，枚举以后就只能使用这些实例
    // 同样可以定义类的五大成员
}
```
### 与普通类的区别

- 枚举默认继承Enum类（是Object的子类），不能继承其他类
- 枚举类默认是final类，要么是abstract类
- 如果没有添加抽象方法，枚举自动添加final，如果没有添加final，系统默认会添加abstract，枚举的修饰符final和abstract不能人为添加，由系统默认添加
- 枚举的构造器只能用private修饰（单例模式），不写修饰符，系统会自动添加private
- 枚举要求在第一行列出所有的实例
### 枚举的默认拥有的方法
```java
static 枚举名[] values(); // 返回枚举的所有实例
static 枚举名 valueOf(String name);// 根据枚举名返回枚举实例
String name();//该方法返回枚举实例的名字
int ordinal(); // 该方法返回枚举实例的下标
```
### 枚举的作用

- 定义变量
- 调用类方法或者类变量



### 枚举与有参构造器和无参构造器
枚举的第一行并不是简单地列出枚举实例
第一行实际上事要创建、并枚举的所有实例，所以要根据构造器传递相应的参数
```java
package com.season;

/**
 * 季节枚举
 */

public  enum Season {
    // 第一行列出所有的枚举实例，一般用大写
    SPRING/*调用无参数构造器*/, SUMMER, AUTUMN("秋天")/*调用有参数构造器*/, WINTER("冬天");
    // 定义成员变量
    private  String desc;
    // 定义类变量
    static  String name= "季节";
    // 定义类方法
    public static void test(){
        System.out.println("枚举的类方法");
    }
    // 定义枚举无参数构造器，使用private修饰
    Season(){ }
    // 定义枚举有参数构造器，使用private修饰
    Season(String desc){
        this.desc = desc;
    }

    /**
     * 重写toString
     * @return 枚举的描述
     */
    @Override
    public String toString(){
        return "Season [desc="+this.desc + "]";
    }

    // 定义实例方法
    public  void info() {
        switch (this){
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }


}


/*****************************************************/;
package com.season;

/**
 * 枚举测试类
 */
public class SeasonTest {
    public static void main(String[] args) {
        // 枚举赋值，使用已有的实例进行赋值
        Season s1 = Season.SPRING;
        Season s3 = Season.AUTUMN;
        System.out.println(s1);
        System.out.println(s3);
        // 获取枚举的名字
        String name = s1.name();
        // 返回所有枚举实例
        Season[] arr = Season.values();
        for (Season s : arr) {
            s.info();
        }

        // 根据枚举名返回枚举实例
        Season season = Season.valueOf("SPRING");
        System.out.println("枚举的名字:" + name);

        System.out.println("根据枚举名返回枚举实例:" + season);
    }
}

```
### 抽象枚举
枚举可以使抽象的，只要为枚举定义抽象方法，系统会自动为该枚举添加abstract修饰
如果枚举是抽象的，那么就需要在第一行使用匿名内部类的语法创建枚举实例
```java
package com.person;

/**
 * 人类枚举
 */
public enum Person {
    // 枚举的所有实例：男人，女人
    MEN(){/*调用无参的构造器,省略小括号*/
        // 匿名内部类的类体
        @Override
        public void info(){
            System.out.println("这是男人的info方法");
        }
    },

    WOMEN("女人"){
        @Override
        public void info(){
            System.out.println("这是女人的info方法");
        }
    };
    // 实例变量
    private String desc;

    // 无参数构造器
    Person(){};

    // 带参数构造器
    Person(String desc){
        this.desc = desc;
    };
    // 抽象方法
    abstract void info();

    // get方法
    public String getDesc(){
        return this.desc;
    }
}
/***************************************/;

package com.person;

/**
 * Person测试类
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = Person.MEN;
        p1.info();
        String desc1 = p1.getDesc();
        System.out.println(desc1);

        Person p2 = Person.WOMEN;
        p2.info();
        String desc2 = p2.getDesc();
        System.out.println(desc2);

    }
}


```
### 枚举实现接口
枚举可以实现接口

- 枚举实现接口时实现接口中所有的抽象方法，属于普通枚举
- 枚举实现接口时，并不实现所有的抽象方法，就形成抽象枚举，需要在第一行使用匿名内部类的语法创建实例



### java的入口方法
`public static void main(String[] args){}`
`public` 修饰符
`static`能够被类方法
`main` 从C语言中沿用的
`String[] args`用户输入的参数


## StringBuffer
多线程使用安全，性能差


## StringBuilder
多线程不安全，性能好

## 正则表达式
一个字符串模板

| \ | 将下一字符标记为特殊字符、文本、反向引用或八进制转义符。例如，"n"匹配字符"n"。"\n"匹配换行符。序列"\\\\"匹配"\\"，"\\("匹配"("。 |
| --- | --- |
| ^ | 匹配输入字符串开始的位置。如果设置了 **RegExp** 对象的 **Multiline** 属性，^ 还会与"\n"或"\r"之后的位置匹配。 |
| $ | 匹配输入字符串结尾的位置。如果设置了 **RegExp** 对象的 **Multiline** 属性，$ 还会与"\n"或"\r"之前的位置匹配。 |
| * | 零次或多次匹配前面的字符或子表达式。例如，zo* 匹配"z"和"zoo"。* 等效于 {0,}。 |
| + | 一次或多次匹配前面的字符或子表达式。例如，"zo+"与"zo"和"zoo"匹配，但与"z"不匹配。+ 等效于 {1,}。 |
| ? | 零次或一次匹配前面的字符或子表达式。例如，"do(es)?"匹配"do"或"does"中的"do"。? 等效于 {0,1}。 |
| {_n_} | _n _是非负整数。正好匹配 _n_ 次。例如，"o{2}"与"Bob"中的"o"不匹配，但与"food"中的两个"o"匹配。 |
| {_n_,} | _n _是非负整数。至少匹配 _n _次。例如，"o{2,}"不匹配"Bob"中的"o"，而匹配"foooood"中的所有 o。"o{1,}"等效于"o+"。"o{0,}"等效于"o*"。 |
| {_n_,_m_} | _m_ 和 _n_ 是非负整数，其中 _n_ <= _m_。匹配至少 _n_ 次，至多 _m_ 次。例如，"o{1,3}"匹配"fooooood"中的头三个 o。'o{0,1}' 等效于 'o?'。注意：您不能将空格插入逗号和数字之间。 |
| ? | 当此字符紧随任何其他限定符（*、+、?、{_n_}、{_n_,}、{_n_,_m_}）之后时，匹配模式是"非贪心的"。"非贪心的"模式匹配搜索到的、尽可能短的字符串，而默认的"贪心的"模式匹配搜索到的、尽可能长的字符串。例如，在字符串"oooo"中，"o+?"只匹配单个"o"，而"o+"匹配所有"o"。 |
| . | 匹配除"\r\n"之外的任何单个字符。若要匹配包括"\r\n"在内的任意字符，请使用诸如"[\s\S]"之类的模式。 |
| (_pattern_) | 匹配 _pattern_ 并捕获该匹配的子表达式。可以使用 **$0…$9** 属性从结果"匹配"集合中检索捕获的匹配。若要匹配括号字符 ( )，请使用"\("或者"\)"。 |
| (?:_pattern_) | 匹配 _pattern_ 但不捕获该匹配的子表达式，即它是一个非捕获匹配，不存储供以后使用的匹配。这对于用"or"字符 (|) 组合模式部件的情况很有用。例如，'industr(?:y|ies) 是比 'industry|industries' 更经济的表达式。 |
| (?=_pattern_) | 执行正向预测先行搜索的子表达式，该表达式匹配处于匹配 _pattern_ 的字符串的起始点的字符串。它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?=95|98|NT|2000)' 匹配"Windows 2000"中的"Windows"，但不匹配"Windows 3.1"中的"Windows"。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。 |
| (?!_pattern_) | 执行反向预测先行搜索的子表达式，该表达式匹配不处于匹配 _pattern_ 的字符串的起始点的搜索字符串。它是一个非捕获匹配，即不能捕获供以后使用的匹配。例如，'Windows (?!95|98|NT|2000)' 匹配"Windows 3.1"中的 "Windows"，但不匹配"Windows 2000"中的"Windows"。预测先行不占用字符，即发生匹配后，下一匹配的搜索紧随上一匹配之后，而不是在组成预测先行的字符后。 |
| _x_|_y_ | 匹配 _x_ 或 _y_。例如，'z|food' 匹配"z"或"food"。'(z|f)ood' 匹配"zood"或"food"。 |
| [_xyz_] | 字符集。匹配包含的任一字符。例如，"[abc]"匹配"plain"中的"a"。 |
| [^_xyz_] | 反向字符集。匹配未包含的任何字符。例如，"[^abc]"匹配"plain"中"p"，"l"，"i"，"n"。 |
| [_a-z_] | 字符范围。匹配指定范围内的任何字符。例如，"[a-z]"匹配"a"到"z"范围内的任何小写字母。 |
| [^_a-z_] | 反向范围字符。匹配不在指定的范围内的任何字符。例如，"[^a-z]"匹配任何不在"a"到"z"范围内的任何字符。 |
| \b | 匹配一个字边界，即字与空格间的位置。例如，"er\b"匹配"never"中的"er"，但不匹配"verb"中的"er"。 |
| \B | 非字边界匹配。"er\B"匹配"verb"中的"er"，但不匹配"never"中的"er"。 |
| \c_x_ | 匹配 _x_ 指示的控制字符。例如，\cM 匹配 Control-M 或回车符。_x_ 的值必须在 A-Z 或 a-z 之间。如果不是这样，则假定 c 就是"c"字符本身。 |
| \d | 数字字符匹配。等效于 [0-9]。 |
| \D | 非数字字符匹配。等效于 [^0-9]。 |
| \f | 换页符匹配。等效于 \x0c 和 \cL。 |
| \n | 换行符匹配。等效于 \x0a 和 \cJ。 |
| \r | 匹配一个回车符。等效于 \x0d 和 \cM。 |
| \s | 匹配任何空白字符，包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效。 |
| \S | 匹配任何非空白字符。与 [^ \f\n\r\t\v] 等效。 |
| \t | 制表符匹配。与 \x09 和 \cI 等效。 |
| \v | 垂直制表符匹配。与 \x0b 和 \cK 等效。 |
| \w | 匹配任何字类字符，包括下划线。与"[A-Za-z0-9_]"等效。 |
| \W | 与任何非单词字符匹配。与"[^A-Za-z0-9_]"等效。 |
| \x_n_ | 匹配 _n_，此处的 _n_ 是一个十六进制转义码。十六进制转义码必须正好是两位数长。例如，"\x41"匹配"A"。"\x041"与"\x04"&"1"等效。允许在正则表达式中使用 ASCII 代码。 |
| \_num_ | 匹配 _num_，此处的 _num_ 是一个正整数。到捕获匹配的反向引用。例如，"(.)\1"匹配两个连续的相同字符。 |
| \_n_ | 标识一个八进制转义码或反向引用。如果 \_n_ 前面至少有 _n_ 个捕获子表达式，那么 _n_ 是反向引用。否则，如果 _n_ 是八进制数 (0-7)，那么 _n_ 是八进制转义码。 |
| \_nm_ | 标识一个八进制转义码或反向引用。如果 \_nm_ 前面至少有 _nm_ 个捕获子表达式，那么 _nm_ 是反向引用。如果 \_nm_ 前面至少有 _n_ 个捕获，则 _n_ 是反向引用，后面跟有字符 _m_。如果两种前面的情况都不存在，则 \_nm_ 匹配八进制值 _nm_，其中 _n _和 _m_是八进制数字 (0-7)。 |
| \nml | 当 _n_ 是八进制数 (0-3)，_m_ 和 _l_ 是八进制数 (0-7) 时，匹配八进制转义码 _nml_。 |
| \u_n_ | 匹配 _n_，其中 _n_ 是以四位十六进制数表示的 Unicode 字符。例如，\u00A9 匹配版权符号 (©)。 |



## java国际化
实现的效果，在不同国家的电脑上运行，呈现各自国家的语言
本质：查找替换
### 思路

- 开发人员在写程序的所有信息，都不直接使用字符串，而是使用key来代替
- 内一个key都对应一个value，不同的国家需要不同的资源文件
- 当程序运行时，java国际化机制会自动根据文件的key和value进行替换



### 国际化常用的三个类
`Locale`代表一个国家的语言环境
getAvailableLocales() 获取java语言的所有的Locale
getDefault（Locale.Category Category）获取当前电脑的Locale


`ResoureBundle`用来加载国家化的资源文件，加载后代表一个语言资源包


`MesageFormat`用来对占位符进行填充内容


### 国际化编码步骤

- 编写国际化资源文件（java9之前不支持非西欧字符）
- 加载国际化资源文件
   - 文件命名：<baseName>_语言代码_国家代码.properties
   - ResoureBundle.getBundle(baseName, Locale)
- 根据key来访问value
   - MessagesFormat：用于对消息中的占位符进行填充



## 数字格式化和日期格式化
NumberFormat数字格式化
DateFormat 日期格式化
SimpleDateFormat日期格式化（常用）



## `java`集合`collection`

![collection](.\Java基础.assets\collection.png)

### 集合的基本操作

`Collection.add(Object obj)`添加元素

`Collection.remove(Object obj)`删除元素

`Collection.size()`获取集合的大小

`Collection.isEmpty()`判断集合是否为空

`Collection.contains(Object obj)`判断集合是否包含某个元素

`Collection.clear(Object obj)`清空集合

集合遍历：三种方法foreach/for/while、iterator、lambda表达式

```java
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

public class CollectionTest {
    public static void main(String[] args) {
        // 菱形语法
        Collection<String> c = new HashSet<>();
        // 添加
        c.add("中国");
        c.add("美国");
        c.add("日本");
        System.out.println(c);  //[美国, 中国, 日本]
        // 删除
        c.remove("日本");
        System.out.println(c);  //[美国, 中国]
        // 集合大小
        int size = c.size();
        System.out.println(size); //2

        // 判断是否为空
        boolean isEmpty = c.isEmpty();
        System.out.println(isEmpty);// false
        // 判断是否为空
        System.out.println(c.contains("中国"));  // true
        System.out.println(c.contains("日本"));  // false

        // 遍历
        // 遍历foreach
        for (String s : c) {
            System.out.println(s);
        }

        // 遍历:Iterator遍历器使用while
        Iterator<String> iterator = c.iterator();
        while (iterator.hasNext()){
            String str =  iterator.next();
            System.out.println(str);
        }
        System.out.println("--------------------");
        // 遍历:Iterator遍历器使用for
        for ( Iterator<String> i = c.iterator();i.hasNext(); ){
            String str =  i.next();
            System.out.println(str);
        }
        // 遍历：使用lambda表达式，函数式接口1
        c.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        // 遍历：使用lambda表达式，函数式接口2
        System.out.println("--------------------");
        c.forEach(s -> System.out.println(s));
        // 遍历：使用lambda表达式，函数式接口3
        System.out.println("--------------------");
        c.forEach( System.out::println);
    }
}
```





### set集合

- 无序的
- 不重复的

#### HashSet

- 无序
- 不重复
- 快速

##### hashSet方法判断两个元素相等的条件

- 通过equals比较相等

- hashCode方法相等

  - 所有参与equals比较的成员变量都参与比较

  - 一般为了偶然相等，让参与比较的变量的hashCode乘上一个质数，一般乘31

    - ```java
      this.color.hashCode() * prime * prime+ (int)this.weight * prime+ this.xxx.hashCode();
      ```

##### 重写equals方法和hashCode方法

```java
package hashset;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

/**
 * hashSet集合
 */
public class HashSetTest {
    public static void main(String[] args) {
        // 一般类型申明为接口，适用性强，可以转型其他子类
        // 创建Integer对象
        Collection<Integer> collection = new HashSet<>();
        // 自动装箱
        collection.add(123);
        collection.add(999);
        collection.add(45);
        collection.add(45); // 加不进去
        System.out.println(collection);

        // 创建Dog对象
        Collection<Dog> collection1 = new HashSet<>();
        collection1.add(new Dog("黑色", 12.1));
        collection1.add(new Dog("黑色", 11.1));
        collection1.add(new Dog("白色", 12.1));
        collection1.add(new Dog("黑色", 12.1));// 加不进去
        collection1.add(new Dog("白色", 12.1));// 加不进去


        System.out.println(collection1);
        System.out.println(collection1.size());

    }
}


class Dog{
    String color;
    double weight;

    public Dog(){};

    public Dog(String color, double weight){
        this.color = color;
        this.weight = weight;
    };

    @Override
    public int hashCode() {
        // 为了避免偶然相等乘上一个质数
        int prime = 31 ;
        // color是字符串使用hashCode方法， weight是double使用强制类型转换为int
        return this.color.hashCode()  * prime+ (int)this.weight ;
    }

    /**
     * 重写equals
     * @param obj 要比较的对象
     * @return 比较结果
     */
    @Override
    public boolean equals(Object obj){
        // 如果地址值相同证明是同一个对象
        if (this==obj) return true;
        // 如果obj不为空且obj类型和Dog的类型相同证明是同一个对象
        if (obj!=null  && obj.getClass()==Dog.class){
            return this.color.equals(((Dog) obj).color)  && this.weight - ((Dog) obj).weight < 1e-2;
        }
        return false;
    };


    @Override
    public String toString() {
        return "Dog = [color = " + color + ",weight = " + weight + "]";
    }
}
```

##### hashSet中加入String

所有的系统提供的类，只要重写了equals方法都会重写hashCode方法

```java
import java.util.Set;

/**
 * 不同方式创建的字符串变量能否加入hashSet集合？
 * 所有的系统提供的类，只要重写了equals方法都会重写hashCode方法
 */
public class HashSetTest1 {
    public static void main(String[] args) {
        Set<String> set =new HashSet<>();
        String str = "java";
        String str1 =new String("java");
        set.add(str);
        set.add(str1); // 加不进去
        System.out.println(set);
    }

}
```

##### hashCode底层实现

本质基于数组

##### `hashSet`做了什么

- 调用`hashCode`方法，返回int
- `hashSet`会通过`hashCode`方法的返回值确定放在`hashSet`底层数组的位置
- `Hashset`回到底层数组的该位置去检查，该位置是否含有要查找的元素
  - 如果该位置趋势保存着要找的元素，直接找出该元素即可
  - 如果该位置的元素不是我们要找的元素，此时就需要顺着该链、组个人的去找
  - 链越长、超找性能越差
- `HashSet(int initialCapacity, float loadFactor)`有两个性能选项
  - `initialCapacity` 初始大小，默认为16
  - `loadFactor `负载因子，默认值是0.75（装四分之三，自动扩大），越小则牺牲内存获得性能

#### `LinkHashSet`

`HashSet`的子类，功能与`HashSet`相同

不同点是，它会维护链，保存元素添加的顺序，记住元素的添加顺序，性能较`HashSet`较慢

```java
package linkhashset;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkHashSetTest {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();
        set.add("b");
        set.add("a");
        set.add("c");
        System.out.println(set);  //[b, a, c]

    }
}

```



#### `TreeSet`

`TreeSet`是基于”红黑树“

##### 特征

- 不允许重复
- 比`HashSet`要慢
- `TreeSet`实现了`sortedSet`，因此`TreeSet`会对元素按照元素从小到大的排序
  - `TreeSet`中的元素是按照从小到大的排序
- `TreeSet`怎么比较元素的大小
  - 自然排序——元素本身可以比较大小，元素类本身已经实现了`Comparable`接口、并实现该接口的`compareTo`方法，`java`自带的类基本都实现了`compareTo`方法
  - 定制排序——不要求元素本身可以比较大小，但是要求创建`TreeSet`时传入`compartor`对象，该对象负责比较元素的大小
- `TreeSet`要求元素必须为同一个类型

```java
package treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet自定义元素
 */
public class TreeSetTest1 {
    public static void main(String[] args) {
        Goat goat1 = new Goat("黑色",45.3);
        Goat goat2 = new Goat("黑色",35.8);
        Set<Goat> set =new TreeSet<>();
        set.add(goat1);
        set.add(goat2);
        System.out.println(set);

    }
}

class Goat implements Comparable<Goat>{
    private String color;
    private double weight;

    /**
     * 如果当前对象大于要比较的对象，返回正整数
     * 如果当前对象小于要比较的对象，返回负整数
     * 如果当前对象等于要比较的对象，返回0
     * @param target 要比较的对象
     * @return 正整数 or 负整数 or 0
     */
    @Override
    public int compareTo(Goat target) {
        return Double.compare(this.weight, target.weight);
    }

    public Goat(String color, double weight){
        this.weight =weight;
        this.color = color;
    }

    @Override
    public String toString(){
        return "Goat [color="+color+"]"+"[weight="+weight+"]";
    }
}

```

定制排序

```java
package treeset;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet定制排序
 */
public class TreeSetTest2 {
    public static void main(String[] args) {
        Goat1 goat1 = new Goat1("黑色",45.3);
        Goat1 goat2 = new Goat1("白色",35.8);
//        Set<Goat1> set =new TreeSet<>(new Comparator<Goat1>() {
//
//            /**
//             * 如果当前对象大于要比较的对象，返回正整数
//             * 如果当前对象小于要比较的对象，返回负整数
//             * 如果当前对象等于要比较的对象，返回0
//             */
//            @Override
//            public int compare(Goat1 o1, Goat1 o2) {
//                return o1.getWeight() > o2.getWeight() ? 1: (o1.getWeight() < o2.getWeight() ? -1:0);
//            }
//        });
        Set<Goat1> set =new TreeSet<>((o1, o2) ->
              o1.getWeight() > o2.getWeight() ? 1: (o1.getWeight() < o2.getWeight() ? -1:0) );
        set.add(goat1);
        set.add(goat2);
        System.out.println(set);

    }
}

class Goat1 {
    private final String color;
    private final double weight;


    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public Goat1(String color, double weight){
        this.weight =weight;
        this.color = color;
    }


    @Override
    public String toString(){
        return "Goat [color="+color+"]"+"[weight="+weight+"]";
    }
}

```

### List集合

元素可以重复

元素有序，按照添加顺序，默认第一个索引为0，第二个元素的索引为1，相当于一根竹子，每一节只能装一个对象

`set`几回合支持的方法`list`都支持，由于`list`集合是有索引（下标），一次可以通过下标取元素

`List`集合有额外的遍历元素的方法，通过元素的下标获取



