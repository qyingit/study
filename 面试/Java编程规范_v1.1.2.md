# Java编程规范
## 一、命名规范

1. 代码中的命名均不能以**下划线或美元符号**开始，也不能以**下划线或美元符号**结束。  
  <font color="Firebrick">反例</font>：`_name / $name / name_ / name$`。

2. 代码中的命名严禁使用拼音与英文混合的方式。   
  <font color="DodgerBlue">说明</font>：正确的英文拼写和语法可以让阅读者易于理解，避免歧义。注意，即使纯拼音命名方式也要避免采用。  
  <font color="green">正例</font>：`zuomuniao`、`beijing`等国际通用的名称，可视同英文。  
  <font color="Firebrick">反例</font>：`DaZhePromotion`[打折]、`getPingfenByName()`[评分]、`int 总数 = 3`。

3. 类名使用`UpperCamelCase`风格，但以下情形例外：DO / BO / DTO / VO / AO / PO等。   
	<font color="green">正例</font>：`UserBankVO / UserService / UserController`。

4. 方法名、参数名、成员变量、局部变量都统一使用`lowerCamelCase`风格，必须遵从驼峰形式。   
	<font color="green">正例</font>： `localValue / getHttpMessage() / inputUserId`。

5. 常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。   
	<font color="green">正例</font>：`LOGIN_ERROR_TIMES`。  
	<font color="Firebrick">反例</font>：`TIMES`。 

6. 抽象类命名使用`Abstract`或`Base`开头；异常类命名使用`Exception`结尾；测试类命名以它要测试的类名开始，以Test结尾。 

7. 类型与中括号紧挨相连来定义数组。   
	<font color="green">正例</font>：定义整形数组`int[] arrayDemo`。  
	<font color="Firebrick">反例</font>：在main参数中，使用`String args[]`来定义。 

8. POJO类中布尔类型的变量，都不要加is前缀，否则部分框架解析会引起序列化错误。   
	<font color="Firebrick">反例</font>：定义为基本数据类型`Boolean isDeleted；`的属性，它的方法也是`isDeleted()`，RPC框架在反向解析的时候，“误以为”对应的属性名称是deleted，导致属性获取不到，进而抛出异常。

9. 包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用单数形式，但是类名如果有复数含义，类名可以使用复数形式。   
	<font color="green">正例</font>：应用工具类包名为`com.zmn.order`、类名为`MessageUtils`（此规则参考Spring的框架结构）。

10. 杜绝完全不规范的缩写，避免望文不知义。   
	<font color="Firebrick">反例</font>：`AbstractClass`缩写命名成`AbsClass`；`condition`缩写命名成`condi`，此类随意缩写严重降低了代码的可阅读性。 

11. 为了达到代码自解释的目标，任何自定义编程元素在命名时，使用尽量完整的单词组合来表达其意。   
	<font color="green">正例</font>：从远程仓库拉取代码的类命名为`PullCodeFromRemoteRepository`。   
	<font color="Firebrick">反例</font>：变量int a; 的随意命名方式。 

12. 如果模块、接口、类、方法使用了设计模式，在命名时体现出具体模式。   
	<font color="DodgerBlue">说明</font>：将设计模式体现在名字中，有利于阅读者快速理解架构设计理念。   
	<font color="green">正例</font>：

	```
	public class ObjectFactory {}
	public class LoginProxy {}
	public class ResourceObserver {} 
	```

13. 接口类中的方法和属性不要加任何修饰符号（`public`也不要加），保持代码的简洁性，并加上有效的Javadoc注释。尽量不要在接口里定义变量，如果一定要定义变量，肯定是与接口方法相关，并且是整个应用的基础常量。  
	<font color="DodgerBlue">说明</font>：JDK8中接口允许有默认实现，那么这个`default`方法，是对所有实现类都有价值的默认实现。  
	<font color="green">正例</font>：接口方法签名`void f()`; 接口基础常量`String COMPANY = "zuomuniao"`;   
	<font color="Firebrick">反例</font>：接口方法定义`public abstract void f()`、`public final String COMPANY = "zuomuniao"`;

14. 枚举类名建议带上`Enum`后缀，枚举成员名称需要全大写，单词间用下划线隔开。   
	<font color="DodgerBlue">说明</font>：枚举其实就是特殊的常量类，且构造方法被默认强制是私有。   
	<font color="green">正例</font>：枚举名字为`FileTypeEnum`的成员名称：`IDENTITY`、`BANK`、`CENSUS`。 			
  
******************

## 二、常量、变量定义

1. 不允许任何魔法值（即未经预先定义的常量）直接出现在代码中。  
	<font color="green">正例</font>：
	
	```
	public static String getKeyStageRefundLock(String stageId) {
        return KEY_STAGE_REFUND_LOCK + stageId;
   }
   public static final String KEY_STAGE_REFUND_LOCK = "stage:refund:lock:";
	```
	<font color="Firebrick">反例</font>：

	```
	String key = "Id#zuomuniao_" + tradeId;       
	cache.put(key, value); 
	```
2. `long`或者`Long`初始赋值时，必须使用大写的L，不能是小写的l，小写容易跟数字1混淆，造成误解。   
	<font color="DodgerBlue">说明</font>：
	
	```
	Long a = 2l;
	写的是数字的21，还是Long型的2？
	```
3. <font color="Firebrick">关于基本类型和其Java封装类，如`int`与`Integer`、`long`与`Long`、`float`与`Float`等</font>   
   1）统一使用封装类，方便使用其封装方法，并在应用中统一参数校验规则   
   2）方法参数约定：使用封装类参数，允许`NULL`，查询时，为`NULL`表示忽略该参数，而`0`表示使用该值
   
4. 不要使用一个常量类维护所有常量，按常量功能进行归类，分开维护。     
	<font color="DodgerBlue">说明</font>：大而全的常量类，非得使用查找功能才能定位到修改的常量，不利于理解和维护。     
	<font color="green">正例</font>：Redis相关常量放在类`RedisConstant`下；用户银行卡配置相关常量放在类`UserBankConstant`下。 

4. 常量的复用层次有：应用内共享常量、类内共享常量。    
	1）应用内共享常量：放在`common`模块中的`constant`目录下  
	2）类内共享常量：直接在类内部`private static final`定义 

****************
## 三、代码格式
1. 大括号的使用约定。如果是大括号内为空，则简洁地写成`{}`即可，不需要换行。如果是非空代码块则：  
	1）左大括号前不换行  
	2）左大括号后换行  
	3）右大括号前换行  
	4）右大括号后还有`else`等代码则不换行；表示终止的右大括号后必须换行。   
	<font color="green">正例</font>：

	```
	public class AliBankDTO {}
	```
	```
	public class AliBankDTO {
		public void method() {}
	}
	```

2. 左小括号和字符之间不出现空格；同样，右小括号和字符之间也不出现空格。详见第5条下方正例提示。  
	<font color="green">正例</font>：

	```
	if (value1 == value2) 
	```
	<font color="Firebrick">反例</font>：

	```
	if ( value1 == value2 )
	```
3. `if / for / while / switch / do`等保留字与括号之间都必须加空格。   
	<font color="green">正例</font>：

	```
	if (value1 == value2) 
	for (int i = 0; i < 10; i++)
	switch (name)
	```

4. 任何二目、三目运算符的左右两边都需要加一个空格。   
	<font color="DodgerBlue">说明</font>：运算符包括赋值运算符=、逻辑运算符&&、加减乘除符号等。  
	<font color="green">正例</font>：

	```
	int value = value1 + value2;
	```
	<font color="Firebrick">反例</font>：

	```
	int value=value1+value2;
	```
