<br>

<br>

<br>

<br>

<br>

<br>

<br>

<center> Android 移动应用开发期末项目报告</center>

<br>

<center>伴旅</center>

<br>

<br>

         组       号：  79

         小组成员：  卢锦涛       14353216   jtl0208@163.com   908583676

                             高仕腾      14353066

                             肖姗姗      14353332

                             李成婉宁   14353134

<br>

<br>

<br>

<br>

<br>

<br>

<br>

<br>

<br>

<br>

<br>

 Table of Contents <center> Android 移动应用开发期末项目报告</center><center>伴旅</center>1   概述2   背景2.1   项目背景2.2   同类应用的不足2.3   应用设想、涉及范围和使用技术2.4   项目特点3   项目说明3.1   功能模块3.2   逻辑流程3.3   技术说明3.3.1   AppStart启动界面3.3.2   BottomNavigationBar 特色底部导航栏3.3.3   Fragment的详细使用3.3.4   ListView左右分栏效果3.3.5   天气查询动态广播3.3.6   ItemTouchHelper3.3.7   云数据库接入3.3.8   自动定位3.3.9   显示商家地点的地图3.3.10   用户登录/注册的实现3.3.11   ScrollView嵌套两个RecycleViewer3.3.12   毛玻璃背景效果实现3.4   代码架构3.4.1    域名+应用程序名称3.4.2    应用名称3.4.3    各模块4   应用效果5   开发过程中遇到的问题及解决办法6   思考及感想7   小组分工8   参考资料

<br>

<br>

1   概述

---

如今自由行成为人们旅游出行的热门趋势，虽然目前有许多针对自由行的App，但是它们都是作为中间商的角色存在，消费者并不能直接与商家沟通预定，甚至进行议价。而且它们只提供当地较大型的旅游项目，所以当人们想体验当地特色的旅游项目的时候并不知道要到哪里寻找。除此之外，在旅游当中，日常生活服务也是不可缺少的，比如说洗衣服务等，目前的地图和旅游App都不能很好地够满足。

所以我们推出了这款App（只实现了旅客端），里面提供了地方特色旅游项目和日常服务的商家，而且无论大小商家都可以通过分类轻松找到；并且旅客可以通过App直接联系商家进行议价和预定，免掉中间商赚差价环节，更优惠；旅客还可以寻找靠谱旅伴（导游或驴友）。实现自由行的最大自由，开辟一种全新的旅游模式。

<br>

2   背景

---

2.1   项目背景

目前，越来越多人选择自由行作为旅游方式而不是传统的跟团旅游模式。由于跟团旅游多数只是走马观花型，旅客不能体验到本土风情，而自由行可以满足人们出行自由的需求，由自己规划，想去哪就去哪，更好地体验当地特色。而且根据自由行的数据报告显示，自由行已经成为旅游方式的主流，以“当地人的方式”旅行越来越受到自由行旅客的欢迎，且自由行产品的多样化、碎片化和自由组合是未来的发展趋势。

2.2   同类应用的不足

随着自由行占领旅游市场的份额逐年增加，越来越多针对自由行的App出现，主要包括出行方式、酒店预订、旅游攻略、驴友或地陪寻找等功能。虽然这些App使得人们自由行更加方便，但是还是有不少不足之处。

许多App都是作为中间商的角色在运作，旅客如要预定一个商家，只能通过App上面的价格进行选择，并不能直接跟商家进行议价改价，而且每次预定的时候都要加上中间商的服务费，对于旅客来说是不实惠的。

并且大多数App只提供了当地旅游的大众项目，或者用另一句话说，只提供很少甚至没有提供当地特色的旅游项目。所以如果旅客要寻找特色旅游项目，体验当地风情，先要到网上查找攻略，查找评价，再查找商家的联系方式，再进行联系，这过程十分烦杂。

除此之外，日常生活服务在旅行中是必不可少的。如果旅客在某地旅游，酒店的洗衣服务很贵，所以他就会想要寻找一个比较便宜的附近洗衣店，那么他只能通过地图来进行查找，但是很多时候，地图会忽略掉很多商店，搜索出来的结果通常不如意。但是目前自由行App并不提供生活服务，他们只着眼于出行和项目，并没有考虑到自由行中生活服务的不便性，没有解决自由行旅客出行中的这类麻烦。

