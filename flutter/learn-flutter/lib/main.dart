//练习官方的计数器代码
import 'package:flutter/material.dart';
//导入路由页面
import './router.dart';
//导入新的依赖
import 'package:english_words/english_words.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  //Widget 页面布局对象
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      //应用名称
      title: 'Flutter Demo',
      theme: new ThemeData(
        //主题颜色蓝色
        primarySwatch: Colors.blue,
      ),
      home: new myHomePage(title: '这是主页'),
    );
  }
}

class myHomePage extends StatefulWidget {
  myHomePage({Key key, this.title}) : super(key: key);
  final String title;
  @override
  _MyHomePageState createState() => new _MyHomePageState();
}

class _MyHomePageState extends State<myHomePage> {
  int _counter = 0;
  var wordchild = RandomWordsWidget();
  void _intCounter() {
    setState(() {
      _counter++;
    });
  }
  void _delCounter(e) {
    setState(() {
      _counter--;
    });
  }
  void _changeworld(){
    setState(() {
     wordchild=RandomWordsWidget(); 
    });
  }
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text(widget.title),
      ),
      body: new Center(
        child: new Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            new Text('点击按钮增加数字,点击数字减1'),
            Listener(
              //监听事件
              child: new Text(
                '$_counter',
                style: Theme.of(context).textTheme.display1,
              ),
              onPointerDown: _delCounter,
            ),
            //跳转到新页面代码
            FlatButton(
              child: Text('open new page'),
              textColor: Colors.blue,
              onPressed: () {
                Navigator.push(context,
                    new MaterialPageRoute(builder: (context) {
                  return new NewRouter();
                }));
              },
            ),
            FlatButton(
            child: new Row(
              children: <Widget>[
                new Text('点击显示新的英语单词'),
                wordchild
              ],
            ),
            onPressed: () {
              _changeworld();
            },
            )
          ],
        ),
      ),
      floatingActionButton: new FloatingActionButton(
        onPressed: _intCounter,
        tooltip: 'Increment',
        child: new Icon(Icons.add),
      ),
    );
  }
}

class RandomWordsWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // 生成随机字符串
    final wordPair = new WordPair.random();
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: new Text(wordPair.toString()),
    );
  }
}