5. 采用4个空格缩进，禁止使用tab字符。   
   <font color="DodgerBlue">说明</font>：
   如果使用tab缩进，必须设置1个tab为4个空格。IDEA设置tab为4个空格时，请勿勾选`Use tab character`；而在eclipse中，必须勾选`insert spaces for tabs`。     
   <font color="green">正例</font>： （涉及1-5点）
	
	```
    public static void main(String[] args) {
    
      // 缩进4个空格
      String say = "hello";
      
      // 运算符的左右必须有一个空格
      int flag = 0;
      
      // 关键词if与括号之间必须有一个空格，括号内的f与左括号，0与右括号不需要空格
      if (flag == 0) {
          System.out.println(say);
      }
      
      // 左大括号前加空格且不换行；左大括号后换行
      if (flag == 1) {
          System.out.println("world");
          // 右大括号前换行，右大括号后有else，不用换行
      } else {
          System.out.println("ok");
          // 在右大括号后直接结束，则必须换行
      }
    }
	```
6. <font color="Firebrick">注释的双斜线与注释内容之间有且仅有一个空格。</font>   
		<font color="green">正例</font>：

	```
	// 这是示例注释，请注意在双斜线之后有一个空格  
	String ygb = new String(); 
	```
7. 单行字符数限制最好不超过120个（Idea中会有一条竖线），超出需要换行，换行时遵循如下原则：  
	1）第二行相对第一行缩进4个空格，从第三行开始，不再继续缩进，参考示例  
	2）运算符与下文一起换行  
	3）方法调用的点符号与下文一起换行  
	4）方法调用时，多个参数，需要换行时，在逗号后进行  
	5）在括号前不要换行，见反例  
	<font color="green">正例</font>：

	```
	StringBuffer sb = new StringBuffer();
	
	// 超过120个字符的情况下，换行缩进4个空格，点号和方法名称一起换行
	sb.append("zi").append("xin")
                .append("huang")
                .append("huang")
                .append("huang");
	                   
	// 参数很多的方法调用可能超过120个字符，要在逗号后换行  
	method(args1, args2, args3, ... 
	argsX);
	```
	<font color="Firebrick">反例</font>：

	```
	StringBuffer sb = new StringBuffer(); 
	 
	// 超过120个字符的情况下，不要在括号前换行  
	sb.append("zi").append("xin")...append      
	("huang");    
	
	// 参数很多的方法调用可能超过120个字符，不要在逗号前换行  
	method(args1, args2, args3, ... 
	, argsX); 
	```
8. 方法参数在定义和传入时，多个参数逗号后边必须加空格。   
	<font color="green">正例</font>：下例中实参的"a",后边必须要有一个空格。 

	```
	void method("a", "b", "c"); 
	```
9. IDE的`text file encoding`设置为`UTF-8`; IDE中文件的换行符使用Unix格式，不要使用Windows格式。   
	<font color="DodgerBlue">说明</font>：
	由于Windows默认是用的是CRLF做换行符，Linux/mac使用LF。在协作开发时候会经常因为回车符而造成冲突。<br>
`IDEA -> Editor -> Code Style`中`Line separator`选择`Unix and OS X(\n)`。 

10. 没有必要增加若干空格来使某一行的字符与上一行对应位置的字符对齐。   
	<font color="green">正例</font>： 

	```
	int a = 3;  
	long b = 4L;  
	float c = 5F;  
	StringBuffer sb = new StringBuffer();
	```
	<font color="DodgerBlue">说明</font>：增加sb这个变量，如果需要对齐，则给a、b、c都要增加几个空格，在变量比较多的情况下，是非常累赘的事情。 

11. 不同逻辑、不同语义、不同业务的代码之间插入一个空行分隔开来以提升可读性。  
	<font color="DodgerBlue">说明</font>：没有必要插入**多个空行**进行隔开。 

12. 格式化代码快捷键：
	- mac：Command + Alt + L
	- windows：Ctrl + Alt + L

****************
## 四、OOP规约 

1. 避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成本，直接用**类名**来访问即可。   
	<font color="green">正例</font>：
	
	```
	FileUtil.readFile(FileUtil.PATH);

	```
	<font color="Firebrick">反例</font>：

	```
	FileUtil util = new FileUtil();
  	FileUtil.readFile(util.PATH);
	```
	
2. 所有的覆写方法，必须加`@Override`注解。  
	<font color="DodgerBlue">说明</font>：`getObject()`与`get0bject()`的问题。一个是字母的O，一个是数字的0，加`@Override`可以准确判断是否覆盖成功。另外，如果在抽象类中对方法签名进行修改，其实现类会马上编译报错。 

3. 相同参数类型，相同业务含义，才可以使用Java的可变参数，避免使用`Object`。  
	<font color="DodgerBlue">说明</font>：可变参数必须放置在参数列表的最后。（尽量不用可变参数编程）  
	<font color="green">正例</font>：

	```
	public User getUsers(String type, Integer... ids) {...} 
	```
4. <font color="Firebrick">外部正在调用或依赖的接口，不允许修改方法签名，避免对接口调用方产生影响。接口过时必须加`@Deprecated`注解，并清晰地说明采用的新接口或者新服务是什么。 如果需要可以重载一个同名方法。</font>

5. <font color="Firebrick">不能使用过时的类或方法，包括JDK的过时类或方法、第三方的的类库。新添加的第三方的类库，使用其最新的jar包。已经使用的第三方类库，通过迭代的方式，替换过时的类或方法。 </font>  
	<font color="DodgerBlue">说明</font>：`java.net.URLDecoder`中的方法`decode(String encodeStr)`这个方法已经过时，应该使用双参数`decode(String source, String encode)`。接口提供方既然明确是过时接口，那么有义务同时提供新的接口；作为调用方来说，有义务去考证过时方法的新实现是什么。 

6. `Object`的`equals`方法容易抛空指针异常，应使用常量或确定有值的对象来调用`equals`。  
	<font color="DodgerBlue">说明</font>：推荐使用`java.util.Objects.equals`，如`Objects.equals("test", object)`;  
	<font color="green">正例</font>：`"test".equals(object)`;  
	<font color="Firebrick">反例</font>：`object.equals("test")`; 

7. 所有的相同类型的包装类对象之间值的比较，全部使用equals方法比较。  
	<font color="DodgerBlue">说明</font>：对于Integer var = ?  在-128至127范围内的赋值，Integer对象是在IntegerCache.cache产生，会复用已有对象，这个区间内的Integer值可以直接使用==进行判断，但是这个区间之外的所有数据，都会在堆上产生，并不会复用已有对象，这是一个大坑，推荐使用equals方法进行判断。 

8. 关于基本数据类型与包装数据类型的使用标准如下：  
	1）所有的`POJO`类属性必须使用包装数据类型  
	2）RPC方法的返回值和参数必须使用包装数据类型  
	3）局部变量可以使用基本数据类型  
	4）<font color="Firebrick">与Android或IOS交互的API接口，入参必须使用基本数据类型（签名使用）</font>  
	<font color="DodgerBlue">说明</font>：`POJO`类属性没有初值是提醒使用者在需要使用时，必须自己显式地进行赋值，任何NPE问题，或者入库检查，都由使用者来保证。  
	<font color="green">正例</font>：数据库的查询结果可能是null，因为自动拆箱，用基本数据类型接收有NPE风险。  
	<font color="Firebrick">反例</font>：比如显示成交总额涨跌情况，即正负x%，x为基本数据类型，调用的RPC服务，调用不成功时，返回的是默认值，页面显示为0%，这是不合理的，应该显示成中划线。所以包装数据类型的null值，能够表示额外的信息，如：远程调用失败，异常退出。 

9. 定义`DO/DTO/VO`等`POJO`类时，不要设定任何属性**默认值**。  
	<font color="Firebrick">反例</font>：`POJO`类的`createTime`默认值为new Date();但是这个属性在数据提取时并没有置入具体值，在更新其它字段时又附带更新了此字段，导致创建时间被修改成当前时间。 

10. 序列化类新增属性时，请不要修改`serialVersionUID`字段，避免反序列失败。如果完全不兼容升级，避免反序列化混乱，那么请修改`serialVersionUID`值。  
	<font color="DodgerBlue">说明</font>：注意`serialVersionUID`不一致会抛出序列化运行时异常。 