2.3   应用设想、涉及范围和使用技术

基于以上同类应用的不足，我们设想的应用可以解决以上三个问题，应用提供了地方特色旅游项目和日常服务的商家，并且旅客可以通过App直接联系商家进行议价和预定，还可以寻找靠谱旅伴（导游或驴友）。

这款应用主要针对自由行旅客，让他们在自由行旅游中使用，避免很多自由行中不必要的麻烦。

本应用主要使用了安卓开发、数据库和GPS技术。

2.4   项目特点

- 实用性：这款应用很实用，基本上能满足自由行旅客在自由行中所需要的功能。
- 创新性：相对于同类应用，这款应用存在创新和突破。它去除中间商赚差价环节，让旅客能与商家直接联系进行议价改价；能够查找到当地特色的旅游项目；满足自由行旅客在旅行中的生活服务的需求。
- 用户体验：这款应用（旅客端）架构简单，就只分为商家、旅伴、消息和个人信息四大模块，每个模块功能单一，易于操作，对用户友好。UI设计简洁美观，有专门的配色，内容布局合理清晰。应用运行稳定，运行流畅，速度较快。
- 兼容性：兼容多个版本，且兼容32位和64位系统，但只兼容安卓平台。
- 隐私保护性：涉及用户隐私，用最基本的数据库储存用户信息，故安全性较低。

<br>

3   项目说明

---

3.1   功能模块

下图是这款应用——伴旅的功能模块。

<center><p style="font-size:15px">图1   应用功能模块图</p></center>

伴旅分为四个功能模块，分别为商家模块、旅伴模块、消息模块和个人信息模块。

商家功能模块主要是显示商家的大致信息和详细信息功能。包括了商家分类、商家列表和商家详情功能，囊括了商家显示的基本功能，其中，在商家详情页除了显示商家的详细信息，还有联系商家的功能。

旅伴功能模块主要是显示旅伴的大致信息和详细信息功能。包括了旅伴列表和旅伴详情功能，其中旅伴详情模块中不仅显示相应旅伴的详细信息，还有联系旅伴的功能。

消息功能模块是将所有与商家/旅伴联系的消息整合到一块，方便用户查看和管理消息。包括了消息列表和发送/接收消息功能（没有实现发送/接收消息的完整功能）。

个人信息模块是整合了个人的信息，方便用户查看和管理个人信息。包括一些最基本的账户注册或登录、订单信息、收藏信息、优惠券信息和设置的功能。

3.2   逻辑流程

逻辑流程主要为商家业务逻辑流程，如下图所示。

<center><p style="font-size:15px">图2   商家业务逻辑流程图</p</center>

3.3   技术说明

3.3.1   AppStart启动界面

使用关键技术：AlphaAnimation动画、页面跳转和销毁

- AlphaAnimation动画
  控制对象alpha水平的动画。这个动画可以通过改变alpha属性，达到渐入渐出的效果。
  <br>
- 构造方法：AlphaAnimation(float fromAlpha, float toAlpha)
  使用代码实现渐变动画
  <br>
- 代码实现关键部分
      //渐变展示启动屏幕
      AlphaAnimation anima = new AlphaAnimation(0.3f,1.0f);
      
      //设置动画持续时间
      anima.setDuration(2000);
      
      //开始动画
      welcomeTag.startAnimation(anima);
      
      //添加事件监听
      anima.setAnimationListener(new Animation.AnimationListener() {
      @Override
      //动画开始阶段
      public void onAnimationStart(Animation animation) {
             welcomeTag.setBackgroundResource(R.drawable.logo);
             }
      
      @Override
      //动画结束阶段
      public void onAnimationEnd(Animation animation) {
             //跳转页面并销毁程序
             redirecTo();
             }
      @Override
      public void onAnimationRepeat(Animation animation) {
             }
             });
  其中redirectTo()
      private void redirecTo(){
              Intent intent = new Intent(this,BottomNavigationBarDemoActivity.class);
              startActivity(intent);//页面跳转
              finish();//销毁activity
          }

<br>

<br>

3.3.2   BottomNavigationBar 特色底部导航栏

<center><p style="font-size:15px">图3   特色底部导航栏</p></center>

Google在2016年初推出的Material Design中增加的一个导航控制，类似于苹果的底部Toolbar

