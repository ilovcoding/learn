//这是新页面
import 'package:flutter/material.dart';

class NewRouter extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'list 组件',
      home: Scaffold(
        appBar: new AppBar(title: new Text('Row Widget')),
        // body: RowWidget(),
        body: ColumnWidget(),
      ),
    );
  }
}

class RowWidget extends StatelessWidget {
  //横向列表代码
  @override
  Widget build(BuildContext context) {
    //水平布局代码Row Widget
    //灵活布局大家均分  不用expanded 父元素大小取决于子元素
    return Row(
      children: <Widget>[
        Expanded(
          child: new RaisedButton(
            onPressed: () {},
            color: Colors.redAccent,
            child: new Text('read button'),
          ),
        ),
        Expanded(
          child: new RaisedButton(
            onPressed: () {},
            color: Colors.lightBlue,
            child: new Text('blue button'),
          ),
        ),
        Expanded(
          child: new RaisedButton(
            onPressed: () {},
            color: Colors.orangeAccent,
            child: new Text('orange button'),
          ),
        ),
      ],
    );
  }
}

class ColumnWidget extends StatelessWidget {
  //纵向布局
  @override
  Widget build(BuildContext context) {
    return Center(
        //center去掉没有水平居中效果
        child: Column(
      crossAxisAlignment: CrossAxisAlignment.center, //是指这一堆文档内部居中对齐 不是说屏幕中间
      mainAxisAlignment: MainAxisAlignment.center, //主轴居中 即上下居中

      children: <Widget>[
        new Text('I am Column widget'),
        Expanded(child: new Text('Column widget')), //灵活布局撑开中间
        new Text('widget'),
        new Text('I am Column widget'),
      ],
    ));
  }
}