11. 构造方法里面除了变量赋值禁止加入任何业务逻辑，如果有初始化逻辑，请放在init方法中。 

12. `POJO`类必须写`toString`方法。使用IDE中的工具：`source> generate toString`时，如果继承了另一个`POJO`类，注意在前面加一下`super.toString`。  
	<font color="DodgerBlue">说明</font>：在方法执行抛出异常时，可以直接调用POJO的toString()方法打印其属性值，便于排查问题。 

13. 使用索引访问用`String`的`split`方法得到的数组时，需做最后一个分隔符后有无内容的检查，否则会有抛`IndexOutOfBoundsException`的风险。  
	<font color="DodgerBlue">说明</font>：

	```
	String str = "a,b,c,,"; 
	
	// 默认会把后面都是空字符的去掉 
	String[] ary = str.split(",");  
	
	// 预期大于3，结果是3 
	System.out.println(ary.length);
	```
	```
	// 如果想得到所有的，limit参数设置为负数，如-1
	String str = "a,b,c,,"; 
	
	// limit=-1，会全部匹配 
	String[] ary = str.split(",", -1);  
	
	// 结果是5
	System.out.println(ary.length);
	```
14. 当一个类有多个构造方法，或者多个同名方法，这些方法应该按顺序放置在一起，便于阅读，此条规则优先于第15条规则。 

15. 类内方法定义的顺序依次是：公有方法或保护方法 > 私有方法 > getter/setter方法。  
	<font color="DodgerBlue">说明</font>：公有方法是类的调用者和维护者最关心的方法，首屏展示最好；保护方法虽然只是子类关心，也可能是“模板设计模式”下的核心方法；而私有方法外部一般不需要特别关心，是一个黑盒实现；因为承载的信息价值较低，所有`Service`和`Dao`的`getter/setter`方法放在类体最后。 

16. `setter`方法中，参数名称与类成员变量名称一致，this.成员名 = 参数名。这个使用Idea自动生成即可。
在`getter/setter`方法中，不要增加业务逻辑，增加排查问题的难度。  
	<font color="Firebrick">反例</font>：

	```
	public Integer getData() {      
		if (condition) {  
			return this.data + 100;  
		} else { 
			return this.data - 100; 
		}  
	}
	```
17. <font color="Firebrick">循环体内，字符串的连接方式，使用StringBuilder的append方法进行扩展。</font>  
	<font color="DodgerBlue">说明</font>：反编译出的字节码文件显示每次循环都会new出一个StringBuilder对象，然后进行append操作，最后通过toString方法返回String对象，造成内存资源浪费。  
	<font color="green">正例</font>：

	```
  StringBuilder sb = new StringBuilder();
	for (int i = 0; i <100; i++) {
    	sb.append("hello");
	}
	```
	<font color="Firebrick">反例</font>：

	```
	String str = "start";
	for (int i = 0; i < 100; i++) {
		str = str + "hello";      
	}
	```
18. `final`可以声明类、成员变量、方法、以及本地变量，下列情况使用`final`关键字：  
	1）不允许被继承的类，如：`String`类  
	2）不允许修改引用的域对象，如：`POJO`类的域变量  
	3）不允许被重写的方法，如：`POJO`类的`setter`方法  
	4）不允许运行过程中重新赋值的局部变量  
	5）避免上下文重复使用一个变量，使用final描述可以强制重新定义一个变量，方便更好地进行重构

19. 慎用Object的clone方法来拷贝对象。   
	<font color="DodgerBlue">说明</font>：对象的clone方法默认是浅拷贝，若想实现深拷贝需要重写clone方法实现属性对象的拷贝。 

20. 类成员与方法访问控制从严：  
	1）如果不允许外部直接通过`new`来创建对象，那么构造方法必须是`private`  
	2）工具类不允许有`public`或`default`构造方法  
	3）类非`static`成员变量并且与子类共享，必须是`protected`  
	4）类非`static`成员变量并且仅在本类使用，必须是`private`  
	5）类`static`成员变量如果仅在本类使用，必须是`private`  
	6）若是`static`成员变量，必须考虑是否为`final`  
	7）类成员方法只供类内部调用，必须是`private`  
	8）类成员方法只对继承类公开，那么限制为`protected`  
	<font color="DodgerBlue">说明</font>：任何类、方法、参数、变量，严控访问范围。过于宽泛的访问范围，不利于模块解耦。  
	思考：如果是一个`private`的方法，想删除就删除，可是一个`public`的`service`成员方法或成员变量，删除一下，不得手心冒点汗吗？变量像自己的小孩，尽量在自己的视线内，变量作用域太大，无限制的到处跑，那么你会担心的。 

**********************
## 五、集合处理 
1. 关于`hashCode`和`equals`的处理，遵循如下规则：   
	1）只要重写`equals`，就必须重写`hashCode`   
	2）因为`Set`存储的是不重复的对象，依据`hashCode`和`equals`进行判断，所以Set存储的对象必须重写这两个方法   
	3）如果自定义对象作为`Map`的key键，那么必须重写`hashCode`和`equals`   
	<font color="DodgerBlue">说明</font>：`String`重写了`hashCode`和`equals`方法，所以我们可以非常愉快地使用`String`对象作为key来使用。所有的内置的包装对象都重写了`hashCode`和`equals`方法。 

2. `ArrayList`的`subList`结果不可强转成`ArrayList`，否则会抛出`ClassCastException`异常，即`java.util.RandomAccessSubList cannot be cast to java.util.ArrayList`.   
	<font color="DodgerBlue">说明</font>：`subList`返回的是`ArrayList`的内部类`SubList`，并不是`ArrayList`，而是`ArrayList`的一个视图，对于`SubList`子列表的所有操作最终会反映到原列表上。 

3. 使用集合转数组的方法，必须使用集合的`toArray(T[] array)`，传入的是类型完全一样的数组，大小就是`list.size()`。   
	<font color="DodgerBlue">说明</font>：使用`toArray`带参方法，入参分配的数组空间不够大时，`toArray`方法内部将重新分配内存空间，并返回新数组地址；如果数组元素个数大于实际所需，下标为`[list.size()]`的数组元素将被置为null，其它数组元素保持原值，因此最好将方法入参数组大小定义与集合元素个数一致。   
	<font color="green">正例</font>： 

	```
   List<String> list = new ArrayList<String>(2);      
   list.add("guan");     
   list.add("bao");       
   String[] array = new String[list.size()];      
   array = list.toArray(array);
	```
	<font color="Firebrick">反例</font>：直接使用`toArray`无参方法存在问题，此方法返回值只能是`Object[]`类，若强转其它类型数组将出现`ClassCastException`错误。