- 特色
  - 选择背景样式和触击模式
  - icon可以自动着色
- 实现方法和流程(仅展示关键部分)
  - 依赖添加
        compile 'com.ashokvarma.android:bottom-navigation-bar:1.2.0'
  - 布局实现
        <com.ashokvarma.bottomnavigation.BottomNavigationBar
                android:id="@+id/bottom_navigation_bar"
                android:layout_height="wrap_content"
                android:layout_width="match_parent"/>
  - 在主页面里设置导航栏的模式和背景风格
        * 三种模式
    1. MODE_DEFAULT
       1. MODE_FIXED
       2. MODE_SHIFTING
          - 背景样式
       3. BACKGROUND_STYLE_DEFAULT
       4. BACKGROUND_STYLE_ROPPLE
       5. BACKGROUND_STYLE_STATIC
        //得到BottomNavigationBar控件
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        //设置模式     
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        //设置BottomNavigationBar背景风格
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_DEFAULT);
        //按钮的ico和文字设置
        bottomNavigationBar
          .addItem(new BottomNavigationItem(R.mipmap.shop, "商家").setActiveColorResource(R.color.colorApp))
          .addItem(new BottomNavigationItem(R.mipmap.heart, "旅伴").setActiveColorResource(R.color.colorApp))
          .addItem(new BottomNavigationItem(R.mipmap.speach_, "消息").setActiveColorResource(R.color.colorApp))
          .addItem(new  BottomNavigationItem(R.mipmap.user, "个人").setActiveColorResource(R.color.colorApp));
        bottomNavigationBar
          .setActiveColor(R.color.colorAccent)
            .setInActiveColor(R.color.white)
            .setBarBackgroundColor("#ffffff")
            .setTabSelectedListener(this);

3.3.3   Fragment的详细使用

Fragment相当于Activity里的一个模块或者是碎片，有着自己的生命周期，可以单独处理自己的输出，可以在Activity运行的时候加载或者移除Fragment模块。

- 在项目中，由于该底部导航栏独占一个Activity，所以在上面的其他四个内容都需要用Fragment来填充页面。
  <br>
- 重要的三个回调函数
  - onCreate()
    创建Fragment时候调用这个方法
  - onCreateView()
    绘制Fragment的UI需要调用这个方法，该函数返回一个View
  - onPause()
    离开Fragment的时候调用这个方法
- 代码关键部分
  只举一个其中一个Fragment的例子，其他的大同小异。
  - 首先需要根据底部导航栏来选择跳转Fragment
        private void setFourthFragment(){
          //实例化一个FragmentTransaction实例，Transaction可以在运行的时候添加删除或者替换Fragment，从而实现UI的动态变换
          FragmentManager fm = getSupportFragmentManager();
          FragmentTransaction transaction = fm.beginTransaction();
          //调用了启动类加器，实例化调用的类
          userFragment = UserFragment.newInstance("个人");
          //用我们定义的Fragment类来替换掉原先的Fragment
          transaction.replace(R.id.layFrame, userFragment);
          //提交修改后的Fragment
          transaction.commit();
        }
  - 自定义的Fragment
        @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                // Inflate the layout for this fragment
                View view = inflater.inflate(R.layout.fragment_user,container, false);
                Bundle bundle = getArguments();
              //返回一个View类型的视图，
                return view;
            }

3.3.4   ListView左右分栏效果

<center><p style="font-size:15px">图4   ListView左右分栏效果图</p></center>

- 实现思想
  默认的ListView只有一个item样式依次排序下来，如果想要在一个ListView里面有item可以左右分开或者是更多不同样式，可以通过便遍历每一个position的方式，通过改变两个item里的Visibility值，实现同一个ListView里不同的样式显示。
  <br>