4. 使用工具类`Arrays.asList()`把数组转换成集合时，不能使用其修改集合相关的方法，它的`add/remove/clear`方法会抛出`UnsupportedOperationException`异常。   
	<font color="DodgerBlue">说明</font>：asList的返回对象是一个`Arrays`内部类，并没有实现集合的修改方法。`Arrays.asList`体现的是适配器模式，只是转换接口，后台的数据仍是数组。

	```
	String[] str = new String[] { "you", "wu" };     
	List list = Arrays.asList(str); 
	```
	第一种情况：list.add("yangguanbao"); 运行时异常。  
	第二种情况：str[0] = "gujin"; 那么list.get(0)也会随之修改。

	. 不要在`foreach`循环里进行元素的`remove/add`操作。remove元素请使用`Iterator`方式，如果并发操作，需要对`Iterator`对象加锁。  	 
	<font color="green">正例</font>： 

	```
    Iterator<String> iterator = list.iterator();  
    while (iterator.hasNext()) {          
          String item = iterator.next();                  
                if (删除元素的条件) {                   
                        iterator.remove();                 
                }      
    }
	```
	<font color="Firebrick">反例</font>：

	 ```
    List<String> list = new ArrayList<String>();      
    list.add("1");      
    list.add("2");      
    for (String item : list) {        
        if ("1".equals(item)) {          
              list.remove(item);         
          }   
    }
    
    // 以上代码的执行结果肯定会出乎大家的意料，那么试一下把“1”换成“2”，会是同样的结果吗？
    // list.remove这种方式只能删除index是size-2（倒数第二个）的不重复的元素，删除其他元素
    // 会报java.util.ConcurrentModificationException异常。
	 ```
	
	. 在JDK7版本及以上，`Comparator`要满足如下三个条件，不然`Arrays.sort`，`Collections.sort`会报`IllegalArgumentException`异常。  	
	<font color="DodgerBlue">说明</font>：三个条件如下：  
	1）x，y的比较结果和y，x的比较结果相反  
	2）x>y，y>z，则x>z  
	3）x=y，则x，z比较结果和y，z比较结果相同  	 
	<font color="Firebrick">反例</font>：下例中没有处理**相等**的情况，实际使用中可能会出现异常：

	```
    new Comparator<Student>() {           
          @Override          
          public int compare(Student o1, Student o2) {              
            return o1.getId() > o2.getId() ? 1 : -1;       
          }  
    };  
	```

7. 集合初始化时，指定集合初始值大小。   
	<font color="DodgerBlue">说明</font>：`HashMap`使用`HashMap(int initialCapacity)`初始化。  
	<font color="green">正例</font>：initialCapacity = (需要存储的元素个数 / 负载因子) + 1。注意负载因子（即loader factor）默认为0.75，如果暂时无法确定初始值大小，请设置为16（即默认值）。  
	<font color="Firebrick">反例</font>：HashMap需要放置1024个元素，由于没有设置容量初始大小，随着元素不断增加，容量7次被迫扩大，resize需要重建hash表，严重影响性能。 

8. 使用`entrySet`遍历Map类集合KV，而不是`keySet`方式进行遍历。   
	<font color="DodgerBlue">说明</font>：`keySet`其实是遍历了2次，一次是转为`Iterator`对象，另一次是从`hashMap`中取出key所对应的value。而`entrySet`只是遍历了一次就把key和value都放到了entry中，效率更高。如果是JDK8，使用`Map.foreach`方法。   
	<font color="green">正例</font>：`values()`返回的是V值集合，是一个list集合对象；`keySet()`返回的是K值集合，是一个Set集合对象；`entrySet()`返回的是K-V值组合集合。 

	```
	Map<String, String> map = new HashMap<>();
   	map.put("a", "a");
   	map.put("b", "b");

   for (Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println(entry.getKey());
        System.out.println(entry.getValue());
   }

   map.forEach((key, value) -> {
        System.out.println(key);
        System.out.println(value);
   });
	
	```

9. 高度注意Map类集合K/V能不能存储null值的情况，如下表：

        | 集合类             | Key         | Value       | Super        | 说明         
        |-------------------|-------------|-------------|--------------|-------------------  
        | Hashtable         | 不允许       | 不允许       | Dictionary   | 线程安全                
        | ConcurrentHashMap | 不允许       | 不允许       | AbstractMap  | 锁分段技术（JDK8:CAS）  
        | TreeMap           | 不允许       | 可允许       | AbstractMap  | 线程不安全           
        | HashMap           | 可允许       | 可允许       | AbstractMap  | 线程不安全           

    <font color="Firebrick">反例</font>： 由于HashMap的干扰，很多人认为ConcurrentHashMap是可以置入null值，而事实上，存储null值时会抛出NPE异常。

**************

## 六、注释规范

1. 类、类属性、类方法的注释必须使用Javadoc规范，使用`/**内容*/` 文档注释的格式，不得使用 `// xxx` 单行注释的方式。  
	<font color="DodgerBlue">说明</font>：在IDE编辑窗口中，Javadoc方式会提示相关注释，生成Javadoc可以正确输出相应注释；在IDE中，工程调用方法时，不进入方法即可悬浮提示方法、参数、返回值的意义，提高阅读效率。   
		<font color="green">正例</font>：

	```
	/**
	 * 类描述：shiro权限验证
	 * @author zhangsan
	 * @date 2018/01/23 10:20
	 */
	public class ShiroPermissionUtil {
	
	/**
     * 手机号的权限编码
     */
    public final static String MOBILE_PERMISSION = "/show/mobile.action";	
    
    /**
     * 格式化手机号
     * @param mobile 手机号
     * @return 格式化后的手机号
     */
    public static String showMobile(String mobile) {
        if (hasPermission(MOBILE_PERMISSION)) {
            return mobile;
        }
        return StringUtil.formatHideMobileSixNumber(mobile);
    }
	
	```

2. <font color="Firebrick">方法内部单行注释，在被注释语句上方另起一行，使用`// xxx `单行注释。方法内部多行注释使用`/* xxx */ `多行注释。单行和多行注释上面要加一行空行。</font>  
		<font color="green">正例</font>：

	```
	public static String showMobile(String mobile) {
	
        // 从shiro中判断是否有显示手机号的权限 （这是单行注释）
        if (hasPermission(MOBILE_PERMISSION)) {
            return mobile;
        }
        
        /*
        这是多行注释
        这是多行注释
         */
        return StringUtil.formatHideMobileSixNumber(mobile);
    }
   ```

3. 所有的类都必须添加类描述、创建者、创建日期。即类描述、@author、@date。<font color="Firebrick">author是每个人姓名的全拼。</font>  
	<font color="green">正例</font>：

	```
	/**
	 * 类描述：shiro权限验证
	 * @author zhangsan 
	 * @date 2018/01/23 10:40
	 */
	public class ShiroPermissionUtil {}
			
	```
	<font color="DodgerBlue">说明</font>：

	```
	Idea中配置，setting->Editor->File and Code Template中File Header：
	/** 
	 * 类描述：
	 * @author  ${USER} 
	 * @date   ${YEAR}/${MONTH}/${DAY} ${TIME} 
	 */
	```


4. 所有的`controller`方法、接口方法、工具类中的方法、过滤器中的方法必须要有方法说明、参数@param（如果有）、返回值`@return`（如果有）、异常说明`@throws`（如果有）。  
方法说明应该指出做什么事情、实现什么功能。对子类的实现要求、或者调用注意事项等一并说明。
<br><font color="green">正例</font>：

	```
    /**
     * 格式化手机号
     * @param mobile 手机号
     * @return 格式化后的手机号
     */
    public static String showMobile(String mobile) {
        if (hasPermission(MOBILE_PERMISSION)) {
            return mobile;
        }
        return StringUtil.formatHideMobileSixNumber(mobile);
    }
	
	```
5. 所有的枚举类型字段必须要有注释，说明每个数据项的用途，推荐使用多行注释。
	
	```
	public enum AliLogEnum {

    /**
     * 身份证类型
     */
    LOG_TYPE_IDENTITY(1, "身份证实名"),
    
    /**
     * 银行卡类型
     */
    LOG_TYPE_BACK4(2, "银行卡四要素"),
    }
	```
6. 如果模块或类增加了负责人，需要在类上添加修改人。即@modifier。可以有多个修改人，<font color="Firebrick"> modifier是每个人姓名的全拼。</font>  
	<font color="green">正例</font>：

	```
	/**
	 * 类描述：shiro权限验证
	 * @author liuyi
	 * @date 2018/01/23 10:40
	 * @modifier zhangsan, lisi 
	 */
	public class ShiroPermissionUtil {}
			
	```
	
7. <font color="Firebrick">在其他人（即类的@author或@modifier不是自己）的类中添加方法，包括方法返回值、方法名、方法参数，需要在方法的注释加上@author。author是每个人姓名的全拼。</font>
	
	```
    /**
     * 检查手机号
     * @param mobile 手机号
     * @return 格式化后的手机号
     * @author zhangsan 
     */
    public static String checkMobile(String mobile) {
        if (hasPermission(MOBILE_PERMISSION)) {
            return mobile;
        }
        return StringUtil.formatHideMobileSixNumber(mobile);
    }
	
	```

8. <font color="Firebrick">修改其他人（即类的@author或@modifier不是自己）的方法，包括方法体和方法内容，需要在方法的注释加上`@modifier 修改人 时间 简单的修改内容描述`。  
	</font>只保留最近3次的修改人的记录，当已有3次记录，第4次的修改记录要覆盖<font color="Firebrick">时间最早的记录</font>。
	
	```
    /**
     * 检查手机号
     * @param mobile 手机号
     * @return 格式化后的手机号
     * @modifier zhagnsan 2018/01/01 格式化手机号
     * @modifier lisi 2018/02/01 格式化手机号
     * @modifier wangwu 2018/03/01 格式化手机号
     */
    public static String checkMobile(String mobile) {
        if (hasPermission(MOBILE_PERMISSION)) {
            return mobile;
        }
        
        // 格式化手机号
        return StringUtil.formatHideMobileSixNumber(mobile);
    }
	
	```
	
	当已有3次记录，第4次的修改记录要覆盖时间最早的记录。
	
	```
    /**
     * 检查手机号
     * @param mobile 手机号
     * @return 格式化后的手机号
     * @modifier liuliu 2018/06/01 格式化手机号
     * @modifier lisi 2018/02/01 格式化手机号
     * @modifier wangwu 2018/03/01 格式化手机号
     */
    public static String checkMobile(String mobile) {
        if (hasPermission(MOBILE_PERMISSION)) {
            return mobile;
        }
        
        // 格式化手机号
        return StringUtil.formatHideMobileSixNumber(mobile);
    }
	
	```
9. <font color="Firebrick">一个方法内有多个代码块，每个代码块都要有注释，说明代码块的作用。</font>

10. 谨慎注释掉代码。在上方详细说明，而不是简单地注释掉。如果无用，则删除。  
	<font color="DodgerBlue">说明</font>：代码被注释掉有两种可能性：  
		1）后续会恢复此段代码逻辑  
		2）永久不用  
	前者如果没有备注信息，难以知晓注释动机。后者建议直接删掉(代码仓库保存了历史代码)。

11. 注释说明使用中文即可，与其“半吊子”英文来注释，不如用中文注释把问题说清楚。专有名词与关键字保持英文原文即可。       
	<font color="Firebrick">反例</font>：“TCP连接超时”解释成“传输控制协议连接超时”，理解反而费脑筋。 

12. 代码修改的同时，注释也要进行相应的修改，尤其是参数、返回值、异常、核心逻辑等的修改。     
	<font color="DodgerBlue">说明</font>：代码与注释更新不同步，就会很容易误导他人。 

13. 谨慎注释掉代码。在上方详细说明，而不是简单地注释掉。如果无用，则删除。   
	<font color="DodgerBlue">说明</font>：代码被注释掉有两种可能性：  
		1）后续会恢复此段代码逻辑  
		2）永久不用  
	前者如果没有备注信息，难以知晓注释动机。后者建议直接删掉（代码仓库保存了历史代码）。 

14. 对于注释的要求：  
	1）能够准确反应设计思想和代码逻辑  
	2）能够描述业务含义，使别的程序员能够迅速了解到代码背后的信息  
	其实就是解释清楚这段代码干什么用的，实现什么功能。

***************
## 七、控制语句 
1. 在一个`switch`块内，每个`case`要么通过`break/return`等来终止，要么注释说明程序将继续执行到哪一个`case`为止；在一个`switch`块内，都必须包含一个`default`语句并且放在最后，即使空代码。 

2. 在`if / else / for / while / do`语句中必须使用大括号。即使只有一行代码，避免采用单行的编码方式： 

	```  
	if (condition) statements;  
	```
	
	<font color="green">正例</font>：

	```
	if (true) {
        return "正确";
    }
	```
	<font color="Firebrick">反例</font>：

	```
	if (true)  return "正确";
		
	```

3. 在高并发场景中，避免使用”等于”判断作为中断或退出的条件。   
	<font color="DodgerBlue">说明</font>：如果并发控制没有处理好，容易产生等值判断被“击穿”的情况，使用大于或小于的区间判断条件来代替。   
	<font color="green">正例</font>： 

	```
	if (count < 1)  {
        return "抢完了";
    }
	```

	<font color="Firebrick">反例</font>：判断剩余奖品数量等于0时，终止发放奖品，但因为并发处理错误导致奖品数量瞬间变成了负数，这样的话，活动无法终止。 
	
	```
	if (count == 0)  {
        return "抢完了";
    }
	```

4. 表达异常的分支时，少用if-else方式，这种方式可以改写成：

	```
	if (condition) {              
	  ...              
	  return obj;    
	}   
	    
	// 接着写else的业务逻辑代	码; 
	```
	<font color="DodgerBlue">说明</font>：如果非得使用`if()...else if()...else...`方式表达逻辑，为避免后续代码维护困难，请勿超过3层。  
	<font color="green">正例</font>：超过3层的`if-else`的逻辑判断代码可以使用卫语句来实现，示例如下： 

	```
	public void today() {      
	  if (isBusy()) {   
	      System.out.println(“change time.”);            
	      return; 
	  }       
	  if (isFree()) {  
	      System.out.println(“go to travel.”);             
	      return;     
	  }  
	  System.out.println(“stay at home to learn Alibaba Java Coding Guidelines.”);      
	  return; 
	} 
	
	// 所谓卫语句，如果某个条件需要检查，就应该单独检查该条件，并在该条件为真时立刻从方法中返回。
	// 这样的单独检查常常被称为“卫语句”。
	```

5. 除常用方法（如getXxx/isXxx）等外，不要在条件判断中执行其它复杂的语句，将复杂逻辑判断的结果赋值给一个有意义的布尔变量名，以提高可读性。   
	<font color="DodgerBlue">说明</font>：很多if语句内的逻辑相当复杂，阅读者需要分析条件表达式的最终结果，才能明确什么样的条件执行什么样的语句，那么，如果阅读者分析逻辑表达式错误呢？   
	<font color="green">正例</font>： 

	```
	boolean existed = (file.open(fileName, "w") != null) && (...) || (...); 
	if (existed) {    
	   ... 
	}  
	```
	<font color="Firebrick">反例</font>：

	```
	if ((file.open(fileName, "w") != null) && (...) || (...)) {     
	  ... 
	}
	```

6. 循环体中的语句要考量性能，以下操作尽量移至循环体外处理，如定义对象、变量、获取数据库连接，进行不必要的try-catch操作（这个try-catch是否可以移至循环体外）。 

7. 避免采用取反逻辑运算符。   
	<font color="DodgerBlue">说明</font>：取反逻辑不利于快速理解，并且取反逻辑写法必然存在对应的正向逻辑写法。   
	<font color="green">正例</font>：使用if (x < 628) 来表达 x 小于628  
	<font color="Firebrick">反例</font>：使用if (!(x >= 628)) 来表达 x 小于628

*****************
## 八、异常 
1. <font color="Firebrick">定义有业务含义的自定义异常，避免直接抛出`new RuntimeException()`，更不允许直接抛出Exception或者Throwable。 </font>
2. 有`try`块放到了事务代码中，`catch`异常后，<font color="Firebrick">原则上需要抛出一个异常</font>。  
  <font color="Firebrick">反例</font>：使用if (!(x >= 628)) 来表达 x 小于628

*****************
## 九、zmn项目规范

1. zmn有两个公共module项目：
  - **zmn-common**：公共项目，包括全局公用的自定义annotation、常量、字典、POJO、工具类等  

    <font color="Firebrick">反例</font>：如果是供调用`xxx-dubbo-interface`接口的相关公共类，应该定义在`xxx-dubbo-interface`中。  

  - **zmn-manager**：公共项目，包括公共配置、公共业务工具等，以及第三方中间件整合，如`dubbo`、`elasticsearch`、`hadoop`、`lts`、`shiro`等module，每个第三方中间件整合独立为一个二级模块。