- 代码实现(只抽取关键部分展示关键思想)
  - 布局文件
    布局文件中是有left和right两个不同的样式的，放在同一个位置里，之后可以调用。
  - Java关健代码
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
          holder = new ViewHolder();
            if(convertView == null){
              convertView = inflater.inflate(R.layout.fragment_chat_item, null);
                holder.titleRight = (TextView)convertView.findViewById(R.id.GuiderNameRight);
                holder.titleLeft = (TextView)convertView.findViewById(R.id.GuiderNameLeft);
                (RelativeLayout)convertView.findViewById(R.id.GuiderLeft);
                holder.iv_right = (RelativeLayout)convertView.findViewById(R.id.GuiderRight);
                convertView.setTag(holder);
            } else
               //拿到当前位置的标识符
               holder = (ViewHolder) convertView.getTag();
               //每一个位置都赋予左右两边相同的值
        holder.titleLeft.setText(data.get(position).get("Name").toString());
            holder.titleRight.setText(data.get(position).get("Name").toString());
            //根据当前位置，如果是偶数位，隐藏左边栏，显示右边栏，反之亦然
            if(position % 2 == 0){
              holder.iv_left.setVisibility(View.GONE);
                holder.iv_right.setVisibility(View.VISIBLE);
            } else{
                holder.iv_left.setVisibility(View.VISIBLE);
                holder.iv_right.setVisibility(View.GONE);
            }
            return convertView;
        }

<br>

3.3.5   天气查询动态广播

- 关健技术
  - 天气查询/网络请求
    项目中调用了“心知天气”的免费API，可以用来查询天气实况。
    搜索框/定位获取城市名称，通过网络服务获取对应城市的天气情况，获取一个JSON文件，通过解析该文件提取天气现象和温度信息。
  - 动态广播/通知栏Notification
- 代码实现(仅展示关键代码)
  - 注册广播
        IntentFilter dynamic_filter = new IntentFilter();
         dynamic_filter.addAction("android.intent.action.dynamicAction");//添加动态广播的Action
         getContext().registerReceiver(dynamicReceiver,dynamic_filter);
  - 创建子线程进行网络访问的操作
        final String path = "https://api.thinkpage.cn/v3/weather/now.json?"+"key=kpsgmop8lhpnqvh8&location=";
        new Thread() {
               //创建子线程进行网络访问的操作
               public void run() {
                  try {
                   StringBuffer buffer  = new StringBuffer(path);
                    //得到所要查询的城市名
                    location = currentlocal.getText().toString();
                    //因为涉及中文，需要将城市名使用UTF8编码加入URL参数
                    buffer.append(URLEncoder.encode(location, "utf-8"));
                    //获取JSON文件
                    smap = getJSONObject(buffer.toString());
                //在handler中处理JSON文件、提取信息
                handler.sendEmptyMessage(0);
              }
                catch (Exception e) {
                          e.printStackTrace();
                      }
                  } 
              }.start();