2. 各业务系统一级module包括以下二级module：
  - **admin**：后台module
    - **controller**：用于页面逻辑处理和跳转控制  
  - **manager**：业务系统内的公共配置、业务工具、第三方接口/服务对接等
  - **model**：实体类module，包括两个类包：
    - **entity**：数据表映射实体
    - **vo**：可能用到的业务展示对象定义
  - **persistence**：持久层module
  - **service**：业务逻辑module，保证数据输入输出清晰，不超出服务层界限，不负责页面逻辑流转服务，包括两个类包：
    - **services**：用于包装`Persistence`数据操作服务，包括单表、join多表数据，实现简单的数据增删改查业务，直接调用`Persistence`层，不能直接调用`Services`和`Business`。  
    - **business**：实现复杂的业务逻辑，可以调用`Services`层或`Business`层，不能直接调用`Persistence`层。如调用多个`Persistence`或多个`Service`的操作，必须放在`Business`包
  - **api**：API接口module，为客户端、H5、第三方等提供对外接口
  - **dubbo-interface**：dubbo接口module，为使用dubbo服务的其他模块提供接口依赖
  - **dubbo**：dubbo接口实现module，该模块提供具体的dubbo服务
  - **task**：Job任务module，包括定时批量任务执行、消息的具体业务处理等

*****************
## 十、zmn类/文件/方法命名规范
### 一）类、类文件命名

<font color="DodgerBlue">范例以CRM系统中的`crm_user`、`crm_user_address`表说明。</font>  

1. **Model** 类和文件命名规则    
         
    - 实体类：<font color="DodgerBlue">`表前缀<表名称>`</font>，对应数据表名，<font color="Firebrick">注意带有表前缀`Crm`</font>，可使用`mybatis-generator`生成  
    <font color="green">正例</font>：`CrmUser`、`CrmUserAddress`  
    <font color="Firebrick">反例</font>：`User`、`UserAddress`  
    - 数据查询对象：<font color="DodgerBlue">`<对象名称>Query`</font>，方法入参
    - 数据对象：<font color="DodgerBlue">`<对象名称>DO`</font>（可以理解为表实体类之外的数据对象），如地理位置信息对象`GeoDO`        
    - 展示对象：<font color="DodgerBlue">`<对象名称>VO`</font>，如`UserVO`、`AddressVO`(表对象之外的展示对象，例如：一个对象的局部或者多个对象的合并、对接第三方接口自定义对象)       
    - `POJO`是`DO/DTO/BO/VO`的统称，禁止命名成xxxPOJO      



2. **BService、Service、Persistence** 类和文件命名规则： 
	
	**Persistence** 类和文件命名规则      
	
	- 接口类命名规则：<font color="DodgerBlue">`<表名称>Dao`</font>，<font color="Firebrick">注意没有表前缀`Crm`</font>，可使用`mybatis-generator`来生成Persistence类  
  <font color="green">正例</font>：`UserDao`、`UserAddressDao`  
  <font color="Firebrick">反例</font>：`CrmUserDao`、`CrmUserAddressDao`    
	
	**Service** 类和文件命名规则     

	- 接口类命名规则：<font color="DodgerBlue">`<表名称>Service`</font>  
	- 实现类命名规则：<font color="DodgerBlue">`<表名称>ServiceImpl`</font>，<font color="Firebrick">注意没有表前缀`Crm`</font>  
<font color="green">正例</font>：`UserService`、`UserServiceImpl`    
<font color="Firebrick">反例</font>：`CrmUserService`、`CrmUserServiceImpl`  
	
	**Business** 类和文件命名规则    
	
	- 接口类命名规则：<font color="DodgerBlue">`<功能名称>BService`</font>  
	- 实现类命名规则：<font color="DodgerBlue">`<功能名称>BServiceImpl`</font>，<font color="Firebrick">注意没有表前缀`Crm`</font>    
<font color="green">正例</font>：`UserAuthBService `、`UserAuthBServiceImpl`  
<font color="Firebrick">反例</font>：`CrmUserAuthBService`、`CrmUserAuthBServiceImpl`   
  
3. **Manager** 类和文件命名规则

	- 接口类命名规则：<font color="DodgerBlue">`<功能名称>Manager`</font>  
	- 实现类命名规则：<font color="DodgerBlue">`<功能名称>ManagerImpl`</font>   
	  <font color="green">正例</font>：报表指标缓存类 `MeasureCacheManager`、`MeasureCacheManagerImpl`   
	  <font color="green">正例</font>：基础数据远程调用并二次封装类`PlatRemoteManager`、`PlatRemoteManagerImpl`  

4. **Dubbo-interface** 类和文件命名规则  
  - 接口类命名规则：<font color="DodgerBlue">`<功能名称>RemoteService`</font>  
	  <font color="green">正例</font>：用户身份认证调用接口`UserAuthRemoteService`  
  - 数据传输对象包名：`dto`，包含入参对象`xxxDIO`和dubbo专用的出参对象`xxxDRO`  
    入参对象类命名规则：<font color="DodgerBlue">`<功能名称>DIO`</font>  
    出参对象类命名规则：<font color="DodgerBlue">`<功能名称>DRO`</font>  
	 <font color="green">正例</font>：入参对象`UserAuthDIO `、出参对象`UserTokenDRO` 

5. **Dubbo** 类和文件命名规则  
  - 实现类命名规则：<font color="DodgerBlue">`<功能名称>RemoteServiceImpl`</font>  
	  <font color="green">正例</font>：用户身份认证`UserAuthRemoteServiceImpl`  
  - 接口返回参数，必须是<font color="Firebrick">ResponseDTO类</font>  
	  <font color="green">正例</font>：`ResponseDTO<UserTokenDRO>`   

6. **Controller** 类和文件命名规则   
  
	- 基类：<font color="DodgerBlue">`<功能名称>BaseController`</font>   
	- 显示类：<font color="DodgerBlue">`<功能名称>ListController`</font>   
	- 操作类：<font color="DodgerBlue">`<功能名称>ModifyController`</font>  
	- 特殊功能类：根据功能命名，如`xxxExportController`    
	  <font color="green">正例</font>：`UserBaseController`、`UserListController`、`UserModifyController`   
	  <font color="green">正例</font>：`UserAddressBaseController`、`UserAddressListController`、`UserAddressModifyController`
  
7. **Template** 文件命名规则，一般包含四个文件：   
  
	- 查询详情文件：<font color="DodgerBlue">`detail.html`</font>   
	- 查询列表文件：<font color="DodgerBlue">`list.html`</font> ，引用`_query.html`和`_table.html`两个子模板文件    
	- 查询条件子模板：<font color="DodgerBlue">`_query.html`</font> 
	- 查询结果子模板：<font color="DodgerBlue">`_table.html`</font>   
	<font color="Firebrick">注意：子模板html文件，文件名用下划线开头，如`_query.html`</font>    
	
8. **其他类** 类和文件命名规则  

	- MQ类的规则：<font color="DodgerBlue">`<功能名称>Listener`</font> ，如`OrderCreateListener`      
	- Task类的规则：<font color="DodgerBlue">`<功能名称>Task`</font> ，如`OrderCreateTask`
	- Config配置类规则：<font color="DodgerBlue">`<配置组合名称>Config`</font> ，如`ShiroWebConfig`
	- DTO类的规则：数据传输对象，对其它对象的封装传输，用于Business、Dubbo、Controller向外传输对象，如`ResponseDTO`，除封装返回对象外，还封装有状态码、处理结果等属性

### 二）方法命名规范
1. **命名格式：**  
	
	```
	<方法前缀><操作对象><操作字段...>[By条件参数][For目的]
	```
	- **方法前缀**，定义方法的作用类型  
	  获取单个对象或元素：<font color="DodgerBlue">`find`</font>、<font color="DodgerBlue">`get`</font>  
	  获取列表或分页列表：<font color="DodgerBlue">`list`</font>、<font color="DodgerBlue">`listPage`</font>  
	  插入或新增数据：<font color="DodgerBlue">`insert`</font>、<font color="DodgerBlue">`add`</font>  
	  更新或修改数据：<font color="DodgerBlue">`update`</font>、<font color="DodgerBlue">`modify`</font>  
	  删除或移除数据：<font color="DodgerBlue">`delete`</font>
	- **操作对象**，一般为Model对象（无表前缀），如类的所有方法中只有一种对象，则可以省略对象  
	  <font color="green">正例</font>：取得区域列表 list**Area**、list(类里的方法中只有Area对象)  
	  <font color="green">正例</font>：修改用户信息使用 update**User**  
	  <font color="green">正例</font>：修改用户地址信息使用 update**UserAddress**
	- **操作字段**，一个或多个字段，如多个字段则并列组合，也可以使用描述词概括  
	  <font color="green">正例</font>：取得区域Id和名称列表 list**AreaIdName**、list**AreaVt**  
	  <font color="green">正例</font>：修改用户对象的状态使用 updateUser**Status**、update**Status**    
	  <font color="green">正例</font>：修改用户对象的多个联系信息 updateUser**MobileEmail**、updateUser**Contact**
	- **By条件参数**，方法操作的条件，一个或多个字段。如多个字段则并列组合，也可以使用描述词概括；如单个条件为表对象主键，则可省略     
	  <font color="green">正例</font>：取得下级区域Id和名称列表 listAreaIdName**ByParentId**、listAreaVt**ByParentId**  
	  <font color="green">正例</font>：修改指定Id的用户 updateUser**ByUserId**、updateUser(默认By主键UserId)    
	  <font color="green">正例</font>：修改有效手机号的用户 updateUser**ByStatusMobile**、updateUser**ByValidMobile**
	- **For目的**，方法操作的目的  
	  一般情况下通过方法前缀和操作对象、操作字段，方法目的已经不言而喻，则不需要`For目的`内容，只有目的不明确的情况才需要  
	  <font color="green">正例</font>：取得用户登录所需的字段信息 findUser**ForLogin**  
	  <font color="green">正例</font>：取得树状的产品分类列表 listCategory**ForTree**  