- 网络访问子线程运行完在handler里解析JSON文件，并发送到广播
      private Handler handler = new Handler() {
              //在handler中解析JSON文件
              public void handleMessage(android.os.Message msg) {
                  switch (msg.what) {
                      case 0:
                          if(smap.get("text") != "x"){
                              String temp = smap.get("text") + "  " + smap.get("tem") + "℃";
                              weather = temp;

3.3.6   ItemTouchHelper

RecycleView添加拖动需要用到一个类，是Android兼容包的一部分：ItemTouchHelper。它处理好了关于在RecycleView上添加拖动排序和滑动删除的所有事情，是RecycleView.ItemDecoration的子类。

- 项目中的主要功能
  - 单击进入聊天界面
  - 长按可以拖拽排序（ItemTouchCallback）
  - 左滑显示出删除窗口
  - 在删除窗口中，点击删除可以删除该item

3.3.7   云数据库接入

Bmob提供了一个云数据库的服务，可以在上面建表之后再跟应用接入并且可以具有增删改查的功能，所以小组项目中选取了它作为第三方数据库，避免了自己搭一个服务器和数据库的麻烦，直接由Bmob接入即可。

在项目中，仅仅只是完成了商品列表页的数据读取。但它还具有其他功能，比如，即时聊天，文件传输，流量访问查询等功能。由于完成数据库与本项目应用接入有着较大的工作量，本项目没有完成这些功能，只完成了数据列表读取。



<center style="text-size:15px">图5   Bmob中建的数据库图</center>

3.3.8   自动定位

利用百度API来实现自动定位，需要百度地图SDK包。返回的值有经纬度时间和详细地址等，我们再项目里只需要用到本地城市名，因此getCity将其提取出来。

自动定位需要用到GPS传感器以及网络服务，两者的相互结合可以精确定位到自己的位置。在室内使用网路服务，在室外使用GPS定位服务。

3.3.9   显示商家地点的地图

<center>

<p style="font-size:15px">图6   商家详情中的地图显示图</p></center>

- 实现思路
  同样使用百度API来实现特定位置附近地图的显示，通过地理编码，将获取到的地址转成经纬度，然后通过加上自定义Marker，显示商店地理位置的地图和标识的商店地点。
  <br>
- 代码实现
  商家地点的地图显示关键在于地理编码，而地理编码的实现如下：
- 创建地理编码检索实例
      final GeoCoder geoCoder = GeoCoder.newInstance();

     * 创建地理编码检索监听者`OnGetGeoCoderResultListener`
    
          监听者中主要有两个方法，一个是`onGetGeoCodeResult`，获取的是地理编码的结果；另一个是`onGetReverseGeoCodeResult`，获取的是反地理编码的结果。所以在这里只需要完善地理编码部分即可。
    
          首先获取地理编码结果，将其转换为经纬度。
          ```java
          float latitude = (float) geoCodeResult.getLocation().latitude;
          float longitude = (float) geoCodeResult.getLocation().longitude;
    	  LatLng point = new LatLng(latitude, longitude);

      这里我设置了两个marker，如上图所示，一个是位置上方的矩形，另一个是圆圈marker。通过`Bitmap`和`OverlayOptions`来构建MarkerOption，用于在地图上添加矩形marker。而圆圈marker则是通过`CircleOptions`来构建marker。
      最后再通过`addOverlay`方法依次将两个marker添加到地图上，并且更新地图的状态。
      <br>

- 设置地理编码检索监听者
       ```java
       geoCoder.setOnGetGeoCodeResultListener(listener);
       ```
- 发起地理编码检索
      geoCoder.geocode(new GeoCodeOption().city("广州").address("番禺区大石镇迎宾路长隆欢乐世界"));

3.3.10   用户登录/注册的实现

- 实现思路
  在这里使用轻量级数据库Sqlite来存储注册过的用户的信息，来保证已注册过的用户的信息可以在登录时显示，登录或注册后会有Broadcast提醒以示成功，并且使用bundle将名字显示在个人页面上，呈现一种已登录/注册的状态。
  <br>
- 代码实现
  - 注册时用户名冗余检测
        if(dataBase.queryNameDuplicate(register_username.getText().toString())){  
        	Toast xxxx 
        }
  - 在数据库存储注册用户信息
        dataBase.insert(register_username.getText().toString(),register_password.getText().toString());
  - 登录时密码检错
        TextUtils.equals(login_password.getText().toString(), correctPassword);
  - 登录/注册成功的动态广播
        //bundle
        String message = "Welcome," + register_username.getText().toString() + "!";
        bundle.putString("message", message);
        //broadcast
         Intent sendIntent = new Intent(DYNAMICATION);
         sendIntent.putExtras(bundle);
         sendBroadcast(sendIntent);

3.3.11   ScrollView嵌套两个RecycleViewer

<center>

<p style="font-size:15px">图7   商家详情中的地图显示</p></center>

- 实现思路
  我们将所有商家分成两类，于是用到了两个RecycleViewer，并且为了保证用户在可以上拉并且有更好的用户体验，我们将两个RecycleViewer嵌套进ScrollView中。
  <br>
- 代码实现
- 为RecyclerViewer添加库
      import android.support.v7.widget.RecyclerView;
- RecycleViewer的Adapter中onBindViewHolder函数
      ```java
      viewHolder.Image.setBackgroundResource(imageId1[i]);
        viewHolder.Service.setText(merchant_list.get(i).getService());
        viewHolder.Price.setText(merchant_list.get(i).getPrice());
        viewHolder.Address.setText(merchant_list.get(i).getAddress());
        if (mOnItemClickLitener != null)
        {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener()
            {
             @Override
           	 public void onClick(View v) {
                mOnItemClickLitener.onItemClick(viewHolder.itemView,i,merchant_list.get(i));
            }
         });
       }
      
      ```
  - 嵌套进scrollView
        // Inflate the layout for this fragment
          View view = inflater.inflate(R.layout.fragment_home, container, false);

3.3.12   毛玻璃背景效果实现

- 实现思路
  毛玻璃效果使用了高斯模糊算法，这一部分在网上找到了参考，添加BlurUtil类到工程下，然后在activity中调用将背景进行高斯模糊，就可以实现毛玻璃效果，并且再根据需要设置参数来改变模糊程度。不过后来考虑到整体简约风格的统一性，并没有使用。
  <br>
- 代码实现
      private void setBackground(int id) {
        //模糊程度
        int scaleRatio=5;
        int blurRadius = 3;
        Bitmap bm = BitmapFactory.decodeResource(getResources(),id);
        Bitmap scaledBm = Bitmap .createScaledBitmap(bm,bm.getWidth()/scaleRatio,bm.getHeight()/scaleRatio,false);
        final Bitmap blurBmp = BlurUtil.fastblur(MainActivity.this, scaledBm, blurRadius);
        final Drawable newBitmapDrawable = new BitmapDrawable(blurBmp);
        personalLayout.post(new Runnable() {
            @Override
            public void run(){
               personalLayout.setBackgroundDrawable(newBitmapDrawable);
            }
        });
      }

3.4   代码架构

以下是伴旅应用的代码架构图。

<center>

<p style="font-size:15px">图8   伴旅代码架构图</p></center>

3.4.1    域名+应用程序名称

   com.example.lenovo.triptogether

3.4.2    应用名称

   伴旅（Trip Together）

3.4.3    各模块

- DataBase

存放数据库类

- StoreList                                                                                                                                        

商品详情类

- APPStart.java
  应用启动页，有渐变的效果，随后进入内容页面
- BottomNavigationBar.java
  应用进入的内容页，默认调用HomePage这个Fragment作为首页，含有BottomNavigationBar
- Page

存放四个Fragment，内容页

- HomePage

首页

      * WeatherDynamicReceiver.java

      > 天气动态广播，调用广播发出通知

      * HomeFragment.java

      > 发起网络请求查询天气，实现自动定位，RecycleView的触发事件

      * Merchant.java

      * MercahntAdapter1.java

        > 第一个RecycleView的自定义Adapter

      * MerchantAdapter2.java

        > 第二个RecycleView的自定义Adapter

- ChatPage

旅伴界面

     * ChatFragment.java

旅伴界面，实现左右分栏

      * ListAdapter.java

左右分栏的自定义适配器

       * ChatContent.java

聊天界面

- MailPage

收件箱界面，左滑可以显示删除和刷新该栏，长按拖拽可以重排序

      * MailFragment.java
      > 收件箱界面
    
      * MainRecycleAdapter.java
      * TeseModel.java
    
      * Operation
         * ItemTouchHelperCallback.java

拖拽事件类

          * DividerItemDecoration.java

左滑事件类

- UserPage

个人信息页面

     * LoginRegister.java

      * LoginActivity.java

        > 登陆界面

      * RegisterActivity.java

        > 注册界面

      * DynamicReceiver.java

      * DataBase.java

- UserFragment.java
      > 个人信息页面
- StoreDetails.java
  商品详情页，里面含有商家附近地图和详细信息

<br>

4   应用效果

---

                        

<p style="font-size:15px">        图9   手机主界面中的伴旅                 图10   点击伴旅应用后的应用开屏界面</p>

                        

<p style="font-size:15px;  white-space:pre"> 图11   伴旅主界面，顶部有查询栏，           图12   点击长隆欢乐世界的商家，

可以自动定位客户目前所在城市，             即可跳到它的商家详情页，其中包括

下面是商家列表，分为生活起居类和          大众评分、营业时间、联系方式、

娱乐出行类                                                  价目和其定位地图</p>

                        

<p style="font-size:15px;  white-space:pre; text-align">        图13 和 14   旅伴搜索的界面，显示每个旅伴的大致信息，以供选择</p>

                        

<p style="font-size:15px;  white-space:pre;">   图15   消息界面，显示消息列表         图16   点击某一消息进去，即可显示对话窗口</p>

                        

 <p style="font-size:15px;  white-space:pre-swap;">    图16   向左划某个消息即可对                        图17   个人信息界面，显示基

     该消息进行删除或刷新操作                            础个人信息，含有设置入口</p>

                        

 <p style="font-size:15px;  white-space:pre-swap;">          图18   个人登录界面                                    图19   个人注册界面</p>

       

<p style="font-size:15px;  white-space:pre;">    图20   成功登陆后会动态广播，              图21   通过主界面顶部的查询栏输入

    在通知栏处显示信息                                某城市后按查询按钮，即会在通知栏
                                                                     处显示天气</p>



<br>

5   开发过程中遇到的问题及解决办法

---

1. 设置开机界面顶部栏沉浸，内容页显示通知栏。实现的时候不可以同时兼顾。

- 开机界面
      getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
               getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
           }
- 在其他界面使用原来的Style样式即可

2. 在选择BottomNavigationBar跳转到不同页面的时候无法切换Fragment

- 在BottomNavigationBar的类中的onTabSelected中，需要用到replace，再commitAllowingStateLoss，之前使用的commit提交修改，但是没有成功，改成这个就可以了。

3. 其他Activity切回BottomNavigationBar这个Activity的时候（因为四个主页面并不是Activity而是四个Fragment），导航栏的图标没有重绘。

- 原本是onTabSelect中跳转Fragment，然后选择当从Bottom这个页面跳转到其他的Activity的时候，将当前Fragment的position也传过去，返回的时候根据对方传回来他所要回来的Fragment的position，根据position判断应该选择哪个tab进行重绘以及哪个Fragment进行跳转。
  - 例子：
      if (intentposition == 1){
      	bottomNavigationBar.setFirstSelectedPosition(1)//默认选择索引为0的菜单为主页面;
              .initialise();//对导航进行重绘
           setSecondFragment();//跳转第二个Fragment
      }

4. 做商家主页面遇到的问题&解决

我对商家主页面的设计参考了airbnb的方式，即可以上拉下拉，并且可以左右滑动，于是我在界面上使用两个RecycleViewer来给两类商家进行展示。在这一部分我一共碰到两个大问题，其一，图片都是大图，每次都因为内存溢出闪退；其二，左右拉动的时候，无法显示全这一行的全部内容。

 第一个问题的处理分为两步，将在drawable中的图片放到mipmap中，并且在adapter中直接进行填充，并且两个adapter对应的recycler中的内容不能错位。第二个问题，是因为在填充第二个RecycleViewer时出现了与第一个的交错填充，导致第一个无法显示全，第二个无法滑动，改过来统一就可以。还有这一部分一定要添加包。另外，由于无法上下滑动，于是我们将其嵌套入ScrollView，这样就可以实现全部内容的上下滑动。

5. 做个人页面遇到的问题&解决

这一部分虽然涉及到轻量级数据库，但由于之前实现过，不是很麻烦，但是还是遇到了些问题。这一部分主要功能是登录与注册的功能，我想在登录和注册之后返回个人界面，并且在个人界面显示已登录或注册的用户的用户名。遇到的第一个问题是，注册之后个人界面未更新名字，这个是在bundle传参和activity之间finish和start的顺序问题导致，具体因时间久远，有点忘记了。然后就是存储在数据库中的时候，如果有重复主码，就会导致出错，于是每次插入的时候需要检查主码，并且需要检查密码是否为空，以保证数据正确。

6. RecycleView和ListView加载图片的时候回造成内存溢出，也就是常见的OOM，加载的时候内存不够程序就会崩溃。

内存不够可以从两个地方解决。

- 将要显示的文件压缩，比如图片，将他压缩到一定程度，加载图片耗费不太大就可以加载出文件处理，但这个时候图片文件是放在了程序里面，肯定不适用。
  <br>
  - 另一种方法就是将图片放在一个远端数据库，然后在加载的时候将其加载的时候。举个例子：当没有滑到的地方就先别图片加载处理，等到到达item的位置的时候，再从服务器中将文件下载下来。其次，在服务器端也应该将这些文件进行一定的压缩，不影响使用和观感体验。

7. ScrollView中不能有多个Layout

所以在写的时候只能在里面新建一个RelativeLayout，再再里面当成一个新布局使用。

8. 实验过程中，还经常遇到一些传递的是一个空的context，不能生成视图。

这个事故在我们项目中主要是因为多线程，子线程没有结束就开始开始传值。因为在项目多次出现，原因也大同小异，解决方法就是要避免线程之间的传值。

9. RecycleView的点击事件

这个问题纯粹是不是很熟这种View，所以在自定义的时候是不知道怎么触发点击事件或者是长按事件的。

- 将我们自定义的Adapter实现onClick接口，然后在下面定义点击事件，返回的时候调用就好了。
  if (mOnItemClickListener != null){
          viewHolder.itemView.setOnClickListener(new View.OnClickListener(){
      @Override
              public void onClick(View v) {
                   // TODO Auto-generated method stub
                  mOnItemClickListener.onItemClick(viewHolder.itemView, i,merchant_list.get(i));
          }
       });
  }
- 在主程序中调用
      merchantAdapter2.setOnItemClickListener(new MerchantAdapter2.OnMyItemClickListener(){
          public void onItemClick(View view,int position,Merchant item){
              Intent intent = new Intent(getContext(),store_detail.class);
              Bundle bundle = new Bundle();
              bundle.putString("storename",item.getService().toString());
              intent.putExtras(bundle);
              startActivity(intent);
           }
      });

10. 百度地图SDK

这是一个大坑。SDK包老是更新，手机系统不同它又不同。之前在32位手机调试风调雨顺，换了新手机64位的就各种GG，不能自动定位，不能显示地图。

- 经过不懈努力的一天调试，解决方法就是去官网下一个全部的包，比如下个4.0版本以上的包。除了放在app\libs里面，不要忘了右键add as Library。其次还要建一个jniLibs库，把armbi和armbi64位的文件夹都给放进去，原因网上的解释就是如果第三方库的so文件不能使用，就需要用jinLibs。
  - 另外就是一定不能把各个版本的包混用，不然程序检查的时候检查到的东西都无法加载。

11. 实验中还有很多很多其他杂七杂八的问题，年代久远也都忘了差不多了。

<br>

6   思考及感想

---

如果把一次项目分工分成只有代码的分工，那是非常不合理的。在组队的时候，就已经明确有数，需要一些审美比较好以及可以担任写码的人。因此，我们项目小组里有平面设计和视频剪辑非常厉害的人，也有代码能力不错的人。项目初期设计的时候，由UI两个人制图，再写成布局文件。功能设计和负责的后台交互交由另外两个人设计。无论是UI设计还是后台设计，亦或是产品概念完善，展示材料（包括PPT和视频剪辑）都是这整一个项目不可或缺的。

因此，占比每人各25其实是非常合理的。在这次实验中，每个人都投身于大量资料的搜寻里，并获得了许多的知识和资料，甚至是课上没有教到的知识点。对AS的操作则是更加的熟悉，毕竟导包和引用包，生成APK，调用API，定义样式等等地方随便一个就可以耗时，而且特别难以debug，因为大部分不是代码问题。

整一个项目设计下来，从产品概念设计到可实施性，再到前端设计，再到后台搭建数据库等，每一个过程汇集了四个人的多少个夜晚。尽管很辛苦，但挺有意义的。第一次就已经接触了这么复杂的工程文件，开始以为很简单，但工程量其实很大，所以，许多知识在不断的功能补充的时候慢慢充实我们，这一点，不仅仅是说代码上的学习，而是许多其他应用我们的使用，比如Office中的Publish制作用户手册，比如各大配色网站，比如Github里有用的代码框架，比如还了解了一些产品的市场性等等等。

项目设计应该就多方面知识学习，每一环都是一门学问。这是我们的课程项目感想。

值得~

<br>

7   小组分工

---

   组员 	   学号   	              负责内容              	贡献百分比
  卢锦涛 	14353216	       主要功能代码设计，云数据库基础设计        	 25% 
  高仕腾 	14353006	    部分功能代码设计与优化，云数据库设计，视频制作     	 25% 
  肖姗姗 	14353332	部分功能代码设计与优化，功能架构设计，前端UI设计，用户手册制作	 25% 
  李成婉宁	14353134	部分功能代码设计与优化，前端UI设计，PPT制作，说明文档制作 	 25% 

<br>

8   参考资料

---

- 百度地图地理编码和自定义Marker： http://www.jianshu.com/p/062017544504
- BottomNavigation：
  http://www.jcodecraeer.com/a/opensource/2016/0419/4164.html
- ItemTouchHelper：
  http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0630/3123.html
- Android地图SDK
  http://lbsyun.baidu.com/index.php?title=androidsdk
  http://blog.csdn.net/zjl5211314/article/details/6899593
- 心知天气API
  http://www.thinkpage.cn/api
- Bmob云数据库
  http://docs.bmob.cn/data/Android/a_faststart/doc/index.html