2. **Dubbo、Manager、Business、Service、Dao** 方法命名规范：  

   1）获取单个对象或对象的具体字段的方法用<font color="DodgerBlue">`find`</font>、<font color="DodgerBlue">`get`</font>作前缀  
   
   - **Persistence / Service模块** 中使用<font color="DodgerBlue">`find`</font>，**Manager / Business / Dubbo** 等模块中使用<font color="DodgerBlue">`get`</font>
   - 获取单个user对象：   
	  <font color="green">正例</font>：`findUserByKey`、`findUser(默认By主键UserId)`、`getUserAddressByAddrId`    
   - 获取单个user对象的的mobile字段：  
	  <font color="green">正例</font>：`findUserMobileByKey`、`findUserRealname(默认By主键UserId)`  
   - 获取单个user对象的id和realname字段：  
	  <font color="green">正例</font>：`findUserIdRealnameByKey`  
   - 获取单个user对象的联系信息相关字段，多个字段如属于某一类型，可直接描述词替代，例如`Contact`包含了user对象的`mobile`、`email`、`address`、`weixin`等字段：  
	  <font color="green">正例</font>：`findUserContactByKey`(等同于`findUserByKeyForContact`）、`getUserContactByEmail`  
   
   2）获取统计值的方法用<font color="DodgerBlue">`count`</font>作前缀   
   
   -  取得指定条件的address数量：   
	  <font color="green">正例</font>：`countUserAddressByQuery`、`countUserAddressByUserId` 
   
   3）获取多个对象的方法用<font color="DodgerBlue">`list`</font>作前缀   
   
   - 获取多个user、address对象：   
	  <font color="green">正例</font>：`listUserByQuery`、`listUserByUserIds`、`listUserAddressByUserId`     
   - 获取多个user对象的的mobile字段、多个address对象的经纬度：  
	  <font color="green">正例</font>：`listUserMobileByQuery`、`listUserMobileByUserIds`、`listUserAddressLatlngByUserId`  
   - 获取多个user对象的id和realname字段：  
	  <font color="green">正例</font>：`listUserIdRealnameByQuery`、`listUserIdRealnameByUserIds`  
   - 获取多个user对象的联系信息相关字段，多个字段如属于某一类型，可直接描述词替代，例如`Contact`包含了user对象的`mobile`、`email`、`address`、`weixin`等字段：  
	  <font color="green">正例</font>：`listUserContactByQuery`(等同于`listUserByQueryForContact`)、`listUserContactByUserIds`   
   - 获取多个Area的VtDTO对象(areaId和name的键值对信息)，适用于简单的，较为明确的键值对，不适用于复杂对象：  
	  <font color="green">正例</font>：`listAreaVtByQuery`、`listAreaVtByAreaIds`  
	  <font color="Firebrick">反例</font>：`listUserVtByQuery`、`listUserVtByUserIds`，`User`对象属性多，键值对内容不明确  
   
   
   4）获取分页对象的方法用<font color="DodgerBlue">`listPage`</font>作前缀   
   
   - 同`list`      
   
   5）修改的方法用<font color="DodgerBlue">`update`</font>、<font color="DodgerBlue">`modify`</font>作前缀 
   
   - **Persistence / Service模块** 中使用<font color="DodgerBlue">`update`</font>，**Manager / Business /  Dubbo** 等模块中使用<font color="DodgerBlue">`modify`</font>
   - 修改单个或多个user、address对象：   
	  <font color="green">正例</font>：`updateUserByKey`、`modifyUser(默认By主键UserId)`、`updateUserAddressByUserId`    
   - 修改user对象的的mobile、status字段：  
	  <font color="green">正例</font>：`updateUserMobileByKey`、`updateUserStatus(默认By主键UserId)`  
   - 修改user对象的nickname和realname字段：  
	  <font color="green">正例</font>：`updateUserNicknameRealnameByKey`、`modifyUserNicknameRealnameByUserId`  
   - 获取user对象的联系信息相关字段，多个字段如属于某一类型，可直接描述词替代，例如`Contact`包含了user对象的`mobile`、`email`、`address`、`weixin`等字段：  
	  <font color="green">正例</font>：`updateUserContactByKey`(等同`updateUserByKeyForContact`)            
     
   6）新增的方法用<font color="DodgerBlue">`insert`</font>、<font color="DodgerBlue">`add`</font>作前缀 
   
   - **Persistence / Service模块** 中使用<font color="DodgerBlue">`insert`</font>，**Manager / Business /  Dubbo** 等模块中使用<font color="DodgerBlue">`add`</font>
   - 新增单个user、address对象：     
	  <font color="green">正例</font>：`insertUser`、`insertUserAddress`、`addUser`   
   - 批量新增多个user、address对象，使用对象复数：   
	  <font color="green">正例</font>：`insertUsers`、`insertUserAddresses`、`addUsers`     
     
   7）删除的方法用<font color="DodgerBlue">`delete`</font>作前缀 
   
   - 删除单个或多个user、address对象(此处为举例需要，实际场景中一般不允许删除数据)：   
	  <font color="green">正例</font>：`deleteUserByKey`、`deleteUser(默认By主键UserId)`、`deleteUserAddressByUserId`    
   - 删除user与product的关注关系：  
	  <font color="green">正例</font>：`deleteUserFollowByUserIdProductId`、`deleteUserFollowByUserId`       
   
   8）其他操作：
   
   - 复杂的业务逻辑操作，可自行命名方法  
	  <font color="green">正例</font>：从CRM系统中异步同步用户数据 `syncUserFromCRM`   
	  <font color="green">正例</font>：复制模板站点并创建新的站点 `copySiteFromTemplateSite`   
	  <font color="green">正例</font>：读取报表数据并分析 `readReport`   
	  <font color="green">正例</font>：建立指标规则的键值关系Map `bindMeasureRuleMap` 

3. **Controller** 方法命名规范：

	- 页面显示，以user显示为例，对应的`RequestMapping`为`@RequestMapping("/user/")`  
	  <font color="green">正例</font>：用户列表页`list`、用户详情页`detail`、用户地址列表页`listAddress`  
	- 操作动作，以user操作为例，对应的`RequestMapping`为`@RequestMapping("/user/modify/")`  
	  <font color="green">正例</font>：新增和修改用户`addEdit`、更改用户状态`modifyStatus`、更改用户密码`modifyPassword`  
	- Ajax请求，查询请求放在放在`AjaxController`中；修改请求放在`ModifyController`中，修改请求方法名以`ajax`开头  
	  <font color="green">正例</font>：异步获取用户地址列表`UserAjaxAddress#listUserAddress `、异步更改用户状态`ajaxModifyStatus`   

4. **方法前缀对比**   

	|  | Persistence | Service | Business | Manager | Dubbo | Controller |
	| --- |:--- |:---|:--- |:--- |:--- |:---|
	| 获取单个 | find | find | get | get | get | 页面Path |
	| 获取列表 | list | list | list | list | list | list |
	| 分页获取列表 | listPage | listPage | listPage | listPage | listPage | listPage |
	| 更新 | update | update | modify | modify | modify | modify |
	| 新增 | insert | insert | add | add | add | add |
	| 删除 | delete | delete | delete | delete | delete | delete |

### 三）方法在类中的位置及顺序
1. **Dubbo、Manager、Business、Service、Persistence** 中方法的顺序依次为：  
	<font color="DodgerBlue">`获取/查询单个对象或单个对象的字段`、`获取/查询列表`、`获取统计值`、`更新/修改`、`插入/新增`、`删除`</font>   
2. **Mapper.xml** 中`sql片段`的位置和顺序同上。
3. **Dubbo、Manager、Business、Service、Persistence、Mapper** 中，各文件中相同方法的位置和顺序保持一致。 
4. 重载与被重载的方法应置于相邻的位置，被重载的方法在下方。 

  ReportDao.xml  

  ```
  <!--查询单个对象-->
    <select id="findByKey" parameterType="Integer" resultMap="baseResultMap">
        ……
    </select>
  
  <!--分页查询列表-->
    <select id="listPageByQuery" parameterType="DataReportQuery" resultMap="baseResultMap">
        ……
    </select>
  
  <!--查询列表-->
    <select id="listByQuery" parameterType="DataReportQuery" resultMap="baseResultMap">
        ……
    </select>
  
  <!--获取数量-->
    <select id="countByQuery" parameterType="DataReportQuery" resultType="Integer">
        ……
    </select>
  ```


	<!--更新对象-->
	<update id="updateByKey" parameterType="DataReport">
	    ……
	</update>
	
	<!--更新对象的指定字段-->
	<update id="updateStatus" parameterType="DataReport">
	    ……
	</update>
	
	<!--批量更新对象的指定字段-->
	<update id="updateStatusBatch" parameterType="StatusDTO">
	    ……
	</update>
	
	<!--更新对象的指定字段-->
	<update id="updateSort" parameterType="DataReport">
	    ……
	</update>


	<!--插入新对象-->
	<insert id="insert" parameterType="DataReport" useGeneratedKeys="true" keyProperty="reportId">
	    ……
	</insert>
	
	<!--删除对象-->
	<delete id="deleteByKey" parameterType="Integer">
	    ……
	</delete>
	```
	
	ReportDao.java  
	
	```
	public interface ReportDao {
	
		// 查询单个对象
		DataReport findByKey(Integer reportId);
		
		// 分页查询列表
		List<DataReport> listPageByQuery(DataReportQuery query);
		
		// 查询列表
		List<DataReport> listByQuery(DataReportQuery query);
		
		// 获取数量
		Integer countByQuery(DataReportQuery query);


​		
		// 更新对象
		Integer updateByKey(DataReport report);
		
		// 更新对象的指定字段
		Integer updateStatus(DataReport report);
		
		// 批量更新对象的指定字段
		Integer updateStatusBatch(StatusDTO dto);
		
		// 更新对象的指定字段
		Integer updateSort(DataReport report);


​		
		// 插入对象
		Integer insert(DataReport report);


​		
		// 删除对象
		Integer deleteByKey(Integer reportId);
	}
	```
	
	ReportService.java  
	
	```
	public interface ReportService {
	
		// 查询单个对象
	    DataReport findByKey(Integer reportId);
	
		// 分页查询列表
	    List<DataReport> listPageByQuery(DataReportQuery query);
	
		// 查询列表（重载下面的方法listByQuery）
	    List<DataReport> listByDatasetId(Integer datasetId);
	    List<DataReport> listByQuery(DataReportQuery query);
	
		// 获取数量
	    Integer countByQuery(DataReportQuery query);


​	
		// 更新对象
	    Integer updateByKey(DataReport report);
	
		// 更新对象的指定字段（重载下面的方法updateStatus）
	    Integer updateStatus(Integer reportId, Integer status, String updater);
	    Integer updateStatus(DataReport report);
	
		// 批量更新对象的指定字段（重载下面的方法updateStatusBatch）
	    Integer updateStatusBatch(List<Integer> reportIds, Integer status, String updater);
	    Integer updateStatusBatch(StatusDTO dto);
	
		// 更新对象的指定字段（重载下面的方法updateSort）
	    Integer updateSort(Integer reportId, Integer sort);
	    Integer updateSort(DataReport report);


​	
		// 插入对象
	    Integer insert(DataReport report);


​	
		// 删除对象
	    Integer deleteByKey(Integer reportId);
	}
	```
	
	ReportServiceImpl.java  
	
	```
	public interface ReportServiceImpl implements ReportService {
		
		@Resource
		private ReportDao reportDao;


​		
		// 查询单个对象
		@Override
		public DataReport findByKey(Integer reportId) {
			……
		}
		
		// 分页查询列表
		@Override
		public List<DataReport> listPageByQuery(DataReportQuery query) {
			……
		}
		
		// 查询列表（重载下面的方法listByQuery）
		@Override
		public List<DataReport> listByDatasetId(Integer datasetId) {
			……
		}
		@Override
		public List<DataReport> listByQuery(DataReportQuery query) {
			……
		}


		// 获取数量 
		@Override
		public Integer countByQuery(DataReportQuery query) {
			……
		}


​		
		// 更新对象
		@Override
		public Integer updateByKey(DataReport report) {
			……
		}
		
		// 更新对象的指定字段（重载下面的方法updateStatus）
		@Override
		public Integer updateStatus(Integer reportId, Integer status, String updater) {
			……
		}
		@Override
		public Integer updateStatus(DataReport report) {
			……
		}
		
		// 批量更新对象的指定字段（重载下面的方法updateStatusBatch）
		@Override
		public Integer updateStatusBatch(List<Integer> reportIds, Integer status, String updater) {
			……
		}
		@Override
		public Integer updateStatusBatch(StatusDTO dto) {
			……
		}
		
		// 更新对象的指定字段（重载下面的方法updateSort）
		@Override
		public Integer updateSort(Integer reportId, Integer sort) {
			……
		}
		@Override
		public Integer updateSort(DataReport report) {
			……
		}


​		
		// 插入对象
		@Override
		public Integer insert(DataReport report) {
			……
		}


​		
		// 删除对象
		@Override
		public Integer deleteByKey(Integer reportId) {
			……
		}
	}
	```

**********************

### 版本历史
| 版本号 | 更新日期 | 更新人 | 备注 |
| ------|:------- |:------|:----|
| 1.0 | 2018.09.27 | 贺光华 | 发布1.0版本 |
| 1.1 | 2019.07.20 | 贺光华 | 发布1.1版本 |


